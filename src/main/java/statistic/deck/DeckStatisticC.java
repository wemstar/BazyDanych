package statistic.deck;

import commons.Commons;
import entity.CardEntity;
import entity.TypeEntity;
import javassist.scopedpool.SoftValueHashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wemstar on 26.12.13.
 */
public class DeckStatisticC {

    DeckStatisticV view;
    public void updateView()
    {
        view.getPanelOne().removeAll();
        view.getPanelTwo().removeAll();
        view.getPanelThere().removeAll();
        view.getPanelFour().removeAll();

        DeckStatisticM model=view.getModel();
        JFreeChart chart1= ChartFactory.createPieChart("Statystyka typów",model.dataset1,true,true,false);
        JFreeChart chart2=ChartFactory.createBarChart("Statystyka siły i obrony kart do ich kosztu","Koszt","Wartość",model.dataset2, PlotOrientation.VERTICAL,true,true,false);
        JFreeChart chart3=ChartFactory.createBarChart("Liczba kart o podanym koszcie","Koszt","Ilość",model.dataset3, PlotOrientation.VERTICAL,true,true,false);
        JFreeChart chart4= ChartFactory.createPieChart("Statystyka ras",model.dataset4,true,true,false);

        view.getPanelOne().add(new ChartPanel(chart1));
        view.getPanelTwo().add(new ChartPanel(chart2));
        view.getPanelThere().add(new ChartPanel(chart3));
        view.getPanelFour().add(new ChartPanel(chart4));
    }
    public void generateDataset()
    {
        DeckStatisticM model=view.getModel();
        model.dataset1=new DefaultPieDataset();
        model.dataset2=new DefaultCategoryDataset();
        model.dataset3=new DefaultCategoryDataset();
        model.dataset4=new DefaultPieDataset();

        countStatistic(model.dataset1,model.entity.getCard_list());
        cardCostToPower(model.dataset2, model.entity.getCard_list());
        cardCostStatistic(model.dataset3,model.entity.getCard_list());
        countRaceStat(model.dataset4,model.entity.getCard_list());
    }

    public void countStatistic(DefaultPieDataset dataSet,Collection<CardEntity> cardList)
    {
        Map<String,Integer> typeCount=new HashMap();

        for(TypeEntity key : Commons.typeList) { if(!key.getName().isEmpty())typeCount.put(key.getName(),0); }
        for(CardEntity card: cardList) { typeCount.put(card.getType().getName(),typeCount.get(card.getType().getName())+1); }
        for(Map.Entry<String,Integer> entry:typeCount.entrySet()){ dataSet.setValue(entry.getKey(),entry.getValue()); }
    }

    public void countRaceStat(DefaultPieDataset dataSet,Collection<CardEntity> cardList)
    {
        Map<String,Integer> raceCount=new HashMap<String, Integer>();
        for(CardEntity card: cardList)
        {
            if(raceCount.containsKey(card.getRace().getName()))raceCount.put(card.getRace().getName(),raceCount.get(card.getRace().getName())+1);
            else raceCount.put(card.getRace().getName(),1);
        }
        for(Map.Entry<String,Integer> entry:raceCount.entrySet())dataSet.setValue(entry.getKey(),entry.getValue());

    }

    public void cardCostToPower(DefaultCategoryDataset dataSet,Collection<CardEntity> cardList)
    {
        Map<Integer,Integer> mapCostToStrenght= new HashMap<Integer, Integer>();
        Map<Integer,Integer> mapCostToDefence=new HashMap<Integer, Integer>();

        for(CardEntity entity: cardList)
        {
            int strenght=entity.getStrenght()==null?0:entity.getStrenght();
            int defence=entity.getDefence()==null?0:entity.getDefence();

            if(!mapCostToStrenght.containsKey(entity.getCost())) mapCostToStrenght.put(entity.getCost(), strenght);
            else mapCostToStrenght.put(entity.getCost(),mapCostToStrenght.get(entity.getCost())+strenght);

            if(!mapCostToDefence.containsKey(entity.getCost()))mapCostToDefence.put(entity.getCost(),defence);
            else mapCostToDefence.put(entity.getCost(),mapCostToDefence.get(entity.getCost())+defence);
        }

        for(Map.Entry<Integer,Integer> entry: mapCostToStrenght.entrySet())dataSet.addValue(entry.getValue(),"Siła",entry.getKey());
        for(Map.Entry<Integer,Integer> entry: mapCostToDefence.entrySet())dataSet.addValue(entry.getValue(),"Obrona",entry.getKey());
    }

    public void cardCostStatistic(DefaultCategoryDataset dataSet,Collection<CardEntity> cardList)
    {
        Map<Integer,Integer> mapCountCost=new HashMap<Integer, Integer>();
        Map<Integer,Integer> mapAddiCountCost=new HashMap<Integer, Integer>();

        for(CardEntity entity:cardList)
        {
            if(!mapCountCost.containsKey(entity.getCost()))mapCountCost.put(entity.getCost(),1);
            else mapCountCost.put(entity.getCost(),mapCountCost.get(entity.getCost())+1);

            if(!mapAddiCountCost.containsKey(entity.getAddicionallcost()))mapAddiCountCost.put(entity.getAddicionallcost(),1);
            else mapAddiCountCost.put(entity.getAddicionallcost(),mapAddiCountCost.get(entity.getAddicionallcost())+1);
        }

        for(Map.Entry<Integer,Integer> entry: mapCountCost.entrySet())dataSet.addValue(entry.getValue(),"Koszt Podstawowy",entry.getKey());
        for(Map.Entry<Integer,Integer> entry: mapAddiCountCost.entrySet())dataSet.addValue(entry.getValue(),"Koszt Dodatkowy",entry.getKey());
    }

    public void setView(DeckStatisticV view) {
        this.view = view;
    }

    public DeckStatisticV getView() {
        return view;
    }
}
