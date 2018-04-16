package nonrel_database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dao.IModelDAO;
import shared.command.ICommand;
import shared.model.Player;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

/**
 * Created by paulinecausse on 4/9/18.
 */

public class NonRelDB implements IModelDAO {
    private File playerFile;
    private File gameFile;
    private File commandFile;
    private int commandLimit;

    @Override
    public void initializeDB(int commandLimit){
        System.out.println("CHANGES MADE !");
        try{
            playerFile = new File("PlayerFile.txt");
            if(!playerFile.exists()){
                playerFile.createNewFile();
            }
            gameFile = new File("GameFile.txt");
            if(!gameFile.exists()){
                gameFile.createNewFile();
            }
            commandFile = new File("CommandFile.txt");
            if(!commandFile.exists()){
                commandFile.createNewFile();
            }

            this.commandLimit = commandLimit;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //TODO: Should it return a boolean instead that lets us know if we need to reserialize the game?
    @Override
    public void storeCommand(ICommand command){
        CommandDAO.getInstance(commandFile).addCommand(command);
    }

    @Override
    public boolean isCommandLimitReached(){
        int limit = CommandDAO.getInstance(commandFile).getCommands().size();
        System.out.println("NUMBER OF COMMANDS: " + limit);
        if(limit > commandLimit){
            System.out.println("TRUE");
            return true;
        }

        return false;
    }

//    @Override
//    public void executeCommandList() {
//        List<ICommand> commands = CommandDAO.getInstance(commandFile).getCommands();
//        for(ICommand command:commands){
//            try{
//                command.execute();
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

    @Override
    public void saveGames(List<IGame> games){
        GameDAO.getInstance(gameFile).deleteGames();
        for(IGame game:games){
            GameDAO.getInstance(gameFile).addGame(game);
        }
    }

    @Override
    public void savePlayers(List<IPlayer>players){
        PlayerDAO.getInstance(playerFile).deletePlayers();
        for(IPlayer player:players){
            PlayerDAO.getInstance(playerFile).addPlayer(player);
        }
    }

    @Override
    public void addPlayer(IPlayer player){
        //gameID is not used in this function call
        PlayerDAO.getInstance(playerFile).addPlayer(player);
    };

    @Override
    public List<IGame> getGames(){
        return GameDAO.getInstance(gameFile).getGames();
    }

    @Override
    public List<IPlayer>getPlayers(){
        return PlayerDAO.getInstance(playerFile).getPlayers();
    }

    @Override
    public void clearCommands() {

        CommandDAO.getInstance(commandFile).deleteCommands();
    }

    @Override
    public List<ICommand> getCommandList(int id){
        List<ICommand> commands = CommandDAO.getInstance(commandFile).getCommands();
        List<ICommand> wantedCommands = new ArrayList<>();
        for(ICommand command: commands){
            if(command.getGameId() == id){
                wantedCommands.add(command);
            }
        }
        return wantedCommands;
    }

}
