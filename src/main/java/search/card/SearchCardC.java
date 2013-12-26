package search.card;

import commons.ClickCardAction;
import commons.HibernateFunctions;
import entity.CardEntity;

/**
 * Created by wemstar on 15.12.13.
 */
public class SearchCardC {
    private SearchCardV view;
    private ClickCardAction action;

    public void setAction(ClickCardAction action){this.action=action;}

    public void updateView() {

        SearchCardM model=view.getModel();
        view.setName(model.name);
        view.setRace(model.race);
        view.setType(model.type);
        view.setEdition(model.edition);
        view.setCardList(model.cardList);

    }

    public void updateModel() {
        SearchCardM model=view.getModel();

        model.name=view.getName();
        model.race=view.getRace();
        model.type=view.getType();
        model.edition=view.getEdition();
        model.cardList=view.getCardList();
    }

    public SearchCardV getView() {
        return view;
    }
    public void setView(SearchCardV view)
    {
        this.view=view;
    }

    public void searchCard() {

        updateModel();
        HibernateFunctions.searchCard(view.getModel());
        updateView();
    }


    public void cardDetail(CardEntity entity) {

        action.cardAction(entity);



    }
}
