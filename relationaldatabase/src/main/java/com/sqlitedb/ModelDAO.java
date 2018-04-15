package com.sqlitedb;

import java.util.ArrayList;
import java.util.List;

import dao.IModelDAO;
import shared.command.ICommand;
import shared.model.Player;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

import static com.sqlitedb.RelationalDatabase.*;


public class ModelDAO implements IModelDAO {

    public static void main(String[] args){
        ModelDAO model = new ModelDAO();
        model.initializeDB(10);
    }

    private RelationalDatabase db;
    @Override
    public void initializeDB(int commandLimit) {
        try {
            db = new RelationalDatabase();
            db.openConnection();
            db.createTables();
            //Add the command limit for the database

            List<Object> list = new ArrayList<>();
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

    }

    @Override
    public boolean isCommandLimitReached() {
        return false;
    }

//    @Override
//    public void executeCommandList() {
//
//    }

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
                db.insert(TABLE_PLAYERS, COLUMN_PLAYER_BLOB, list);
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
