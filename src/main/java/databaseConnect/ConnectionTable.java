package databaseConnect;

import log.Log;

import java.sql.*;

import static utils.ConnectionDataTable.*;


public class ConnectionTable {


    public static Connection con = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;


    public static Connection connectToDB(){
        Log.info("Connect to DB " + URL + " by user " + USERNAME);
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Log.info("Connection to DB successful!");
        } catch (ClassNotFoundException | SQLException e) {
            Log.error(e.getMessage());
        }  return con;
    }

    public static void closeConnection(){
        if(con != null){
            try {
                con.close();
                Log.info("Connection to DB closed successfully");
            } catch (SQLException throwables) {
                Log.error(throwables.getMessage());
            }

        }
        if (pstmt != null) {
            try {
                pstmt.close();
                Log.info("Statement closed successfully");
            } catch (SQLException se) {
                Log.error("Statement was not closed. Reason:\n" + se.getMessage());
            }
        }

        if (rs != null) {
            try {
                rs.close();
                Log.info("ResultSet closed successfully");
            } catch (SQLException se) {
                Log.error("ResultSet was not closed. Reason:\n" + se.getMessage());
            }
        }
    }

}
