package commons.models;

import entity.CardEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 15.12.13.
 */
public class CardListTableModel extends AbstractTableModel {

    List<CardEntity> list=new ArrayList<CardEntity>();

    public void setCardList(List<CardEntity> list)
    {
        this.list=list;
    }

    public List<CardEntity> getCardList()
    {
        return list;
    }

    public String getColumnName(int col) {return columnNames.get(col); }

    @Override
    public int getRowCount(){ return list.size(); }

    @Override
    public boolean isCellEditable(int row, int col){ return false; }

    @Override
    public int getColumnCount(){ return 10; }

    public CardEntity getRowAt(int rowIndex){ return list.get(rowIndex); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        CardEntity card=getRowAt(rowIndex);

        if(columnIndex==0)return card.getName();
        if(columnIndex==1)return card.getType().getName();
        if(columnIndex==2)return card.getRace().getName();
        if(columnIndex==3)return card.getCost();
        if(columnIndex==4)return card.getAddicionallcost();
        if(columnIndex==5)return card.getStrenght();
        if(columnIndex==6)return card.getDefence();
        if(columnIndex==7)return card.getSubtypes();
        if(columnIndex==8)return card.getCount();
        if(columnIndex==9)return card.getEdition().getName();

        return "";
    }

    private static final List<String> columnNames =new ArrayList<String>();

    static
    {
        columnNames.add("Nazwa");
        columnNames.add("Type");
        columnNames.add("Rasa");
        columnNames.add("Koszt Podstawowy");
        columnNames.add("Koszt Dodatkowy");
        columnNames.add("Siła");
        columnNames.add("Wytrzymałośc");
        columnNames.add("Pod Typ");
        columnNames.add("Ilosć");
        columnNames.add("Edycja");
    }
}
