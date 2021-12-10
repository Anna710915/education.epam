package by.epam.connectiontask.mapper.impl;

import by.epam.connectiontask.entity.UserDiscount;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.mapper.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDiscountMapper implements CustomRowMapper<UserDiscount> {
    public static final String DISCOUNT_ID = "discount_id";
    public static final String DISCOUNT = "discount";
    public static final String YEAR_ORDERS = "year_orders";

    @Override
    public UserDiscount mapRow(ResultSet resultSet) throws DaoException {
        UserDiscount userDiscount = new UserDiscount();
        try {
            userDiscount.setDiscountId(resultSet.getLong(DISCOUNT_ID));
            userDiscount.setDiscount(resultSet.getBigDecimal(DISCOUNT));
            userDiscount.setYearOrders(resultSet.getInt(YEAR_ORDERS));
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userDiscount;
    }
}
