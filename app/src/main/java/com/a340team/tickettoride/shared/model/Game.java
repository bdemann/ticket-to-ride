package com.a340team.tickettoride.shared.model;

import java.util.ArrayList;

/**
 *
 * Created by BenNelson on 2/2/18.
 */
public class Game implements IGame {

    private ArrayList<Player> players;

    public Game(ArrayList<Player> players){
        this.players = players;
    }

    @Override
    public void setPlayerWithLongestRoute(String playerName) {
    }

    @Override
    public void setTrainCardDeck(ArrayList<TrainCard> trainCardDeck) {

    }

    @Override
    public void setDestCardDeck(ArrayList<DestinationCard> destCardDeck) {

    }

    @Override
    public void setCardsFaceUp(ArrayList<TrainCard> cardsFaceUp) {

    }

    @Override
    public void setOpenRoutes(ArrayList<Route> openRoutes) {

    }

    @Override
    public void setClaimedRoutes(ArrayList<Route> claimedRoutes) {

    }

    @Override
    public void setPlayers(ArrayList<Player> Players) {
        this.players = players;

    }

    @Override
    public void generateScoreSummary() {

    }

    @Override
    public void setGameMap(TTRMap gameMap) {

    }

    @Override
    public String getPlayerWithLongestRoute() {
        return null;
    }

    @Override
    public ArrayList<TrainCard> getTrainCardDeck() {
        return null;
    }

    @Override
    public ArrayList<DestinationCard> getDestCardDeck() {
        return null;
    }

    @Override
    public ArrayList<TrainCard> getCardsFaceUp() {
        return null;
    }

    @Override
    public ArrayList<Route> getOpenRoutes() {
        return null;
    }

    @Override
    public ArrayList<Route> getClaimedRoutes() {
        return null;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public String getScoreSummary() {
        return null;
    }

    @Override
    public TTRMap getGameMap() {
        return null;
    }
}
