package by.epam.dietmanager.model;

import by.epam.dietmanager.collections.Role;

import javax.persistence.*;
import java.util.Date;
import java.util.StringJoiner;


@Entity
@Table(name="user_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractUser implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email", unique = true)
    protected String email;
    @Column(name = "pwd")
    private String password;
    protected String name;
    protected String surname;
    @Enumerated(EnumType.STRING)
    protected Role role;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    private boolean active = true;

    public boolean isActive() {
        return active;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AbstractUser() {
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
