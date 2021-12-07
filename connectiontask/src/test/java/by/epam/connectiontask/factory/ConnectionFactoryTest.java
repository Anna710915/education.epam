package by.epam.connectiontask.factory;

import by.epam.connectiontask.exception.CustomException;
import by.epam.connectiontask.factory.ConnectionFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.sql.Connection;

public class ConnectionFactoryTest {
    @Test
    public void connectionCreate() throws CustomException {
        Connection connection = ConnectionFactory.createConnection();
        assertNotNull(connection);
    }
}
