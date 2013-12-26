package details.deck;

import commons.Commons;
import commons.models.CardListTableModel;
import commons.models.DeckListTableModel;
import entity.CardEntity;
import entity.DeckEntity;
import entity.RaceEntity;
import entity.UserEntity;
import search.card.SearchCardV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by wemstar on 23.12.13.
 */
public class DeckDetailsV {
    private JTextField tfName;
    private JTable tCardList;
    private JComboBox cbRace;
    private JComboBox cbUser;
    private DeckDetailsM model;
    private DeckDetailsC controller;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JButton edytujButton;
    private JButton zapiszButton;
    private SearchCardV searchControl;

    public void addToSearchPanel(JPanel component)
    {

    }
    public DeckDetailsV() {
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.saveDeck();
                setControlState(false);
            }
        });
        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setControlState(true);
            }
        });
    }

    public void setModel(DeckDetailsM model) {
        this.model = model;
    }

    public DeckDetailsM getModel() {
        return model;
    }

    public void initializeComponents() {

        tCardList.setModel(new CardListTableModel());
        cbRace.setModel(new DefaultComboBoxModel(Commons.raceList.toArray()));
        cbUser.setModel(new DefaultComboBoxModel(Commons.userList.toArray()));
        tCardList.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent me)
            {
                if (me.getClickCount() == 2) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);
                    CardEntity entity = ((CardListTableModel) (table.getModel())).getRowAt(row);
                    controller.performCardClick(entity);
                }
            }
        });

    }

    public void setController(DeckDetailsC controller) {
        this.controller = controller;
    }

    public DeckDetailsC getController() {
        return controller;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setName(String name) {
        tfName.setText(name);
    }

    public String getName() {
        return tfName.getText();
    }

    public void setUser(UserEntity user) {
        cbUser.setSelectedItem(user);
    }

    public UserEntity getUser() {
        return (UserEntity) cbUser.getSelectedItem();
    }

    public void setRace(RaceEntity race) {
        cbRace.setSelectedItem(race);
    }

    public RaceEntity getRace() {
        return (RaceEntity) cbRace.getSelectedItem();
    }

    public void setCardList(List<CardEntity> cardList) {
        ((CardListTableModel) tCardList.getModel()).setCardList(cardList);
        tCardList.updateUI();
    }

    public List<CardEntity> getCardList() {
        return ((CardListTableModel) tCardList.getModel()).getCardList();
    }

    public void setControlState(boolean controlState) {
        tfName.setEnabled(controlState);
        tCardList.setEnabled(controlState);
        cbRace.setEnabled(controlState);
        cbUser.setEnabled(controlState);
        edytujButton.setEnabled(controlState);
        zapiszButton.setEnabled(controlState);
        edytujButton.setEnabled(!controlState);
        tCardList.setEnabled(controlState);
        searchControl.setActiveControl(controlState);

    }

    public void setSearchControl(SearchCardV searchControl) {
        this.searchControl = searchControl;
        searchPanel.add(searchControl.getMainPanel());
        mainPanel.updateUI();
    }

    public SearchCardV getSearchControl() {
        return searchControl;
    }
}
