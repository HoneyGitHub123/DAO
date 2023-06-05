package service;

import dao.AbstractDao;
import model.Airline;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDao extends AbstractDao<Airline> {

    public Airline findByCode(Airline airline) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from airline where airline_code=?");
            statement.setString(1, airline.getAirlineCode());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return getAirlineFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public List<Airline> findAll() throws SQLException {
        List<Airline> airlines = new ArrayList<Airline>();
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(" select * from airline;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airline airline = getAirlineFromResultSet(resultSet);
                airlines.add(airline);
            }
            return airlines;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public boolean update(Airline airline) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(" Update airline set airline_name=? where airline_code=?");
            statement.setString(1, airline.getAirlineName());
            statement.setString(2, airline.getAirlineCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Airline airline) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from airline where airline_code=?");
            statement.setString(1, airline.getAirlineCode());
            int i = statement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(Airline airline) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "insert into airline(airline_name,airline_code) values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, airline.getAirlineName());
            statement.setString(2, airline.getAirlineCode());

            int i = statement.executeUpdate();//returns number of rows affected

            if (i == 1) {
                return true;
            }
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
