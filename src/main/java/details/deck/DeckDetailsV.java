package details.deck;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
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
    private JButton statystykaButton;
    private JButton deleteButton;
    private SearchCardV searchControl;

    public void addToSearchPanel(JPanel component) {

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

                if (model.entity.getUser().equals(Commons.currentUser)) {
                    setControlState(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Nie masz uprawneń do modyfikacji tali", "Błąd uprawnień", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });
        statystykaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.statisticView();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteDeck();
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
        tCardList.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
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
        mainPanel.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        tfName = new JTextField();
        tfName.setEnabled(false);
        mainPanel.add(tfName, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Nazwa");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbRace = new JComboBox();
        cbRace.setEnabled(false);
        mainPanel.add(cbRace, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cbUser = new JComboBox();
        cbUser.setEnabled(false);
        mainPanel.add(cbUser, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Rasa");
        mainPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Użytkownik");
        mainPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchPanel = new JPanel();
        searchPanel.setLayout(new BorderLayout(0, 0));
        searchPanel.setEnabled(false);
        mainPanel.add(searchPanel, new GridConstraints(3, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(-1, 400), null, 0, false));
        edytujButton = new JButton();
        edytujButton.setText("Edytuj");
        mainPanel.add(edytujButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zapiszButton = new JButton();
        zapiszButton.setEnabled(false);
        zapiszButton.setText("Zapisz");
        mainPanel.add(zapiszButton, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        statystykaButton = new JButton();
        statystykaButton.setText("Statystyka");
        mainPanel.add(statystykaButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, new GridConstraints(0, 2, 3, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tCardList = new JTable();
        scrollPane1.setViewportView(tCardList);
        deleteButton = new JButton();
        deleteButton.setText("Usuń");
        mainPanel.add(deleteButton, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label1.setLabelFor(tfName);
        label2.setLabelFor(cbRace);
        label3.setLabelFor(cbUser);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
