package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.Activity;
import by.epam.entity.BaseUser;
import by.epam.entity.User;

import java.util.*;

public class BaseUserService extends UserService {
    Scanner scan = new Scanner(System.in);
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

    public boolean add(BaseUser ob){
        return data.add(ob);
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

    public boolean update(BaseUser ob){
        Integer index = getIndexByKey(ob.getEmail());
        if(index != -1){
            data.set(index, ob);
            return true;
        }
        return false;
    }

    @Override
    public BaseUser consoleBuilder() {
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
        Integer choice;
        System.out.println("1. Create \n2. Update\n3. Delete \n4. Show all\n0. Exit");
        while(!scan.hasNextInt()){
            System.out.println("Waiting for integer value");
        }
        choice = scan.nextInt();

        switch (choice){
            case 1:{
                add(consoleBuilder());
                break;
            }
            case 2:{
                update(consoleBuilder());
                break;
            }
            case 3:{
                System.out.println("Enter email to delete");
                String email = scan.next();
                if(delete(email)) {
                    System.out.println("Success");
                }
                else {
                    System.out.println("Delete failed");
                }
                break;
            }
            case 4:{
                //один из способов(возможно работает)
                ArrayList<BaseUser> data1 = (ArrayList<BaseUser>) getAll().stream().filter(ob -> ob.getClass().equals(BaseUser.class));

                //второй способо
                //тоже возможно работатет
                ArrayList<BaseUser> data = new ArrayList<>();
                ArrayList<User> users = getAll();

                for (int i = 0; i < users.size(); i++) {
                    if(Objects.equals(users.get(i).getClass(), getClass())){
                        data.add((BaseUser) users.get(i));
                    }
                }

                for(BaseUser e : data){
                    System.out.println(e.toString());
                }
                break;
            }
            default:
                return;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUserService that = (BaseUserService) o;
        return Objects.equals(scan, that.scan);
    }

}
