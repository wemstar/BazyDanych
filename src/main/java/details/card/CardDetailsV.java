package details.card;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.Commons;
import commons.models.CardListTableModel;
import core.main.MainApplicationC;
import entity.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class CardDetailsV {
    private JPanel mainPanel;
    private JComboBox typeComboBox;
    private JComboBox raceComboBox;
    private JComboBox editionComboBox;
    private JSpinner costSpinner;
    private JSpinner addictionalCostSpinner;
    private JSpinner strenghtSpinner;
    private JSpinner defenceSpinner;
    private JSpinner countSpinner;
    private JTextField subTypesTextField;
    private JComboBox actionComboBox;
    private JTextField nameTextField;
    private JPanel imagePanel;
    private JButton edytujButton;
    private JButton zapiszButton;
    private JButton bDelete;
    private CardDetailsM model;
    private CardDetailsC controller;


    public CardDetailsV() {
        edytujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableEdit();
            }
        });
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCard();
            }
        });
        imagePanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                if (me.getClickCount() == 2 && zapiszButton.isEnabled()) {

                    openImage();

                }
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteCard();
            }
        });
    }

    private void openImage() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG & JPG Images", "jpg", "png");
        chooser.setFileFilter(filter);
        MainApplicationC cont = (MainApplicationC) Commons.ctx.getBean("MainApplication");

        if (chooser.showOpenDialog(cont.getView()) == JFileChooser.APPROVE_OPTION) {
            controller.loadFile(chooser.getSelectedFile());
            System.out.println("Hura");
        }

    }

    private void saveCard() {
        enableControls(false);
        controller.saveCard();
    }

    private void enableEdit() {
        enableControls(true);
    }

    public void enableControls(boolean value) {
        typeComboBox.setEnabled(value);
        raceComboBox.setEnabled(value);
        editionComboBox.setEnabled(value);
        costSpinner.setEnabled(value);
        addictionalCostSpinner.setEnabled(value);
        strenghtSpinner.setEnabled(value);
        defenceSpinner.setEnabled(value);
        countSpinner.setEnabled(value);
        subTypesTextField.setEnabled(value);
        actionComboBox.setEnabled(value);
        nameTextField.setEnabled(value);
        zapiszButton.setEnabled(value);
        edytujButton.setEnabled(!value);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public CardDetailsM getModel() {
        return model;
    }

    public void initalizeComponents() {
        typeComboBox.setModel(new DefaultComboBoxModel(Commons.typeList.toArray()));
        raceComboBox.setModel(new DefaultComboBoxModel(Commons.raceList.toArray()));
        editionComboBox.setModel(new DefaultComboBoxModel(Commons.editionList.toArray()));
        actionComboBox.setModel((new DefaultComboBoxModel(Commons.actionList.toArray())));
    }

    public String getName() {
        return nameTextField.getText();
    }

    public List<ActionEntity> getAction() {
        return null;//(ActionEntity) actionComboBox.getSelectedItem();
    }

    public String getSubTypes() {
        return subTypesTextField.getText();
    }

    public Integer getCount() {
        return (Integer) countSpinner.getValue();
    }

    public Integer getDefence() {
        return (Integer) defenceSpinner.getValue();
    }

    public Integer getStrenght() {
        return (Integer) strenghtSpinner.getValue();
    }

    public Integer getAddicionalCost() {
        return (Integer) addictionalCostSpinner.getValue();
    }

    public Integer getCost() {
        return (Integer) costSpinner.getValue();
    }

    public EditionEntity getEdition() {
        return (EditionEntity) editionComboBox.getSelectedItem();
    }

    public RaceEntity getRace() {
        return (RaceEntity) raceComboBox.getSelectedItem();
    }

    public TypeEntity getType() {
        return (TypeEntity) typeComboBox.getSelectedItem();
    }

    public void setType(TypeEntity type) {
        typeComboBox.setSelectedItem(type);
    }

    public void setRace(RaceEntity race) {
        raceComboBox.setSelectedItem(race);
    }

    public void setEdition(EditionEntity edition) {
        editionComboBox.setSelectedItem(edition);
    }

    public void setCost(Integer cost) {
        costSpinner.setValue(cost);
    }

    public void setAddicionalCost(Integer addicionalCost) {
        addictionalCostSpinner.setValue(addicionalCost);
    }

    public void setStrenght(Integer strenght) {
        strenghtSpinner.setValue(strenght);
    }

    public void setDefence(Integer defence) {
        defenceSpinner.setValue(defence);
    }

    public void setCount(Integer count) {
        countSpinner.setValue(count);
    }

    public void setSubTypes(String subTypes) {
        subTypesTextField.setText(subTypes);
    }

    public void setAction(List<ActionEntity> action) {
        actionComboBox.setSelectedItem(action);
    }

    public void setName(String name) {
        nameTextField.setText(name);
    }

    public void setModel(CardDetailsM model) {
        this.model = model;
    }

    public void setController(CardDetailsC controller) {
        this.controller = controller;
    }

    public void setImage(BufferedImage image) {
        if(image==null)return;
        imagePanel.removeAll();
        imagePanel.add(new JLabel(new ImageIcon(image)));
        imagePanel.updateUI();

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
        mainPanel.setLayout(new GridLayoutManager(11, 4, new Insets(0, 0, 0, 0), -1, -1));
        typeComboBox = new JComboBox();
        typeComboBox.setEnabled(false);
        mainPanel.add(typeComboBox, new GridConstraints(1, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        raceComboBox = new JComboBox();
        raceComboBox.setEnabled(false);
        mainPanel.add(raceComboBox, new GridConstraints(2, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        editionComboBox = new JComboBox();
        editionComboBox.setEnabled(false);
        mainPanel.add(editionComboBox, new GridConstraints(4, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Edycja");
        mainPanel.add(label1, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        costSpinner = new JSpinner();
        costSpinner.setEnabled(false);
        mainPanel.add(costSpinner, new GridConstraints(3, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addictionalCostSpinner = new JSpinner();
        addictionalCostSpinner.setEnabled(false);
        mainPanel.add(addictionalCostSpinner, new GridConstraints(5, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        strenghtSpinner = new JSpinner();
        strenghtSpinner.setEnabled(false);
        mainPanel.add(strenghtSpinner, new GridConstraints(6, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        defenceSpinner = new JSpinner();
        defenceSpinner.setEnabled(false);
        mainPanel.add(defenceSpinner, new GridConstraints(7, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        countSpinner = new JSpinner();
        countSpinner.setEnabled(false);
        mainPanel.add(countSpinner, new GridConstraints(8, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        subTypesTextField = new JTextField();
        subTypesTextField.setEditable(true);
        subTypesTextField.setEnabled(false);
        mainPanel.add(subTypesTextField, new GridConstraints(9, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        actionComboBox = new JComboBox();
        actionComboBox.setEnabled(false);
        mainPanel.add(actionComboBox, new GridConstraints(10, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Koszt");
        mainPanel.add(label2, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Race");
        mainPanel.add(label3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Type");
        mainPanel.add(label4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Name");
        mainPanel.add(label5, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(36, 55), null, 0, false));
        imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout(0, 0));
        mainPanel.add(imagePanel, new GridConstraints(0, 0, 5, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, new Dimension(150, 180), null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Koszt Dodatkowy");
        mainPanel.add(label6, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Siła");
        mainPanel.add(label7, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setText("Wytrzymałośc");
        mainPanel.add(label8, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setText("Ilość");
        mainPanel.add(label9, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Pod typy");
        mainPanel.add(label10, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Akcje");
        mainPanel.add(label11, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameTextField = new JTextField();
        nameTextField.setEditable(true);
        nameTextField.setEnabled(false);
        mainPanel.add(nameTextField, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 55), null, 0, false));
        edytujButton = new JButton();
        edytujButton.setText("Edytuj");
        mainPanel.add(edytujButton, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zapiszButton = new JButton();
        zapiszButton.setEnabled(false);
        zapiszButton.setText("Zapisz");
        mainPanel.add(zapiszButton, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bDelete = new JButton();
        bDelete.setText("Usuń");
        mainPanel.add(bDelete, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label1.setLabelFor(editionComboBox);
        label2.setLabelFor(costSpinner);
        label3.setLabelFor(raceComboBox);
        label4.setLabelFor(typeComboBox);
        label5.setLabelFor(nameTextField);
        label6.setLabelFor(addictionalCostSpinner);
        label7.setLabelFor(strenghtSpinner);
        label8.setLabelFor(defenceSpinner);
        label9.setLabelFor(countSpinner);
        label10.setLabelFor(subTypesTextField);
        label11.setLabelFor(actionComboBox);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
