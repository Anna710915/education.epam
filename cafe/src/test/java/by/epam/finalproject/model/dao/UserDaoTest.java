package by.epam.finalproject.model.dao;

import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.model.dao.impl.UserDaoImpl;
import by.epam.finalproject.model.entity.User;
import by.epam.finalproject.model.pool.ConnectionPool;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class UserDaoTest {
    AbstractDao<User> abstractDao;
    EntityTransaction entityTransaction;
    @BeforeClass
    public void init(){
        abstractDao = new UserDaoImpl();
        entityTransaction = new EntityTransaction();
        entityTransaction.init(abstractDao);
    }

    @Test
    public void findUserByLoginAndPasswordTest() throws DaoException {
        Optional<User> actual = ((UserDaoImpl)abstractDao).findUserByLoginAndPassword("2Merkul8","16fduecn2002");
        assertTrue(actual.isPresent());
    }
    @Test
    public void findUserByIdTest() throws DaoException {
        User actual = abstractDao.findEntityById(4);
        assertNotNull(actual);
    }
    @Test
    public void findAllUsersTest() throws DaoException {
        List<User> actual = abstractDao.findAll();
        assertFalse(actual.isEmpty());
    }
    @AfterClass
    public void close(){
        entityTransaction.end();
        ConnectionPool.getInstance().destroyPool();
        abstractDao = null;
        entityTransaction = null;
    }
}
