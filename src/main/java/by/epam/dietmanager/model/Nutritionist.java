package by.epam.dietmanager.model;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
@Entity
@Table(name = "nutritionist")
public class Nutritionist extends AbstractUser {
    private Integer experience;
    private double rating;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Client> clients = new HashSet<>();
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