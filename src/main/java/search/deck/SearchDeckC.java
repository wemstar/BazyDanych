package search.deck;

import commons.Commons;
import commons.HibernateFunctions;
import core.main.MainApplicationV;
import details.deck.DeckDetailsC;
import entity.DeckEntity;

import javax.swing.*;

/**
 * Created by wemstar on 20.12.13.
 */
public class SearchDeckC {

    private SearchDeckV view;
    private MainApplicationV master;

    public void updateModel()
    {
        SearchDeckM model=view.getModel();

        model.name=view.getName();
        model.race=view.getRace();

        model.user=view.getUser();

    }

    public void updateView()
    {
       SearchDeckM model=view.getModel();
       view.setName(model.name);
       view.setRace(model.race);
       view.setDeckList(model.deckList);
    }

    public void setView(SearchDeckV view) {
        this.view = view;
    }
    public SearchDeckV getView(){ return view;}

    public void searchDeck() {

        updateModel();
        HibernateFunctions.searchDeck(view.getModel());
        updateView();
    }

    public void setMaster(MainApplicationV master) {
        this.master = master;
    }
    public void deckDetail(DeckEntity entity) {



            DeckDetailsC controler= (DeckDetailsC) Commons.ctx.getBean("DeckDetails");
            controler.castToModel(entity);
            master.addTab(controler.getView().getMainPanel(),"Szczegóły Tali");



    }
}
