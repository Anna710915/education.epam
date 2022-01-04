package by.epam.finalproject.model.service.impl;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.exception.ServiceException;
import by.epam.finalproject.model.dao.AbstractDao;
import by.epam.finalproject.model.dao.EntityTransaction;
import by.epam.finalproject.model.dao.MenuDao;
import by.epam.finalproject.model.dao.impl.MenuDaoImpl;
import by.epam.finalproject.model.entity.Menu;
import by.epam.finalproject.model.service.MenuService;
import by.epam.finalproject.validator.Validator;
import by.epam.finalproject.validator.impl.ValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static by.epam.finalproject.controller.Parameter.*;
import static by.epam.finalproject.controller.Parameter.PRODUCT_PRICE;

public class MenuServiceImpl implements MenuService {
    private static final Logger logger = LogManager.getLogger();
    private static MenuServiceImpl instance;

    private MenuServiceImpl(){}

    public static MenuServiceImpl getInstance(){
        if(instance == null){
            instance = new MenuServiceImpl();
        }
        return instance;
    }
    @Override
    public List<Menu> findAllMenu() throws ServiceException {
        AbstractDao<Menu> menuAbstractDao = new MenuDaoImpl();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(menuAbstractDao);
        try {
            List<Menu> menuList = menuAbstractDao.findAll();
            return menuList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }finally {
            transaction.end();
        }
    }

    @Override
    public boolean addNewProduct(Map<String,String> map, String defaultImage) throws ServiceException {
        Validator validator = ValidatorImpl.getInstance();
        if(!validator.checkProductData(map)){
            return false;
        }
        AbstractDao abstractDao = new MenuDaoImpl();
        EntityTransaction entityTransaction = new EntityTransaction();
        entityTransaction.init(abstractDao);
        try {
            String name = map.get(PRODUCT_NAME);
            String composition = map.get(PRODUCT_COMPOSITION);
            double weight = Double.parseDouble(map.get(PRODUCT_WEIGHT));
            double calories = Double.parseDouble(map.get(PRODUCT_CALORIES));
            LocalTime time = LocalTime.parse(map.get(PRODUCT_TIME), DateTimeFormatter.ofPattern("HH:MM")); // TODO
            BigDecimal discount = BigDecimal.valueOf(Double.parseDouble(map.get(PRODUCT_DISCOUNT)));
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(map.get(PRODUCT_PRICE)));
            long sectionId = Long.parseLong(map.get(PRODUCT_SECTION));
            Menu menu = new Menu(name, defaultImage, composition, weight, calories, time, discount, price, sectionId);
            boolean result = abstractDao.create(menu);
            return result;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }finally {
            entityTransaction.end();
        }
    }

    @Override
    public boolean updateProductPhoto(String image, String name) throws ServiceException{
        MenuDaoImpl menuDao = new MenuDaoImpl();
        EntityTransaction entityTransaction = new EntityTransaction();
        entityTransaction.init(menuDao);
        try {
            return menuDao.updateImagePathByName(name, image);
        } catch (DaoException e) {
            throw new ServiceException(e);
        } finally {
            entityTransaction.end();
        }
    }
}
