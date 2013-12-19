package search;

import CardDetails.CardDetailsC;
import commons.Commons;
import entity.CardEntity;
import entity.EditionEntity;
import entity.RaceEntity;
import entity.TypeEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class SearchV {
    private SearchC controller;
    private SearchM model;
    private JTable tSearchResult;
    private JTextField tfName;
    private JComboBox cbType;
    private JComboBox cbRace;
    private JComboBox cbEdition;
    private JPanel mainPanel;
    private JButton bSearch;


    public SearchV()
    {
        initializeComponents();
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchCard();
            }
        });
        tSearchResult.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                if (me.getClickCount() == 2) {
                    JTable table =(JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    CardEntity entity= ((SearchTableModel)(table.getModel())).getRowAt(row);
                    controller.cardDetail(entity);
                }
            }
        });
    }



    private void initializeComponents() {

        cbRace.setModel(new DefaultComboBoxModel(Commons.raceList.toArray()));
        cbEdition.setModel(new DefaultComboBoxModel(Commons.editionList.toArray()));
        cbType.setModel(new DefaultComboBoxModel(Commons.typeList.toArray()));
        tSearchResult.setModel(new SearchTableModel());

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setModel(SearchM model) {
        this.model=model;
    }

    public SearchM getModel() {
        return model;
    }

    public String getName() {
        return tfName.getText();
    }

    public RaceEntity getRace() {
        return (RaceEntity)cbRace.getSelectedItem();
    }

    public TypeEntity getType() {
        return (TypeEntity)cbType.getSelectedItem();
    }

    public EditionEntity getEdition() {
        return (EditionEntity)cbEdition.getSelectedItem();
    }

    public List<CardEntity> getCardList() {
        return ((SearchTableModel)(tSearchResult.getModel())).getCardList();
    }

    public void setName(String name) {
        tfName.setText(name);
    }

    public void setRace(RaceEntity race) {
        cbRace.setSelectedItem(race);
    }

    public void setType(TypeEntity type) {
        cbType.setSelectedItem(type);
    }

    public void setEdition(EditionEntity edition) {
        cbEdition.setSelectedItem(edition);
    }

    public void setCardList(List<CardEntity> cardList) {
        ((SearchTableModel)(tSearchResult.getModel())).setCardList(cardList);
        tSearchResult.updateUI();

    }

    public void setController(SearchC controller) {
        this.controller = controller;
    }
}
