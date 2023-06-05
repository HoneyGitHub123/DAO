package service;

import utils.AbstractDao;
import model.Country;
import utils.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDao extends AbstractDao<Country> {

    @Override
    public Country findByCode(Country country) throws SQLException, SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement("select * from country where country_code=?");
            statement.setString(1, country.getCountryCode());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return getCountryFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Country findById(Country entity) throws SQLException {
        return null;
    }

    @Override
    public Country findByNum(Country entity) throws SQLException {
        return null;
    }

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(" select * from country;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = getCountryFromResultSet(resultSet);
                countries.add(country);
            }
            return countries;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

@Override
    public boolean insert(Country country) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "insert into country values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, country.getCountryCode());
            statement.setString(2, country.getCountryName());
            int i = statement.executeUpdate();//returns number of rows affected

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
@Override
    public boolean update(Country country) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(" Update country set country_name=? where country_code=?");
            statement.setString(1, country.getCountryName());
            statement.setString(2, country.getCountryCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

@Override
    public boolean delete(Country country) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from country where country_code=?");
            statement.setString(1, country.getCountryCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Country getCountryFromResultSet(ResultSet resultSet) throws SQLException {
        Country country = new Country();
        country.setCountryCode(resultSet.getString("country_code"));
        country.setCountryName(resultSet.getString("country_name"));
        return country;
    }


}
