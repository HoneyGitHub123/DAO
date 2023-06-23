package service;

import dboperations.FlightSqlOperation;
import model.Airline;
import model.Flight;
import utils.AbstractDao;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao extends AbstractDao<Flight> {


    @Override
    public Optional<Flight> findByCode(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Flight> findById(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Optional<Flight> findByNum(Flight flight) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FlightSqlOperation.SELECT_BY_CODE)) {
            statement.setInt(1, flight.getFlightNo());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return Optional.of(getFlightFromResultSet(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }


    @Override
    public List<Flight> findAll() throws SQLException {
        List<Flight> flights = new ArrayList<Flight>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FlightSqlOperation.SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = getFlightFromResultSet(resultSet);
                flights.add(flight);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flights;
    }

    private Flight getFlightFromResultSet(ResultSet resultSet) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightNo(resultSet.getInt("flight_no"));
        flight.setFlightName(resultSet.getString("flight_name"));
        flight.setDepTime(resultSet.getString("dep_time"));
        flight.setArrivalTime(resultSet.getString("arr_time"));
        flight.setSource(resultSet.getString("source_place"));
        flight.setDestination(resultSet.getString("destination"));
        flight.setSeat(resultSet.getInt("seat_available"));
        return flight;
    }


    @Override
    public boolean insert(Flight entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Flight entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Flight entity) throws SQLException {
        return false;
    }


}
