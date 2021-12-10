package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.Menu;
import by.epam.connectiontask.entity.Order;
import by.epam.connectiontask.exception.DaoException;

import java.util.Map;
import java.util.Optional;

public interface MenuDao {
    Optional<String> findImagePathByName(String name) throws DaoException;
    boolean updateImagePathByName(String name, String filePath) throws DaoException;
    Optional<Menu> findFoodByName(String name) throws DaoException;
    Map<Menu,Integer> findAllOrderFood(Order order) throws DaoException;
}
