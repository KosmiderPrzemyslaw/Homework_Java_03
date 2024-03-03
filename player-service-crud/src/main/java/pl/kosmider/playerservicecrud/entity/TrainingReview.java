package pl.kosmider.playerservicecrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "training_review")
public class TrainingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;

    public TrainingReview(String comment) {
        this.comment = comment;
    }

    public TrainingReview() {
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TrainingReview{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
