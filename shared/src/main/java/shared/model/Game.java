package shared.model;

import java.util.List;

/**
 *
 * Created by BenNelson on 2/2/18.
 */
public class Game implements IGame {

    private List<Player> _players;
    private int _id;
    private int _maxNumberPlayer;
    private int _numberPlayer;

    public Game(List<Player> players, int numberPlayer){
        this._players = players;
        this._maxNumberPlayer = numberPlayer;
        this._numberPlayer = 1;
    }

    public Game() {}

    public void setId(int id){
        this._id = id;
    }

    @Override
    public void setPlayerWithLongestRoute(String playerName) {
    }

    @Override
    public void setTrainCardDeck(List<TrainCard> trainCardDeck) {

    }

    @Override
    public void setDestCardDeck(List<DestinationCard> destCardDeck) {

    }

    @Override
    public void setCardsFaceUp(List<TrainCard> cardsFaceUp) {

    }

    @Override
    public void setOpenRoutes(List<Route> openRoutes) {

    }

    @Override
    public void setClaimedRoutes(List<Route> claimedRoutes) {

    }

    @Override
    public void setPlayers(List<Player> players) {
        this._players = players;

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
    public List<TrainCard> getTrainCardDeck() {
        return null;
    }

    @Override
    public List<DestinationCard> getDestCardDeck() {
        return null;
    }

    @Override
    public List<TrainCard> getCardsFaceUp() {
        return null;
    }

    @Override
    public List<Route> getOpenRoutes() {
        return null;
    }

    @Override
    public List<Route> getClaimedRoutes() {
        return null;
    }

    @Override
    public List<Player> getPlayers() {
        return this._players;
    }

    @Override
    public String getScoreSummary() {
        return null;
    }

    @Override
    public TTRMap getGameMap() {
        return null;
    }

    @Override
    public void addPlayer(Player joiner) {
        _players.add(joiner);
        _numberPlayer ++;
    }

    public int getId() {
        return _id;
    }

    public int getMaxNumberPlayer() {
        return _maxNumberPlayer;
    }

    public int getNumberPlayer() {
        return _numberPlayer;
    }
}
