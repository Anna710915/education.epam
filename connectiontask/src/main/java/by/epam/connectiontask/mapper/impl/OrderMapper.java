package by.epam.connectiontask.mapper.impl;

import by.epam.connectiontask.entity.Order;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.mapper.CustomRowMapper;

import static by.epam.connectiontask.mapper.impl.UserMapper.USER_ID;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements CustomRowMapper<Order> {
    public static final String ORDER_ID = "order_id";
    public static final String ORDER_DATE = "order_date";
    public static final String ORDER_STATE = "order_state";
    public static final String TYPE_PAYMENT = "type_payment";
    public static final String USER_COMMENT = "user_comment";
    public static final String COMMENT_DATE = "comment_date";

    @Override
    public Order mapRow(ResultSet resultSet) throws DaoException {
        Order order = new Order();
        try {
            order.setOrderId(resultSet.getLong(ORDER_ID));
            order.setOrderDate(resultSet.getTimestamp(ORDER_DATE).toLocalDateTime());
            order.setOrderState(Order.OrderState.valueOf(resultSet.getString(ORDER_STATE)
                    .trim().toUpperCase()));
            order.setTypePayment(Order.TypePayment.valueOf(resultSet.getString(TYPE_PAYMENT)
                    .trim().toUpperCase()));
            order.setUserComment(resultSet.getString(USER_COMMENT));
            order.setCommentDate(resultSet.getTimestamp(COMMENT_DATE).toLocalDateTime());
            order.setUserId(resultSet.getLong(USER_ID));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return order;
    }
}
