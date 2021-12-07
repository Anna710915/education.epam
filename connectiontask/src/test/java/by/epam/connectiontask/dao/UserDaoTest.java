package by.epam.connectiontask.dao;

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
