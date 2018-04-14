package nonrel_database;

import java.io.File;
import java.util.List;

import dao.IModelDAO;
import shared.command.ICommand;
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
        try{
            playerFile = new File("PlayerFile.txt");
            gameFile = new File("GameFile.txt");
            commandFile = new File("CommandFile.txt");
            this.commandLimit = commandLimit;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void storeCommand(ICommand command){
        if(!isCommandLimitReached()){
            CommandDAO.getInstance(commandFile).addCommand(command);
        }
        else{
            //TODO: serialize every game and player
//            List<IGame> games = ServerRoot.getGames();
//            List<IPlayer> players = ServerRoot.getPlayers();
            //delete old games and players
            PlayerDAO.getInstance(playerFile).deletePlayers();
            GameDAO.getInstance(gameFile).deleteGames();
            //add new games and players
//            setGames(games);
//            setPlayers(players,1);
            //delete commands
            clearCommands();
        }
    }

    @Override
    public boolean isCommandLimitReached(){
        if(CommandDAO.getInstance(commandFile).getCommandLimit() > commandLimit){
            return true;
        }

        return false;
    }

    @Override
    public void executeCommandList() {
        List<ICommand> commands = CommandDAO.getInstance(commandFile).getCommands();
        for(ICommand command:commands){
            try{
                command.execute();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void saveGames(List<IGame> games){
        for(IGame game:games){
            GameDAO.getInstance(gameFile).addGame(game);
        }
    }

    @Override
    public void savePlayers(List<IPlayer>players, int gameID){
        for(IPlayer player:players){
            PlayerDAO.getInstance(playerFile).addPlayer(player,gameID);
        }
    }

    @Override
    public List<IGame> getGames(){
        return GameDAO.getInstance(gameFile).getGames();
    }

    @Override
    public List<IPlayer>getPlayers(int gameID){
        return PlayerDAO.getInstance(playerFile).getPlayers();
    }

    @Override
    public void clearCommands() {
        CommandDAO.getInstance(commandFile).deleteCommands();
    }

}
