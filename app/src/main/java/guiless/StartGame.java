package guiless;

import model.ClientRoot;
import proxies.syncProxy.GameMenuServerProxySync;
import proxies.syncProxy.GameServerProxySync;
import proxies.syncProxy.LobbyServerProxySync;
import proxies.syncProxy.LoginServerProxySync;
import shared.logging.Logger;
import shared.model.Player;
import shared.model.TrainCard;
import shared.model.interfaces.IGame;
import shared.results.CreateGameResult;
import shared.results.Result;
import shared.results.StartGameResult;

/**
 * Created by bdemann on 3/5/18.
 */

public class StartGame {

    public static void main(String[] args) {
        Result result;
        new LoginServerProxySync().register("bdemann", "password");
        new LoginServerProxySync().register("mkporet", "password");
        new LoginServerProxySync().signin("bdemann", "password");
        new LoginServerProxySync().signin("mkporet", "password");
        result = new GameMenuServerProxySync().createGame(new Player("bdemann"), 2, "Test Game");
        System.out.println("Create Game Result:");
        System.out.println(result);
        IGame game = ((CreateGameResult) result).getGame();
        new GameMenuServerProxySync().joinGame(game.getId(), new Player("mkporet"));
        StartGameResult startGameResult = new LobbyServerProxySync().startGame(game, "bdemann");
        System.out.println("Start Game Result:");
        System.out.println(startGameResult);
        for(TrainCard card: startGameResult.getGameInfo().getFaceUpCards()){
            Logger.log("Here is a card:" + card.toString());
        }
    }

}
