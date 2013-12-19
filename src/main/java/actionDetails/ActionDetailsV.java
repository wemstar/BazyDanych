package actionDetails;

import CardDetails.CardDetailsM;

/**
 * Created by wemstar on 17.12.13.
 */
public class ActionDetailsV {

    private ActionDetailsM model;
    private ActionDetailsC controller;

    public void setModel(ActionDetailsM model) { this.model = model;}

    public ActionDetailsM getModel(){ return model;   }

    public void initalizeComponents() {


    }

    public void setController(ActionDetailsC controller) {
        this.controller = controller;
    }

    public ActionDetailsC getController() {
        return controller;
    }
}
