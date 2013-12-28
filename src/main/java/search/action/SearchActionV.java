package search.action;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
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

    public void initializeComponents() {
        cbTrigger.setModel(new DefaultComboBoxModel(Commons.trigerList.toArray()));
        cbType.setModel(new DefaultComboBoxModel(Commons.actionTypeList.toArray()));
        tSearchResult.setModel(new ActionListTableModel());
    }

    public JPanel getMainPanel() {
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
        return ((ActionListTableModel) (tSearchResult.getModel())).getActionList();
    }

    public void setActionList(List<ActionEntity> actionList) {
        ((ActionListTableModel) (tSearchResult.getModel())).setActionList(actionList);
        tSearchResult.updateUI();
    }

    public SearchActionC getController() {
        return controller;
    }

    public void setController(SearchActionC controller) {
        this.controller = controller;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1));
        tfName = new JTextField();
        mainPanel.add(tfName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        taAbility = new JTextArea();
        mainPanel.add(taAbility, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        cbTrigger = new JComboBox();
        mainPanel.add(cbTrigger, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbType = new JComboBox();
        mainPanel.add(cbType, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bSearch = new JButton();
        bSearch.setText("Szukaj");
        mainPanel.add(bSearch, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new GridConstraints(0, 2, 5, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tSearchResult = new JTable();
        scrollPane1.setViewportView(tSearchResult);
        final JLabel label1 = new JLabel();
        label1.setText("Nazwa");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Zdolności");
        mainPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Wyzwalacz");
        mainPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Type");
        mainPanel.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
