package by.epam.connectiontask.main;

import by.epam.connectiontask.dao.AbstractDao;
import by.epam.connectiontask.dao.EntityTransaction;
import by.epam.connectiontask.dao.UserDiscountDao;
import by.epam.connectiontask.entity.UserDiscount;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.pool.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
