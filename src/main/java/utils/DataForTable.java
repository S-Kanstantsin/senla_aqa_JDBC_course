package utils;

public class DataForTable {
    public static String NAME_TABLE = "ourDrinkUo";
    public static String CREATE_TABLE = "CREATE TABLE "+ NAME_TABLE +"("
            + "ID int(10) NOT NULL,"
            + "User_Name VARCHAR(45) NOT NULL,"
            + "City VARCHAR(45) NOT NULL,"
            + "Bar VARCHAR(45),"
            + "PRIMARY KEY (id))";
    public static String SELECT_ALL_DATA = "SELECT * FROM " + NAME_TABLE;
    public static String INSERT_DATA_TABLE = "INSERT INTO "+ NAME_TABLE +"("
            +"ID, User_Name, City, Bar)"
            +" VALUES(?,?,?,?)";
    public static String SELECT_FIRST_NAME ="SELECT * FROM "+ NAME_TABLE
            +" WHERE User_Name = \"Mack\"";
    public static String SELECT_FROM_ID= "SELECT City FROM "+ NAME_TABLE
            + "WHERE id = 1";
    public static String UPDATE_BAR ="UPDATE "+ NAME_TABLE +" SET Bar=?"
            +" WHERE City =  \"Grodno\"";
    public static String SELECT_JOIN_BAR = "SELECT u.City, cntr.Bar\n"
            +"FROM user u LEFT JOIN Bar cntr ON u.id=cntr.Bar WHERE City ='Grodno'";
    public static String DELETE_ID = "DELETE FROM "+ NAME_TABLE +" WHERE id=?";
    public static String DELETE_TABLE ="DROP TABLE "+ NAME_TABLE;

}
