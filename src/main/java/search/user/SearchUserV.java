package search.user;

import commons.Commons;
import commons.models.DeckListTableModel;
import commons.models.UserListTableModel;
import entity.DeckEntity;
import entity.UserEntity;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by wemstar on 27.12.13.
 */
public class SearchUserV {
    private JTextField tfNick;
    private JComboBox cbRole;

    private JButton bSearch;
    private JTable tSearchResult;
    private JPanel mainPanel;
    private SearchUserC controller;
    private SearchUserM model;



    public SearchUserV() {
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchUser();
            }
        });
        tSearchResult.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                if (me.getClickCount() == 2) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    UserEntity entity = ((UserListTableModel) (table.getModel())).getRowAt(row);
                    controller.userDetail(entity);
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


    public SearchUserC getController() {
        return controller;
    }

    public void setController(SearchUserC controller) {
        this.controller = controller;
    }

    public void initializeComponents() {
        cbRole.setModel(new DefaultComboBoxModel(Commons.roleList.toArray()));
        tSearchResult.setModel(new UserListTableModel());

    }

    public void setModel(SearchUserM model) {
        this.model = model;
    }

    public SearchUserM getModel() {
        return model;
    }

    public void setNick(String nick) {
        tfNick.setText(nick);
    }

    public String getNick() {
        return tfNick.getText();
    }

    public void setRole(String role) {
        cbRole.setSelectedItem(role);
    }

    public String getRole() {
        return (String) cbRole.getSelectedItem();
    }

    public void setUsersList(List<UserEntity> usersList) {
        ((UserListTableModel) (tSearchResult.getModel())).setUserList(usersList);
        tSearchResult.updateUI();
    }

    public List<UserEntity> getUsersList() {
        return ((UserListTableModel) (tSearchResult.getModel())).getUserList();
    }
}
