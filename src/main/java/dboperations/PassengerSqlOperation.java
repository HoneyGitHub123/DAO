package dboperations;

public class PassengerSqlOperation {

    public static final String SELECT_BY_ID = "SELECT * FROM passenger WHERE passenger_id=?";
    public static final String SELECT_ALL = "SELECT * FROM passenger";
    public static final String UPDATE = "UPDATE passenger SET passenger_name=? WHERE passenger_id=?";
    public static final String DELETE = "DELETE FROM passenger WHERE passenger_id=?";
    public static final String INSERT = "INSERT INTO passenger(passenger_id,passenger_name,mobile_no,age,dob,address,city,state,country_code) VALUES(?,?,?,?,?,?,?,?,?)";

}

