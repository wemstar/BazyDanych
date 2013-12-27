package search.user;

import commons.Commons;
import commons.HibernateFunctions;
import core.main.MainApplicationC;
import details.deck.DeckDetailsC;
import details.user.UserDetailsC;
import details.user.UserDetailsV;
import entity.UserEntity;

/**
 * Created by wemstar on 27.12.13.
 */
public class SearchUserC {

    private SearchUserV view;

    public void setView(SearchUserV view) {
        this.view = view;
    }

    public SearchUserV getView() {
        return view;
    }

    public void updateView()
    {
        SearchUserM model=view.getModel();

        view.setNick(model.entity.getNick());

        view.setRole(model.entity.getRole());
        view.setUsersList(model.usersList);
    }
    public void updateModel()
    {
        SearchUserM model=view.getModel();

        model.entity.setNick(view.getNick());

        model.entity.setRole(view.getRole());
        model.usersList=view.getUsersList();

        updateView();

    }

    public void searchUser()
    {
        updateModel();
        HibernateFunctions.searchUser(view.getModel());
        updateView();
    }

    public void userDetail(UserEntity entity) {
        UserDetailsC controler= (UserDetailsC) Commons.ctx.getBean("UserDetails");
        controler.getView().getModel().entity=entity;
        controler.updateView();
        MainApplicationC cont= (MainApplicationC) Commons.ctx.getBean("MainApplication");
        cont.getView().addTab(controler.getView().getMainPanel(), "Szczegóły Użytkownika");
    }
}
