package commons;

import core.main.MainApplicationC;
import core.main.MainApplicationV;
import details.card.CardDetailsC;
import details.card.CardDetailsM;
import details.card.CardDetailsV;
import details.action.ActionDetailsC;
import details.action.ActionDetailsM;
import details.action.ActionDetailsV;
import details.deck.DeckDetailsC;
import details.deck.DeckDetailsM;
import details.deck.DeckDetailsV;
import details.user.UserDetailsC;
import details.user.UserDetailsM;
import details.user.UserDetailsV;
import entity.ActionEntity;
import entity.DeckEntity;
import entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import search.action.SearchActionC;
import search.action.SearchActionM;
import search.action.SearchActionV;
import search.card.SearchCardC;
import search.card.SearchCardM;
import search.card.SearchCardV;
import search.deck.SearchDeckC;
import search.deck.SearchDeckM;
import search.deck.SearchDeckV;
import search.user.SearchUserC;
import search.user.SearchUserM;
import search.user.SearchUserV;
import statistic.deck.DeckStatisticC;
import statistic.deck.DeckStatisticM;
import statistic.deck.DeckStatisticV;

/**
 * Created by wemstar on 15.12.13.
 */
@Configuration
public class Beans {

    @Bean
    @Scope("prototype")
    SearchCardC Search()
    {
        SearchCardV view=new SearchCardV();
        view.setModel(new SearchCardM());
        SearchCardC controller=new SearchCardC();
        controller.setView(view);
        view.setController(controller);

        return controller;
    }

    @Bean
    @Scope("prototype")
    CardDetailsC CardDetail()
    {
        CardDetailsV view=new CardDetailsV();
        view.setModel(new CardDetailsM());
        CardDetailsC controller=new CardDetailsC();
        controller.setView(view);
        view.initalizeComponents();
        view.setController(controller);

        return controller;
    }

    @Bean
    @Scope("prototype")
    CardDetailsC NewCard()
    {
        CardDetailsC controller=CardDetail();
        controller.getView().enableControls(true);
        return controller;
    }

    @Bean
    @Scope("prototype")
    ActionDetailsC ActionDetail()
    {
        ActionDetailsV view=new ActionDetailsV();
        view.setModel(new ActionDetailsM());
        ActionDetailsC controller=new ActionDetailsC();
        controller.setView(view);
        view.initalizeComponents();
        view.setController(controller);

        return controller;
    }

    @Bean
    @Scope("prototype")
    SearchDeckC SearchDeck()
    {
        SearchDeckV view=new SearchDeckV();
        view.setModel(new SearchDeckM());
        SearchDeckC controller=new SearchDeckC();
        controller.setView(view);
        view.initializeComponents();
        view.setController(controller);

        return controller;
    }

    @Bean
    @Scope("prototype")
    DeckDetailsC DeckDetails()
    {
        DeckDetailsV view= new DeckDetailsV();
        view.setModel(new DeckDetailsM());
        DeckDetailsC controller= new DeckDetailsC();
        controller.setView(view);
        view.initializeComponents();
        view.setController(controller);

        return controller;
    }
    @Bean
    @Scope("prototype")
    DeckDetailsC NewDeck()
    {
        DeckDetailsC controller= DeckDetails();
        DeckEntity entity=new DeckEntity();
        controller.getView().getModel().entity=entity;
        controller.getView().setControlState(true);

        return controller;
    }
    @Bean
    MainApplicationC MainApplication()
    {
        MainApplicationC controller=new MainApplicationC();
        MainApplicationV view=new MainApplicationV();
        controller.setView(view);
        view.setController(controller);
        view.initializeComponents();
        return controller;
    }
    @Bean
    @Scope("prototype")
    DeckStatisticC DeckStatistic()
    {
        DeckStatisticC controller=new DeckStatisticC();
        DeckStatisticV view=new DeckStatisticV();
        view.setModel(new DeckStatisticM());
        view.setController(controller);
        controller.setView(view);
        return controller;
    }

    @Bean
    @Scope("prototype")
    ActionDetailsC ActionDetails()
    {
        ActionDetailsC controller=new ActionDetailsC();
        ActionDetailsV view=new ActionDetailsV();
        view.initalizeComponents();
        controller.setView(view);
        view.setController(controller);
        view.setModel(new ActionDetailsM());
        return controller;
    }

    @Bean
    @Scope("prototype")
    ActionDetailsC NewAction()
    {
        ActionDetailsC controller =ActionDetails();
        ActionEntity entity=new ActionEntity();
        controller.getView().getModel().entity=entity;
        return controller;
    }

    @Bean
    @Scope("prototype")
    UserDetailsC UserDetails()
    {
        UserDetailsC controller=new UserDetailsC();
        UserDetailsV view=new UserDetailsV();
        controller.setView(view);
        view.setController(controller);
        view.setModel(new UserDetailsM());
        view.initializeComponent();
        view.setControlState(false);
        return controller;
    }

    @Bean
    @Scope("prototype")
    UserDetailsC NewUser()
    {
        UserDetailsC controller=UserDetails();
        UserEntity entity=new UserEntity();
        controller.getView().setControlState(true);
        controller.getView().getModel().entity=entity;
        return controller;
    }

    @Bean
    @Scope("prototype")
    SearchUserC SearchUser()
    {
        SearchUserC controller=new SearchUserC();
        SearchUserV view=new SearchUserV();
        view.initializeComponents();
        controller.setView(view);
        view.setController(controller);
        SearchUserM model=new SearchUserM();
        model.entity=new UserEntity();

        view.setModel(model);

        return controller;
    }

    @Bean
    @Scope("prototype")
    SearchActionC SearchAction()
    {
        SearchActionC controller= new SearchActionC();
        SearchActionV view= new SearchActionV();
        view.initializeComponents();
        controller.setView(view);
        view.setController(controller);
        SearchActionM model= new SearchActionM();
        model.entity=new ActionEntity();

        view.setModel(model);

        return controller;
    }
}
