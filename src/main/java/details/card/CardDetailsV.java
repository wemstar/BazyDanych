package details.card;

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
    }

    private void openImage() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG & JPG Images", "jpg","png");
        chooser.setFileFilter(filter);
        MainApplicationC cont= (MainApplicationC) Commons.ctx.getBean("MainApplication");

        if(chooser.showOpenDialog(cont.getView()) == JFileChooser.APPROVE_OPTION) {
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

        imagePanel.removeAll();
        imagePanel.add(new JLabel(new ImageIcon(image)));
        imagePanel.updateUI();

    }


}
