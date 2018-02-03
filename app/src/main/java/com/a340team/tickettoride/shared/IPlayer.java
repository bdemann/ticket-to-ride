package com.a340team.tickettoride.shared;
import android.graphics.Color;

import java.util.ArrayList;

/**
 * Created by BenNelson on 2/2/18.
 */
public interface IPlayer {

    void addDestCard(Card card);
    void discardDestCard(Card card);
    void addTrainCard(Card card);
    void discardTrainCar(Card card);
    void addRoute(Route route);
    void setTrains(ArrayList<Train> trains);
    void setColor(Color color);
    void setScore(int score);
    void setScoreMarker(int scoreMarker);
    void setCurrentGame(int currentGame);
    ArrayList<Train> getTrains();
    Color getColor();
    int getScore();
    int getScoreMarker();
    int getCurrentGame();


}
