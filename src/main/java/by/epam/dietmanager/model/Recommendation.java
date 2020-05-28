package by.epam.dietmanager.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 600)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Nutritionist author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Client receiver;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "recommendation_dish",
            joinColumns = {@JoinColumn(name = "recommendation.id")},
            inverseJoinColumns = {@JoinColumn(name = "dish.id")}
    )
    private Set<Dish> dishes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Activity activity;
    private Date date;
    private Integer mark;
    @Column(length = 600)
    private String feedback;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    private boolean complete;

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Recommendation() {
        date = new Date();
        complete = false;
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

    public Nutritionist getAuthor() {
        return author;
    }

    public void setAuthor(Nutritionist author) {
        this.author = author;
    }

    public Client getReceiver() {
        return receiver;
    }

    public void setReceiver(Client receiver) {
        this.receiver = receiver;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Recommendation{");
        sb.append("id=").append(id);
        sb.append(", text='").append(text).append('\'');
        sb.append(", author=").append(author);
        sb.append(", receiver=").append(receiver);
        sb.append(", dishes=").append(dishes);
        sb.append(", activityId=").append(activity);
        sb.append('}');
        return sb.toString();
    }
}
