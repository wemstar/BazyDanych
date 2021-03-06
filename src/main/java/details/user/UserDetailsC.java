package details.user;

import commons.Commons;
import commons.HibernateFunctions;
import entity.UserEntity;

import javax.swing.*;
import java.util.Arrays;

/**
 * Created by wemstar on 27.12.13.
 */
public class UserDetailsC {

    private UserDetailsV view;

    public UserDetailsV getView() {
        return view;
    }

    public void setView(UserDetailsV view) {
        this.view = view;
    }

    public void updateView()
    {
        UserEntity model=view.getModel().entity;

        view.setNick(model.getNick());
        view.setPassword(model.getPassword().toCharArray());
        view.setRole(model.getRole());

    }
    public void updateModel()
    {
        UserEntity model=view.getModel().entity;

        model.setNick(view.getNick());
        model.setPassword(new String(view.getPassword()));
        model.setRole(view.getRole());

        updateView();
    }

    public void saveUser() throws Exception {

        updateModel();
        if(!Arrays.equals(view.getPassword(),view.getPasswordConfirm()))
        {
            JOptionPane.showMessageDialog(null, "Hasła muszą się zgadzać", "Wrong ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(view.getModel().entity.getNick().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Pole nick nie może byc puste", "Wrong ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        HibernateFunctions.saveUser(view.getModel().entity);
    }

    public void deleteUser() {
        if(Commons.currentUser.getRole().equals("admin"))HibernateFunctions.deleteUser(view.getModel().entity);
    }
}
