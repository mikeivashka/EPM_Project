package by.epam.entity;

import by.epam.collections.TrainingType;

import java.util.StringJoiner;

public class Activity {
    private TrainingType type;
    private String description;
    private String link;

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