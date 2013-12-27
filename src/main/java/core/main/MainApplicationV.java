package core.main;

import commons.ClickCardAction;
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

    public MainApplicationV()
    {
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
    }

    private void searchAction() {
        SearchActionC cont= (SearchActionC) Commons.ctx.getBean("SearchAction");
        addTab(cont.getView().getMainPanel(),"Szukaj Akcje");
    }

    private void newUser() {
        UserDetailsC cont= (UserDetailsC) Commons.ctx.getBean("NewUser");
        addTab(cont.getView().getMainPanel(),"Nowy Użytkownik");
    }

    private void newAction() {
        ActionDetailsC cont= (ActionDetailsC) Commons.ctx.getBean("NewAction");
        addTab(cont.getView().getMainPanel(),"Nowa Akcja");
    }

    public void initializeComponents()
    {
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
        DeckDetailsC controller= (DeckDetailsC) Commons.ctx.getBean("NewDeck");
        addTab(controller.getView().getMainPanel(),"Nowa Talia");
    }

    private void newSearchDialog()
    {
        SearchDeckC controller = (SearchDeckC) Commons.ctx.getBean("SearchDeck");
        controller.setMaster(this);
        addTab(controller.getView().getMainPanel(), "Szukaj Taili");
    }

    private void newCardDialog()
    {
        CardDetailsC controller = (CardDetailsC) Commons.ctx.getBean("NewCard");
        addTab(controller.getView().getMainPanel(), "Nowa Karta");
    }

    private void newSearchCardDialog()
    {
        SearchCardC searchCardC = (SearchCardC) Commons.ctx.getBean("Search");

        searchCardC.setAction(new ClickCardAction() {
            @Override
            public void cardAction(CardEntity entity) {
                CardDetailsC controler= (CardDetailsC) Commons.ctx.getBean("CardDetail");
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
}
