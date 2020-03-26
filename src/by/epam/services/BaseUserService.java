package by.epam.services;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.BaseUser;

public class BaseUserService extends UserService {
    public BaseUser create(Integer age, Gender gender, Integer height, Double weight, ActivityLevel activityLevel){
        BaseUser bUser = new BaseUser();

        bUser.setAge(age);
        bUser.setGender(gender);
        bUser.setHeight(height);
        bUser.setWeight(weight);
        bUser.setActivityLevel(activityLevel);

        return bUser;
    }

    public boolean add(Integer age, Gender gender, Integer height, Double weight, ActivityLevel activityLevel){
        return data.add(create(age, gender, height, weight, activityLevel));
    }

    public boolean update(Integer age, Gender gender, Integer height, Double weight, ActivityLevel activityLevel){
        Integer index = this.getIndexByKey();
    }
}
