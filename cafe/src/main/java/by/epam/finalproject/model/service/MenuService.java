package by.epam.finalproject.model.service;

import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.entity.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<Menu> findAllMenu() throws ServiceException;
    boolean addNewProduct(Map<String, String> map, String defaultImage) throws ServiceException;
    boolean updateProductPhoto(String image, String name) throws ServiceException;
}
