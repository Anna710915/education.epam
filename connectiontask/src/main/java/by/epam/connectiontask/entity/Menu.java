package by.epam.connectiontask.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Menu extends CustomEntity {

    private long foodId;
    private String nameFood;
    private String picturePath;
    private String composition;
    private double weight;
    private double calories;
    private LocalTime cookingTime;
    private BigDecimal discount;
    private BigDecimal price;
    private long sectionId;

    public Menu(){}

    public Menu(long foodId, String nameFood, String picturePath, String composition,
                double weight, double calories, LocalTime cookingTime, BigDecimal discount,
                BigDecimal price, long sectionId) {
        this.foodId = foodId;
        this.nameFood = nameFood;
        this.picturePath = picturePath;
        this.composition = composition;
        this.weight = weight;
        this.calories = calories;
        this.cookingTime = cookingTime;
        this.discount = discount;
        this.price = price;
        this.sectionId = sectionId;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public LocalTime getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(LocalTime cookingTime) {
        this.cookingTime = cookingTime;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

}
