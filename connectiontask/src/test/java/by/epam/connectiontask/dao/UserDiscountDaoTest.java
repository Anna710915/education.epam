package by.epam.connectiontask.dao;

import by.epam.connectiontask.dao.impl.AbstractDao;
import by.epam.connectiontask.dao.impl.EntityTransaction;
import by.epam.connectiontask.dao.impl.UserDiscountDao;
import by.epam.connectiontask.entity.UserDiscount;
import by.epam.connectiontask.exception.DaoException;
import by.epam.connectiontask.pool.ConnectionPool;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.math.BigDecimal;
import java.util.List;


public class UserDiscountDaoTest {
    AbstractDao abstractDao;
    EntityTransaction entityTransaction;
    @BeforeClass
    public void init(){
        abstractDao = new UserDiscountDao();
        entityTransaction = new EntityTransaction();
        entityTransaction.init(abstractDao);
    }

    @Test
    public void findAllTest() throws DaoException {
        List<UserDiscount> actual = abstractDao.findAll();
        assertNotNull(actual);
    }

    @Test
    public void findEntityByIdTest() throws DaoException {
        UserDiscount actual = (UserDiscount) abstractDao.findEntityById(2L);
        assertNotNull(actual);
    }
    @Test
    public void createTest() throws DaoException {
        boolean actual = abstractDao.create(new UserDiscount(new BigDecimal(0.1),24));
        assertTrue(actual);
    }

    @Test
    public void updateTest() throws DaoException {
        UserDiscount newUserDiscount = new UserDiscount(3, new BigDecimal(0.05), 6);
        UserDiscount expected = (UserDiscount) abstractDao.findEntityById(3);
        UserDiscount actual = (UserDiscount) abstractDao.update(newUserDiscount);
        assertEquals(actual, expected);
    }

    @Test
    public void deleteByIdTest() throws DaoException {
        boolean actual = abstractDao.delete(3);
        assertTrue(actual);
    }
    @Test
    public void deleteTest() throws DaoException {
        boolean actual = abstractDao.delete(new UserDiscount(7,new BigDecimal(0.1),24));
        assertTrue(actual);
    }
    @AfterClass
    public void close(){
        entityTransaction.end();
        ConnectionPool.getInstance().destroyPool();
        abstractDao = null;
        entityTransaction = null;
    }
}
