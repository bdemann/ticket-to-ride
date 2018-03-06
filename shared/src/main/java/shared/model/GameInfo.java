package shared.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import shared.model.history.GameHistory;
import shared.model.interfaces.IGameInfo;
import shared.model.interfaces.IPlayer;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameInfo implements IGameInfo, Serializable {
    private String _playerWithLongestRoute;
    private List<TrainCard> _faceUpCards;
    private int _gameId;
    private String _gameName;
    //Show information about all players in the game, including
    // their names,
    private List<String> _players; // A list of players in turn order.
    // colors,
    private Map<String, Integer> _playerColors;
    // points
    private Map<String, Integer> _playerPoints;
    // and the order in which the players take turns
    private Map<String, Integer> _playerHandSizes;
    private List<Route> _claimedRoutes;
    private GameHistory _gameHistory;
    private int _turnIndex;

    public GameInfo(int gameId, String gameName, GameHistory _gameHistory, String playerWithLongestRoute, List<TrainCard> faceUpCards, List<String> players, Map<String, Integer> playerColors, Map<String, Integer> playerPoints, Map<String, Integer> playerHandSizes, List<Route> claimedRoutes, GameHistory gameHistory, int turnIndex) {
        this._playerWithLongestRoute = playerWithLongestRoute;
        this._faceUpCards = faceUpCards;
        this._gameId = gameId;
        this._gameName = gameName;
        this._players = players;
        this._playerColors = playerColors;
        this._playerPoints = playerPoints;
        this._playerHandSizes = playerHandSizes;
        this._claimedRoutes = claimedRoutes;
        this._gameHistory = gameHistory;
        this._turnIndex = turnIndex;
    }

    @Override
    public String getPlayerWithLongestRoute() {
        return _playerWithLongestRoute;
    }

    @Override
    public List<TrainCard> getFaceUpCards() {
        return _faceUpCards;
    }

    @Override
    public int getGameId() {
        return _gameId;
    }

    @Override
    public String getGameName() {
        return _gameName;
    }

    @Override
    public List<String> getPlayers() {
        return _players;
    }

    @Override
    public Map<String, Integer> getPlayerColors() {
        return _playerColors;
    }

    @Override
    public Map<String, Integer> getPlayerPoints() {
        return _playerPoints;
    }

    @Override
    public Map<String, Integer> getPlayerHandSizes() {
        return _playerHandSizes;
    }

    @Override
    public List<Route> getClaimedRoutes() {
        return _claimedRoutes;
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
    public String activePlayer() {
        return _players.get(_turnIndex);
    }
}
