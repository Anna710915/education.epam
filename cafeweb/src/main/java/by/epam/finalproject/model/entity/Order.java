package by.epam.finalproject.model.entity;

import java.time.LocalDateTime;

public class Order extends CustomEntity {

    public enum OrderState {
        NEW("new"), PROCESSING("processing"), CANCELLED("cancelled"), RECEIVED("received"), COMPLETED("completed"), OVERDUE("overdue");

        String state;

        OrderState(String state){
            this.state = state;
        }

        public String getState(){
            return state;
        }
    }

    public enum TypePayment {
        CASH("cash"), CARD("card");
        String payment;

        TypePayment(String payment){
            this.payment = payment;
        }

        public String getPayment(){
            return payment;
        }
    }

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
