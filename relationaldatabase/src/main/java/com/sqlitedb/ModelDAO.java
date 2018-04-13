package com.sqlitedb;

import java.util.List;
import java.sql.*;

import dao.IModelDAO;
import shared.command.ICommand;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;


public class ModelDAO implements IModelDAO {


    public static void main(String[] args){


    }
    @Override
    public void initializeDB(int commandLimit) {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:tickettoride.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

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
    public List<IGame> getGames() {
        return null;
    }

    @Override
    public List<IPlayer> getPlayers(int gameID) {
        return null;
    }

    @Override
    public void clearCommands() {

    }


}
