package presenter;

/**
 * Created by BenNelson on 2/12/18.
 *
 */
public interface IGameSelectionPresenter {

    void createGame(int creatorColor, String gameName, int numberOfPlayers);
    boolean joinGame(int gameID);
}
