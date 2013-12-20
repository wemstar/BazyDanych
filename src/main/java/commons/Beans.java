package commons;

import CardDetails.CardDetailsC;
import CardDetails.CardDetailsM;
import CardDetails.CardDetailsV;
import actionDetails.ActionDetailsC;
import actionDetails.ActionDetailsM;
import actionDetails.ActionDetailsV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import search.card.SearchC;
import search.card.SearchM;
import search.card.SearchV;

/**
 * Created by wemstar on 15.12.13.
 */
@Configuration
public class Beans {

    @Bean
    @Scope("prototype")
    SearchC Search()
    {
        SearchV view=new SearchV();
        view.setModel(new SearchM());
        SearchC controller=new SearchC();
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

}
