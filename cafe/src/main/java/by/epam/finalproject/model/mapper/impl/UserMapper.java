package by.epam.finalproject.model.mapper.impl;

import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.mapper.CustomRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static by.epam.finalproject.model.mapper.impl.UserDiscountMapper.DISCOUNT;
import static by.epam.finalproject.model.mapper.impl.UserDiscountMapper.DISCOUNT_ID;

public class UserMapper implements CustomRowMapper<User> {
    public static final String USER_ID = "user_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "user_password";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone";
    public static final String BIRTHDAY = "birthday";
    public static final String USER_STATE = "state";
    public static final String USER_ROLE = "role_name";

    @Override
    public Optional<User> mapRow(ResultSet resultSet) {
        User user = new User();
        Optional<User> optionalUser;
        try {
            user.setUserId(resultSet.getLong(USER_ID));
            user.setFirstName(resultSet.getString(FIRST_NAME));
            user.setLastName(resultSet.getString(LAST_NAME));
            user.setLogin(resultSet.getString(LOGIN));
            user.setPassword(resultSet.getString(PASSWORD));
            user.setEmail(resultSet.getString(EMAIL));
            user.setPhoneNumber(resultSet.getInt(PHONE_NUMBER));
            user.setBirthday(resultSet.getDate(BIRTHDAY).toLocalDate());
            user.setDiscountId(resultSet.getLong(DISCOUNT_ID));
            user.setState(User.UserState.valueOf(resultSet.getString(USER_STATE)
                    .trim().toUpperCase()));
            user.setRole(User.UserRole.valueOf(resultSet.getString(USER_ROLE)
                    .trim().toUpperCase()));
            optionalUser = Optional.of(user);
        } catch (SQLException e) {
            optionalUser = Optional.empty();
        }
        return optionalUser;
    }
}
