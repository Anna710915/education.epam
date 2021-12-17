package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.dao.AbstractDao;
import by.epam.finalproject.model.dao.EntityTransaction;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.util.PasswordEncryption;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;
    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public Optional<User> signIn(String login, String password) throws ServiceException {
        AbstractDao userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        String encryptPassword = PasswordEncryption.md5Apache(password);
        try{
            Optional<User> user = ((UserDaoImpl) userDao).findUserByLoginAndPassword(login, encryptPassword);
            return  user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
