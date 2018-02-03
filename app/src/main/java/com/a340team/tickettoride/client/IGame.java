package com.a340team.tickettoride.client;
import java.util.ArrayList;

/**
 * Created by BenNelson on 2/2/18.
 */
public interface IGame {
    void setPlayerWithLongestRoute(String playerName);
    void setTrainCardDeck(ArrayList<TrainCard> trainCardDeck);
    void setDestCardDeck(ArrayList<DestinationCard> destCardDeck);
    void setCardsFaceUp(ArrayList<TrainCard> cardsFaceUp);
    void setOpenRoutes(ArrayList<Route> openRoutes);
    void setClaimedRoutes(ArrayList<Route> claimedRoutes);
    void setOpponents(ArrayList<String> otherPlayers);
    void generateScoreSummary();
    void setGameMap(TTRMap gameMap);
    String getPlayerWithLongestRoute();
    ArrayList<TrainCard> getTrainCardDeck();
    ArrayList<DestinationCard> getDestCardDeck();
    ArrayList<TrainCard> getCardsFaceUp();
    ArrayList<Route> getOpenRoutes();
    ArrayList<Route> getClaimedRoutes();
    ArrayList<String> getOpponents();
    String getScoreSummary();
    TTRMap getGameMap();

}
