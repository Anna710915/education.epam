package by.epam.taskthird.builder;

public enum SweetsXmlTag{
    SWEETS("sweets"),
    COOKIE("cookie"),
    CHOCOLATE("chocolate"),
    ID("id"),
    NAME("name"),
    COOKIE_TYPE("cookieType"),
    CHOCOLATE_TYPE("chocolateType"),
    VALUE("value"),
    PRODUCTION("production"),
    PRODUCTION_DATE("productionDate"),
    PROTEIN("protein"),
    FAT("fat"),
    CARBOHYDRATE("carbohydrate"),
    SUGAR("sugar"),
    FLOUR("flour"),
    MILK("milk"),
    ENERGY("energy"),
    FILLING("filling"),
    COCOA("cocoa"),
    VANILLA("vanilla");
    private String value;
    SweetsXmlTag(String value){
        this.value = value;
    }
    public String getValue(){

        return value;
    }
}
