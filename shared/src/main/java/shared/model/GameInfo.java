package shared.model;

import java.util.List;
import java.util.Map;

import shared.model.history.GameHistory;
import shared.model.interfaces.IGameInfo;

/**
 * Created by bdemann on 3/4/18.
 */

public class GameInfo implements IGameInfo {
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

    public GameInfo(int gameId, String gameName, GameHistory _gameHistory, String playerWithLongestRoute, List<TrainCard> faceUpCards, List<String> players, Map<String, Integer> playerColors, Map<String, Integer> playerPoints, Map<String, Integer> playerHandSizes, List<Route> claimedRoutes) {
        this._playerWithLongestRoute = playerWithLongestRoute;
        this._faceUpCards = faceUpCards;
        this._gameId = gameId;
        this._gameName = gameName;
        this._players = players;
        this._playerColors = playerColors;
        this._playerPoints = playerPoints;
        this._playerHandSizes = playerHandSizes;
        this._claimedRoutes = claimedRoutes;
    }

    public String getPlayerWithLongestRoute() {
        return _playerWithLongestRoute;
    }

    public List<TrainCard> getFaceUpCards() {
        return _faceUpCards;
    }

    public int getGameId() {
        return _gameId;
    }

    public String getGameName() {
        return _gameName;
    }

    public List<String> getPlayers() {
        return _players;
    }

    public Map<String, Integer> getPlayerColors() {
        return _playerColors;
    }

    public Map<String, Integer> getPlayerPoints() {
        return _playerPoints;
    }

    public Map<String, Integer> getPlayerHandSizes() {
        return _playerHandSizes;
    }

    public List<Route> getClaimedRoutes() {
        return _claimedRoutes;
    }
}
