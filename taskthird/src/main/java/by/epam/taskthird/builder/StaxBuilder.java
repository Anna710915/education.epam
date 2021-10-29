package by.epam.taskthird.builder;

import by.epam.taskthird.entity.AbstractSweets;
import by.epam.taskthird.entity.Chocolate;
import by.epam.taskthird.entity.Cookie;
import by.epam.taskthird.entity.SweetsValue;
import by.epam.taskthird.exception.CustomException;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

public class StaxBuilder extends AbstractSweetsBuilder {
    private static final String DELIMITER_DASH = "-";
    private static final String DELIMITER_UNDERSCORE = "_";
    private XMLInputFactory inputFactory;
    public StaxBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }
    public StaxBuilder(Set<AbstractSweets> sweets){
        super(sweets);
    }
    @Override
    public void buildSweets(String filename) throws CustomException{
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while(reader.hasNext()){
                int type = reader.next();
                if(type == XMLStreamConstants.START_ELEMENT){
                    name = reader.getLocalName();
                    if(name.equals(SweetsXmlTag.COOKIE.getValue()) ||
                            name.equals(SweetsXmlTag.CHOCOLATE.getValue())){
                        AbstractSweets current = buildSweets(reader);
                        sweets.add(current);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private AbstractSweets buildSweets(XMLStreamReader reader) throws CustomException {
        AbstractSweets abstractSweets = null;
        String name = reader.getLocalName();
        if(name.equals(SweetsXmlTag.COOKIE.getValue())){
            abstractSweets = new Cookie();
            Cookie cookie = (Cookie) abstractSweets;
            cookie.setCookieType(reader.getAttributeValue(null, SweetsXmlTag.COOKIE_TYPE.getValue()));
        }else if( name.equals(SweetsXmlTag.CHOCOLATE.getValue())){
            abstractSweets = new Chocolate();
            Chocolate chocolate = (Chocolate) abstractSweets;
            chocolate.setChocolateType(reader.getAttributeValue(null,SweetsXmlTag.CHOCOLATE_TYPE.getValue()));
        }
        abstractSweets.setId(reader.getAttributeValue(null,SweetsXmlTag.ID.getValue()));
        abstractSweets.setName(reader.getAttributeValue(null,SweetsXmlTag.NAME.getValue()));
        try {
            while(reader.hasNext()){
                int type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (SweetsXmlTag.valueOf(toConstantValue(name))){
                            case PRODUCTION ->{
                                abstractSweets.setProduction(getXMLText(reader));
                            }
                            case PRODUCTION_DATE ->{
                                abstractSweets.setProductionDate(LocalDate.parse(getXMLText(reader)));
                            }
                            case SUGAR ->{
                                abstractSweets.setSugar(Integer.parseInt(getXMLText(reader)));
                            }
                            case FLOUR ->{
                                Cookie cookie = (Cookie) abstractSweets;
                                cookie.setFlour(getXMLText(reader));
                            }
                            case MILK ->{
                                abstractSweets.setMilk(Integer.parseInt((getXMLText(reader))));
                            }
                            case ENERGY ->{
                                abstractSweets.setEnergy(Integer.parseInt((getXMLText(reader))));
                            }
                            case FILLING ->{
                                Chocolate chocolate = (Chocolate) abstractSweets;
                                chocolate.setFilling(getXMLText(reader));
                            }
                            case COCOA ->{
                                Chocolate chocolate = (Chocolate) abstractSweets;
                                chocolate.setCocoa(Integer.parseInt(getXMLText(reader)));
                            }
                            case VANILLA ->{
                                Chocolate chocolate = (Chocolate) abstractSweets;
                                chocolate.setVanilla(Integer.parseInt(getXMLText(reader)));
                            }
                            case VALUE -> {
                                abstractSweets.setValue(getXMLValue(reader));
                            }
                            default -> {
                                throw new CustomException();
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(SweetsXmlTag.valueOf(toConstantValue(name))==SweetsXmlTag.CHOCOLATE ||
                                SweetsXmlTag.valueOf(toConstantValue(name))==SweetsXmlTag.COOKIE){
                            return abstractSweets;
                        }
                }
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        throw new CustomException();
    }
    private SweetsValue getXMLValue(XMLStreamReader reader)throws CustomException{
        SweetsValue value = new SweetsValue();
        int type;
        String name;
        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type){
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();
                        switch (SweetsXmlTag.valueOf(name.toUpperCase())){
                            case PROTEIN ->{
                                value.setProtein(Double.parseDouble(getXMLText(reader)));
                            }
                            case FAT ->{
                                value.setFat(Double.parseDouble(getXMLText(reader)));
                            }
                            case CARBOHYDRATE ->{
                                value.setCarbohydrate(Double.parseDouble(getXMLText(reader)));
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if(SweetsXmlTag.valueOf(toConstantValue(name))==SweetsXmlTag.VALUE){
                            return value;
                        }
                }
            }
        }catch (XMLStreamException e){
            throw new CustomException();
        }
        throw new CustomException();
    }
    private String getXMLText(XMLStreamReader reader) throws  CustomException{
        String text = null;
        try {
            if(reader.hasNext()){
                reader.next();
                text = reader.getText();
            }
        } catch (XMLStreamException e) {
            throw new CustomException();
        }
        return text;
    }
    private String toConstantValue(String name){
        return name.replace(DELIMITER_DASH,DELIMITER_UNDERSCORE)
                .toUpperCase();
    }
}
