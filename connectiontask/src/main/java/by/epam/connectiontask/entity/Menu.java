package by.epam.connectiontask.entity;

import java.time.LocalTime;

public class Menu extends CustomEntity {
    private long foodId;
    private String nameFood;
    private String picturePath;
    private String composition;
    private double weight;
    private double calories;
    private LocalTime cookingTime;
    private double discount;
    private double price;
    private long sectionId;

    public Menu(){}

    public Menu(long foodId, String nameFood, String picturePath, String composition, double weight,
                double calories, LocalTime cookingTime, double discount, double price, long sectionId) {
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (foodId != menu.foodId) return false;
        if (Double.compare(menu.weight, weight) != 0) return false;
        if (Double.compare(menu.calories, calories) != 0) return false;
        if (Double.compare(menu.discount, discount) != 0) return false;
        if (Double.compare(menu.price, price) != 0) return false;
        if (sectionId != menu.sectionId) return false;
        if (!nameFood.equals(menu.nameFood)) return false;
        if (!picturePath.equals(menu.picturePath)) return false;
        if (!composition.equals(menu.composition)) return false;
        return cookingTime.equals(menu.cookingTime);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (foodId ^ (foodId >>> 32));
        result = 31 * result + nameFood.hashCode();
        result = 31 * result + picturePath.hashCode();
        result = 31 * result + composition.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(calories);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cookingTime.hashCode();
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (sectionId ^ (sectionId >>> 32));
        return result;
    }
}
