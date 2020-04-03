package by.epam.entity;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class User extends Entity {
    private String name;
    private String surname;
    private String email;
    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
