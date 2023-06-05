package service;

import dao.GenericDao;
import model.Airport;

import java.sql.SQLException;
import java.util.List;

public class AirportService implements Service<Airport> {

    private final GenericDao<Airport> airportDao;

    public AirportService(GenericDao<Airport> airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public Airport findByCode(Airport entity) throws SQLException {
        return airportDao.findByCode(entity);
    }

    @Override
    public List<Airport> findAll() throws SQLException {
        return airportDao.findAll();
    }

    @Override
    public boolean insert(Airport entity) throws SQLException {
        return airportDao.insert(entity);
    }

    @Override
    public boolean update(Airport entity) throws SQLException {
        return airportDao.update(entity);
    }

    @Override
    public boolean delete(Airport entity) throws SQLException {
        return airportDao.delete(entity);
    }


}

