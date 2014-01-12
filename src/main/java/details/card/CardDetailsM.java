package details.card;

import entity.ActionEntity;
import entity.EditionEntity;
import entity.RaceEntity;
import entity.TypeEntity;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class CardDetailsM {
    public TypeEntity type;
    public RaceEntity race;
    public EditionEntity edition;
    public Integer cost=new Integer(0);
    public Integer addicionalCost=new Integer(0);;
    public Integer strenght=new Integer(0);
    public Integer defence=new Integer(0);
    public Integer count=new Integer(0);
    public String subTypes;
    public List<ActionEntity> action;
    public String name;
    public BufferedImage img;
}
