package by.epam.dietmanager.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.Set;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String text;
    private Integer authorId;
    private Integer receiverId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recommendation_dish",
            joinColumns = { @JoinColumn(name = "recommendation.id")},
            inverseJoinColumns = {@JoinColumn(name = "dish.id")}
    )
    private Set<Dish> dishes;
    private Integer activityId;
    private Date date;
    private Integer feedback;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    private boolean complete;

    public Integer getFeedback() {
        return feedback;
    }

    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Recommendation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recommendation{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", authorId=").append(authorId);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", dishes=").append(dishes);
        sb.append(", activityId=").append(activityId);
        sb.append('}');
        return sb.toString();
    }
}
