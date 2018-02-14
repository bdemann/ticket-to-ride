package guifacade;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import model.ClientRoot;
import poller.Poller;
import presenter.LoginPresenter;
import proxy.LoginClientProxy;
import proxy.serverproxies.GameSelectionServerProxy;
import proxy.serverproxies.LoginServerProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.IGame;
import shared.model.Player;
import view.LoginActivity;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LoginGuiFacade {

    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static String signIn(String username, String password) {
        //This GuiFacade will send the username and password on to the server.
        //It will receive certain results and decide what to do with them.
        LoginServerProxy lsp = new LoginServerProxy();
        CommandResult result = lsp.signin(username,password);
        Poller.start();
        return _processResults(username,password,result, true);
    }

    public static String register(String username, String password){

        LoginServerProxy lsp = new LoginServerProxy();
        CommandResult result = lsp.register(username,password);
        return _processResults(username,password,result, false);
    }

    private static String _processResults(String username, String password, CommandResult commandResults, boolean isSignIn){

        if(commandResults == null){
            return "Server Down";
        }
        //send username and password to root
        if(commandResults.getCommandSuccess() && isSignIn){
            _updatePlayer(username, password);
        }
        else{
            //check for exception
            if(commandResults.getExceptionType() != null){
                //System.out.println("ExceptionType: " + commandResults.getExceptionType()+". " + commandResults.getExceptionMessage());
                return "Exception of type: " + commandResults.getExceptionType() +
                        ". " + commandResults.getExceptionMessage();
            }

            if(!commandResults.getCommandSuccess()){
                //System.out.println("False. UserMessage: " + commandResults.getUserMessage());
                return commandResults.getUserMessage();
            }
        }

        //System.out.println("True. UserMessage: " + commandResults.getUserMessage());
        return commandResults.getUserMessage();
    }

    private static void _updatePlayer(String username, String password){
        Player player = new Player(username, password);
        _clientRoot.setClientPlayer(player);
    }
    public static String getGamesList(String username) {
        GameSelectionServerProxy proxy = new GameSelectionServerProxy();
        CommandResult result = proxy.getGamesList(username);
        return null;
    }

    private String _processGetGamesListResult(CommandResult commandResults){

        if(commandResults == null){
            return "Server Down";
        }
        //send username and password to root
        if(commandResults.getCommandSuccess()){
            List<IGame> list = (List<IGame>)commandResults.getResult();
            _clientRoot.setListGames(list);
        }
        else{
            //check for exception
            if(commandResults.getExceptionType() != null){
                //System.out.println("ExceptionType: " + commandResults.getExceptionType()+". " + commandResults.getExceptionMessage());
                return "Exception of type: " + commandResults.getExceptionType() +
                        ". " + commandResults.getExceptionMessage();
            }

            if(!commandResults.getCommandSuccess()){
                //System.out.println("False. UserMessage: " + commandResults.getUserMessage());
                return commandResults.getUserMessage();
            }
        }

        //System.out.println("True. UserMessage: " + commandResults.getUserMessage());
        return commandResults.getUserMessage();
    }
}

