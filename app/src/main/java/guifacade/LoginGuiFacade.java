package guifacade;

import model.ClientRoot;
import proxy.LoginClientProxy;
import proxy.serverproxies.LoginServerProxy;
import shared.commandResults.CommandResult;
import shared.model.Player;

/**
 *
 * Created by BenNelson on 2/3/18.
 */

public class LoginGuiFacade {
    private static ClientRoot _clientRoot = ClientRoot.instance();

    public static void main(String[] args) {
        String registerResult = register("username", "password");
        String loginResult = signIn("username", "password");
    }

    public static String signIn(String username, String password) {
        //This GuiFacade will send the username and password on to the server.
        //It will receive certain results and decide what to do with them.
        LoginServerProxy lsp = new LoginServerProxy();
        CommandResult commandResults = lsp.signin(username,password);

        //send username and password to root
        if(commandResults.getCommandSuccess()){
            _addPlayer(username, password);
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


    public static String register(String username, String password){

        LoginClientProxy lsp = new LoginClientProxy();
        CommandResult commandResults = lsp.register(username,password);

        //send username and password to root
        if(commandResults.getCommandSuccess()){
            _addPlayer(username, password);
        }
        else{
            //check for exception
            if(commandResults.getExceptionType() != null){
//                System.out.print("ExceptionType: " + commandResults.getExceptionType()+". " + commandResults.getExceptionMessage());
                return "Exception of type: " + commandResults.getExceptionType() +
                        ". " + commandResults.getExceptionMessage();
            }
//            System.out.print("False. UserMessage: " + commandResults.getUserMessage());
            return commandResults.getUserMessage();
        }
//        System.out.print("True. UserMessage: " + commandResults.getUserMessage() + "\n");
        return commandResults.getUserMessage();
    }

    private static void _addPlayer(String username, String password){
        Player player = new Player(username, password);
        _clientRoot.setClientPlayer(player);
    }
}
