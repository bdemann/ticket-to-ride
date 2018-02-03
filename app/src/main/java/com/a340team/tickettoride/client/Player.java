package com.a340team.tickettoride.client;
import android.graphics.Color;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by BenNelson on 2/2/18.
 */
public class Player implements IPlayer {
    @Override
    public void addDestCard(Card card) {

    }

    @Override
    public void discardDestCard(Card card) {

    }

    @Override
    public void addTrainCard(Card card) {

    }

    @Override
    public void discardTrainCar(Card card) {

    }

    @Override
    public void addRoute(Route route) {

    }

    @Override
    public void setTrains(ArrayList<Train> trains) {

    }

    @Override
    public void setColor(Color color) {

    }

    @Override
    public void setScore(int score) {

    }

    @Override
    public void setScoreMarker(int scoreMarker) {

    }

    @Override
    public void setCurrentGame(int currentGame) {

    }

    @Override
    public ArrayList<Train> getTrains() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public int getScoreMarker() {
        return 0;
    }

    @Override
    public int getCurrentGame() {
        return 0;
    }
}
