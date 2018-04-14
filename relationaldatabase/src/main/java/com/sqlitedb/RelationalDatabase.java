package com.sqlitedb;

import java.sql.*;
import java.util.*;

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
    private final String ID = "id";
    private final String GAME = "game";
    private final String DB_TITLE = "Database_TTR";

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

                stmt.executeUpdate("drop table if exists " + DB_TITLE);
                stmt.executeUpdate("create table " + DB_TITLE + " ( " + ID +   " integer not null unique, "
                                                                         + GAME + " text not null unique )");
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

    public void fillDictionary() throws Exception {
        try {
            String[] words = {"fred", "wilma", "betty", "barney"};
            PreparedStatement stmt = null;
            try {
                String sql = "insert into "+ DB_TITLE +" (" + ID +", " + GAME + ") values (?,?)";
                stmt = conn.prepareStatement(sql);

                int i = 0;
                for (String word : words) {
                    stmt.setInt(1, i++);
                    stmt.setString(1, word);

                    if (stmt.executeUpdate() != 1) {
                        throw new Exception("fillDictionary failed: Could not insert word");
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
            throw new Exception("fillDictionary failed", e);
        }
    }

    public Set<String> loadDictionary() throws Exception {
        try {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                String sql = "select game from " + DB_TITLE;
                stmt = conn.prepareStatement(sql);

                Set<String> words = new HashSet<>();
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String word = rs.getString(1);
                    words.add(word);
                }

                return words;
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
            throw new Exception("fillDictionary failed", e);
        }
    }

}