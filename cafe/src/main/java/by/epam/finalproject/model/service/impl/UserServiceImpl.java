package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.dao.EntityTransaction;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.service.UserService;
import by.epam.finalproject.util.PasswordEncryption;
import by.epam.finalproject.validator.Validator;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import static by.epam.finalproject.controller.Parameter.INVALID_BIRTHDAY;
import static by.epam.finalproject.controller.Parameter.INVALID_FIRST_NAME;
import static by.epam.finalproject.controller.Parameter.INVALID_GMAIL;
import static by.epam.finalproject.controller.Parameter.INVALID_LOGIN;
import static by.epam.finalproject.controller.Parameter.INVALID_PASSWORD;
import static by.epam.finalproject.controller.Parameter.INVALID_LAST_NAME;
import static by.epam.finalproject.controller.Parameter.INVALID_PHONE_NUMBER;
import static by.epam.finalproject.controller.Parameter.NOT_UNIQ_LOGIN;
import static by.epam.finalproject.controller.Parameter.NOT_UNIQ_GMAIL;
import static by.epam.finalproject.controller.Parameter.USER_FIRST_NAME;
import static by.epam.finalproject.controller.Parameter.USER_BIRTHDAY;
import static by.epam.finalproject.controller.Parameter.USER_GMAIL;
import static by.epam.finalproject.controller.Parameter.USER_LAST_NAME;
import static by.epam.finalproject.controller.Parameter.USER_PHONE_NUMBER;
import static by.epam.finalproject.controller.Parameter.LOGIN;
import static by.epam.finalproject.controller.Parameter.PASSWORD;

public class UserServiceImpl implements UserService {
    private static final String TRUE = "true";
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
            Optional<User> user = userDao.findUserByLoginAndPassword(login, encryptPassword);
            transaction.end();
            return  user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public boolean userRegistration(Map<String,String> mapData) throws ServiceException{
        UserDaoImpl userDao = new UserDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(userDao);
        String firstName = mapData.get(USER_FIRST_NAME);
        String lastName = mapData.get(USER_LAST_NAME);
        String login = mapData.get(LOGIN);
        String password = mapData.get(PASSWORD);
        String gmail = mapData.get(USER_GMAIL);
        String phone = mapData.get(USER_PHONE_NUMBER);
        String birthday = mapData.get(USER_BIRTHDAY);

        try {
            String resultFirstName = Validator.isCorrectName(firstName)
                    ? TRUE : INVALID_FIRST_NAME;
            String resultLastName = Validator.isCorrectName(lastName)
                    ? TRUE : INVALID_LAST_NAME;
            String resultLogin = Validator.isCorrectLogin(login)
                    ? (userDao.findUserByLogin(login).isEmpty()
                    ? TRUE : NOT_UNIQ_LOGIN) : INVALID_LOGIN;
            String resultPassword = Validator.isCorrectPassword(password)
                    ? TRUE : INVALID_PASSWORD;
            String resultGmail = Validator.isCorrectGmail(gmail)
                    ? (userDao.findUserByEmail(gmail).isEmpty()
                    ? TRUE : NOT_UNIQ_GMAIL) : INVALID_GMAIL;
            String resultPhone = Validator.isCorrectPhoneNumber(phone)
                    ? TRUE : INVALID_PHONE_NUMBER;
            String resultBirthday = Validator.isCorrectBirthday(birthday)
                    ? TRUE : INVALID_BIRTHDAY;

            boolean commonResult = resultFirstName == TRUE && resultLastName == TRUE
                    && resultLogin == TRUE && resultPassword == TRUE && resultGmail == TRUE
                    && resultPhone == TRUE && resultBirthday == TRUE;

            if(commonResult){
                String encryptPassword = PasswordEncryption.md5Apache(password);
                int phoneNumber = Integer.parseInt(phone);
                LocalDate date = LocalDate.parse(birthday);
                long discountId = 1;
                User user = new User(firstName, lastName, login, encryptPassword, gmail,
                        phoneNumber, date, discountId, User.UserRole.CLIENT, User.UserState.NEW);
                boolean isUserCreate = userDao.create(user);
                transaction.end();
                return isUserCreate;
            }else{
                mapData.replace(USER_FIRST_NAME,resultFirstName);
                mapData.replace(USER_LAST_NAME,resultLastName);
                mapData.replace(LOGIN,resultLogin);
                mapData.replace(PASSWORD,resultPassword);
                mapData.replace(USER_GMAIL,resultGmail);
                mapData.replace(USER_PHONE_NUMBER,resultPhone);
                mapData.replace(USER_BIRTHDAY,resultBirthday);
            }
        } catch (DaoException e) {
            throw new ServiceException("Add user error: ", e);
        }
        transaction.end();
        return false;
    }
}
