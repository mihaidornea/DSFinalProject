package ro.mihaidornea.facultate.ds.final_project.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "producer_id", referencedColumnName = "id")
    private Producer producer;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "game_genre",
            joinColumns = {@JoinColumn (name = "game_id")},
            inverseJoinColumns = {@JoinColumn (name = "genre_id")}
    )
    private Set<Genre> genres = new HashSet<>();
    private float price;
    private String description;

    public Game() {
    }
}
