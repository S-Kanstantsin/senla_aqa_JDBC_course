package databaseConnect;

public class TableData {
    private int id;
    private String user_name;
    private String city;
    private String bar;

    public TableData(int id, String user_name, String city, String bar) {
        this.id = id;
        this.user_name  = user_name;
        this.city = city;
        this.bar = bar;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getCity() {
        return city;
    }

    public String getBar() {
        return bar;
    }

}
