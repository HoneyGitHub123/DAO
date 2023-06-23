package dboperations;

public class CountrySqlOperation {

    public static final String SELECT_BY_CODE = "SELECT * FROM country WHERE country_code=?";
    public static final String SELECT_ALL = "SELECT * FROM Country";
    public static final String UPDATE = "UPDATE country SET country_name=? WHERE country_code=?";
    public static final String DELETE = "DELETE FROM country WHERE country_code=?";
    public static final String INSERT = "INSERT INTO country(country_code, country_name) VALUES (?, ?)";

}
