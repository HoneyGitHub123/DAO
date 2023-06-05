package service;

import model.Airport;
import model.Flight;
import utils.AbstractDao;
import utils.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FlightDao extends AbstractDao<Flight> {


    @Override
    public Flight findByCode(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Flight findById(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Flight findByNum(Flight flight) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from flight where flight_no=?");
            statement.setInt(1, flight.getFlightNo());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return getFlightFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    @Override
    public List<Flight> findAll() throws SQLException {
        return null;
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
}
