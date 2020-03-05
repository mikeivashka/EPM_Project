package by.epam.entity;

import java.io.Serializable;
import java.util.Map;

public class Dish implements Serializable {

    private String title;
    private Map<Product, Integer> ingredients;
    private int caloriesCapacity;
    private String recepyLink;

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

}
