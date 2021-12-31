package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.dao.EntityTransaction;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.util.PasswordEncryption;
import by.epam.finalproject.util.mail.Mail;
import by.epam.finalproject.validator.Validator;
import by.epam.finalproject.validator.impl.ValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static by.epam.finalproject.controller.Parameter.*;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();
    private static final String REGISTRATION_SUBJECT = "GoodCafe registration";
    private static final String REGISTRATION_BODY = "Registration was successful";
    private static UserServiceImpl instance;
    private UserServiceImpl(){}

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public Optional<User> signIn(String login, String password) throws ServiceException {
        UserDaoImpl userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        String encryptPassword = PasswordEncryption.md5Apache(password);
        try{
            return userDao.findUserByLoginAndPassword(login, encryptPassword);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }

    public boolean userRegistration(Map<String,String> mapData) throws ServiceException{
        UserDaoImpl userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        try {
            Validator validator = ValidatorImpl.getInstance();
            boolean commonResult = validator.checkRegistration(mapData);
            logger.log(Level.INFO, "Common result " + commonResult);
            if(!commonResult){
                return false;
            }
            String firstName = mapData.get(USER_FIRST_NAME);
            String lastName = mapData.get(USER_LAST_NAME);
            String login = mapData.get(LOGIN);
            String email = mapData.get(USER_EMAIL);
            String phone = mapData.get(USER_PHONE_NUMBER);
            String password = mapData.get(PASSWORD);
            String birthday = mapData.get(USER_BIRTHDAY);
            String encryptPassword = PasswordEncryption.md5Apache(password);
            int phoneNumber = Integer.parseInt(phone);
            LocalDate date = LocalDate.parse(birthday);
            long discountId = 1;
            boolean uniqResult = true;
            if(userDao.findUserByLogin(login).isPresent()){
                mapData.put(LOGIN,NOT_UNIQ_LOGIN);
                uniqResult = false;
            }
            if(userDao.findUserByEmail(email).isPresent()){
                mapData.put(USER_EMAIL,NOT_UNIQ_EMAIL);
                uniqResult = false;
            }
            if(userDao.findUserByPhoneNumber(phoneNumber).isPresent()){
                mapData.put(USER_PHONE_NUMBER,NOT_UNIQ_PHONE);
                uniqResult = false;
            }
            if(!uniqResult){
                return false;
            }
            User user = new User(firstName, lastName, login, encryptPassword, email,
                    phoneNumber, date, discountId, User.UserRole.CLIENT, User.UserState.NEW);
            boolean isUserCreate = userDao.create(user);
            if(isUserCreate){
                Mail.createMail(email,REGISTRATION_SUBJECT,REGISTRATION_BODY);
            }
            return isUserCreate;
        } catch (DaoException e) {
            throw new ServiceException("Add user error: ", e);
        }finally {
            transaction.end();
        }
    }

    public List<User> findAllUsers() throws ServiceException{
        UserDaoImpl userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        try {
            return userDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }

    public boolean deleteUser(long id) throws ServiceException{
        UserDaoImpl userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        try {
            return userDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            transaction.end();
        }
    }
}
