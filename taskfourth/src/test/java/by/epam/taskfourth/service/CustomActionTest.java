package by.epam.taskfourth.service;

import by.epam.taskfourth.chain.AbstractHandler;
import by.epam.taskfourth.chain.TextHandler;
import by.epam.taskfourth.comparator.ParagraphComparator;
import by.epam.taskfourth.composite.Composite;
import by.epam.taskfourth.composite.CompositeImpl;
import by.epam.taskfourth.composite.TypeComponent;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;


public class CustomActionTest {
    CustomAction action;
    Composite composite;
    AbstractHandler handler;

    @BeforeClass
    public void createAction(){
        action = new CustomAction();
        handler = new TextHandler();
    }
    @BeforeMethod
    public void createComposite(){
        composite = new CompositeImpl(TypeComponent.TEXT);
    }
    @Test
    public void sortParagraphsTest(){
        handler.handlerRequest(composite,"\tAm I original? Am I the only one? Am I sexual?\n" +
                "\tAm I everything you need? You better rock your body now!");
        List<Composite> list = action.sortParagraphs(composite,new ParagraphComparator());
        String expected = "[Am I everything you need? You better rock your body now! ," +
                " Am I original? Am I the only one? Am I sexual? ]";
        String actual = list.toString();
        assertEquals(actual,expected);
    }
    @Test
    public void removeWordByLength(){
        handler.handlerRequest(composite,"Am I original? Am I the only one? Am I sexual? " +
                "Am I everything you need? You better rock your body now!");
        action.removeWordByLength(composite,3);
        String expected = "Am I original? Am I  only ? Am I sexual? " +
                "Am I everything  need?  better rock your body ! \n";
        String actual = composite.toString();
        assertEquals(actual,expected);
    }
    @Test
    public void removeSentenceByLength(){
        handler.handlerRequest(composite,"Am I original? Am I the only one? Am I sexual? " +
                "Am I everything you need? You better rock your body now!");
        action.removeSentenceByLength(composite,6);
        String expected = "You better rock your body now! \n";
        String actual = composite.toString();
        assertEquals(actual,expected);
    }
    @AfterMethod
    public void closeComposite(){
        composite = null;
    }
    @AfterClass
    public void closeAction(){
        action = null;
        handler = null;
    }
}
