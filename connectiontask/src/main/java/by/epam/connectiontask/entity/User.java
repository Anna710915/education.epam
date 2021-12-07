package by.epam.connectiontask.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User extends CustomEntity {
    private long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private int phoneNumber;
    private LocalDate birthday;
    private LocalDateTime registrationDate;
    private long stateId;
    private long discountId;
    private long roleId;

    public User(){}

    public User(long userId, String firstName, String lastName, String login, String password,
                String email, int phoneNumber, LocalDate birthday, LocalDateTime registrationDate, long stateId, long discountId, long roleId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.stateId = stateId;
        this.discountId = discountId;
        this.roleId = roleId;
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (phoneNumber != user.phoneNumber) return false;
        if (stateId != user.stateId) return false;
        if (discountId != user.discountId) return false;
        if (roleId != user.roleId) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        if (!email.equals(user.email)) return false;
        if (!birthday.equals(user.birthday)) return false;
        return registrationDate.equals(user.registrationDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber;
        result = 31 * result + birthday.hashCode();
        result = 31 * result + registrationDate.hashCode();
        result = 31 * result + (int) (stateId ^ (stateId >>> 32));
        result = 31 * result + (int) (discountId ^ (discountId >>> 32));
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId=").append(userId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", birthday=").append(birthday);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", stateId=").append(stateId);
        sb.append(", discountId=").append(discountId);
        sb.append(", roleId=").append(roleId);
        sb.append('}');
        return sb.toString();
    }
}
