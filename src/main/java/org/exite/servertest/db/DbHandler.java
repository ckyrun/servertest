package org.exite.servertest.db;

import org.exite.servertest.exception.InternalDBException;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DbHandler {

    private final String url;
    private final String login;
    private final String pass;

    private Connection con;

    public DbHandler(String dburl, String dblogin, String dbpass) {
        this.url = dburl+"?autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false&maxReconnects=10";
        this.login = dblogin;
        this.pass = dbpass;
    }

    public void insertMessage(Map<String, String> mapValues, byte[] buffer) throws InternalDBException {

        reconnect();
        final String sql = "INSERT INTO docs (doc_body, sender, recipient, file_name) VALUES (?,?,?,?);";

        try (final PreparedStatement ps = this.con.prepareStatement(sql)) {
            ps.setBlob(1, new ByteArrayInputStream(buffer));
            ps.setString(2, mapValues.get("sender"));
            ps.setString(3, mapValues.get("recipient"));
            ps.setString(4, mapValues.get("fileName"));
            ps.executeUpdate();
        } catch (Exception e) {
            throw new InternalDBException("Ошибка записи в базу", e);
        }

    }

    public void connect() {
        try{
            this.con = DriverManager.getConnection(url, login, pass);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    protected void reconnect() {
        try{
            if(con == null || !con.isValid(5))
                connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
