package com.sqlitedb;

import java.util.List;
import java.sql.*;
import java.util.Set;

import dao.IModelDAO;
import shared.command.ICommand;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;


public class ModelDAO implements IModelDAO {


    private RelationalDatabase db;

    public static void main(String[] args){
        ModelDAO m = new ModelDAO();
        m.initializeDB(1);
    }

    @Override
    public void initializeDB(int commandLimit) {
        try {
            this.db = new RelationalDatabase();
            db.openConnection();
            db.createTables();
            db.fillDictionary();
            Set<String> words = db.loadDictionary();
            db.closeConnection(true);
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

    @Override
    public void executeCommandList() {

    }

    @Override
    public void saveGames(List<IGame> games) {

    }

    @Override
    public void savePlayers(List<IPlayer> players, int gameID) {

    }

    @Override
    public void addPlayer(IPlayer player){

    }

    @Override
    public List<IGame> getGames() {
        return null;
    }

    @Override
    public List<IPlayer> getPlayers(int gameID) {
        return null;
    }

    @Override
    public void clearCommands() {
        //TODO implement this method!! It should delete the list of commands
    }
}
