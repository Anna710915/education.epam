package by.epam.finalproject.model.entity;

import java.time.LocalDate;

public class User extends CustomEntity {
    public enum UserRole {
        ADMIN(1), CLIENT(2), GUEST(3);
        private long roleId;

        UserRole(long id){
            roleId = id;
        }

        public long getRoleId(){
            return roleId;
        }
    }
    public enum UserState {
        NEW(1), ACTIVE(2), INACTIVE(3), BLOCKED(4), UNBLOCKED(5);
        private long stateId;

        UserState (long id){
            stateId = id;
        }

        public long getStateId(){
            return stateId;
        }
    }
    private long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private int phoneNumber;
    private LocalDate birthday;
    private long discountId;
    private UserRole role;
    private UserState state;

    public User(){}

    public User(long userId, String firstName, String lastName, String login,
                String password, String email, int phoneNumber, LocalDate birthday, long discountId, UserRole role, UserState state) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.discountId = discountId;
        this.role = role;
        this.state = state;
    }

    public User(String firstName, String lastName, String login,
                String password, String email, int phoneNumber, LocalDate birthday, long discountId, UserRole role, UserState state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.discountId = discountId;
        this.role = role;
        this.state = state;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
}
