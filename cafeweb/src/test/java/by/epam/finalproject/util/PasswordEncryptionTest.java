package by.epam.finalproject.util;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
public class PasswordEncryptionTest {
    @Test
    public void md5ApacheTest(){
        String expected = "4fa25efdd84d2e2c9f206980d4ccfff1";
        String actual = PasswordEncryption.md5Apache("devcolibri");
        assertEquals(actual,expected);
    }
}
