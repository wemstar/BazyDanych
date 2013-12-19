package commons;

import entity.ActionEntity;
import entity.EditionEntity;
import entity.RaceEntity;
import entity.TypeEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class Commons {

    public final static List<RaceEntity> raceList=new ArrayList<RaceEntity>() ;
    public final static List<EditionEntity> editionList=new ArrayList<EditionEntity>();
    public final static List<TypeEntity> typeList=new ArrayList<TypeEntity>();
    public final static List<ActionEntity> actionList=new ArrayList<ActionEntity>();

    public static void updateDictionary()
    {

        List list=HibernateFunctions.getHibernateList(TypeEntity.class);
        for( Object item : list) typeList.add((TypeEntity) item);

        list=HibernateFunctions.getHibernateList(RaceEntity.class);
        for( Object item : list) raceList.add((RaceEntity) item);

        list=HibernateFunctions.getHibernateList(EditionEntity.class);
        for( Object item : list) editionList.add((EditionEntity) item);

        list=HibernateFunctions.getHibernateList(ActionEntity.class);
        for( Object item : list) actionList.add((ActionEntity) item);



    }

    public final static ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

}
