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
    public final static List<String> roleList=new ArrayList<String>();
    public final static List<String> trigerList=new ArrayList<String>();
    public final static List<String> actionTypeList=new ArrayList<String>();
    public final static List<DeckEntity> deckList =new ArrayList<DeckEntity>();
    public static UserEntity currentUser;

    public static void updateDictionary()
    {
        raceList.clear();
        editionList.clear();
        typeList.clear();
        actionList.clear();
        userList.clear();
        roleList.clear();
        trigerList.clear();
        actionTypeList.clear();
        deckList.clear();;

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

        list=HibernateFunctions.getHibernateList(DeckEntity.class,"name");
        for( Object item : list) deckList.add((DeckEntity) item);


        roleList.add("");
        roleList.add("admin");
        roleList.add("user");

        trigerList.add("");
        trigerList.add("Akcja");
        trigerList.add("Wymuszony");

        actionTypeList.add("");
        actionTypeList.add("Pasywna");
        actionTypeList.add("Aktywna");

    }

    public final static ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);

}
