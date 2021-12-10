package by.epam.connectiontask.dao;

import by.epam.connectiontask.dao.impl.AbstractDao;
import by.epam.connectiontask.dao.impl.EntityTransaction;
import by.epam.connectiontask.dao.impl.UserDiscountDao;
import org.testng.annotations.BeforeClass;

public class UserDaoTest {
    AbstractDao abstractDao;
    EntityTransaction entityTransaction;
    @BeforeClass
    public void init(){
        abstractDao = new UserDiscountDao();
        entityTransaction = new EntityTransaction();
        entityTransaction.init(abstractDao);
    }
}
