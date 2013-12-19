package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by wemstar on 15.12.13.
 */
@Entity
@Table(name = "deck", schema = "project", catalog = "i1macura")
public class DeckEntity {
    private String name;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeckEntity that = (DeckEntity) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    private RaceEntity basic_race;

    @ManyToOne(optional = false)
    public RaceEntity getBasic_race() {
        return basic_race;
    }

    public void setBasic_race(RaceEntity basic_race) {
        this.basic_race = basic_race;
    }

    @Override
    public String toString(){return getName();}

    private Collection<CardEntity> card_list;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_deck", catalog = "project", joinColumns = {
            @JoinColumn(name = "card_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "deck_id",nullable = false, updatable = false) })
    public Collection<CardEntity> getCard_list() {
        return card_list;
    }

    public void setCard_list(Collection<CardEntity> card_list) {
        this.card_list = card_list;
    }

    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
