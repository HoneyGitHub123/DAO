package service;

import model.Flight;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Service<T> {

    Optional<T> findByCode(T entity) throws SQLException;

    Optional<T> findById(T entity) throws SQLException;

    Optional<T> findByNum(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean insert(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;

}
