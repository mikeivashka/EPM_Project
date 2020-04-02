package by.epam.services.builders;

import by.epam.collections.TrainingType;
import by.epam.entity.Activity;

import java.util.Scanner;

public class ActivityBuilder {
    public Activity ActivityBuilder() {
        return new Activity();
    }

    public Activity ActivityBuilder(Integer id, TrainingType type, String description, String link) {
        return getActivity(id, type, description, link);
    }

    public Activity getActivity(Integer id, TrainingType type, String description, String link) {
        Activity result = new Activity();
        result.setLink(link);
        result.setId(id);
        result.setDescription(description);
        result.setType(type);
        return result;
    }

    public Activity consoleBuilder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("id (integer): ");
        Integer id = scan.nextInt();
        System.out.println("training type (1 - POWER, 2 - CARDIO, default - CARDIO)");
        TrainingType trainingType;
        switch (scan.nextInt()){
            case 1:{
                trainingType = TrainingType.POWER;
                break;
            }
            case 2:{
                trainingType = TrainingType.CARDIO;
                break;
            }
            default: {
                trainingType = TrainingType.CARDIO;
                break;
            }
        }
        System.out.println("Enter a description line: ");
        String description = scan.next();
        System.out.println("Enter a link with activity description: ");
        String link = scan.next();
        return getActivity(id, trainingType, description, link);
    }

}
