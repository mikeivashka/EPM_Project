package by.epam.entity;

import by.epam.collections.ActivityLevel;
import by.epam.collections.Gender;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class User implements Serializable {
    private String name;
    private String surname;
    private String email;
    private static final long serialVersionUID = 1L;
    static class UserBaseData {
        private int age;
        private Gender gender;
        private int height;
        private double weight;
        private ActivityLevel activityLevel;
        //private static final long serialVersionUID = 1L;
        public UserBaseData(int age, Gender gender, int height, double weight, ActivityLevel activityLevel) {
            this.age = age;
            this.gender = gender;
            this.height = height;
            this.weight = weight;
            this.activityLevel = activityLevel;
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
            UserBaseData that = (UserBaseData) o;
            return age == that.age &&
                    height == that.height &&
                    Double.compare(that.weight, weight) == 0 &&
                    gender == that.gender &&
                    activityLevel == that.activityLevel;
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, gender, height, weight, activityLevel);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("UserBaseData{");
            sb.append("age=").append(age);
            sb.append(", gender=").append(gender);
            sb.append(", height=").append(height);
            sb.append(", weight=").append(weight);
            sb.append(", activityLevel=").append(activityLevel);
            sb.append('}');
            return sb.toString();
        }
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
        return Objects.hash(email);
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
