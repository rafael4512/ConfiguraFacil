package dataaccess;

import java.sql.*;

/**
 * @author Jaime Leite, João Marques, Nuno Rei e Rafael Lourenço
 * @version 12-2018
 */
public class Connect {
    private static final String URL = "localhost:3306";
    //private static final String URL = "127.0.0.1:3306";
    private static final String SCHEMA = "configurafacil";
    private static final String USERNAME = "root";
    //private static final String PASSWORD = "Niquita1998";
    //private static final String PASSWORD = "inesmartins8";
    private static final String PASSWORD = "MYSQL2018";
    //private static final String PASSWORD = "pcdojaime123";

    public static Connection connect() {
	try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://"+URL+"/"+SCHEMA+"",USERNAME,PASSWORD);
            return c;
	}
	catch (ClassNotFoundException | SQLException e) {
            throw new NullPointerException(e.getMessage());
	}
    }

    public static void close(Connection c) {
	try {
            c.close();
	}	
	catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
	}
    }
}