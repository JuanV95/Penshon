package com.example.alexander.penshon20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB extends _Default implements Runnable {

    private Connection conn;
    private String host = "stevie.heliohost.org";
    private String db = "mixi07_penshon";
    private int port = 5432;
    private String user = "mixi07";
    private String pass = "penshon123";
    private String url = "jdbc:postgresql://stevie.heliohost.org:5432/mixi07_penshon";

    public DB() {
        super();
        this.conecta();
    }

    @Override
    public void run() {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void conecta() {
        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
    }

    private void disconecta() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (Exception e) {

            } finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query) {
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query) {
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        } catch (Exception e) {
            this._status = false;
            this._mensagem = e.getMessage();
        }
        return resultSet;
    }

    public Statement createStatement() {
        try {
            Statement consulta = (Statement) this.conn.createStatement();
            return consulta;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
