package by.epam.connectiontask.entity;

public class MenuOrder extends CustomEntity{
    private long orderId;
    private long foodId;
    private int dishNumber;

    public MenuOrder(){}

    public MenuOrder(long orderId, long foodId, int dishNumber) {
        this.orderId = orderId;
        this.foodId = foodId;
        this.dishNumber = dishNumber;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public int getDishNumber() {
        return dishNumber;
    }

    public void setDishNumber(int dishNumber) {
        this.dishNumber = dishNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuOrder menuOrder = (MenuOrder) o;

        if (orderId != menuOrder.orderId) return false;
        if (foodId != menuOrder.foodId) return false;
        return dishNumber == menuOrder.dishNumber;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (foodId ^ (foodId >>> 32));
        result = 31 * result + dishNumber;
        return result;
    }
}
