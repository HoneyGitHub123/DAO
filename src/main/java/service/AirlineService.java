package service;

import model.Airline;
import model.Airport;
import utils.GenericDao;

import java.sql.SQLException;
import java.util.List;

public class AirlineService implements Service<Airline> {

    private final GenericDao<Airline> airlineDao;


    public AirlineService(GenericDao<Airline> airlineDao) {
        this.airlineDao = airlineDao;
    }


    @Override
    public Airline findByCode(Airline entity) throws SQLException {
        return airlineDao.findByCode(entity);
    }

    @Override
    public Airline findById(Airline entity) throws SQLException {
        return null;
    }

    @Override
    public Airline findByNum(Airline entity) throws SQLException {
        return null;
    }

    @Override
    public List<Airline> findAll() throws SQLException {
        return airlineDao.findAll();
    }

    @Override
    public boolean insert(Airline entity) throws SQLException {
        return airlineDao.insert(entity);
    }

    @Override
    public boolean update(Airline entity) throws SQLException {
        return airlineDao.update(entity);
    }

    @Override
    public boolean delete(Airline entity) throws SQLException {
        return airlineDao.delete(entity);
    }


}
