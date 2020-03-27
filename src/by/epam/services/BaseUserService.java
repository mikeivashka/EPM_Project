package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.BaseUser;
import by.epam.entity.User;

import java.util.Scanner;

public class BaseUserService extends UserService {
    private BaseUser create(Integer age
                         , Gender gender
                         , Integer height
                         , Double weight
                         , ActivityLevel activityLevel
                         , String email
                         , String name
                         , String surname){
        BaseUser bUser = new BaseUser();

        bUser.setAge(age);
        bUser.setGender(gender);
        bUser.setHeight(height);
        bUser.setWeight(weight);
        bUser.setActivityLevel(activityLevel);
        bUser.setEmail(email);
        bUser.setName(name);
        bUser.setSurname(surname);

        return bUser;
    }

    public boolean add(Integer age
                     , Gender gender
                     , Integer height
                     , Double weight
                     , ActivityLevel activityLevel
                     , String email
                     , String name
                     , String surname){

        return data.add(create(age, gender, height, weight, activityLevel, email, name, surname));
    }

    public boolean update(Integer age
            , Gender gender
            , Integer height
            , Double weight
            , ActivityLevel activityLevel
            , String email
            , String name
            , String surname){

        Integer index = this.getIndexByKey(email);

        if(index != -1){
            data.set(index,create(age
                                , gender
                                , height
                                , weight
                                , activityLevel
                                , email
                                , name
                                , surname));

            return true;
        }
        return false;
    }

    @Override
    public User consoleBuilder() {
        Scanner scan = new Scanner(System.in);
        System.out.println("name");
        String name = scan.next();
        System.out.println("surname");
        String surname = scan.next();
        System.out.println("email");

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

        String email = scan.next();
        System.out.println("age(int): ");
        Integer age = scan.nextInt();
        System.out.println("height(double): ");
        Integer height = scan.nextInt();
        System.out.println("weight(double): ");
        Double weight = scan.nextDouble();

        return create(age, gender,height,weight,aLevel,email,name,surname);
    }

    @Override
    public void consoleManager() {

    }
}
