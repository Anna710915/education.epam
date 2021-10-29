package by.epam.taskthird.entity;

import java.time.LocalDate;

public class Cookie extends AbstractSweets {
    String cookieType;
    String flour;
    public Cookie(){}
    public Cookie(String id, String name, String production, LocalDate productionDate, String cookieType, int sugar, String flour, int milk, int energy, SweetsValue value) {
        super(id, name, production, productionDate, energy,sugar,milk,value);
        this.cookieType = cookieType;
        this.flour = flour;
    }

    public String getCookieType() {
        return cookieType;
    }

    public void setCookieType(String cookieType) {
        this.cookieType = cookieType;
    }

    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("Cookie{cookieType=").append(cookieType);
        builder.append(", flour=").append(flour);
        builder.append("}\n");
        return builder.toString();
    }
}
