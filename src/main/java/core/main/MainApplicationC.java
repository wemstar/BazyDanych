package core.main;

import commons.Commons;
import commons.HibernateFunctions;
import core.forms.LoginDialog;

/**
 * Created by wemstar on 26.12.13.
 */
public class MainApplicationC {

    public static void main(String[] args) {

        login();
        //HibernateFunctions.createFactory();
        Commons.updateDictionary();
        MainApplicationC controller = (MainApplicationC) Commons.ctx.getBean("MainApplication");
        MainApplicationV  view=controller.getView();
        view.pack();
        view.setVisible(true);
        HibernateFunctions.sessionFactory.close();
        System.exit(0);
    }

    private static void login() {
        LoginDialog view=new LoginDialog();
        view.pack();

        view.setLocationRelativeTo(null);
        view.setVisible(true);
        if(view.isResult())
        {

            HibernateFunctions.createFactory(view.getTfLogin(),new String(view.getPfPassword()));
        }

    }

    private MainApplicationV view;

    public MainApplicationV getView() {
        return view;
    }

    public void setView(MainApplicationV view) {
        this.view = view;
    }
}
