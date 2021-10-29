package by.epam.taskthird.builder;

import by.epam.taskthird.entity.AbstractSweets;
import by.epam.taskthird.entity.Chocolate;
import by.epam.taskthird.entity.Cookie;
import by.epam.taskthird.entity.SweetsValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public class DomBuilder extends AbstractSweetsBuilder {
    private DocumentBuilder docBuilder;
    public DomBuilder(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        try {
            docBuilder= factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
    public DomBuilder(Set<AbstractSweets> sweets){
        super(sweets);
    }
    @Override
    public void buildSweets(String filename) {
        Document doc;
        NodeList sweetsList;
        try {

            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            //getting a list of sweets child elements
            sweetsList = root.getElementsByTagName("cookie");
            buildElements(sweetsList);
            sweetsList = root.getElementsByTagName("chocolate");
            buildElements(sweetsList);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    private void buildElements(NodeList sweetsList){
        for(int i = 0; i < sweetsList.getLength(); i++){
            Element sweetsElement = (Element)sweetsList.item(i);
            AbstractSweets sweet = buildSweets(sweetsElement);
            sweets.add(sweet);
        }
    }
    private AbstractSweets buildSweets(Element sweetsElement){
        AbstractSweets sweet = null;
        if(sweetsElement.getTagName() == "cookie"){
            sweet = new Cookie();
            Cookie cookie = (Cookie)sweet;
            cookie.setFlour(getElementTextContent(sweetsElement,"flour"));
            cookie.setCookieType(sweetsElement.getAttribute("cookie-type"));
        }else if(sweetsElement.getTagName() == "chocolate"){
            sweet = new Chocolate();
            Chocolate chocolate = (Chocolate)sweet;
            chocolate.setChocolateType(sweetsElement.getAttribute("chocolate-type"));
            Integer element = Integer.parseInt(getElementTextContent(sweetsElement,"vanilla"));
            chocolate.setVanilla(element);
            element = Integer.parseInt(getElementTextContent(sweetsElement,"cocoa"));
            chocolate.setCocoa(element);
            chocolate.setFilling(getElementTextContent(sweetsElement,"filling"));
        }
        sweet.setId(sweetsElement.getAttribute("id"));
        sweet.setName(sweetsElement.getAttribute("name"));
        sweet.setProduction(getElementTextContent(sweetsElement,"production"));
        sweet.setProductionDate(LocalDate.parse(getElementTextContent(sweetsElement,"production-date")));
        sweet.setEnergy(Integer.parseInt(getElementTextContent(sweetsElement,"energy")));
        sweet.setMilk(Integer.parseInt(getElementTextContent(sweetsElement,"milk")));
        sweet.setSugar(Integer.parseInt(getElementTextContent(sweetsElement,"sugar")));
        SweetsValue value = sweet.getValue();
        Element valueElement =
                (Element) sweetsElement.getElementsByTagName("value").item(0);
        value.setCarbohydrate(Double.parseDouble(getElementTextContent(sweetsElement,"carbohydrate")));
        value.setProtein(Double.parseDouble(getElementTextContent(sweetsElement,"protein")));
        value.setFat(Double.parseDouble(getElementTextContent(sweetsElement,"fat")));
        return sweet;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
