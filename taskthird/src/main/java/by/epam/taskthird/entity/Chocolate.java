package by.epam.taskthird.entity;

import java.time.LocalDate;

public class Chocolate extends Sweets{
    String chocolateType;
    String filling;
    int cocoa;
    int vanilla;
    public Chocolate(){

        super();
        this.chocolateType = "Milk";
    }
    public Chocolate (String id, String name, String production, LocalDate productionDate, String chocolateType, String filling, int energy, int milk, int cocoa, int sugar, int vanilla, SweetsValue value){
        super(id, name, production, productionDate,energy,sugar,milk,value);
        this.chocolateType = chocolateType;
        this.filling = filling;
        this.cocoa = cocoa;
        this.vanilla = vanilla;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public int getCocoa() {
        return cocoa;
    }

    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    public String getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(String chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("Chocolate{chocolateType=").append(chocolateType);
        builder.append(", filling=").append(filling);
        builder.append(", cocoa=").append(cocoa);
        builder.append(", vanilla=").append(vanilla);
        builder.append("}\n");
        return builder.toString();
    }
}
