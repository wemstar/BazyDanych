package search.user;

import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wemstar on 27.12.13.
 */
public class SearchUserV {
    private JTextField tfNick;
    private JComboBox cbRole;
    private JComboBox cbDeck;
    private JButton bSearch;
    private JTable tSearchResult;
    private JPanel mainPanel;
    private SearchUserC controller;
    private SearchUserM model;

    public SearchUserV() {
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


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

    }

    public void setModel(SearchUserM model) {
        this.model = model;
    }

    public SearchUserM getModel() {
        return model;
    }
}
