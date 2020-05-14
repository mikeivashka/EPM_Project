package by.epam.dietmanager.model;

import java.io.Serializable;
import java.util.StringJoiner;

public class Product implements Serializable, Cloneable {
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

