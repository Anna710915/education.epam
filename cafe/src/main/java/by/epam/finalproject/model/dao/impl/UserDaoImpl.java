package by.epam.finalproject.model.dao.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.model.dao.AbstractDao;
import by.epam.finalproject.model.dao.UserDao;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.mapper.impl.UserMapper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static by.epam.finalproject.model.mapper.impl.UserMapper.PASSWORD;
import static by.epam.finalproject.model.mapper.impl.UserMapper.USER_STATE;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    private static final Logger logger = LogManager.getLogger();
    private static final String SQL_SELECT_ALL_USERS = """
            SELECT user_id, first_name, last_name, login, user_password, email, phone, birthday,
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id""";
    private static final String SQL_INSERT_NEW_USER = """ 
            INSERT INTO users(first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state_id, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
    private static final String SQL_SELECT_USER_BY_ID = """
            SELECT user_id, first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id
            WHERE user_id = (?)""";
    private static final String SQL_DELETE_USER_BY_ID = """
            DELETE FROM users WHERE user_id = (?)""";
    private static final String SQL_UPDATE_USER = """
            UPDATE users SET first_name = (?), last_name = (?), login = (?), user_password = (?), email = (?), 
            phone = (?), birthday = (?), discount_id = (?), state_id = (?), role_id = (?) 
            WHERE user_id = (?)""";
    public static final String SQL_SELECT_PASSWORD_BY_LOGIN = """
            SELECT user_password FROM users WHERE login = (?) """;
    private static final String SQL_UPDATE_PASSWORD_BY_LOGIN = """
            UPDATE users SET user_password = (?) WHERE login = (?)""";
    private static final String SQL_UPDATE_USER_STATE_BY_LOGIN = """
            UPDATE users SET state_id = (?) where login = (?)""";
    private static final String SQL_UPDATE_USER_STATE_BY_ID = """
            UPDATE users SET state_id = (?) WHERE user_id = (?)""";
    private static final String SQL_SELECT_USER_BY_LOGIN = """
            SELECT users.user_id, first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id WHERE login = (?)""";
    private static final String SQL_SELECT_USER_BY_PHONE_NUMBER = """
            SELECT users.user_id, first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id WHERE phone = (?)""";
    private static final String SQL_SELECT_USER_BY_EMAIL = """
            SELECT users.user_id, first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id WHERE email = (?)""";
    private static final String SQL_SELECT_USER_STATE_BY_ID = """
            SELECT state FROM users JOIN user_state ON users.state_id = user_state.state_id
            WHERE users.user_id = (?)""";
    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD = """
            SELECT users.user_id, first_name, last_name, login, user_password, email, phone, birthday, 
            discount_id, state, role_name FROM users
            JOIN user_state ON user_state.state_id = users.state_id
            JOIN user_role ON user_role.role_id = users.role_id WHERE login = (?) AND user_password = (?)""";

    @Override
    public List<User> findAll() throws DaoException {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Optional<User> optionalUser = new UserMapper().mapRow(resultSet);
                if(optionalUser.isPresent()) {
                    userList.add(optionalUser.get());
                }
            }
            logger.log(Level.INFO,"List: " + userList);
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return userList;
    }

    @Override
    public User findEntityById(long id) throws DaoException {
        PreparedStatement statement = null;
        User user = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_ID);
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Optional<User> optionalUser = new UserMapper().mapRow(resultSet);
                if(optionalUser.isPresent()) {
                    user = optionalUser.get();
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }

    @Override
    public boolean delete(long id) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = this.proxyConnection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setLong(1,id);
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
    }

    @Override
    public boolean delete(User entity) throws DaoException {
        PreparedStatement statement = null;
        try {
            statement = this.proxyConnection.prepareStatement(SQL_DELETE_USER_BY_ID);
            statement.setLong(1,entity.getUserId());
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
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
            statement.setLong(8, entity.getDiscountId());
            statement.setLong(9, entity.getState().getStateId());
            statement.setLong(10, entity.getRole().getRoleId());
            logger.log(Level.INFO,"The new row: " + entity);
            return statement.executeUpdate() != 0 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
    }

    @Override
    public User update(User entity) throws DaoException {
        PreparedStatement statement = null;
        User user;
        try{
            user = findEntityById(entity.getUserId());
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLogin());
            statement.setString(4, entity.getPassword());
            statement.setString(5, entity.getEmail());
            statement.setInt(6, entity.getPhoneNumber());
            statement.setDate(7, Date.valueOf(entity.getBirthday().toString()));
            statement.setLong(8, entity.getDiscountId());
            statement.setLong(9, entity.getState().getStateId());
            statement.setLong(10, entity.getRole().getRoleId());
            statement.setLong(11,entity.getUserId());
            return statement.executeUpdate() != 0 ? user : null;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
    }

    @Override
    public Optional<String> findPasswordByLogin(String login) throws DaoException {
        PreparedStatement statement = null;
        Optional<String> password = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_PASSWORD_BY_LOGIN);
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                password = Optional.of(resultSet.getString(PASSWORD));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return password;
    }

    @Override
    public boolean updatePasswordByLogin(String password, String login) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_PASSWORD_BY_LOGIN);
            statement.setString(1,password);
            statement.setString(2,login);
            return statement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
    }

    @Override
    public boolean updateUserStateByLogin(User.UserState state, String login) throws DaoException{
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_USER_STATE_BY_LOGIN);
            statement.setLong(1,state.getStateId());
            statement.setString(2,login);
            return statement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
    }

    @Override
    public boolean updateUserState(long userId, long stateId) throws DaoException {
        PreparedStatement statement = null;
        try{
            statement = this.proxyConnection.prepareStatement(SQL_UPDATE_USER_STATE_BY_ID);
            statement.setLong(1,stateId);
            statement.setLong(2,userId);
            return statement.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);
            statement.setString(1,login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new UserMapper().mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByPhoneNumber(int phone) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_PHONE_NUMBER);
            statement.setInt(1,phone);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new UserMapper().mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
            statement.setString(1,email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new UserMapper().mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByOrder(long orderId) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_EMAIL);
            statement.setLong(1,orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new UserMapper().mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }

    @Override
    public Optional<User.UserState> findStateById(long userId) throws DaoException {
        PreparedStatement statement = null;
        Optional<User.UserState> userState = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_STATE_BY_ID);
            statement.setLong(1,userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                userState = Optional.of(User.UserState.valueOf(resultSet.getString(USER_STATE)
                        .trim().toUpperCase()));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return userState;
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        PreparedStatement statement = null;
        Optional<User> user = Optional.empty();
        try{
            statement = this.proxyConnection.prepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASSWORD);
            statement.setString(1,login);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = new UserMapper().mapRow(resultSet);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            close(statement);
        }
        return user;
    }
}
