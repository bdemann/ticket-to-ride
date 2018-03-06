package shared.model.interfaces;

import java.util.List;
import java.util.Map;

import shared.model.Route;
import shared.model.TrainCard;
import shared.model.history.GameHistory;

/**
 * Created by bdemann on 3/4/18.
 */

public interface IGameInfo {
    String getPlayerWithLongestRoute();
    List<TrainCard> getFaceUpCards();
    int getGameId();
    String getGameName();
    List<String> getPlayers();
    Map<String, Integer> getPlayerColors();
    Map<String, Integer> getPlayerPoints();
    Map<String, Integer> getPlayerHandSizes();
    List<Route> getClaimedRoutes();
    GameHistory getGameHistory();
}
