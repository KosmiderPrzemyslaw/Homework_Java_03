package pl.kosmider.playerservicecrud.entity;

import jakarta.persistence.*;

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


    public Training(String title) {
        this.title = title;
    }

    public Training() {
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
