package com.a340team.tickettoride.shared;
import java.util.ArrayList;

/**
 * Interface for a single Game in the ticket to ride game yay!
 *
 * Created by BenNelson on 2/2/18.
 */
public interface IGame {
    void setPlayerWithLongestRoute(String playerName);
    void setTrainCardDeck(ArrayList<TrainCard> trainCardDeck);
    void setDestCardDeck(ArrayList<DestinationCard> destCardDeck);
    void setCardsFaceUp(ArrayList<TrainCard> cardsFaceUp);
    void setOpenRoutes(ArrayList<Route> openRoutes);
    void setClaimedRoutes(ArrayList<Route> claimedRoutes);
    void setPlayers(ArrayList<Player> Players);
    void generateScoreSummary();
    void setGameMap(TTRMap gameMap);
    String getPlayerWithLongestRoute();
    ArrayList<TrainCard> getTrainCardDeck();
    ArrayList<DestinationCard> getDestCardDeck();
    ArrayList<TrainCard> getCardsFaceUp();
    ArrayList<Route> getOpenRoutes();
    ArrayList<Route> getClaimedRoutes();
    ArrayList<Player> getPlayers();
    String getScoreSummary();
    TTRMap getGameMap();

}
