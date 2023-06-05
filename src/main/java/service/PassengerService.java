package service;

import model.Country;
import model.Passenger;
import utils.GenericDao;

import java.sql.SQLException;
import java.util.List;

public class PassengerService implements Service<Passenger> {
    private final GenericDao<Passenger> passengerDao;

    public PassengerService(GenericDao<Passenger> passengerDao) {
        this.passengerDao = passengerDao;
    }

    @Override
    public Passenger findByCode(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public Passenger findById(Passenger entity) throws SQLException {
        return passengerDao.findById(entity);
    }

    @Override
    public Passenger findByNum(Passenger entity) throws SQLException {
        return null;
    }

    @Override
    public List<Passenger> findAll() throws SQLException {
        return passengerDao.findAll();
    }

    @Override
    public boolean insert(Passenger entity) throws SQLException {
        return passengerDao.insert(entity);
    }

    @Override
    public boolean update(Passenger entity) throws SQLException {
        return passengerDao.update(entity);
    }

    @Override
    public boolean delete(Passenger entity) throws SQLException {
        return passengerDao.delete(entity);
    }
}


