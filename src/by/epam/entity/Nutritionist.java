package by.epam.entity;

import java.util.Date;
import java.util.StringJoiner;

public class Nutritionist extends User{
    private Date experience;
    private double rating;

    public Date getExperience() {
        return experience;
    }

    public void setExperience(Date experience) {
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