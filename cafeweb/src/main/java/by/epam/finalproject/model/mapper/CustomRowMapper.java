package by.epam.finalproject.model.mapper;

import by.epam.finalproject.model.entity.CustomEntity;
import by.epam.finalproject.exception.DaoException;

import java.sql.ResultSet;
import java.util.Optional;

@FunctionalInterface
public interface CustomRowMapper<T extends CustomEntity> {
    Optional<T> mapRow(ResultSet resultSet) throws DaoException;
}
