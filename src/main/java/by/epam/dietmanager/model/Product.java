package by.epam.dietmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Product implements Cloneable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;
    private String title;
    private int caloriesCapacity;
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Dish> dishes;
    public Product(){
    }

    public Product(String title, int caloriesCapacity) {
        this.title = title;
        this.caloriesCapacity = caloriesCapacity;
    }
    public String getTitle() {
        return title;
    }
    public int getCaloriesCapacity() {
        return caloriesCapacity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCaloriesCapacity(int caloriesCapacity) {
        this.caloriesCapacity = caloriesCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return caloriesCapacity == product.caloriesCapacity &&
                title.equals(product.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("caloriesCapacity=" + caloriesCapacity)
                .toString();
    }
}

