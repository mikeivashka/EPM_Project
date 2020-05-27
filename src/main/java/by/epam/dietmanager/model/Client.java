package by.epam.dietmanager.model;


import by.epam.dietmanager.collections.ActivityLevel;
import by.epam.dietmanager.collections.Gender;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client extends AbstractUser {
    private int age;
    private Gender gender;
    private int height;
    private double weight;
    @Enumerated(EnumType.ORDINAL)
    private ActivityLevel activityLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
    private Set<Recommendation> recommendations;

    public Client(){
        super();
        activityLevel = ActivityLevel.NONE;
        gender = Gender.MALE;
    }

    public Client(String email, String name, String surname, int age, Gender gender, int height, double weight, ActivityLevel activityLevel, Nutritionist nutritionist) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
        this.nutritionist = nutritionist;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return age == that.age &&
                height == that.height &&
                Double.compare(that.weight, weight) == 0 &&
                gender == that.gender &&
                activityLevel == that.activityLevel &&
                nutritionist == that.nutritionist;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append(super.toString());
        sb.append(",age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append(", activityLevel=").append(activityLevel);
        sb.append(", nutritionist=").append(nutritionist);
        sb.append('}');
        return sb.toString();
    }

    public Nutritionist getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(Nutritionist nutritionist) {
        this.nutritionist = nutritionist;
    }
}
