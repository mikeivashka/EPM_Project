package by.epam.entity;

import by.epam.collections.TrainingType;

import java.io.Serializable;
import java.util.StringJoiner;

public class Activity implements Serializable {
    private  Integer id;
    private TrainingType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String description;
    private String link;
    private static final long serialVersionUID = 1L;
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
                .add("type=" + type.name())
                .add("description='" + description + "'")
                .add("link='" + link + "'")
                .toString();
    }
}