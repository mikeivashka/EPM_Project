package by.epam.entity;

import by.epam.collections.Gender;

import java.util.Objects;

public class UserBaseData {
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private int height;
    private double weight;

    public UserBaseData(String name, String surname, int age, Gender gender, int height, double weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
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
        UserBaseData that = (UserBaseData) o;
        return age == that.age &&
                height == that.height &&
                Double.compare(that.weight, weight) == 0 &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender, height, weight);
    }
}
