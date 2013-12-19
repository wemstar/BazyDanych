package entity;

import javax.persistence.*;

/**
 * Created by wemstar on 15.12.13.
 */
@Entity
@Table(name = "action", schema = "project", catalog = "i1macura")
public class ActionEntity {
    private String name;
    private String ability;
    private String triger;
    private String type;

    @Id
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ability")
    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    @Basic
    @Column(name = "triger")
    public String getTriger() {
        return triger;
    }

    public void setTriger(String triger) {
        this.triger = triger;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (ability != null ? !ability.equals(that.ability) : that.ability != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (triger != null ? !triger.equals(that.triger) : that.triger != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ability != null ? ability.hashCode() : 0);
        result = 31 * result + (triger != null ? triger.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
    @Override
    public String toString(){return getName();}
}
