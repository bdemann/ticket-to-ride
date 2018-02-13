package server.proxies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import shared.Command;
import shared.ICommand;

/**
 * Created by bdemann on 2/12/18.
 */

public class ClientCommands {

    private static ClientCommands _instance = new ClientCommands();
    private Map<String, List<ICommand>> _commands;

    private ClientCommands() {
        _commands = new HashMap<>();
    }

    public static Set<String> getUsers() {
        return _instance._commands.keySet();
    }

    public static List<ICommand> getCommandList(String username) {
        List<ICommand> commands = _instance._commands.get(username);
        _instance._commands.put(username, new ArrayList<ICommand>());
        return commands;
    }

    //TODO get rid of this function as soon we have the commands actually added. or maybe just adapt it...
    public static void addCommand(String username, ICommand command) {
        List<ICommand> commands;
        if(_instance._commands.containsKey(username)) {
            commands = _instance._commands.get(username);
        } else {
            commands = new ArrayList<>();
        }
        commands.add(command);
        _instance._commands.put(username, commands);
    }

    public static void main(String[] args){
        List<ICommand> commands = new ArrayList<>();
        Class<?>[] parmTypes = {String.class, String.class};
        Object[] parmValues = {"bdemann", "password"};
        Command command = new Command("server.facades.LoginServerFacade", "register", parmTypes, parmValues);
        commands.add(command);
        _instance._commands.put("bdemann", commands);
        _instance._commands.put("mcporet", commands);
        System.out.println(_instance._commands.keySet());
        if(_instance._commands.get("mcporet")==null) {
            System.out.println("it was null");
        } else {
            System.out.println("it wasn't null");
        }
        System.out.println("This is after");
        System.out.println(_instance._commands.get("bdemann"));
        System.out.println(getCommandList("bdemann"));
        System.out.println(_instance._commands.get("bdemann"));
    }
}
