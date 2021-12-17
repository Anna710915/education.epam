package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.model.dao.AbstractDao;
import by.epam.finalproject.model.dao.OrderDao;
import by.epam.finalproject.model.entity.Order;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.mapper.impl.OrderMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.epam.finalproject.model.mapper.impl.OrderMapper.ORDER_STATE;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String SQL_SELECT_ALL_ORDERS = """
            SELECT order_id, order_date, order_state, type_payment, user_comment,
            comment_date, user_id FROM orders""";
    private static final String SQL_SELECT_ORDER_BY_ID = """
            SELECT order_id, order_date, order_state, type_payment, user_comment,
            comment_date, user_id FROM orders WHERE order_id = (?)""";
    private static final String SQL_INSERT_NEW_ORDER = """
            INSERT INTO orders(order_date, order_state, type_payment, user_comment,
            comment_date, user_id) VALUES (?, ?, ?, ?, ?, ?)""";
    private static final String SQL_DELETE_ORDER = """
            DELETE FROM orders WHERE order_id = (?)""";
    private static final String SQL_UPDATE_ORDER = """
            UPDATE orders SET order_date = (?), order_date = (?), order_state = (?), 
            type_payment = (?), user_comment = (?), comment_date = (?), user_id = (?)
            WHERE order_id = (?)""";
    private static final String SQL_SELECT_ALL_USER_ORDERS = """
            SELECT order_id, order_date, order_state, type_payment, user_comment,
            comment_date, user_id FROM orders WHERE user_id = (?)""";
    private static final String SQL_UPDATE_ORDER_STATE_BY_ID = """
            UPDATE orders SET order_state = (?) WHERE order_id = (?)""";
    private static final String SQL_SELECT_ORDER_STATE_BY_ID = """
            SELECT order_state FROM orders WHERE order_id = (?)""";


    @Override
    public List<Order> findAll() throws DaoException {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ALL_ORDERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Optional<Order> optionalOrder = new OrderMapper().mapRow(resultSet);
                if(optionalOrder.isPresent()) {
                    orderList.add(optionalOrder.get());
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return orderList;
    }

    @Override
    public Order findEntityById(long id) throws DaoException{
        Order order = new Order();
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ORDER_BY_ID);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Optional<Order> optionalOrder = new OrderMapper().mapRow(resultSet);
                if(optionalOrder.isPresent()) {
                    order = optionalOrder.get();
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return order;
    }

    @Override
    public boolean delete(long id) throws DaoException{
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_DELETE_ORDER);
            statement.setLong(1,id);
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }

    }

    @Override
    public boolean delete(Order entity) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_DELETE_ORDER);
            statement.setLong(1,entity.getOrderId());
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
    }

    @Override
    public boolean create(Order entity) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_INSERT_NEW_ORDER);
            statement.setDate(1, Date.valueOf(entity.getOrderDate().toString()));
            statement.setString(2,entity.getOrderState().getState());
            statement.setString(3,entity.getTypePayment().getPayment());
            statement.setString(4,entity.getUserComment());
            statement.setDate(5,Date.valueOf(entity.getCommentDate().toString()));
            statement.setLong(6,entity.getUserId());
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
    }

    @Override
    public Order update(Order entity) throws DaoException {
        PreparedStatement statement = null;
        Order order;
        try{
            order = findEntityById(entity.getOrderId());
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_ORDER);
            statement.setDate(1, Date.valueOf(entity.getOrderDate().toString()));
            statement.setString(2,entity.getOrderState().getState());
            statement.setString(3,entity.getTypePayment().getPayment());
            statement.setString(4,entity.getUserComment());
            statement.setDate(5,Date.valueOf(entity.getCommentDate().toString()));
            statement.setLong(6,entity.getUserId());
            statement.setLong(7,entity.getOrderId());
            return statement.executeUpdate() != 0 ? order : null;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
    }

    @Override
    public List<Order> findAllUserOrders(User user) throws DaoException {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ALL_USER_ORDERS);
            statement.setLong(1,user.getUserId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Optional<Order> optionalOrder = new OrderMapper().mapRow(resultSet);
                if(optionalOrder.isPresent()) {
                    orderList.add(optionalOrder.get());
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return orderList;
    }


    @Override
    public boolean updateOrderStateById(long orderId, Order.OrderState orderState) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_ORDER_STATE_BY_ID);
            statement.setString(1,orderState.getState());
            statement.setLong(2,orderId);
            return statement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
    }

    @Override
    public Optional<Order.OrderState> findOrderStateById(long orderId) throws DaoException {
        PreparedStatement statement = null;
        Optional<Order.OrderState> state = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ORDER_STATE_BY_ID);
            statement.setLong(1,orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                state = Optional.of(Order.OrderState.valueOf(resultSet.getString(ORDER_STATE)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return state;
    }
}
