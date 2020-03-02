package by.epam.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {
    private String title;
    private int caloriesCapacity;

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
        return Objects.hash(title, caloriesCapacity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("caloriesCapacity=" + caloriesCapacity)
                .toString();
    }
}

