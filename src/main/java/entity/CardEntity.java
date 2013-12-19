package entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
@Entity
@Table(name = "card", schema = "project", catalog = "i1macura")
public class CardEntity {
    private Integer addicionallcost;
    private Integer cost;
    private Integer count;
    private Integer defence;
    private byte[] image;
    private String name;
    private Integer strenght;
    private String subtypes;

    @Basic
    @Column(name = "addicionallcost")
    public Integer getAddicionallcost() {
        return addicionallcost;
    }

    public void setAddicionallcost(Integer addicionallcost) {
        this.addicionallcost = addicionallcost;
    }

    @Basic
    @Column(name = "basiccost")
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer basiccost) {
        this.cost = basiccost;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "defence")
    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "strenght")
    public Integer getStrenght() {
        return strenght;
    }

    public void setStrenght(Integer strenght) {
        this.strenght = strenght;
    }

    @Basic
    @Column(name = "subtypes")
    public String getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(String subtypes) {
        this.subtypes = subtypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (addicionallcost != null ? !addicionallcost.equals(that.addicionallcost) : that.addicionallcost != null)
            return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (defence != null ? !defence.equals(that.defence) : that.defence != null) return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (strenght != null ? !strenght.equals(that.strenght) : that.strenght != null) return false;
        if (subtypes != null ? !subtypes.equals(that.subtypes) : that.subtypes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (addicionallcost != null ? addicionallcost.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (defence != null ? defence.hashCode() : 0);
        result = 31 * result + (image != null ? Arrays.hashCode(image) : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (strenght != null ? strenght.hashCode() : 0);
        result = 31 * result + (subtypes != null ? subtypes.hashCode() : 0);
        return result;
    }

    private TypeEntity type;

    @ManyToOne(optional = false)
    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    private EditionEntity edition;

    @ManyToOne(optional = false)
    public EditionEntity getEdition() {
        return edition;
    }

    public void setEdition(EditionEntity edition) {
        this.edition = edition;
    }

    private RaceEntity race;

    @ManyToOne(optional = false)
    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }

    @Override
    public String toString(){return getName();}

    private List<ActionEntity> actions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "card_action", catalog = "project", joinColumns = {
            @JoinColumn(name = "card_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "action_id",nullable = false, updatable = false) })
    public List<ActionEntity> getActions() {
        return actions;
    }

    public void setActions(List<ActionEntity> actions) {
        this.actions = actions;
    }

}
