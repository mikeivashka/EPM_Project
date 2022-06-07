package by.epam.dietmanager.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
@Entity
@Table(name = "nutritionist")
public class Nutritionist extends AbstractUser {
    private Integer experience;
    @Transient
    private double rating;
    private Integer totalMark = 8;
    private Integer marksCount = 1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutritionist")
    private Set<Client> clients = new HashSet<>();

    public Nutritionist() {
        rating = totalMark/(double)marksCount;
    }

    public Integer getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(Integer totalMark) {
        this.totalMark = totalMark;
    }

    public Integer getMarksCount() {
        return marksCount;
    }

    public void setMarksCount(Integer marksCount) {
        this.marksCount = marksCount;
    }


    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
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
        rating = totalMark/(double)marksCount;
        return rating;
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