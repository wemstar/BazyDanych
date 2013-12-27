package commons;

import entity.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import search.action.SearchActionM;
import search.card.SearchCardM;
import search.deck.SearchDeckM;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class HibernateFunctions {

    public static SessionFactory sessionFactory;
    public static Configuration configuration=new Configuration();

    static
    {

    }
    public static void createFactory(String login,String password)
    {
        configuration.setProperty("hibernate.connection.username",login).setProperty("hibernate.connection.password",password);
        createFactory();

    }
    public static void createFactory()
    {
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    public static void searchCard(SearchCardM model)
    {
        Session session= sessionFactory.openSession();
        Criteria criteria= session.createCriteria(CardEntity.class);

        if(model.race!= null && !model.race.getName().isEmpty())
        {
            criteria=criteria.add(Restrictions.eq("race", model.race));
        }
        if(model.edition!= null && !model.edition.getName().isEmpty())
        {
            criteria=criteria.add(Restrictions.like("edition", model.edition));
        }
        if(model.name!= null && !model.name.isEmpty())
        {
            criteria=criteria.add(Restrictions.eq("name", model.name));
        }
        if(model.type!= null && !model.type.getName().isEmpty())
        {

            criteria=criteria.add(Restrictions.eq("type", model.type));
        }

        List list= criteria.list();

        List<CardEntity> cardList=new ArrayList<CardEntity>();
        for(Object item: list ){ cardList.add((CardEntity) item); }
        model.cardList=cardList;
        session.flush();
        session.close();
    }

    public static List getHibernateList(Class classEntity,String order)
    {
        Session session=sessionFactory.openSession();
        List lista=session.createCriteria(classEntity).addOrder(Order.asc(order)).list();
        session.flush();
        session.close();
        return lista;
    }

    public static void saveCard(CardEntity entity)
    {
        Session session=sessionFactory.openSession();

        Transaction transaction=session.beginTransaction();

        session.saveOrUpdate(entity);
        transaction.commit();
        session.flush();
        session.close();
    }




    public static void searchDeck(SearchDeckM model) {

        Session session= sessionFactory.openSession();

        Criteria criteria= session.createCriteria(DeckEntity.class);
        if(model.race!= null && !model.race.getName().isEmpty())
        {
            criteria=criteria.add(Restrictions.eq("basic_race", model.race));
        }
        if(model.name!= null && !model.name.isEmpty())
        {
            criteria=criteria.add(Restrictions.like("name", model.name));
        }
        if(model.user!= null && !model.user.getNick().isEmpty())
        {
            criteria=criteria.add(Restrictions.like("user", model.user));
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List list= criteria.list();
 
        List<DeckEntity> cardList=new ArrayList<DeckEntity>();
        for(Object item: list ) { cardList.add((DeckEntity) item); }
        model.deckList=cardList;
        session.flush();
        session.close();
    }

    public static void saveDeck(DeckEntity entity)
    {
        Session session=sessionFactory.openSession();
        Transaction transatcio= session.beginTransaction();
        session.saveOrUpdate(entity);
        transatcio.commit();
        session.close();
    }

    public static void saveAction(ActionEntity entity) {

        Session session=sessionFactory.openSession();
        Transaction transatcio= session.beginTransaction();
        session.saveOrUpdate(entity);
        transatcio.commit();
        session.close();
        Commons.updateDictionary();
    }

    public static void saveUser(UserEntity entity)
    {
        Session session=sessionFactory.openSession();
        Transaction transatcio= session.beginTransaction();
        session.saveOrUpdate(entity);
        transatcio.commit();
        session.close();
        Commons.updateDictionary();

    }

    public static void searchAction(SearchActionM model) {
        Session session= sessionFactory.openSession();
        Criteria criteria=session.createCriteria(ActionEntity.class);

        if(!(model.entity.getName()==null || model.entity.getName().isEmpty()))criteria.add(Restrictions.like("name",model.entity.getName()));
        if(!(model.entity.getType()==null || model.entity.getType().isEmpty()))criteria.add(Restrictions.eq("type", model.entity.getType()));
        if(!(model.entity.getTriger()==null || model.entity.getTriger().isEmpty()))criteria.add(Restrictions.eq("triger", model.entity.getTriger()));
        if(!(model.entity.getAbility()==null || model.entity.getAbility().isEmpty()))criteria.add(Restrictions.eq("ability", model.entity.getAbility()));

        List list= criteria.list();
        List<ActionEntity> actionList= new ArrayList<ActionEntity>();
        for(Object item: list ){ actionList.add((ActionEntity) item); }
        model.actionList=actionList;
        session.flush();
        session.close();
    }

    public static void deleteAction(ActionEntity entity) {

        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }
}
