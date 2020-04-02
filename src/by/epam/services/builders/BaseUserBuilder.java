package by.epam.services.builders;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.BaseUser;

import java.util.Scanner;

public class BaseUserBuilder {
    public BaseUser BaseUserBuilder() {
        return new BaseUser();
    }

    public BaseUser BaseUserBuilder(String email, String name, String surname, ActivityLevel activityLevel, Integer age, Gender gender, Integer height, Double weight){
        return getBaseUser(email, name, surname, activityLevel, age, gender, height, weight);
    }

    public BaseUser getBaseUser(String email, String name, String surname, ActivityLevel activityLevel, Integer age, Gender gender, Integer height, Double weight){
        BaseUser ob = new BaseUser();
        ob.setAge(age);
        ob.setActivityLevel(activityLevel);
        ob.setGender(gender);
        ob.setHeight(height);
        ob.setWeight(weight);
        ob.setEmail(email);
        ob.setName(name);
        ob.setSurname(surname);
        return ob;
    }
    public BaseUser consoleBuilder() {
        Scanner scan = new Scanner(System.in);
        System.out.println("name");
        String name = scan.next();
        System.out.println("surname");
        String surname = scan.next();
        System.out.println("email");
        String email = scan.next();
        Gender gender;
        System.out.println("Gender\n: 1. male\n2.female");
        switch(scan.nextInt()){
            case 1: {
                gender = Gender.MALE;
                break;
            }
            case 2:{
                gender = Gender.FEMALE;
                break;
            }
            default: {
                gender = Gender.MALE;
                break;
            }
        }

        ActivityLevel aLevel;
        System.out.println("Activity level\n: 1.NONE\n2.SEDENTARY\n3.LIGHTLY_ACTIVE\n4.MODERATELY_ACTIVE\n5.VERY_ACTIVE");
        switch (scan.nextInt()){
            case 1:{
                aLevel = ActivityLevel.NONE;
                break;
            }
            case 2:{
                aLevel = ActivityLevel.SEDENTARY;
                break;
            }
            case 3:{
                aLevel = ActivityLevel.LIGHTLY_ACTIVE;
                break;
            }
            case 4:{
                aLevel = ActivityLevel.MODERATELY_ACTIVE;
                break;
            }
            case 5:{
                aLevel = ActivityLevel.VERY_ACTIVE;
                break;
            } default: {
                aLevel = ActivityLevel.NONE;
                break;
            }
        }
        System.out.println("age(Int): ");
        Integer age = scan.nextInt();
        System.out.println("height(Int): ");
        Integer height = scan.nextInt();
        System.out.println("weight(double): ");
        Double weight = scan.nextDouble();
        return getBaseUser(email, name, surname, aLevel, age, gender, height, weight);
    }
}
