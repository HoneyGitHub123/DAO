package service;

import model.Airline;
import model.Flight;
import utils.GenericDao;

import java.sql.SQLException;
import java.util.List;

public class FlightService implements Service<Flight> {


    private final GenericDao<Flight> flightDao;


    public FlightService(GenericDao<Flight> flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight findByCode(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Flight findById(Flight entity) throws SQLException {
        return null;
    }

    @Override
    public Flight findByNum(Flight entity) throws SQLException {
        return flightDao.findByNum(entity);

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
}
