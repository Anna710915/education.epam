package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.Order;
import by.epam.connectiontask.entity.User;
import by.epam.connectiontask.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface OrderDao {
    List<Order> findAllUserOrders(User user) throws DaoException;
    boolean updateOrderStateById(long orderId, Order.OrderState orderState) throws DaoException;
    Optional<Order.OrderState> findOrderStateById(long orderId) throws DaoException;
}
