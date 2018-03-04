package shared.model;
import java.util.List;

/**
 * Interface for a single Game in the ticket to ride game yay!
 *
 * Created by BenNelson on 2/2/18.
 */
public interface IGame {
    void setPlayerWithLongestRoute(String playerName);
    void setTrainCardDeck(TrainDeck trainCardDeck);
    void setDestCardDeck(DestinationDeck destCardDeck);
    void setCardsFaceUp(List<TrainCard> cardsFaceUp);
    void setOpenRoutes(List<Route> openRoutes);
    void setClaimedRoutes(List<Route> claimedRoutes);
    void setPlayers(List<IPlayer> players);
    void generateScoreSummary();
    void setGameMap(TTRMap gameMap);
    String getPlayerWithLongestRoute();
    TrainDeck getTrainCardDeck();
    DestinationDeck getDestCardDeck();
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
    void setGameName(String gameName);
    String getGameName();
    void removePlayer(IPlayer player);
    IPlayer getPlayer(String username);
    boolean isGameStarted();
    void startGame();

}
