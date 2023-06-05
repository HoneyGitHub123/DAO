package service;

import model.Airport;
import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface Service <T>{

    T findByCode(T entity) throws SQLException;

    T findById(T entity) throws SQLException;
    T findByNum(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean insert(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

}
