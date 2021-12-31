package by.epam.finalproject.validator.impl;

import by.epam.finalproject.validator.Validator;

import java.util.Map;

import static by.epam.finalproject.controller.Parameter.*;

public final class ValidatorImpl implements Validator {
    private static final String NAME_PATTERN = "^[A-Za-zА-Яа-я]{3,50}$";
    private static final String PRODUCT_NAME_PATTERN = "^[A-Za-zА-Яа-я\\s]{3,50}$";
    private static final String USER_LOGIN_PATTERN = "^[A-Za-zА-Яа-я0-9_]{4,16}$";
    private static final String USER_PASSWORD_PATTERN = "^[A-Za-zА-Яа-я0-9\\.]{5,40}$";
    private static final String USER_MAIL_PATTERN = "^[A-Za-z0-9\\.]{1,30}@[a-z]{2,7}\\.[a-z]{2,4}$";
    private static final String USER_PHONE_NUMBER_PATTERN = "\\d{9}";
    private static final String USER_BIRTHDAY_DATE_PATTERN = "^(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)$";
    private static final String DIGIT_PRODUCT_PATTERN = "\\d{1,6}\\.?\\d{0,2}";
    private static final String DISCOUNT_PATTERN = "\\d\\.\\d{0,2}";
    private static ValidatorImpl instance;

    private ValidatorImpl(){}

    public static ValidatorImpl getInstance(){
        if(instance == null){
            instance = new ValidatorImpl();
        }
        return instance;
    }
    public boolean isCorrectName(String name){
        return isNotNullOrEmpty(name) && name.matches(NAME_PATTERN);
    }

    public boolean isCorrectLogin(String login){
        return isNotNullOrEmpty(login) && login.matches(USER_LOGIN_PATTERN);
    }

    public boolean isCorrectPassword(String password){
        return isNotNullOrEmpty(password) && password.matches(USER_PASSWORD_PATTERN);
    }

    public boolean isCorrectEmail(String gmail){
        return isNotNullOrEmpty(gmail) && gmail.matches(USER_MAIL_PATTERN);
    }

    public boolean isCorrectPhoneNumber(String phoneNumber){
        return isNotNullOrEmpty(phoneNumber) && phoneNumber.matches(USER_PHONE_NUMBER_PATTERN);
    }

    public boolean isCorrectBirthday(String birthday){
        return isNotNullOrEmpty(birthday) && birthday.matches(USER_BIRTHDAY_DATE_PATTERN);
    }

    @Override
    public boolean isCorrectProductDigit(String digit) {
        return isNotNullOrEmpty(digit) && digit.matches(DIGIT_PRODUCT_PATTERN);
    }

    @Override
    public boolean isCorrectDiscount(String discount) {
        return isNotNullOrEmpty(discount) && discount.matches(DISCOUNT_PATTERN);
    }

    @Override
    public boolean isCorrectProductName(String name) {
        return isNotNullOrEmpty(name) && name.matches(PRODUCT_NAME_PATTERN);
    }

    @Override
    public boolean checkRegistration(Map<String, String> map) {
        boolean result = true;
        String firstName = map.get(USER_FIRST_NAME);
        String lastName = map.get(USER_LAST_NAME);
        String login = map.get(LOGIN);
        String password = map.get(PASSWORD);
        String email = map.get(USER_EMAIL);
        String phone = map.get(USER_PHONE_NUMBER);
        String birthday = map.get(USER_BIRTHDAY);

        if(!isCorrectName(firstName)){
            map.put(USER_FIRST_NAME,INVALID_FIRST_NAME);
            result = false;
        }
        if(!isCorrectName(lastName)){
            map.put(USER_LAST_NAME,INVALID_LAST_NAME);
            result = false;
        }
        if(!isCorrectLogin(login)){
            map.put(LOGIN,INVALID_LOGIN);
            result = false;
        }
        if(!isCorrectPassword(password)){
            map.put(PASSWORD,INVALID_PASSWORD);
            result = false;
        }
        if(!isCorrectEmail(email)){
            map.put(USER_EMAIL, INVALID_EMAIL);
            result = false;
        }
        if(!isCorrectPhoneNumber(phone)){
            map.put(USER_PHONE_NUMBER,INVALID_PHONE_NUMBER);
            result = false;
        }
        if(!isCorrectBirthday(birthday)){
            map.put(USER_BIRTHDAY,INVALID_BIRTHDAY);
            result = false;
        }
        return result;
    }

    @Override
    public boolean checkProductData(Map<String, String> map) {
        boolean result = true;
        String name = map.get(PRODUCT_NAME);
        String weight = map.get(PRODUCT_WEIGHT);
        String calories = map.get(PRODUCT_CALORIES);
        String discount = map.get(PRODUCT_DISCOUNT);
        String price = map.get(PRODUCT_PRICE);
        if(!isCorrectProductName(name)){
            map.put(PRODUCT_NAME,INVALID_PRODUCT_NAME);
            result = false;
        }
        if(!isCorrectProductDigit(weight)){
            map.put(PRODUCT_WEIGHT,INVALID_PRODUCT_WEIGHT);
            result = false;
        }
        if(!isCorrectProductDigit(calories)){
            map.put(PRODUCT_CALORIES,INVALID_PRODUCT_CALORIES);
            result = false;
        }
        if(!isCorrectProductDigit(price)){
            map.put(PRODUCT_PRICE,INVALID_PRODUCT_PRICE);
            result = false;
        }
        if(!isCorrectDiscount(discount)){
            map.put(PRODUCT_DISCOUNT,INVALID_PRODUCT_DISCOUNT);
            result = false;
        }
        return result;
    }

    private boolean isNotNullOrEmpty(String line){
        return line != null && !line.isEmpty();
    }
}
