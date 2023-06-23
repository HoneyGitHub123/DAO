package service;

import dboperations.AirportSqlOperation;
import utils.AbstractDao;
import model.Airport;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dboperations.AirportSqlOperation.*;

public class AirportDao extends AbstractDao<Airport> {
    @Override
    public Optional<Airport> findByCode(Airport airport) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_CODE)) {
            statement.setString(1, airport.getAirportCode());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    return Optional.of(getAirlineFromResultSet(resultSet));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return Optional.empty();
        }
    }


    @Override
    public Optional<Airport> findById(Airport entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Airport> findByNum(Airport entity) throws SQLException {
        return null;
    }

    @Override
    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<Airport>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(AirportSqlOperation.SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airport airport = getAirlineFromResultSet(resultSet);
                airports.add(airport);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return airports;
    }

    @Override
    public boolean insert(Airport entity) throws SQLException {

        return false;
    }


    @Override
    public boolean update(Airport airport) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(AirportSqlOperation.UPDATE)) {
            statement.setString(1, airport.getAirportName());
            statement.setString(2, airport.getAirportCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(Airport airport) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(AirportSqlOperation.DELETE)) {
            statement.setString(1, airport.getAirportCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Airport getAirlineFromResultSet(ResultSet resultSet) throws SQLException {
        Airport airport = new Airport();
        airport.setAirportCode(resultSet.getString("airport_code"));
        airport.setAirportName(resultSet.getString("airport_name"));
        airport.setStateName(resultSet.getString("state_name"));
        airport.setCityNameCode(resultSet.getString("city_name"));
        return airport;
    }
}
