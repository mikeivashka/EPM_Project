package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.BaseUser;

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
}
