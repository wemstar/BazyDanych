package search.deck;

import commons.Commons;
import commons.models.CardListTableModel;
import commons.models.DeckListTableModel;
import entity.CardEntity;
import entity.DeckEntity;
import entity.RaceEntity;
import entity.UserEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by wemstar on 20.12.13.
 */
public class SearchDeckV {
    private JTable tSearchResult;
    private JTextField tfName;
    private JComboBox cbRace;
    private JComboBox cbUser;
    private JButton bSearch;
    private JPanel mainPanel;
    private SearchDeckM model;
    private SearchDeckC controller;

    public SearchDeckV() {
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchDeck();
            }
        });
        tSearchResult.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                if (me.getClickCount() == 2) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    DeckEntity entity = ((DeckListTableModel) (table.getModel())).getRowAt(row);
                    controller.deckDetail(entity);
                }
            }
        });
    }

    public SearchDeckC getController(){ return controller;}

    public void setController(SearchDeckC controller){this.controller=controller;}

    public SearchDeckM getModel() {
        return model;
    }

    public void setModel(SearchDeckM model) {
        this.model = model;
    }

    public String getName() {
        return tfName.getText();
    }

    public void setName(String name) {
        tfName.setText(name);
    }

    public RaceEntity getRace() {
        return (RaceEntity) cbRace.getSelectedItem();
    }

    public void setRace(RaceEntity race) {
        cbRace.setSelectedItem(race);
    }



    public UserEntity getUser() {
        return (UserEntity) cbUser.getSelectedItem();
    }

    public void setDeckList(List<DeckEntity> deckList) {
        ((DeckListTableModel) (tSearchResult.getModel())).setDeckList(deckList);
        tSearchResult.updateUI();
    }

    public void initializeComponents() {

        cbRace.setModel(new DefaultComboBoxModel(Commons.raceList.toArray()));
        cbUser.setModel(new DefaultComboBoxModel(Commons.userList.toArray()));
        tSearchResult.setModel(new DeckListTableModel());


    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
