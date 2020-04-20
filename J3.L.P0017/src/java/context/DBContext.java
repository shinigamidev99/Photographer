/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        Config config = Config.getInstance();
        String url = "jdbc:sqlserver://" + config.getHost() + ":" + config.getPort()
                + ";databaseName=" + config.getDatabaseName();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, config.getUsername(), config.getPassword());
        return conn;
    }

    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}
