package by.epam.dietmanager.model;


import by.epam.dietmanager.collections.TrainingType;
import java.util.Objects;
import java.util.StringJoiner;
import javax.persistence.*;

@Entity
public class Activity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private TrainingType type;
    @Column(length = 600)
    private String description;
    private String link;

    public Activity(TrainingType type, String description, String link) {
        this.type = type;
        this.description = description;
        this.link = link;
    }

    public Activity() {
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