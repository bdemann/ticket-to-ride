package shared.model;


import java.awt.Color;
import java.util.ArrayList;

/**
 * This is the interface for a player in ticket to ride
 *
 * Created by BenNelson on 2/2/18.
 */
public interface IPlayer {

    /**
     *
     * @param username of the player signed in
     */
    void setUsername(String username);

    /**
     *
     * @param password of the player signed in
     */
    void setPassword(String password);

    /**
     *
     * @return the username as a string
     */
    String getUsername();

    /**
     *
     * @return the password as s string
     */
    String getPassword();

    /**
     *
     * @param card
     * return nothing.
     */
    void addDestCard(DestinationCard card);

    /**
     * Discards a destination card
     * @param card
     * return nothing
     */
    void discardDestCard(DestinationCard card);

    /**
     * This method adds a train card to the player's current traincard hand.
     * There is no limit of train cards a player can have.
     *
     * @param card
     * return nothing
     */
    void addTrainCard(TrainCard card);

    /**
     * Discards a train card
     * @param card
     * return nothing
     */
    void discardTrainCard(TrainCard card);

    /**
     * Adds a route to the players route list
     * @param route
     * return nothing
     */
    void addRoute(Route route);

    /**
     * This takes in an action the player wants to perform and deducts it from the amount of actions
     * a player can take during his or her turn
     * @param action
     * return nothing
     */
    void performAction(PlayerAction action);

    /**
     * Set the trains for the player
     * @param trains
     * return nothing
     */
    void setTrains(ArrayList<Train> trains);

    /**
     * Set the color of the player
     * @param color for the player
     */
    void setColor(int color);

    /**
     * A player has a given score
     * @param score for player
     */
    void setScore(int score);

    /**
     * Each player has a score maker that ranges from 1 to 100
     * @param scoreMarker for the player
     */
    void setScoreMarker(int scoreMarker);

    /**
     * This is an ID number for the current game the player is in.
     * @param currentGame of the player
     */
    void setCurrentGame(int currentGame);

    /**
     * Players have trains
     * @return list of trains
     */
    ArrayList<Train> getTrains();

    /**
     * Each player has a color
     * @return Color of the player
     */
    int getColor();

    /**
     *
     * @return score of the player
     */
    int getScore();

    /**
     *
     * @return the int location of the score marker.
     */
    int getScoreMarker();

    /**
     *
     * @return the id number of the current game the player is in.
     */
    int getCurrentGame();

    /**
     *
     * @return the number of actions the player has until his or her turn is over.
     */
    int getRemainingActions();


}
