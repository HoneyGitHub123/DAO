package dboperations;

public class AirlineSqlOperation {
    public static final String SELECT_BY_CODE = "SELECT * FROM airline WHERE airline_code=?";
    public static final String SELECT_ALL = "SELECT * FROM airline";
    public static final String UPDATE = "UPDATE airline SET airline_name=? WHERE airline_code=?";
    public static final String DELETE = "DELETE FROM airline WHERE airline_code=?";
    public static final String INSERT = "INSERT INTO airline(airline_name, airline_code) VALUES (?, ?)";
}
