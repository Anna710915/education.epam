package by.epam.connectiontask.dao;

import by.epam.connectiontask.entity.User;
import by.epam.connectiontask.exception.DaoException;

import java.util.Optional;

public interface UserDao {
    Optional<String> findPasswordByLogin(String login) throws DaoException;
    boolean updatePasswordByLogin(String password, String login) throws DaoException;
    boolean updateUserStateByLogin(User.UserState state, String login) throws DaoException;
    boolean updateUserState(long userId, long stateId) throws DaoException;
    Optional<User> findUserByLogin(String login) throws DaoException;
    Optional<User> findUserByPhoneNumber(int phone) throws DaoException;
    Optional<User> findUserByEmail(String email) throws DaoException;
    Optional<User> findUserByOrder(long orderId) throws DaoException;
    Optional<User.UserState> findStateById(long userId) throws DaoException;
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;


}
