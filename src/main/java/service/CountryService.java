package service;

import dao.GenericDao;
import model.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryService implements Service<Country>{

    private final GenericDao<Country> countryDao;

    public CountryService(GenericDao<Country> countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country findByCode(Country entity) throws SQLException {
        return countryDao.findByCode(entity);
    }

    @Override
    public List<Country> findAll() throws SQLException {
        return countryDao.findAll() ;
    }

    @Override
    public boolean insert(Country entity) throws SQLException {
        return countryDao.insert(entity);
    }

    @Override
    public boolean update(Country entity) throws SQLException {
        return countryDao.update(entity);
    }

    @Override
    public boolean delete(Country entity) throws SQLException {
        return countryDao.delete(entity);
    }
}
