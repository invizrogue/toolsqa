package hometask.base.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String randomFirstName() {
        return faker.name().firstName();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomFullAddress() {
        return faker.address().fullAddress();
    }

    public static String randomDay() {
        return faker.number().numberBetween(1, 28) + "";
    }

    public static String randomBirthYear() {
        return faker.number().numberBetween(1970, 1990) + "";
    }

    public static String randomPhoneNumber() {
        return faker.phoneNumber().phoneNumber().replaceAll("\\D", "").substring(0, 10);
    }

    public static String randomString(int len, String type) {
        String AB = switch (type) {
            case ("letters") -> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            case ("numbers") -> "0123456789";
            default -> "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        };
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomMail(int len) {
        return randomString(len, "letters") + "@"
                + randomString(4, "") + "."
                + randomString(3, "");
    }

    public static String randomPhoneNum() {
        return "9" + randomString(9, "numbers");
    }

    public static String randomMonth() {
        String monthName = "";
        int first = Integer.parseInt(randomString(1, "numbers"));
        int second = Integer.parseInt(randomString(1, "numbers"));
        System.out.println(first + "," + second);
        int monthNum = first + second;
        if (monthNum > 12) {
            monthNum = 1 + second;
        } else if (monthNum == 0) {
            monthNum++;
        }
        switch (monthNum) {
            case (1) -> monthName = "January";
            case (2) -> monthName = "February";
            case (3) -> monthName = "March";
            case (4) -> monthName = "April";
            case (5) -> monthName = "May";
            case (6) -> monthName = "June";
            case (7) -> monthName = "July";
            case (8) -> monthName = "August";
            case (9) -> monthName = "September";
            case (10) -> monthName = "October";
            case (11) -> monthName = "November";
            case (12) -> monthName = "December";
        }
        return monthName;
    }
}
