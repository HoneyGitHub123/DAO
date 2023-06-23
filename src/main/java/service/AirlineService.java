package service;

import model.Airline;
import utils.GenericDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirlineService implements Service<Airline> {

    private final GenericDao<Airline> airlineDao;


    public AirlineService(GenericDao<Airline> airlineDao) {
        this.airlineDao = airlineDao;
    }


    @Override
    public Optional<Airline> findByCode(Airline entity) throws SQLException {
        return airlineDao.findByCode(entity);
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
