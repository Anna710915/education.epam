package by.epam.connectiontask.entity;

import java.time.LocalDateTime;

public class Order extends CustomEntity {
    private long orderId;
    private LocalDateTime orderDate;
    private OrderState orderState;
    private TypePayment typePayment;
    private String userComment;
    private LocalDateTime commentDate;
    private long userId;

    public Order(){}

    public Order(long orderId, LocalDateTime orderDate, OrderState orderState, TypePayment typePayment, String userComment, LocalDateTime commentDate, long userId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderState = orderState;
        this.typePayment = typePayment;
        this.userComment = userComment;
        this.commentDate = commentDate;
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public TypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (orderState != order.orderState) return false;
        return typePayment == order.typePayment;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (orderState != null ? orderState.hashCode() : 0);
        result = 31 * result + (typePayment != null ? typePayment.hashCode() : 0);
        return result;
    }
}
