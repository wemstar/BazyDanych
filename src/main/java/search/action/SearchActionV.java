package search.action;

import commons.Commons;
import commons.models.ActionListTableModel;
import commons.models.CardListTableModel;
import entity.ActionEntity;
import entity.CardEntity;

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
public class SearchActionV {
    private JTextField tfName;
    private JTextArea taAbility;
    private JComboBox cbTrigger;
    private JComboBox cbType;
    private JButton bSearch;
    private JTable tSearchResult;
    private JPanel mainPanel;
    private SearchActionM model;
    private SearchActionC controller;


    public SearchActionV() {
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.searchAction();
            }
        });
        tSearchResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    JTable table = (JTable) e.getSource();
                    Point p = e.getPoint();
                    int row = table.rowAtPoint(p);
                    ActionEntity entity = ((ActionListTableModel) (table.getModel())).getRowAt(row);
                    controller.actionDetail(entity);
                }
            }
        });
    }

    public void initializeComponents()
    {
        cbTrigger.setModel(new DefaultComboBoxModel(Commons.trigerList.toArray()));
        cbType.setModel(new DefaultComboBoxModel(Commons.actionTypeList.toArray()));
        tSearchResult.setModel(new ActionListTableModel());
    }
    public JPanel getMainPanel()
    {
        return mainPanel;
    }

    public SearchActionM getModel() {
        return model;
    }

    public void setModel(SearchActionM model) {
        this.model = model;
    }

    public void setType(String type) {
        cbType.setSelectedItem(type);
    }

    public void setTriger(String triger) {
        cbTrigger.setSelectedItem(triger);
    }

    public String getTriger() {
        return (String) cbTrigger.getSelectedItem();
    }

    public void setAbility(String ability) {
        taAbility.setText(ability);
    }

    public String getAbility() {
        return taAbility.getText();
    }

    public void setName(String name) {
        tfName.setText(name);
    }

    public String getName() {
        return tfName.getText();
    }

    public String getType() {
        return (String) cbType.getSelectedItem();
    }

    public List<ActionEntity> getActionList() {
        return ((ActionListTableModel)(tSearchResult.getModel())).getActionList();
    }

    public void setActionList(List<ActionEntity> actionList) {
        ((ActionListTableModel)(tSearchResult.getModel())).setActionList(actionList);
        tSearchResult.updateUI();
    }

    public SearchActionC getController() {
        return controller;
    }

    public void setController(SearchActionC controller) {
        this.controller = controller;
    }
}
