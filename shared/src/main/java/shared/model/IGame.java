package shared.model;
import java.util.List;

/**
 * Interface for a single Game in the ticket to ride game yay!
 *
 * Created by BenNelson on 2/2/18.
 */
public interface IGame {
    void setPlayerWithLongestRoute(String playerName);
    void setTrainCardDeck(List<TrainCard> trainCardDeck);
    void setDestCardDeck(List<DestinationCard> destCardDeck);
    void setCardsFaceUp(List<TrainCard> cardsFaceUp);
    void setOpenRoutes(List<Route> openRoutes);
    void setClaimedRoutes(List<Route> claimedRoutes);
    void setPlayers(List<IPlayer> players);
    void generateScoreSummary();
    void setGameMap(TTRMap gameMap);
    String getPlayerWithLongestRoute();
    List<TrainCard> getTrainCardDeck();
    List<DestinationCard> getDestCardDeck();
    List<TrainCard> getCardsFaceUp();
    List<Route> getOpenRoutes();
    List<Route> getClaimedRoutes();
    List<IPlayer> getPlayers();
    String getScoreSummary();
    TTRMap getGameMap();

    void addPlayer(IPlayer joiner);
    void setId(int gameId);
    int getId();

    int getNumberPlayer();

    int getMaxNumberPlayer();
}
