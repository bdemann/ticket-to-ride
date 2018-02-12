package shared.client;

import java.util.List;

import shared.model.IGame;

/**
 * This is an interface that will be shared by the CLIENT PROXY CLASSES on the server, and the
 * CLIENT FACADE CLASSES on the client.
 *
 * Created by BenNelson on 2/3/18.
 */

public interface IGameSelectionClient {

    void createGame();
    void joinGame();
    List<IGame> getGames();
    void updateGameList();

}
