package facade.guifacade;

import java.util.ArrayList;
import java.util.List;

import model.ClientRoot;
import proxies.GameServerProxy;
import shared.command.Command;
import shared.model.DestCardSet;
import shared.model.DestCard;
import shared.model.TrainCard;
import shared.model.TrainCardSet;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IRoute;
import shared.results.ClaimRouteResult;
import shared.results.DrawCardsResult;
import shared.results.DrawTrainCardsResult;

/**
 * This helps the presenters talk to the model
 * Created by BenNelson on 3/7/18.
 */

public class GameGuiFacade {

    public static List<DestCard> getStarterDestinationCards(){
        DestCardSet s = ClientRoot.getClientPlayer().getUnresolvedDestCards();
        return s.toList();
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
            return (List<DestCard>) cardResults.getCards();
        }
        else {
            return null;
        }
    }

    public static List<Boolean> getCompleteDestination(){
        boolean isCompleted = false;
        List<Boolean> completedDestination = new ArrayList<>();
        for(DestCard destCard : ClientRoot.getClientPlayer().getUnresolvedDestCards()){
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
        ClientRoot.getClientGame().setCardsFaceUp(result.getFaceUpCards());
        ClientRoot.getClientPlayer().addTrainCard(result.getDrawnCard());
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
}
