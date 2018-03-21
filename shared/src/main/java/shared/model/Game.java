package shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import shared.model.history.GameHistory;
import shared.model.interfaces.IRoute;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IPlayer;

/**
 *
 * Created by BenNelson on 2/2/18.
 */
public class Game implements IGame, Serializable {

    private List<IPlayer> _players;
    private int _id;
    private int _maxNumberPlayer;
    private int _numberPlayer;
    private String _gameName;
    private boolean _gameIsStarted = false;
    private String _playerWithLongestRoute; //If no one has it it will be empty string.
    private TrainDeck _trainDeck;
    private DestDeck _destDeck;
    private List<TrainCard> _faceUpCards;
    private GameHistory _gameHistory;
    private int _turnIndex;

    public Game(String gameName, List<IPlayer> players, int maxNumberPlayer){
        this._players = players;
        this._maxNumberPlayer = maxNumberPlayer;
        this._numberPlayer = 1;
        this._gameName = gameName;
        this._playerWithLongestRoute = "";
        this._trainDeck = new TrainDeck();
        this._destDeck = new DestDeck();
        this._faceUpCards = new ArrayList<>();
        this._gameHistory = new GameHistory();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Game: ").append(_gameName).append(". Game id: ").append(_id).append("\n").toString();
    }

    public void setId(int id){
        this._id = id;
    }

    @Override
    public void setPlayerWithLongestRoute(String playerName) {
        _playerWithLongestRoute = playerName;
    }

    @Override
    public void setTrainCardDeck(TrainDeck trainCardDeck) {
        _trainDeck = trainCardDeck;
    }

    @Override
    public void setDestCardDeck(DestDeck destCardDeck) {
        _destDeck = destCardDeck;
    }

    @Override
    public void setCardsFaceUp(List<TrainCard> cardsFaceUp) {
        _faceUpCards = cardsFaceUp;
    }

    @Override
    public void setOpenRoutes(List<Route> openRoutes) {
        //TODO implement this method
    }

    @Override
    public void setClaimedRoutes(List<Route> claimedRoutes) {
        //TODO implement this method
    }

    @Override
    public void setPlayers(List<IPlayer> players) {
        this._players = players;

    }

    @Override
    public void generateScoreSummary() {
        //TODO implement this method
    }

    @Override
    public void setGameMap(TTRMap gameMap) {
        //TODO implement this method
    }

    public void setGameName(String gameName){
        this._gameName = gameName;
    }

    @Override
    public String getPlayerWithLongestRoute() {
        return _playerWithLongestRoute;
    }

    @Override
    public TrainDeck getTrainCardDeck() {
        return _trainDeck;
    }

    @Override
    public DestDeck getDestCardDeck() {
        return _destDeck;
    }

    @Override
    public List<TrainCard> getCardsFaceUp() {
        return _faceUpCards;
    }

    @Override
    public List<Route> getOpenRoutes() {
        //TODO implement this method
        return null;
    }

    @Override
    public List<Route> getClaimedRoutes() {
        //TODO implement this method
        return null;
    }

    @Override
    public List<IPlayer> getPlayers() {
        return this._players;
    }

    @Override
    public String getScoreSummary() {
        //TODO implement this method
        return null;
    }

    @Override
    public TTRMap getGameMap() {
        //TODO implement this method
        return null;
    }

    @Override
    public void addPlayer(IPlayer joiner) {
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

    @Override
    public GameHistory getGameHistory() {
        return _gameHistory;
    }

    @Override
    public int getTurnIndex() {
        return _turnIndex;
    }

    @Override
    public IPlayer getActivePlayer() {
        return _players.get(_turnIndex);
    }

    @Override
    public int incrementTurnIndex() {
        //If not every player has had a turn
        if(_turnIndex < _players.size()){
            // Move turn to the next player
            return ++_turnIndex;
        }
        // Otherwise start the turns over again.
        _turnIndex = 0;
        return _turnIndex;
    }

    @Override
    public void discardTrainCards(TrainCardSet cards) {
        _trainDeck.discard(cards.getTrainCards());
    }

    @Override
    public void discardDestCards(List<DestCard> cards) {
        _destDeck.discard(cards);
    }

    @Override
    public String getGameName(){
        return _gameName;
    }

    @Override
    public void removePlayer(IPlayer player) {
        boolean removed = false;
        for(IPlayer listPlayer : new ArrayList<>(_players)){
            if(listPlayer.getUsername().equals(player.getUsername())){
                _players.remove(listPlayer);
                removed = true;
            }
        }
        if(removed) {
            _numberPlayer--;
        }

    }

    @Override
    public IPlayer getPlayer(String username) {
        for(IPlayer player : _players) {
            if (player.getUsername().equals(username)){
                return player;
            }
        }
        return null;
    }

    @Override
    public boolean isGameStarted() {
        return _gameIsStarted;
    }

    @Override
    public void startGame() {
        _gameIsStarted = true;
    }

    @Override
    public IGameInfo getGameInfo() {
        List<String> players = new ArrayList<>();
        Map<String, Integer> playerColors = new HashMap<>();
        Map<String, Integer> playerHandSizes = new HashMap<>();
        Map<String, Integer> playerPoints = new HashMap<>();
        Map<String, Integer> trainsRemaining = new HashMap<>();
        Map<String, List<IRoute>> claimedRoutes = new HashMap<>();
        Map<String, Integer> playerDestCount = new HashMap<>();
        for(IPlayer player : _players) {
            String username = player.getUsername();
            players.add(username);
            playerColors.put(username, player.getColor());
            playerHandSizes.put(username, player.getTrainCardHand().size());
            playerPoints.put(username, player.getScore());
            trainsRemaining.put(username, player.getTrains().size());
            //TODO fix this once we know how to get the routes.
            List<IRoute> list = new ArrayList<>();
            claimedRoutes.put(username, list);
            playerDestCount.put(username, player.getDestCards().size());
        }
        return new GameInfo(_id, _gameName, _gameHistory, _playerWithLongestRoute, _faceUpCards, players, playerColors, playerPoints, playerHandSizes, playerDestCount, claimedRoutes, trainsRemaining, getGameHistory(), _turnIndex);
    }
}
