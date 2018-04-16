package com.sqlitedb;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.*;

import shared.comm.CommandEncoder;
import shared.model.interfaces.IGame;
import shared.model.interfaces.IPlayer;

public class RelationalDatabase {

    static {
        try {
            final String driver = "org.sqlite.JDBC";
            Class.forName(driver);
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection conn;
   // static final String COLUMN_GAME_ID = "Game_IDs";
    static final String COLUMN_GAME_BLOB = "Game_Blobs";
    static final String TABLE_GAMES = "Games_TABLE";
    static final String TABLE_COMMANDS = "Commands_TABLE";
    static final String COLUMN_COMMANDS = "Commands";
    static final String TABLE_PLAYERS = "Players_TABLE";
    static final String COLUMN_PLAYER_BLOB = "Player_Blobs";
    static final String TABLE_COMMAND_LIMIT = "Command_Limit_TABLE";
    static final String COLUMN_COMMAND_LIMIT = "Limit_of_commands";

    public void openConnection() throws Exception {
        try {
            final String CONNECTION_URL = "jdbc:sqlite:ticketToRide.sqlite";

            // Open a database connection
            conn = DriverManager.getConnection(CONNECTION_URL);

            // Start a transaction
            conn.setAutoCommit(false);
        }
        catch (SQLException e) {
            throw new Exception("openConnection failed", e);
        }
    }

    public void closeConnection(boolean commit) throws Exception {
        try {
            if (commit) {
                conn.commit();
            }
            else {
                conn.rollback();
            }

            conn.close();
            conn = null;
        }
        catch (SQLException e) {
            throw new Exception("closeConnection failed", e);
        }
    }

    public void createTables() throws Exception {
        try {
            Statement stmt = null;
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("drop table if exists " + TABLE_GAMES);
               // stmt.executeUpdate("create table " + TABLE_GAMES + " ( " + COLUMN_GAME_ID +   " integer not null unique, " + COLUMN_GAME_BLOB + " text not null unique )");
                stmt.executeUpdate("create table " + TABLE_GAMES + " ( " + COLUMN_GAME_BLOB + " text not null )");

                stmt.executeUpdate("drop table if exists " + TABLE_COMMANDS);
                stmt.executeUpdate("create table " + TABLE_COMMANDS + " ( " + COLUMN_COMMANDS + " text not null )");

                stmt.executeUpdate("drop table if exists " + TABLE_PLAYERS);
                stmt.executeUpdate("create table " + TABLE_PLAYERS + " ( " + COLUMN_PLAYER_BLOB + " text not null )");

                stmt.executeUpdate("drop table if exists " + TABLE_COMMAND_LIMIT);
                stmt.executeUpdate("create table " + TABLE_COMMAND_LIMIT + " ( " + COLUMN_COMMAND_LIMIT + " text not null )");

            }
            finally {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            }
        }
        catch (SQLException e) {
            throw new SQLException("createTables failed", e);
        }
    }

    /**
     * @pre this method expects the list of values to be either ints or serializable objects
     *
     * @param tableName
     * @throws Exception
     */
    public void insert(String tableName, String tableColumn, List<Object> values) throws Exception {
        try {
            PreparedStatement stmt = null;
            try {
                String sql = "insert into "+ tableName +" (" + tableColumn +") values (?)";
                stmt = conn.prepareStatement(sql);

                for (Object obj : values) {
                    stmt.setString(1, CommandEncoder.encodeDBInfo(obj));

                    if (stmt.executeUpdate() != 1) {
                        throw new Exception("insert into DB failed: Could not insert OBJECT");
                    }
                }
            }
            finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        catch (SQLException e) {
            throw new Exception("insert into DB failed", e);
        }
    }

    public List<Object> load(String tableName, String tableColumn) throws Exception {
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                String sql = "select "+ tableColumn +" from " + tableName;
                stmt = conn.prepareStatement(sql);

                List<Object> list = new ArrayList<>();
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Object obj = CommandEncoder.decodeDBInfo(rs.getString(1));
                    list.add(obj);
                }
                return list;
            }
            finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            }
        }
        catch (SQLException e) {
            throw new Exception("load failed", e);
        }
    }

    public void replaceGamePlayers(List<IPlayer> players, int gameID) {
        try {

            List<Object> games = load(TABLE_GAMES, COLUMN_GAME_BLOB);
            clearTable(TABLE_GAMES, COLUMN_GAME_BLOB);
            for(Object obj: games){
                if(obj instanceof IGame){
                    IGame game = (IGame) obj;
                    if(game.getId() == gameID) {
                        int index = games.indexOf(obj);
                        games.remove(obj);
                        game.setPlayers(players);
                        games.add(index, game);
                        break;
                    }
                }
            }
            //Now the game is altered, lets put them all back in the db
            insert(TABLE_GAMES, COLUMN_GAME_BLOB, games);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearTable(String tableName, String columnName) throws Exception{
        try {
            Statement stmt = null;
            try {
                stmt = conn.createStatement();

                stmt.executeUpdate("drop table if exists " + tableName);
                stmt.executeUpdate("create table " + tableName + " ( " + columnName + " text not null )");

            }
            finally {
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            }
        }
        catch (SQLException e) {
            throw new SQLException("clear failed", e);
        }
    }
}