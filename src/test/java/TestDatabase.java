import databaseConnect.*;
import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static utils.DataForTable.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDatabase  {


    @Test
    @Order(1)
    public void testCreateTable() {
        JDBCConnection.createTable(CREATE_TABLE);
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_ALL_DATA);
        assertNotNull(rs,"Table don't create");
    }

    @Test
    @Order(2)
    public void testInsertRequest() {
        TableData tableData = new TableData(1, "Mack", "Grodno", "Drunk cherry");
        JDBCConnection.insertIntoTable(tableData, INSERT_DATA_TABLE);
        TableData tableDataSecond = new TableData(3, "Don", "Grodno", "Lulu");
        JDBCConnection.insertIntoTable(tableDataSecond, INSERT_DATA_TABLE);
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_FIRST_NAME);
        assertAll("Should return inserted data",
                () -> assertEquals("1", rs.getString("ID")),
                () -> assertEquals("Mack", rs.getString("User_Name")),
                () -> assertEquals("Grodno", rs.getString("City")),
                () -> assertEquals("Drunk cherry", rs.getString("Bar")));
    }


    @Test
    @Order(3)
    public void selectTest() throws SQLException {
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_FIRST_NAME);
        String actualName = rs.getString("User_Name");
        assertEquals("Mack", actualName);
    }

    @Test
    @Order(4)
    public void updateTableTest() throws SQLException {
        JDBCConnection.updateInTable("Bardak",UPDATE_BAR);
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_ALL_DATA);
        String actualLastName = rs.getString("Bar");
        assertTrue("Bardak".contains(actualLastName));
    }


    @Test
    @Order(5)
    public void selectJoinTest() throws SQLException {
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_JOIN_BAR);
        String expectedBar = "Bardak";
        String actualBar = rs.getString("Bar");
        assertEquals(expectedBar, actualBar, "Actual bar is '" + actualBar + "'. Expected - '" + expectedBar + "'.");
    }



    @Test
    @Order(6)
    public void testSelectRequest_checkAddress() throws SQLException {
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_FROM_ID);
        String expectedCity = "Grodno";
        String actualCity = rs.getString("City");
        assertEquals(expectedCity, actualCity, "Actual city is '" + actualCity + "'. Expected - '" + expectedCity + "'.");
    }

    @Test
    @Order(7)
    public void deleteDataFromTableTest(){
        JDBCConnection.deleteFromTable("20",DELETE_ID);
        ResultSet rs = JDBCConnection.selectFromTable(SELECT_FROM_ID+"20");
        assertNotNull(rs,"Don't delete data from a table");
    }



    @Test
    @Order(8)
    public void deleteTableTest() {
        JDBCConnection.deleteTable(DELETE_TABLE);
    }

}
