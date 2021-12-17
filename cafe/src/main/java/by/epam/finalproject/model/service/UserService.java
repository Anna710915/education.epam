package by.epam.finalproject.model.service;

import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> signIn(String login, String password) throws ServiceException;
}
