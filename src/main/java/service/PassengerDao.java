package service;

import dboperations.PassengerSqlOperation;
import model.Airline;
import model.Passenger;
import utils.AbstractDao;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PassengerDao extends AbstractDao<Passenger> {


    public Optional<Passenger> findById(Passenger passenger) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PassengerSqlOperation.SELECT_BY_ID)) {
            statement.setInt(1, passenger.getPassengerID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return Optional.of(getPassengerFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Passenger> findByNum(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Passenger> findByCode(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public List<Passenger> findAll() throws SQLException {
        List<Passenger> passengers = new ArrayList<Passenger>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PassengerSqlOperation.SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Passenger passenger = getPassengerFromResultSet(resultSet);
                passengers.add(passenger);


            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return passengers;
    }


    @Override
    public boolean update(Passenger passenger) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PassengerSqlOperation.UPDATE)) {
            statement.setString(1, passenger.getPassengerName());
            statement.setInt(2, passenger.getPassengerID());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean delete(Passenger passenger) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PassengerSqlOperation.DELETE)) {
            statement.setInt(1, passenger.getPassengerID());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean insert(Passenger passenger) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(PassengerSqlOperation.INSERT)) {
            statement.setInt(1, passenger.getPassengerID());
            statement.setString(2, passenger.getPassengerName());
            statement.setString(3, passenger.getMobileNum());
            statement.setInt(4, passenger.getAge());
            statement.setString(5, passenger.getDob());
            statement.setString(6, passenger.getAddress());
            statement.setString(7, passenger.getCity());
            statement.setString(8, passenger.getState());
            statement.setString(9, passenger.getCountryCode());


            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Passenger getPassengerFromResultSet(ResultSet resultSet) throws SQLException {
        Passenger passenger = new Passenger();
        passenger.setPassengerID(resultSet.getInt("passenger_id"));
        passenger.setPassengerName(resultSet.getString("passenger_name"));
        passenger.setMobileNum(resultSet.getString("mobile_no"));
        passenger.setDob(resultSet.getString("dob"));
        passenger.setAge(resultSet.getInt("age"));
        passenger.setAddress(resultSet.getString("address"));
        passenger.setCity(resultSet.getString("city"));
        passenger.setState(resultSet.getString("state"));
        passenger.setCountryCode(resultSet.getString("country_code"));
        return passenger;
    }
}



