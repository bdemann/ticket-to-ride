package guifacade;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import model.ClientRoot;
import presenter.LoginPresenter;
import proxy.LoginClientProxy;
import proxy.serverproxies.LoginServerProxy;
import shared.Command;
import shared.commandResults.CommandResult;
import shared.model.Player;
import view.LoginActivity;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LoginGuiFacade {

    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static void main(String[] args) {
       // String result = signIn("username", "password");

    }


    public static String signIn(String username, String password) {
        //This GuiFacade will send the username and password on to the server.
        //It will receive certain results and decide what to do with them.
        LoginServerProxy lsp = new LoginServerProxy();
        CommandResult result = lsp.signin(username,password);
        return _processSignInResults(username,password,result);
    }

    private static String _processSignInResults(String username, String password, CommandResult commandResults){

        //send username and password to root
        if(commandResults.getCommandSuccess()){
            _updatePlayer(username, password);
        }
        else{
            //check for exception
            if(commandResults.getExceptionType() != null){
                System.out.println("ExceptionType: " + commandResults.getExceptionType()+". " + commandResults.getExceptionMessage());
                return "Exception of type: " + commandResults.getExceptionType() +
                        ". " + commandResults.getExceptionMessage();
            }

            System.out.println("False. UserMessage: " + commandResults.getUserMessage());
            return commandResults.getUserMessage();
        }

        System.out.println("True. UserMessage: " + commandResults.getUserMessage());
        return commandResults.getUserMessage();
    }


    public static String register(String username, String password){

        LoginClientProxy lsp = new LoginClientProxy();
        CommandResult commandResults = lsp.register(username,password);

        //send username and password to root
        if(commandResults.getCommandSuccess()){
            _updatePlayer(username, password);
        }
        else{
            //check for exception
            if(commandResults.getExceptionType() != null){
                System.out.print("ExceptionType: " + commandResults.getExceptionType()+". " + commandResults.getExceptionMessage());
                return "Exception of type: " + commandResults.getExceptionType() +
                        ". " + commandResults.getExceptionMessage();
            }
            System.out.print("False. UserMessage: " + commandResults.getUserMessage());
            return commandResults.getUserMessage();
        }
        System.out.print("True. UserMessage: " + commandResults.getUserMessage());
        return commandResults.getUserMessage();
    }

    private static void _updatePlayer(String username, String password){
        Player player = new Player(username, password);
        _clientRoot.setClientPlayer(player);
    }
}
