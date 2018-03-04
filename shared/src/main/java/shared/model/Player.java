package shared.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the player class for ticket to ride.
 *
 * Created by BenNelson on 2/2/18.
 */
public class Player implements IPlayer, Serializable {

    private String _username;
    private String _password;
    private int _color;
    private int _gameId = -1;
    private int points = 0;
    private List<Edge> playersEdges;
    private List<Route> playersRoutes;
    private List<Train> _trains;
    private Hand<TrainCard> _trainCards;
    private Hand<DestCard> _destCards;
    private List<DestCard> _unresolvedDestCards;

    public Player(String username, String password, int color)
    {
        this._username = username;
        this._password = password;
        this._color = color;
    }

    public Player(String username, String password) {
        this._username = username;
        this._password = password;
        this._color = 0;
    }

    public Player(String username) {
        this._username = username;
        this._password = "";
        this._color = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player: ").append(this._username).append(". Color: ").append(this._color);
        return sb.toString();
    }

    @Override
    public void setUsername(String username) {
        this._username = username;
    }

    @Override
    public void setPassword(String password) {
        this._password = password;
    }

    public void setGameId(int id){
        this._gameId = id;
    }

    @Override
    public void setTrainCards(List<TrainCard> startingHand) {
        _trainCards = new Hand<>(startingHand);
    }

    @Override
    public void setUnresolvedDestCards(List<DestCard> unresolvedDestCards) {
        _unresolvedDestCards = unresolvedDestCards;
    }

    @Override
    public void setDestCards(List<DestCard> destCards) {
        this._destCards = new Hand<>(destCards);
    }

    @Override
    public void addDestCards(List<DestCard> newDestCards) {
        this._destCards.addCards(newDestCards);
    }

    @Override
    public String getUsername() {
        return this._username;
    }

    @Override
    public String getPassword() {
        return this._password;
    }

    @Override
    public void addDestCard(DestCard card) {

    }

    @Override
    public void discardDestCard(DestCard card) {

    }

    @Override
    public void addTrainCard(TrainCard card) {
        _trainCards.addCard(card);
    }

    @Override
    public void discardTrainCard(TrainCard card) {
        _trainCards.useCard(card);
        //TODO this will get it out of the players hand but it won't put it into the discard pile... maybe we need to return the discarded card so that some other class can take care of that?
    }

    @Override
    public void addRoute(Route route) {

    }

    @Override
    public void performAction(PlayerAction action) {

    }

    @Override
    public void setTrains(List<Train> trains) {
        this._trains = trains;
    }

    @Override
    public void setColor(int color) {
        this._color = color;

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
    public List<Train> getTrains() {
        return _trains;
    }

    @Override
    public int getColor() {
        return this._color;
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
        return _gameId;
    }
}
