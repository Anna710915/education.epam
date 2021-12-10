package by.epam.connectiontask.main;

import by.epam.connectiontask.dao.impl.AbstractDao;
import by.epam.connectiontask.dao.impl.EntityTransaction;
import by.epam.connectiontask.dao.impl.UserDiscountDao;
import by.epam.connectiontask.entity.UserDiscount;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.pool.ConnectionPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        AbstractDao abstractDao = new UserDiscountDao();
        EntityTransaction entityTransaction = new EntityTransaction();
        try {
            entityTransaction.init(abstractDao);
            List<UserDiscount> actual = abstractDao.findAll();
            for(UserDiscount item: actual) {
                System.out.println(item.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            entityTransaction.end();
            ConnectionPool.getInstance().destroyPool();
        }

    }

}
