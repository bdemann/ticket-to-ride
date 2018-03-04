package server.facades;

import java.util.ArrayList;
import java.util.List;

import shared.model.IGame;
import shared.model.IPlayer;
import shared.model.Train;

/**
 * Created by bdemann on 3/3/18.
 * I am not sure how we are going to interact with this class. Maybe we just will want to take methods out of this class and move them else where but it will be me a starting place
 */

public class StartGameFacade {


    // give players their trains
    // set each score to 0
    // shuffle decks
    // deal cards to each player
    // put out top five cards
    // initiailize the longest path.
    // deal out 3 destination cards
    // let each person know that they need to pick at least two cards
    public static IGame setUpGame(IGame game){
        game = initTrains(game);
        game = initScore(game);
        game = shuffleDecks(game);
        game = dealStartingTrainCards(game);
        game = initDrawPile(game);
        game = initLongestPath(game);
        game = dealStartingTickets(game);
        return game;
    }

    private static IGame dealStartingTickets(IGame game) {
        //TODO implement method
        return null;
    }

    private static IGame initLongestPath(IGame game) {
        //TODO implement method
        return null;
    }

    private static IGame initDrawPile(IGame game) {
        //TODO implement method
        return null;
    }

    private static IGame dealStartingTrainCards(IGame game) {
        //TODO implement method
        return null;
    }

    private static IGame shuffleDecks(IGame game) {
        game.getTrainCardDeck().shuffle();
        game.getDestCardDeck().shuffle();
        return game;
    }

    private static IGame initScore(IGame game) {
        for (IPlayer player : game.getPlayers()){
            player.setScore(0);
        }
        return game;
    }

    private static IGame initTrains(IGame game) {
        for(IPlayer player : game.getPlayers()) {
            player.setTrains(initTrainList());
        }
        return game;
    }

    private static List<Train> initTrainList() {
        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < 45; i++){
            trains.add(new Train());
        }
        return trains;
    }

}
