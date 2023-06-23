package service;

import dboperations.CountrySqlOperation;
import model.Airline;
import utils.AbstractDao;
import model.Country;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountryDao extends AbstractDao<Country> {

    @Override
    public Optional<Country> findByCode(Country country) throws SQLException, SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CountrySqlOperation.SELECT_BY_CODE)) {
            statement.setString(1, country.getCountryCode());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return Optional.of(getCountryFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Country> findById(Country entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Country> findByNum(Country entity) throws SQLException {
        return null;
    }

    @Override
    public List<Country> findAll() throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CountrySqlOperation.SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = getCountryFromResultSet(resultSet);
                countries.add(country);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return countries;
    }


    @Override
    public boolean insert(Country country) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CountrySqlOperation.INSERT)) {
            statement.setString(1, country.getCountryCode());
            statement.setString(2, country.getCountryName());
            int rowsAffected = statement.executeUpdate();//returns number of rows affected
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Country country) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CountrySqlOperation.UPDATE)) {
            statement.setString(1, country.getCountryName());
            statement.setString(2, country.getCountryCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Country country) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CountrySqlOperation.DELETE)) {
            statement.setString(1, country.getCountryCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
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