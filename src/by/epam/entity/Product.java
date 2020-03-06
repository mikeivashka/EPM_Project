package by.epam.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Product implements Serializable {
    private String title;
    private int caloriesCapacity;
    private static final long serialVersionUID = 1L;

    public Product(){
        super();
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
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("caloriesCapacity=" + caloriesCapacity)
                .toString();
    }
}

