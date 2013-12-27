package details.action;

import commons.HibernateFunctions;
import entity.ActionEntity;
import org.w3c.dom.html.HTMLModElement;

/**
 * Created by wemstar on 17.12.13.
 */
public class ActionDetailsC
{
    private ActionDetailsV view;

    public void setView(ActionDetailsV view) {
        this.view = view;
    }

    public ActionDetailsV getView() {
        return view;
    }

    public void updateView()
    {
        ActionDetailsM model=view.getModel();
        view.setName(model.entity.getName());
        view.setAbility(model.entity.getAbility());
        view.setTriger(model.entity.getTriger());
        view.setType(model.entity.getType());
        view.getMainPanel().updateUI();
    }
    public void updateModel()
    {
        ActionEntity entity=view.getModel().entity;

        entity.setName(view.getName());
        entity.setAbility(view.getAbility());
        entity.setTriger(view.getTriger());
        entity.setType(view.getType());

        updateView();
    }

    public void saveAction() {
        updateModel();
        ActionEntity entity=view.getModel().entity;

        HibernateFunctions.saveAction(entity);
    }
}
