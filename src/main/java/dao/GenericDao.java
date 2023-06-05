package dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T findByCode(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean insert(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean delete(T entity) throws SQLException;


}
