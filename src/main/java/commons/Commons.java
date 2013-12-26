package commons;

import entity.*;
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
    public final static List<UserEntity> userList=new ArrayList<UserEntity>();

    public static void updateDictionary()
    {
        List list=HibernateFunctions.getHibernateList(TypeEntity.class,"name");
        for( Object item : list) typeList.add((TypeEntity) item);

        list=HibernateFunctions.getHibernateList(RaceEntity.class,"name");
        for( Object item : list) raceList.add((RaceEntity) item);

        list=HibernateFunctions.getHibernateList(EditionEntity.class,"name");
        for( Object item : list) editionList.add((EditionEntity) item);

        list=HibernateFunctions.getHibernateList(ActionEntity.class,"name");
        for( Object item : list) actionList.add((ActionEntity) item);

        list=HibernateFunctions.getHibernateList(UserEntity.class,"nick");
        for( Object item : list) userList.add((UserEntity) item);

    }

    public final static ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

}
