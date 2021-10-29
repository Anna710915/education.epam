package by.epam.taskthird.entity;

import java.time.LocalDate;

public abstract class AbstractSweets {
    private String id;
    private String name;
    private String production;
    private LocalDate productionDate;
    int energy;
    int sugar;
    int milk;
    SweetsValue value;
    public AbstractSweets(){
        value = new SweetsValue();
    }
    public AbstractSweets(String id, String name, String production, LocalDate productionDate, int energy, int sugar, int milk, SweetsValue value){
        this.id = id;
        this.name = name;
        this.production = production;
        this.productionDate = productionDate;
        this.energy = energy;
        this.sugar = sugar;
        this.milk = milk;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public SweetsValue getValue() {
        return value;
    }

    public void setValue(SweetsValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Sweets{");
        builder.append("id=").append(id);
        builder.append(", name=").append(name);
        builder.append(", production=").append(production);
        builder.append(", productionDate=").append(productionDate);
        builder.append(", energy=").append(energy);
        builder.append(", sugar=").append(sugar);
        builder.append(", milk=").append(milk);
        builder.append(", value=").append(value);
        builder.append("}");
        return builder.toString();
    }

}
