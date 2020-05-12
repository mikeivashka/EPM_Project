package by.epam.entity;

import java.util.StringJoiner;

public class Nutritionist extends AbstractUser {
    private Integer experience;
    private double rating;

    public Nutritionist() {
    }

    public Nutritionist(String email, String name, String surname, Integer experience, double rating) {
        this.email = email;
        this.experience = experience;
        this.rating = rating;
        this.name = name;
        this.surname = surname;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Nutritionist.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("experience=" + experience)
                .add("rating=" + rating)
                .toString();
    }
}