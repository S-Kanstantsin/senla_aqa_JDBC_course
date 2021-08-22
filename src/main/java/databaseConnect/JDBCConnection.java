package databaseConnect;


import log.Log;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnection extends ConnectionTable {


    public static void createTable(String str) {
        try {
            pstmt = ConnectionTable.connectToDB().prepareStatement(str);
            Log.info("Send request to DB: " + pstmt);
            pstmt.executeUpdate(str);
            Log.info("Table was created successfully");
        } catch (SQLException se) {
            Log.error("Table was not created. Reason:\n" + se.getMessage());
        }
    }



    public static ResultSet selectFromTable(String str) {
        try {
            pstmt = ConnectionTable.connectToDB()
                    .prepareStatement(str,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Log.info("Send request to DB: " + pstmt);
            rs = pstmt.executeQuery(str);

            rs.next();
        } catch (SQLException se) {
            Log.error(se.getMessage());
        }
        return rs;
    }

    public static void insertIntoTable(TableData user, String str) {
        try {
            pstmt = ConnectionTable.connectToDB().prepareStatement(str);
            Log.info("Send request to DB: " + pstmt);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2, user.getUser_name());
            pstmt.setString(3, user.getCity());
            pstmt.setString(4, user.getBar());
            pstmt.execute();
        }
        catch (SQLException se) {
            Log.error(se.getMessage());
        }
    }

    public static void updateInTable(String value, String str) {
        try {
            pstmt = ConnectionTable.connectToDB().prepareStatement(str);
            pstmt.setString(1, value);
            pstmt.executeUpdate();
        } 
        catch (SQLException se) {
            Log.error(se.getMessage());
        }
    }

    public static void deleteTable(String str){
        try {
            pstmt = ConnectionTable.connectToDB().prepareStatement(str);

            pstmt.execute();
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }

    }

    public static void deleteFromTable(String value, String str) {
        try {
            Log.info("Send request to DB: " + pstmt);
            pstmt = ConnectionTable.connectToDB().prepareStatement(str);
            pstmt.setString(1,value);
            pstmt.execute();
            Log.info("Data from table was deleted successfully");
        } catch (SQLException se) {
            Log.error("Data from table was not deleted. Reason:\n" + se.getMessage());
        }
    }


}
