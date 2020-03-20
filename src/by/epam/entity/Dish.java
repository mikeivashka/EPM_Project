package by.epam.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class Dish extends Entity {

    private String title;
    private Map<Product, Integer> ingredients;
    private int caloriesCapacity;
    private String recepyLink;
    private static final long serialVersionUID = 1L;

    public Dish() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return caloriesCapacity == dish.caloriesCapacity &&
                title.equals(dish.title) &&
                Objects.equals(ingredients, dish.ingredients) &&
                Objects.equals(recepyLink, dish.recepyLink);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public Map<Product, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<Product, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public int getCaloriesCapacity() {
        return caloriesCapacity;
    }

    public void setCaloriesCapacity(int caloriesCapacity) {
        this.caloriesCapacity = caloriesCapacity;
    }

    public String getRecepyLink() {
        return recepyLink;
    }

    public void setRecepyLink(String recepyLink) {
        this.recepyLink = recepyLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dish.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("ingredients=" + ingredients)
                .add("caloriesCapacity=" + caloriesCapacity)
                .add("recepyLink='" + recepyLink + "'")
                .toString();
    }
}
