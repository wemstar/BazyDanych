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
        DeckStatisticM model=view.getModel();
        JFreeChart chart1= ChartFactory.createPieChart("Statystyka typów",model.dataset1,true,true,false);
        JFreeChart chart2=ChartFactory.createBarChart("Statystyka siły i obrony kart do ich kosztu","Koszt","Wartość",model.dataset2, PlotOrientation.VERTICAL,true,true,false);
        view.getPanelOne().add(new ChartPanel(chart1));
        view.getPanelTwo().add(new ChartPanel(chart2));

    }
    public void generateDataset()
    {
        DeckStatisticM model=view.getModel();
        model.dataset1=new DefaultPieDataset();
        model.dataset2=new DefaultCategoryDataset();
        countStatistic(model.dataset1,model.entity.getCard_list());
        cardCostToPower(model.dataset2, model.entity.getCard_list());


    }

    public void countStatistic(DefaultPieDataset dataSet,Collection<CardEntity> cardList)
    {
        Map<String,Integer> typeCount=new HashMap();

        for(TypeEntity key : Commons.typeList) { if(!key.getName().isEmpty())typeCount.put(key.getName(),0); }
        for(CardEntity card: cardList) { typeCount.put(card.getType().getName(),typeCount.get(card.getType().getName())+1); }
        for(Map.Entry<String,Integer> entry:typeCount.entrySet()){ dataSet.setValue(entry.getKey(),entry.getValue()); }
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

    public void setView(DeckStatisticV view) {
        this.view = view;
    }

    public DeckStatisticV getView() {
        return view;
    }
}
