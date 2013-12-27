package details.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wemstar on 17.12.13.
 */
public class ActionDetailsV {

    private ActionDetailsM model;
    private ActionDetailsC controller;
    private JTextArea taAbility;
    private JComboBox cbTriger;
    private JComboBox cbType;
    private JTextField tfName;
    private JButton zapiszButton;
    private JButton edytujButton;
    private JPanel mainPanel;


    public ActionDetailsV() {
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction();
            }
        });
    }

    private void saveAction() {
        controller.saveAction();
    }

    public void setModel(ActionDetailsM model) {
        this.model = model;
    }

    public ActionDetailsM getModel() {
        return model;
    }

    public void initalizeComponents() {

        cbTriger.setModel(new DefaultComboBoxModel(new String[]{ "Akcja","Wymuszony"}));
        cbType.setModel(new DefaultComboBoxModel(new String[]{"Pasywna","Aktywna"}));
    }

    public void setControlState(boolean state)
    {
        taAbility.setEnabled(state);
        cbTriger.setEnabled(state);
        tfName.setEnabled(state);
        zapiszButton.setEnabled(state);
        edytujButton.setEnabled(!state);
    }


    public void setController(ActionDetailsC controller) {
        this.controller = controller;
    }

    public ActionDetailsC getController() {
        return controller;
    }

    public String getName() {
        return tfName.getText();
    }

    public void setName(String name) {
        tfName.setText(name);
    }


    public String getAbility() {
        return taAbility.getText();
    }

    public void setAbility(String ability) {
        taAbility.setText(ability);
    }

    public String getTriger() {
        return (String) cbTriger.getSelectedItem();
    }

    public String getType() {
        return (String) cbType.getSelectedItem();
    }

    public void setType(String type) {
        cbType.setSelectedItem(type);
    }

    public void setTriger(String triger) {
        cbTriger.setSelectedItem(triger);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
