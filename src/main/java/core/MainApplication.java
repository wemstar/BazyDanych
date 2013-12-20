package core;

import CardDetails.CardDetailsC;
import commons.Commons;
import search.card.SearchC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplication extends JDialog {
    private JPanel contentPane;
    private JButton bSearch;
    private JButton bNewCard;
    private JButton bNewDeck;
    private JPanel mainPanel;
    private JTabbedPane inputPanel;
    private JButton bSearchDeck;
    private JButton buttonOK;

    public MainApplication() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                putSearchForm();
            }
        });
        bNewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCardDialog();
            }
        });
    }

    private void newCardDialog() {
        CardDetailsC controller = (CardDetailsC) Commons.ctx.getBean("NewCard");
        addTab(controller.getView().getMainPanel(), "Nowa Karta");
    }

    private void putSearchForm() {

        SearchC searchC = (SearchC) Commons.ctx.getBean("Search");
        searchC.setMaster(this);
        addTab(searchC.getView().getMainPanel(), "Szukaj");
    }

    public void addTab(JPanel panel, String title) {
        inputPanel.addTab(title, panel);
    }

    public static void main(String[] args) {
        Commons.updateDictionary();
        MainApplication dialog = new MainApplication();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
