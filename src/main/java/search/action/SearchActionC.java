package search.action;

import commons.Commons;
import commons.HibernateFunctions;
import core.main.MainApplicationC;
import details.action.ActionDetailsC;
import entity.ActionEntity;

/**
 * Created by wemstar on 27.12.13.
 */
public class SearchActionC {

    private SearchActionV view;


    public SearchActionV getView() {
        return view;
    }

    public void setView(SearchActionV view) {
        this.view = view;
    }

    public void updateView()
    {
        SearchActionM model=view.getModel();

        view.setName(model.entity.getName());
        view.setAbility(model.entity.getAbility());
        view.setTriger(model.entity.getTriger());
        view.setType(model.entity.getType());
        view.setActionList(model.actionList);
    }

    public void updateModel()
    {
        SearchActionM model=view.getModel();

        model.entity.setName(view.getName());
        model.entity.setAbility(view.getAbility());
        model.entity.setTriger(view.getTriger());
        model.entity.setType(view.getType());
        model.actionList=view.getActionList();

        updateView();
    }

    public void searchAction()
    {
        updateModel();
        HibernateFunctions.searchAction(view.getModel());
        updateView();

    }

    public void actionDetail(ActionEntity entity) {

        ActionDetailsC cont= (ActionDetailsC) Commons.ctx.getBean("ActionDetails");
        cont.getView().getModel().entity=entity;
        cont.updateView();
        MainApplicationC main= (MainApplicationC) Commons.ctx.getBean("MainApplication");
        main.getView().addTab(cont.getView().getMainPanel(),"Szczegóły Akcji");
    }
}
