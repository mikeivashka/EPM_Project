package by.epam.services;

import by.epam.entity.Nutritionist;

import java.util.Date;

public class NutritionistService extends UserService {
    private Nutritionist create(Date experience
            , double rating
            , String email
            , String name
            , String surname){
        Nutritionist ob = new Nutritionist();
        ob.setRating(rating);
        ob.setExpirience(experience);
        ob.setEmail(email);
        ob.setName(name);
        ob.setSurname(surname);
        return ob;
    }

    public boolean add(Date experience
            , double rating
            , String email
            , String name
            , String surname){
        return data.add(create(experience, rating, email, name, surname));
    }

    public boolean update(Date experience
            , double rating
            , String email
            , String name
            , String surname){
        Integer index = getIndexByKey(email);
        if(index != -1){
            data.set(index, create(experience, rating, email, name, surname));
            return true;
        }
        else return false;
    }
}
