package pl.kosmider.playerservicecrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "player_details")
public class PlayerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "playerDetails", cascade = {CascadeType.REFRESH, CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST})
    private Player player;

    public PlayerDetails() {
    }

    public PlayerDetails(String hobby, String email, String phone) {
        this.hobby = hobby;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "PlayerDetails{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


