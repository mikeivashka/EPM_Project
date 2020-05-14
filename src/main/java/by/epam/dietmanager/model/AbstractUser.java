package by.epam.dietmanager.model;

import by.epam.dietmanager.collections.Role;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.StringJoiner;

@MappedSuperclass
public abstract class AbstractUser implements Serializable, Cloneable {

    protected String name;
    protected String surname;
    protected String email;
    protected Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AbstractUser() {
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
        return new StringJoiner(", ", AbstractUser.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("email='" + email + "'")
                .toString();
    }
}
