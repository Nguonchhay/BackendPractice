package services;

import java.sql.*;

public class MySqlService {
    private String connectionString;
    private String dbHost;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    private Connection connection = null;

    public MySqlService(String dbHost, String dbName, String dbUser, String dbPassword) {
       connectionString = "com.mysql.cj.jdbc.Driver";

       this.dbHost = dbHost;
       this.dbName = dbName;
       this.dbUser = dbUser;
       this.dbPassword = dbPassword;
    }

    public Statement getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(this.connectionString);
        connection = DriverManager.getConnection(
            "jdbc:mysql://" + this.dbHost + "/" + this.dbName, this.dbUser, this.dbPassword
        );
        return connection.createStatement();
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null) {
           this.connection.close();
        }
    }

    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);
    }
}
