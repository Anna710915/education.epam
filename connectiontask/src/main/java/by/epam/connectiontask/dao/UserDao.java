package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.User;
import by.epam.connectiontask.exception.DaoException;
import org.apache.logging.log4j.Level;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User>{
    private static final String SQL_SELECT_ALL_USERS =
            "SELECT user_id, first_name, last_name, login, user_password, email, phone, birthday, " +
                    "registration_date, discount_id, state_id, role_id FROM users";
    private static final String SQL_INSERT_NEW_USER = "INSERT INTO users(first_name, last_name, login, user_password, email, phone, birthday, " +
                                "registration_date, discount_id, state_id, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getLong("user_id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("user_password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhoneNumber(resultSet.getInt("phone"));
                user.setBirthday(resultSet.getDate("birthday").toLocalDate());
                user.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime());
                user.setDiscountId(resultSet.getLong("discount_id"));
                user.setStateId(resultSet.getLong("state_id"));
                user.setRoleId(resultSet.getLong("role_id"));
                userList.add(user);
            }
            logger.log(Level.INFO,"List: " + userList);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return userList;
    }

    @Override
    public User findEntityById(long id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(long id) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(User entity) throws DaoException {
        return false;
    }

    @Override
    public boolean create(User entity) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_INSERT_NEW_USER);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setInt(6, entity.getPhoneNumber());
            statement.setDate(7, Date.valueOf(entity.getBirthday().toString()));
            statement.setDate(8, Date.valueOf(entity.getRegistrationDate().toString()));
            statement.setLong(9, entity.getDiscountId());
            statement.setLong(10, entity.getStateId());
            statement.setLong(11, entity.getRoleId());
            logger.log(Level.INFO,"The new row: " + entity);
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User update(User entity) throws DaoException {
        return null;
    }
}
