package by.epam.services;

import by.epam.entity.BaseUser;
import by.epam.entity.Nutritionist;
import by.epam.entity.User;

import java.util.*;

public class NutritionistService extends UserService {
    Scanner scan = new Scanner(System.in);
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

    public boolean add(Nutritionist ob){
        return data.add(ob);
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

    public boolean update(Nutritionist ob){
        Integer index = getIndexByKey(ob.getEmail());
        if(index != -1){
            data.set(index, ob);
            return true;
        }
        return false;
    }

    @Override
    public Nutritionist consoleBuilder() {

        System.out.println("name");
        String name = scan.next();
        System.out.println("surname");
        String surname = scan.next();
        System.out.println("email");
        String email = scan.next();
        System.out.println("rating");
        Double rating = scan.nextDouble();

        System.out.println("start day");
        int day = scan.nextInt();
        System.out.println("start month");
        int month = scan.nextInt();
        System.out.println("start year");
        int year = scan.nextInt();
        //проверить
        Date start = new GregorianCalendar(day,month,year).getTime();

        return create(start,rating,email,name,surname);
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
                ArrayList<Nutritionist> data1 = (ArrayList<Nutritionist>) getAll().stream().filter(ob -> ob.getClass().equals(Nutritionist.class));


                ArrayList<Nutritionist> data = new ArrayList<>();
                ArrayList<User> users = getAll();

                for (int i = 0; i < users.size(); i++) {
                    if(Objects.equals(users.get(i).getClass(), getClass())){
                        data.add((Nutritionist) users.get(i));
                    }
                }
                for(Nutritionist e : data){
                    System.out.println(e.toString());
                }
                break;
            }
            default: return;
        }
    }
}
