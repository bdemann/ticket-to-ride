package facade.guifacade;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

import model.ClientRoot;
import proxies.GameServerProxy;
import shared.command.Command;
import shared.model.DestCardSet;
import shared.model.DestCard;
import shared.model.DestDeck;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IPlayer;
import shared.model.interfaces.IRoute;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.DrawDestCardsResult;
import shared.results.DrawTrainCardsResult;
import shared.results.Result;

/**
 * This helps the presenters talk to the model
 * Created by BenNelson on 3/7/18.
 */

public class GameGuiFacade {


    public static List<DestCard> getStarterDestinationCards(){
        DestCardSet s = ClientRoot.getClientPlayer().getUnresolvedDestCards();
        return s.toList();
    }

    public static List<DestCard> getPlayerDestCards(){
        return ClientRoot.getClientPlayer().getDestCards();
    }

    public static IGameInfo getStarterGameInfo(){
        return ClientRoot.getClientGameInfo();
    }

    public static List<TrainCard> getStarterPlayerHand(){
        return ClientRoot.getClientPlayer().getTrainCardHand().get_cards();
    }

    public static List<DestCard> drawDestinationCards() {
        GameServerProxy gsp = new GameServerProxy();
        DrawCardsResult cardResults = gsp.drawDestCards(ClientRoot.getClientPlayer().getUsername());
        return _processDrawDestinationResults(cardResults);
    }

    private static List<DestCard> _processDrawDestinationResults(DrawCardsResult cardResults) {
        if(cardResults != null){
            //TODO it was not my intention to have a cast like this... is there a way to change this? Maybe its not too big of a deal?
            ClientRoot.getClientPlayer().setUnresolvedDestCards((List<DestCard>) cardResults.getCards());
            return (List<DestCard>) cardResults.getCards();
        }
        else {
            return null;
        }
    }

    public static void discardDestinationCards(List<DestCard> chosenDestCards, DestCardSet cardsToRemove){
        GameServerProxy gsp = new GameServerProxy();
        ClientRoot.getClientPlayer().addDestCards(chosenDestCards) ;
        DestCardSet destCardSet = new DestCardSet(chosenDestCards);
        DrawDestCardsResult destCardsResult = gsp.discardDestCards(ClientRoot.getClientPlayer().getUsername(), destCardSet, cardsToRemove);
        try {
            Command.executeList(destCardsResult.getClientCommands());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Boolean> getCompleteDestination(){
        boolean isCompleted = false;
        List<Boolean> completedDestination = new ArrayList<>();
        for(DestCard destCard : ClientRoot.getClientPlayer().getDestCards()){
            if(destCard.isCompleted()){
                isCompleted = true;
            }
            else if(!destCard.isCompleted()){
                isCompleted = false;
            }
            completedDestination.add(isCompleted);
        }

        return completedDestination;
    }

    public static void drawFaceDownTrainCard() {
        GameServerProxy gsp = new GameServerProxy();
        DrawTrainCardsResult cardsResult = gsp.drawFaceDownTrainCard(ClientRoot.getClientPlayer().getUsername());
        try {
            Command.executeList(cardsResult.getClientCommands());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ClientRoot.getClientPlayer().addTrainCard(cardsResult.getDrawnCard());
    }

    public static void drawFaceUpTrainCard(int trainCardIndex) {
        GameServerProxy gsp = new GameServerProxy();
        DrawTrainCardsResult result = gsp.drawFaceUpTrainCard(ClientRoot.getClientPlayer().getUsername(), trainCardIndex);
        try {
            Command.executeList(result.getClientCommands());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(result.getCommandSuccess()){
            ClientRoot.getClientGame().setCardsFaceUp(result.getFaceUpCards());
            ClientRoot.getClientPlayer().addTrainCard(result.getDrawnCard());
        } else {
            //TODO inform the user about the failed drawing experience
        }
    }

    public static String claimRoute(IRoute route, TrainCardSet cards, String username){

        GameServerProxy gameServerProxy = new GameServerProxy();
        ClaimRouteResult result = gameServerProxy.claimRoute(route,cards,username);
        try{
            Command.executeList(result.getClientCommands());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result.getUserMessage();


       // return null;

    }

    public static boolean checkTurn(){
        String username = ClientRoot.getClientPlayer().getUsername();
        if(username.equals(ClientRoot.getClientGame().getGameInfo().activePlayer())){
            System.out.println("My turn!");
            return true;
        }

        return false;
    }
}
