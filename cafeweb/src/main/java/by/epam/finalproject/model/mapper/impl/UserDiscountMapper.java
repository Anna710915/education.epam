package by.epam.finalproject.model.mapper.impl;

import by.epam.finalproject.model.entity.UserDiscount;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.model.mapper.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDiscountMapper implements CustomRowMapper<UserDiscount> {
    public static final String DISCOUNT_ID = "discount_id";
    public static final String DISCOUNT = "discount";
    public static final String YEAR_ORDERS = "year_orders";

    @Override
    public Optional<UserDiscount> mapRow(ResultSet resultSet) throws DaoException {
        UserDiscount userDiscount = new UserDiscount();
        Optional<UserDiscount> optionalUserDiscount;
        try {
            userDiscount.setDiscountId(resultSet.getLong(DISCOUNT_ID));
            userDiscount.setDiscount(resultSet.getBigDecimal(DISCOUNT));
            userDiscount.setYearOrders(resultSet.getInt(YEAR_ORDERS));
            optionalUserDiscount = Optional.of(userDiscount);
        } catch (SQLException e) {
            optionalUserDiscount = Optional.empty();
        }
        return optionalUserDiscount;
    }
}
