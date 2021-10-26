package by.epam.taskthird.entity;

public class SweetsValue {
    double protein;
    double fat;
    double carbohydrate;
    public SweetsValue(){

    }
    public SweetsValue (double protein, double fat, double carbohydrate){
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("SweetsValue{");
        builder.append(" protein=").append(protein);
        builder.append(", fat=").append(fat);
        builder.append(", carbohydrate=").append(carbohydrate);
        builder.append('}');
        return builder.toString();
    }
}
