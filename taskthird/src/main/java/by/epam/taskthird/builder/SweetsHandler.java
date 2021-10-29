package by.epam.taskthird.builder;

import by.epam.taskthird.entity.AbstractSweets;
import by.epam.taskthird.entity.Chocolate;
import by.epam.taskthird.entity.Cookie;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class SweetsHandler extends DefaultHandler {
    private static final String DELIMITER_DASH = "-";
    private static final String DELIMITER_UNDERSCORE = "_";
    private Set<AbstractSweets> sweets;
    private AbstractSweets current;
    private SweetsXmlTag currentXmlTag;
    private EnumSet<SweetsXmlTag> withText;
    public  SweetsHandler(){
        sweets = new HashSet<AbstractSweets>();
        withText = EnumSet.range(SweetsXmlTag.PRODUCTION,SweetsXmlTag.VANILLA);
    }

    public Set<AbstractSweets> getSweets() {
        return sweets;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs){
        String chocolateTag = SweetsXmlTag.CHOCOLATE.getValue();
        String cookieTag = SweetsXmlTag.COOKIE.getValue();
        if(chocolateTag.equals(qName) || cookieTag.equals(qName)){
            if(chocolateTag.equals(qName)){
                current = new Chocolate();
            }else{
                current = new Cookie();
            }
            for(int i = 0; i < attrs.getLength(); i++){
                String constantName = toConstantValue(attrs.getQName(i));
                currentXmlTag = SweetsXmlTag.valueOf(constantName);
                switch (currentXmlTag){
                    case ID -> {
                        current.setId(attrs.getValue(i));
                    }
                    case NAME ->{
                        current.setName(attrs.getValue(i));
                    }
                    case COOKIE_TYPE -> {
                        Cookie cookie = (Cookie)current;
                        cookie.setCookieType(attrs.getValue(i));
                    }
                    case CHOCOLATE_TYPE -> {
                        Chocolate chocolate = (Chocolate)current;
                        chocolate.setChocolateType(attrs.getValue(i));
                    }
                }
            }
            currentXmlTag = null;
        }else{
            SweetsXmlTag buffer = SweetsXmlTag.valueOf(toConstantValue(qName));
            if(withText.contains(buffer)){
                currentXmlTag = buffer;
            }
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        String chocolateTag = SweetsXmlTag.COOKIE.getValue();
        String cookieTag = SweetsXmlTag.CHOCOLATE.getValue();
        if(chocolateTag.equals(qName) || cookieTag.equals(qName)){
            sweets.add(current);
        }
    }


    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch,start,length);
        if(currentXmlTag!=null){
            switch (currentXmlTag){
                case PRODUCTION ->{
                    current.setProduction(data);
                }
                case PRODUCTION_DATE ->{
                    current.setProductionDate(LocalDate.parse(data));
                }
                case PROTEIN ->{
                    current.getValue().setProtein(Double.parseDouble(data));
                }
                case FAT ->{
                    current.getValue().setFat(Double.parseDouble(data));
                }
                case CARBOHYDRATE ->{
                    current.getValue().setCarbohydrate(Double.parseDouble(data));
                }
                case SUGAR ->{
                    current.setSugar(Integer.parseInt(data));
                }
                case FLOUR ->{
                    Cookie cookie = (Cookie)current;
                    cookie.setFlour(data);
                }
                case MILK ->{
                    current.setMilk(Integer.parseInt((data)));
                }
                case ENERGY ->{
                    current.setEnergy(Integer.parseInt((data)));
                }
                case FILLING ->{
                    Chocolate chocolate = (Chocolate)current;
                    chocolate.setFilling(data);
                }
                case COCOA ->{
                    Chocolate chocolate = (Chocolate)current;
                    chocolate.setCocoa(Integer.parseInt(data));
                }
                case VANILLA ->{
                    Chocolate chocolate = (Chocolate)current;
                    chocolate.setVanilla(Integer.parseInt(data));
                }
                default -> {
                    throw new EnumConstantNotPresentException(
                            currentXmlTag.getDeclaringClass(),currentXmlTag.name());
                }
            }
        }
        currentXmlTag = null;
    }

    private String toConstantValue(String name){
        return name.replace(DELIMITER_DASH,DELIMITER_UNDERSCORE)
                .toUpperCase();
    }
}
