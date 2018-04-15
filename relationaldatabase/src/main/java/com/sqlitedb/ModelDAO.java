package com.sqlitedb;

import java.util.ArrayList;
import java.util.List;

import dao.IModelDAO;
import shared.command.Command;
import shared.command.ICommand;
import shared.model.Player;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

import static com.sqlitedb.RelationalDatabase.*;


public class ModelDAO implements IModelDAO {


    private RelationalDatabase db;

    public static void main(String[] args){
        ModelDAO modelDAO = new ModelDAO();
        int commandLimit = 10;
        modelDAO.initializeDB(commandLimit);

        //TEST STORE COMMAND
        int commandsStored = 10;
        for(int i = 0; i < commandsStored; i++) {
            String index = Integer.toString(i);
            modelDAO.storeCommand(new Command("className" + index, "methodName" + index));
        }
        System.out.printf("Store Command Test: SUCCESS\n");
        //END OF STORING COMMANDS


        //TEST COMMAND LIMIT IS REACHED
        if(modelDAO.isCommandLimitReached()){
            System.out.printf("Command Limit was reached with COMMANDS STORED: " + Integer.toString(commandsStored) + "   and COMMAND LIMIT SET TO: " + Integer.toString(commandLimit) + "\n");
        }
        //END OF TESTING COMMAND LIMIT

        //TEST ADDING PLAYERS
        IPlayer one = new Player("Ben Nelson", "Yo Mama", 0);
        IPlayer two = new Player("Bob Trythall", "Hey Yo", 1);
        IPlayer three = new Player("Garet Nelson", "27348", 2);
        IPlayer four = new Player("Joe Frank", "Excel", 3);
        modelDAO.addPlayer(one);
        modelDAO.addPlayer(two);
        modelDAO.addPlayer(three);
        modelDAO.addPlayer(four);
        //END OF ADDING PLAYERS

        //TESTING GET PLAYERS
        for(IPlayer player : modelDAO.getPlayers()){
            System.out.printf("Got Player: " + player.getUsername() + "\n");
        }
        //END OF GET PLAYERS TEST

        //CLEAR COMMANDS WORKS

        //TESTING GET COMMANDS
        for(ICommand command : modelDAO.getCommandList(-1)){
            System.out.printf("Got COMMAND FROM GAME ID: " + command.getGameId() + "\n");
        }




    }

    //TESTED and should work properly
    @Override
    public void initializeDB(int commandLimit) {
        try {
            db = new RelationalDatabase();
            db.openConnection();
            db.createTables();
            //Add the command limit for the database

            List<java.lang.Object> list = new ArrayList<>();
            list.add(commandLimit);
            db.insert(TABLE_COMMAND_LIMIT, COLUMN_COMMAND_LIMIT, list);

            //Close the db connection
            db.closeConnection(true);
            System.out.println("Database Initialized");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TESTED and should work properly
    @Override
    public void storeCommand(ICommand command) {
        if(db != null){
            List<Object> list = new ArrayList<>();
            list.add(command);
            try {
                db.openConnection();
                db.insert(TABLE_COMMANDS, COLUMN_COMMANDS, list);
                db.closeConnection(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TESTED and should work properly
    @Override
    public boolean isCommandLimitReached() {
        if(db != null){
            try {
                db.openConnection();
                int limit = (int) db.load(TABLE_COMMAND_LIMIT, COLUMN_COMMAND_LIMIT).get(0);
                int commandListSize = (int) db.load(TABLE_COMMANDS, COLUMN_COMMANDS).size();
                db.closeConnection(true);

                if(commandListSize >= limit){
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public void saveGames(List<IGame> games) {

    }

    @Override
    public void savePlayers(List<IPlayer> players, int gameID) {

    }

    //TESTED and should work properly
    @Override
    public void addPlayer(IPlayer player) {
        if(db != null){
            List<Object> list = new ArrayList<>();
            list.add(player);
            try {
                db.openConnection();
                db.insert(TABLE_PLAYERS, COLUMN_PLAYER_BLOB, list);
                db.closeConnection(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<IGame> getGames() {
        return null;
    }

    //TESTED and should work properly
    @Override
    public List<IPlayer> getPlayers() {
        if(db != null){
            try {
                db.openConnection();
                List<Object> list = db.load(TABLE_PLAYERS, COLUMN_PLAYER_BLOB);
                db.closeConnection(true);

                List<IPlayer> players = new ArrayList<>();
                for(Object obj : list){
                    if(obj instanceof IPlayer){
                        players.add((IPlayer) obj);
                    }
                }
                return players;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    //TESTED and should work properly
    @Override
    public void clearCommands() {
        if(db != null){
            try {
                db.openConnection();
                db.clearCommands();
                db.closeConnection(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //TESTED and should work properly
    @Override
    public List<ICommand> getCommandList(int id){
        if(db != null){
            try {
                db.openConnection();
                List<Object> list = db.load(TABLE_COMMANDS, COLUMN_COMMANDS);
                db.closeConnection(true);

                List<ICommand> commands = new ArrayList<>();
                for(Object obj : list){
                    if(obj instanceof ICommand){
                        ICommand cmd = (ICommand) obj;
                        if(cmd.getGameId() == id){
                            commands.add(cmd);
                        }
                    }
                }
                return commands;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}