package details.user;

import commons.Commons;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by wemstar on 27.12.13.
 */
public class UserDetailsV {
    private JTextField tfUserName;
    private JPasswordField pfUserPassword;
    private JPasswordField tfUserPaswordConfirm;
    private JComboBox cbUserRole;
    private JButton bEditUser;
    private JButton bSaveUser;
    private JPanel mainPanel;
    private JButton bDelete;
    private UserDetailsM model;
    private UserDetailsC controller;


    public UserDetailsV() {
        bEditUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setControlState(true);
            }
        });
        bSaveUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.saveUser();
                    setControlState(false);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(mainPanel,"Hasła muszą pasowac","Bład hasło",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    public UserDetailsM getModel() {
        return model;
    }

    public void setModel(UserDetailsM model) {
        this.model = model;
    }

    public void setNick(String nick) {
        tfUserName.setText(nick);
    }

    public String getNick() {
        return tfUserName.getText();
    }

    public void setPassword(char[] password) {
        tfUserPaswordConfirm.setText(new String(password));
        pfUserPassword.setText(new String(password));
    }

    public char[] getPassword() {
        return tfUserPaswordConfirm.getPassword();
    }
    public char[] getPasswordConfirm()
    {
        return pfUserPassword.getPassword();
    }

    public void setRole(String role) {
        cbUserRole.setSelectedItem(role);
    }

    public String getRole() {
        return (String) cbUserRole.getSelectedItem();
    }

    public void setControlState(boolean state)
    {
        tfUserName.setEnabled(state);
        tfUserPaswordConfirm.setEnabled(state);
        pfUserPassword.setEnabled(state);
        cbUserRole.setEnabled(state);
        bEditUser.setEnabled(!state);
        bSaveUser.setEnabled(state);
    }

    public void setController(UserDetailsC controller) {
        this.controller = controller;
    }

    public UserDetailsC getController() {
        return controller;
    }

    public void initializeComponent() {
        cbUserRole.setModel(new DefaultComboBoxModel(Commons.roleList.toArray()));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
