package by.epam.entity;

import by.epam.collections.TrainingType;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

public class Activity extends Entity {
    private  Integer id;
    private TrainingType type;
    private String description;
    private String link;
    private static final long serialVersionUID = 1L;

    public Activity(Integer id, TrainingType type, String description, String link) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.link = link;
    }

    public Activity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainingType getType() {
        return type;
    }

    public void setType(TrainingType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Activity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("type=" + type)
                .add("description='" + description + "'")
                .add("link='" + link + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id) &&
                type == activity.type &&
                Objects.equals(description, activity.description) &&
                Objects.equals(link, activity.link);
    }

    @Override
    public int hashCode() {
        return id;
    }
}