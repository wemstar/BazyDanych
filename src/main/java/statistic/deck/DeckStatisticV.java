package statistic.deck;

import javax.swing.*;

/**
 * Created by wemstar on 26.12.13.
 */
public class DeckStatisticV {
    private JPanel mainPanel;
    private JPanel panelOne;
    private JPanel panelTwo;
    private JPanel panelThere;
    private JPanel panelFour;
    private DeckStatisticM model;
    private DeckStatisticC controller;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getPanelOne() {
        return panelOne;
    }

    public void setPanelOne(JPanel panelOne) {
        this.panelOne = panelOne;
    }

    public JPanel getPanelTwo() {
        return panelTwo;
    }

    public void setPanelTwo(JPanel panelTwo) {
        this.panelTwo = panelTwo;
    }

    public JPanel getPanelThere() {
        return panelThere;
    }

    public void setPanelThere(JPanel panelThere) {
        this.panelThere = panelThere;
    }

    public JPanel getPanelFour() {
        return panelFour;
    }

    public void setPanelFour(JPanel panelFour) {
        this.panelFour = panelFour;
    }

    public DeckStatisticM getModel() {
        return model;
    }

    public void setModel(DeckStatisticM model) {
        this.model = model;
    }

    public DeckStatisticC getController() {
        return controller;
    }

    public void setController(DeckStatisticC controller) {
        this.controller = controller;
    }
}
