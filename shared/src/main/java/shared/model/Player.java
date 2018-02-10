package shared.model;


import java.awt.Color;
import java.util.ArrayList;

/**
 * This class implements the player class for ticket to ride.
 *
 * Created by BenNelson on 2/2/18.
 */
public class Player implements IPlayer {

    private String username;
    private String password;
    private Color color;
    private int gameId = 0;

    public Player(String username, String password, Color color)
    {
        this.username = username;
        this.password = password;
        this.color = color;
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.color = null;
    }

    public Player() {}

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public void setGameId(int id){
        this.gameId = id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void addDestCard(DestinationCard card) {

    }

    @Override
    public void discardDestCard(DestinationCard card) {

    }

    @Override
    public void addTrainCard(TrainCard card) {

    }

    @Override
    public void discardTrainCard(TrainCard card) {

    }

    @Override
    public void addRoute(Route route) {

    }

    @Override
    public void performAction(PlayerAction action) {

    }

    @Override
    public void setTrains(ArrayList<Train> trains) {

    }

    @Override
    public void setColor(Color color) {
        this.color = color;

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
        return this.color;
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

    @Override
    public int getRemainingActions() {
        return 0;
    }

    public int getGameId(){
        return gameId;
    }
}
