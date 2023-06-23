package dboperations;

public class AirportSqlOperation {
    public static final String SELECT_BY_CODE = "SELECT * FROM airport WHERE airport_code=?";
    public static final String SELECT_ALL = "SELECT * FROM airport";
    public static final String UPDATE = "UPDATE airport SET airport_name=? WHERE airport_code=?";
    public static final String DELETE = "DELETE FROM airport WHERE airport_code=?";
}


