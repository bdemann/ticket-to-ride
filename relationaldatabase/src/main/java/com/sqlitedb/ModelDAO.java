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
            System.out.printf("Command Limit was reached with COMMANDS STORED: " + Integer.toString(commandsStored) + "   and COMMAND LIMIT SET TO: " + Integer.toString(commandLimit));
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



    }

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

    @Override
    public List<IPlayer> getPlayers() {
        return null;
    }

    @Override
    public void clearCommands() {
        //TODO implement this method!! It should delete the list of commands
    }

    @Override
    public List<ICommand> getCommandList(int id){
        return new ArrayList<>();
    }
}