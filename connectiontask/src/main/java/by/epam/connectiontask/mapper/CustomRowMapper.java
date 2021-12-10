package by.epam.connectiontask.mapper;


import by.epam.connectiontask.exception.DaoException;

import java.sql.ResultSet;

@FunctionalInterface
public interface CustomRowMapper<T> {
    T mapRow(ResultSet resultSet) throws DaoException;
}
