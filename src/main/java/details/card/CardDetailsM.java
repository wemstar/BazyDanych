package details.card;

import entity.ActionEntity;
import entity.EditionEntity;
import entity.RaceEntity;
import entity.TypeEntity;

import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class CardDetailsM {
    public TypeEntity type;
    public RaceEntity race;
    public EditionEntity edition;
    public Integer cost;
    public Integer addicionalCost;
    public Integer strenght;
    public Integer defence;
    public Integer count;
    public String subTypes;
    public List<ActionEntity> action;
    public String name;
}
