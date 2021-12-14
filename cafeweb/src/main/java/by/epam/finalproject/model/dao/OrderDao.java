package by.epam.finalproject.model.dao;

import by.epam.finalproject.model.entity.Order;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> findAllUserOrders(User user) throws DaoException;
    boolean updateOrderStateById(long orderId, Order.OrderState orderState) throws DaoException;
    Optional<Order.OrderState> findOrderStateById(long orderId) throws DaoException;
}
