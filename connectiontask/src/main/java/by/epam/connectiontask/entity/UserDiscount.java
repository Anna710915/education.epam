package by.epam.connectiontask.entity;

public class UserDiscount extends CustomEntity{
    private long discountId;
    private double discount;
    private int yearOrders;

    public UserDiscount(){}

    public UserDiscount(double discount, int yearOrders) {
        this.discount = discount;
        this.yearOrders = yearOrders;
    }

    public UserDiscount(long discountId, double discount, int yearOrders){
        this.discountId = discountId;
        this.discount = discount;
        this.yearOrders = yearOrders;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getYearOrders() {
        return yearOrders;
    }

    public void setYearOrders(int yearOrders) {
        this.yearOrders = yearOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDiscount that = (UserDiscount) o;

        if (discountId != that.discountId) return false;
        if (Double.compare(that.discount, discount) != 0) return false;
        return yearOrders == that.yearOrders;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (discountId ^ (discountId >>> 32));
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + yearOrders;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDiscount{");
        sb.append("discountId=").append(discountId);
        sb.append(", discount=").append(discount);
        sb.append(", yearOrders=").append(yearOrders);
        sb.append('}');
        return sb.toString();
    }
}
