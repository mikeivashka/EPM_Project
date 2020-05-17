package by.epam.dietmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Entity
public class Dish implements Cloneable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private Integer id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "dish_ingredients",
            joinColumns = { @JoinColumn(name = "dish.id") },
            inverseJoinColumns = { @JoinColumn(name = "product.id") }
    )
    private Set<Product> ingredients;
    private int caloriesCapacity;
    private String recepyLink;
    private static final long serialVersionUID = 1L;

    public Dish(String title, Set<Product> ingredients, int caloriesCapacity, String recepyLink) {
        this.title = title;
        this.ingredients = ingredients;
        this.caloriesCapacity = caloriesCapacity;
        this.recepyLink = recepyLink;
    }

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



    public Set<Product> getIngredients() {
        return Set.copyOf(ingredients);
    }

    public void setIngredients(Set<Product> ingredients) {
        this.ingredients = Set.copyOf(ingredients);
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
