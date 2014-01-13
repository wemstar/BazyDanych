package details.deck;

import commons.ClickCardAction;
import commons.Commons;
import commons.HibernateFunctions;
import core.main.MainApplicationC;
import entity.CardEntity;
import entity.DeckEntity;
import search.card.SearchCardC;
import statistic.deck.DeckStatisticC;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by wemstar on 23.12.13.
 */
public class DeckDetailsC {
    private DeckDetailsV view;
    private ClickCardAction action=new ClickCardAction() {
        @Override
        public void cardAction(CardEntity entity)
        {
            DeckDetailsM model= view.getModel();
            model.entity.getCard_list().remove(entity);
            updateView();
        }
    };

    public void setView(DeckDetailsV vie)
    {
        this.view = vie;
        SearchCardC control= (SearchCardC) Commons.ctx.getBean("Search");
        control.getView().setActiveControl(false);
        view.setSearchControl(control.getView());
        control.setAction(new ClickCardAction() {
            @Override
            public void cardAction(CardEntity entity) {
                DeckDetailsM model= view.getModel();
                DeckEntity enti=model.entity;
                if(entity.getRace()==null || entity.getRace().getFraction().equals("Neutralni")||!enti.getBasic_race().getFraction().equals(entity.getRace().getFraction()))
                {
                    JOptionPane.showMessageDialog(null, "Rasy muszą byc z tej samej frakcji", "Wrong ", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(enti.getCard_list().contains(entity))
                {
                    for(CardEntity card: new ArrayList<CardEntity>(enti.getCard_list()))
                    {
                        if(card.equals(entity))
                        {
                           enti.getCard_list().add(card);
                           break;
                        }
                    }
                }
                else model.entity.getCard_list().add(entity);
                updateView();
            }
        });
    }

    public void updateView() {
        DeckEntity entity= view.getModel().entity;
        view.setName(entity.getName());
        view.setUser(entity.getUser());
        view.setRace(entity.getBasic_race());
        view.setCardList(new ArrayList<CardEntity>(entity.getCard_list()));
    }

    public void updateModel()
    {

        DeckEntity entity= view.getModel().entity;
        entity.setName(view.getName());
        entity.setBasic_race(view.getRace());
        entity.setCard_list(view.getCardList());
        entity.setUser(view.getUser());

    }

    public DeckDetailsV getView() {
        return view;
    }

    public void castToModel(DeckEntity entity) {

        DeckDetailsM model= view.getModel();
        model.entity=entity;
        updateView();
    }

    public void saveDeck() {
        updateModel();
        DeckDetailsM model= view.getModel();
        if(model.entity.getName().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Pole name nie może byc puste", "Wrong ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        HibernateFunctions.saveDeck(model.entity);
        updateView();
    }

    public ClickCardAction getAction() {
        return action;
    }

    public void setAction(ClickCardAction action) {
        this.action = action;
    }

    public void performCardClick(CardEntity entity)
    {
        action.cardAction(entity);
    }

    public void statisticView() {
        MainApplicationC controll= (MainApplicationC) Commons.ctx.getBean("MainApplication");

        DeckStatisticC cont= (DeckStatisticC) Commons.ctx.getBean("DeckStatistic");
        cont.getView().getModel().entity=view.getModel().entity;
        cont.generateDataset();
        controll.getView().addTab(cont.getView().getMainPanel(), "Statystyka Tali");
        cont.updateView();

    }

    public void deleteDeck() {
        if(Commons.currentUser.getRole().equals("admin"))HibernateFunctions.deleteDeck(view.getModel().entity);
    }
}
