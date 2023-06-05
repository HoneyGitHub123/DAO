package service;

import dao.AbstractDao;
import model.Airport;
import model.Country;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirportDao extends AbstractDao<Airport> {

    public Airport findByCode(Airport airport) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from airport where airport_code=?");
            statement.setString(1, airport.getAirportCode());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return getAirportFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public List<Airport> findAll() throws SQLException {
        List<Airport> airports = new ArrayList<Airport>();
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(" select * from airport;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airport airport = getAirportFromResultSet(resultSet);
                airports.add(airport);
            }
            return airports;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Airport airport) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(" Update airport set airport_name=? where airport_code=?");
            statement.setString(1, airport.getAirportName());
            statement.setString(2, airport.getAirportCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Airport airport) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from airport where airport_code=?");
            statement.setString(1, airport.getAirportCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Airport airport) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "insert into airport values (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, airport.getAirportCode());
            statement.setString(2, airport.getAirportName());
            statement.setString(3, airport.getCityName());
            statement.setString(4, airport.getCountryCode());
            statement.setString(5, airport.getStateName());

            int i = statement.executeUpdate();//returns number of rows affected

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Airport getAirportFromResultSet(ResultSet resultSet) throws SQLException {

        Airport airport = new Airport();
        airport.setAirportCode(resultSet.getString("airport_code"));
        airport.setAirportName(resultSet.getString("airport_name"));
        airport.setStateName(resultSet.getString("state_name"));
        airport.setCityNameCode(resultSet.getString("city_name"));
        return airport;
    }
}
