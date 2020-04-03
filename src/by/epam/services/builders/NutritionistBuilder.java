package by.epam.services.builders;

import by.epam.entity.Nutritionist;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class NutritionistBuilder {

    public static Nutritionist getNutritionist(String email, String name, String surname, Date experience, Double rating){
        Nutritionist ob = new Nutritionist();
        ob.setEmail(email);
        ob.setName(name);
        ob.setSurname(surname);
        ob.setExperience(experience);
        ob.setRating(rating);
        return ob;
    }

    public static Nutritionist consoleBuilder() {
        Scanner scan = new Scanner(System.in);
        System.out.println("name");
        String name = scan.next();
        System.out.println("surname");
        String surname = scan.next();
        System.out.println("email");
        String email = scan.next();
        System.out.println("rating");
        Double rating = scan.nextDouble();

        System.out.println("start year");
        int year = scan.nextInt();
        Date start = new GregorianCalendar(01,01,year).getTime();
        return getNutritionist(email, name, surname, start, rating);
    }
}
