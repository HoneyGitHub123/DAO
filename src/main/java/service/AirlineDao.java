package service;

import dboperations.AirlineSqlOperation;
import utils.AbstractDao;
import model.Airline;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dboperations.AirlineSqlOperation.*;

public class AirlineDao extends AbstractDao<Airline> {
    @Override
    public Optional<Airline> findByCode(Airline airline) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_CODE)) {
            statement.setString(1, airline.getAirlineCode());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {

                    return Optional.of(getAirlineFromResultSet(resultSet));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }


    @Override
    public Optional<Airline> findById(Airline entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Airline> findByNum(Airline entity) throws SQLException {
        return null;
    }

    @Override
    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<Airline>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(AirlineSqlOperation.SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Airline airline = new Airline();
                airline = getAirlineFromResultSet(resultSet);
                airlines.add(airline);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return airlines;
    }


    @Override
    public boolean update(Airline airline) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(AirlineSqlOperation.UPDATE)) {
            statement.setString(1, airline.getAirlineName());
            statement.setString(2, airline.getAirlineCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(Airline airline) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(AirlineSqlOperation.DELETE)) {
            statement.setString(1, airline.getAirlineCode());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert(Airline airline) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(AirlineSqlOperation.INSERT)) {
            statement.setString(1, airline.getAirlineName());
            statement.setString(2, airline.getAirlineCode());
            int rowsAffected = statement.executeUpdate();//returns number of rows affected
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Airline getAirlineFromResultSet(ResultSet resultSet) throws SQLException {
        Airline airline = new Airline();
        airline.setAirlineCode(resultSet.getString("airline_code"));
        airline.setAirlineName(resultSet.getString("airline_name"));
        return airline;
    }


}