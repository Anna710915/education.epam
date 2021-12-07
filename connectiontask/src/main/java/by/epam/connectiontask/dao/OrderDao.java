package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.Order;
import by.epam.connectiontask.exception.DaoException;

import java.util.List;

public class OrderDao extends AbstractDao<Order>{
    @Override
    public List<Order> findAll() throws DaoException {
        return null;
    }

    @Override
    public Order findEntityById(long id) throws DaoException{
        return null;
    }

    @Override
    public boolean delete(long id) throws DaoException{
        return false;
    }

    @Override
    public boolean delete(Order entity) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Order entity) throws DaoException {
        return false;
    }

    @Override
    public Order update(Order entity) throws DaoException {
        return null;
    }
}
