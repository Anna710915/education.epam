package by.epam.taskfourth.convertor;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CustomConvertorTest {
    @Test
    public void makeTextTest(){
        CustomConvertor convertor = new CustomConvertor();
        String expected = "It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "    Bye бандерлоги.";
        List<String> testText = new ArrayList<>();
        testText.add("It is a established fact that a reader will be of a page when looking at its layout...");
        testText.add("    Bye бандерлоги.");
        String actual = convertor.makeText(testText);
        assertEquals(actual,expected);
    }
}
