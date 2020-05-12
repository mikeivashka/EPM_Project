package by.epam.services.builders;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;
import by.epam.entity.Client;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class ClientBuilder {
    private static Logger log = LogManager.getLogger();
    public Client getClient(String email, String name, String surname, ActivityLevel activityLevel, Integer age, Gender gender, Integer height, Double weight){
        Client ob = new Client();
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
    public Client consoleBuilder()throws IOException{
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("name");
            String name = scan.next();
            System.out.println("surname");
            String surname = scan.next();
            System.out.println("email");
            String email = scan.next();
            Gender gender;
            System.out.println("Gender:\n 1. male\n2.female");
            switch (scan.nextInt()) {
                case 2: {
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
            switch (scan.nextInt()) {
                case 2: {
                    aLevel = ActivityLevel.SEDENTARY;
                    break;
                }
                case 3: {
                    aLevel = ActivityLevel.LIGHTLY_ACTIVE;
                    break;
                }
                case 4: {
                    aLevel = ActivityLevel.MODERATELY_ACTIVE;
                    break;
                }
                case 5: {
                    aLevel = ActivityLevel.VERY_ACTIVE;
                    break;
                }
                default: {
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
            return getClient(email, name, surname, aLevel, age, gender, height, weight);
        } catch (Exception e){
            log.log(Level.ERROR, "Failed to create object");
            throw new IOException();
        }
    }
}
