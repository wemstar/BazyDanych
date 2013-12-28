package core.main;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import commons.ClickCardAction;
import core.forms.CloseButtonTabbedPane;
import details.action.ActionDetailsC;
import details.card.CardDetailsC;
import commons.Commons;
import details.deck.DeckDetailsC;
import details.user.UserDetailsC;
import entity.CardEntity;
import search.action.SearchActionC;
import search.card.SearchCardC;
import search.deck.SearchDeckC;
import search.user.SearchUserC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplicationV extends JDialog {
    private JPanel contentPane;
    private JButton bSearch;
    private JButton bNewCard;
    private JButton bNewDeck;
    private JPanel mainPanel;
    private JTabbedPane inputPanel;
    private JButton bSearchDeck;
    private JButton bNewAction;
    private JButton wyszukajAkcjeButton;
    private JButton szukajUzytkownikaButton;
    private JButton nowyUżytkownikButton;
    private MainApplicationC controller;

    public MainApplicationV() {
        setContentPane(contentPane);
        setModal(true);


        bNewAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAction();
            }
        });
        nowyUżytkownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser();
            }
        });
        wyszukajAkcjeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAction();
            }
        });
        szukajUzytkownikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchUser();
            }
        });
    }

    private void searchUser() {
        SearchUserC cont = (SearchUserC) Commons.ctx.getBean("SearchUser");
        addTab(cont.getView().getMainPanel(), "Szukaj Uzytkownika");
    }

    private void searchAction() {
        SearchActionC cont = (SearchActionC) Commons.ctx.getBean("SearchAction");
        addTab(cont.getView().getMainPanel(), "Szukaj Akcje");
    }

    private void newUser() {
        UserDetailsC cont = (UserDetailsC) Commons.ctx.getBean("NewUser");
        addTab(cont.getView().getMainPanel(), "Nowy Użytkownik");
    }

    private void newAction() {
        ActionDetailsC cont = (ActionDetailsC) Commons.ctx.getBean("NewAction");
        addTab(cont.getView().getMainPanel(), "Nowa Akcja");
    }

    public void initializeComponents() {
        bSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newSearchCardDialog();
            }
        });
        bNewCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newCardDialog();
            }
        });
        bSearchDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newSearchDialog();
            }
        });
        bNewDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDeck();
            }
        });
    }

    private void newDeck() {
        DeckDetailsC controller = (DeckDetailsC) Commons.ctx.getBean("NewDeck");
        addTab(controller.getView().getMainPanel(), "Nowa Talia");
    }

    private void newSearchDialog() {
        SearchDeckC controller = (SearchDeckC) Commons.ctx.getBean("SearchDeck");
        controller.setMaster(this);
        addTab(controller.getView().getMainPanel(), "Szukaj Taili");
    }

    private void newCardDialog() {
        CardDetailsC controller = (CardDetailsC) Commons.ctx.getBean("NewCard");
        addTab(controller.getView().getMainPanel(), "Nowa Karta");
    }

    private void newSearchCardDialog() {
        SearchCardC searchCardC = (SearchCardC) Commons.ctx.getBean("Search");

        searchCardC.setAction(new ClickCardAction() {
            @Override
            public void cardAction(CardEntity entity) {
                CardDetailsC controler = (CardDetailsC) Commons.ctx.getBean("CardDetail");
                controler.castToModel(entity);
                addTab(controler.getView().getMainPanel(), "Szczegóły karty");
            }
        });
        addTab(searchCardC.getView().getMainPanel(), "Szukaj Karty");
    }

    public void addTab(JPanel panel, String title) {
        inputPanel.addTab(title, panel);
        inputPanel.setSelectedComponent(panel);
    }


    public MainApplicationC getController() {
        return controller;
    }

    public void setController(MainApplicationC controller) {
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
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(3, 1, new Insets(10, 10, 10, 10), -1, -1));
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        contentPane.add(mainPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(640, 640), null, 0, false));
        inputPanel = new CloseButtonTabbedPane();
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        final JToolBar toolBar1 = new JToolBar();
        contentPane.add(toolBar1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        bSearch = new JButton();
        bSearch.setText("Wyszukaj Kartę");
        bSearch.setMnemonic('W');
        bSearch.setDisplayedMnemonicIndex(0);
        toolBar1.add(bSearch);
        bSearchDeck = new JButton();
        bSearchDeck.setText("Wyszukaj Talie");
        toolBar1.add(bSearchDeck);
        wyszukajAkcjeButton = new JButton();
        wyszukajAkcjeButton.setText("Wyszukaj Akcje");
        toolBar1.add(wyszukajAkcjeButton);
        szukajUzytkownikaButton = new JButton();
        szukajUzytkownikaButton.setText("Szukaj Uzytkownika");
        toolBar1.add(szukajUzytkownikaButton);
        final JToolBar toolBar2 = new JToolBar();
        contentPane.add(toolBar2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
        bNewCard = new JButton();
        bNewCard.setText("Nowa Karta");
        toolBar2.add(bNewCard);
        bNewDeck = new JButton();
        bNewDeck.setText("Nowa Tailia");
        toolBar2.add(bNewDeck);
        bNewAction = new JButton();
        bNewAction.setText("Nowa Akcja");
        toolBar2.add(bNewAction);
        nowyUżytkownikButton = new JButton();
        nowyUżytkownikButton.setText("Nowy Użytkownik");
        toolBar2.add(nowyUżytkownikButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }
}
