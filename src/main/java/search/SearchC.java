package search;

import CardDetails.CardDetailsC;
import commons.Commons;
import commons.HibernateFunctions;
import core.MainApplication;
import entity.CardEntity;

/**
 * Created by wemstar on 15.12.13.
 */
public class SearchC {
    private SearchV view;
    private MainApplication master;

    public void updateView() {

        SearchM model=view.getModel();
        view.setName(model.name);
        view.setRace(model.race);
        view.setType(model.type);
        view.setEdition(model.edition);
        view.setCardList(model.cardList);

    }

    public void updateModel() {
        SearchM model=view.getModel();

        model.name=view.getName();
        model.race=view.getRace();
        model.type=view.getType();
        model.edition=view.getEdition();
        model.cardList=view.getCardList();
    }

    public SearchV getView() {
        return view;
    }
    public void setView(SearchV view)
    {
        this.view=view;
    }

    public void searchCard() {

        updateModel();
        HibernateFunctions.searchCard(view.getModel());
        updateView();
    }

    public void setMaster(MainApplication master) {
        this.master = master;
    }
    public void cardDetail(CardEntity entity) {

        CardDetailsC controler= (CardDetailsC) Commons.ctx.getBean("CardDetail");
        controler.castToModel(entity);
        master.addTab(controler.getView().getMainPanel(),"Szczegóły karty");


    }
}
