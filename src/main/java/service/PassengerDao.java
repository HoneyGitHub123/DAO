package service;

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

public class PassengerDao extends AbstractDao<Passenger> {


    public Passenger findById(Passenger passenger) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from passenger where passenger_id=?");
            statement.setInt(1, passenger.getPassengerID());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                return getPassengerFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Passenger findByNum(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public Passenger findByCode(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public List<Passenger> findAll() throws SQLException {
        List<Passenger> passengers = new ArrayList<Passenger>();
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(" select * from passenger;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Passenger passenger = getPassengerFromResultSet(resultSet);
                passengers.add(passenger);
            }
            return passengers;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Passenger passenger) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(" Update passenger set passenger_name=? where passenger_id=?");
            statement.setString(1, passenger.getPassengerName());
            statement.setInt(2, passenger.getPassengerID());
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
    public boolean delete(Passenger passenger) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from passenger where passenger_id=?");
            statement.setInt(1, passenger.getPassengerID());
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
    public boolean insert(Passenger passenger) throws SQLException {
        Connection connection = DataBaseConnection.getConnection();
        String sql = "insert into passenger(passenger_id,passenger_name,mobile_no,age,dob,address,city,state,country_code) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, passenger.getPassengerID());
            statement.setString(2, passenger.getPassengerName());
            statement.setString(3, passenger.getMobileNum());
            statement.setInt(4, passenger.getAge());
            statement.setString(5, passenger.getDob());
            statement.setString(6, passenger.getAddress());
            statement.setString(7, passenger.getCity());
            statement.setString(8, passenger.getState());
            statement.setString(9, passenger.getCountryCode());


            int i = statement.executeUpdate();//returns number of rows affected

            if (i == 1) {
                return true;
            }
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

