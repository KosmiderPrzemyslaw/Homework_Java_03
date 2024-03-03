package pl.kosmider.playerservicecrud.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id")
    private List<TrainingReview> reviews;


    //add a convinience method

    public void addReview(TrainingReview trainingReview) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(trainingReview);
    }

    public Training(String title) {
        this.title = title;
    }

    public Training() {
    }

    public List<TrainingReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<TrainingReview> reviews) {
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", player=" + player +
                '}';
    }
}
