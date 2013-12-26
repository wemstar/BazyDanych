package commons.models;

import entity.DeckEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 20.12.13.
 */
public class DeckListTableModel extends AbstractTableModel {

    private List<DeckEntity> list=new ArrayList<DeckEntity>();

    public void setDeckList(List<DeckEntity> list){this.list=list;}

    public List<DeckEntity> getDeckList(){return list;}

    @Override
    public boolean isCellEditable(int row, int col){ return false; }

    @Override
    public String getColumnName(int col) {return columnNames.get(col);}

    public DeckEntity getRowAt(int row) { return list.get(row); }

    @Override
    public int getRowCount() { return list.size(); }

    @Override
    public int getColumnCount() { return 4; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        if(columnIndex==0)return list.get(rowIndex).getName();
        else if(columnIndex==1)return list.get(rowIndex).getUser();
        else if(columnIndex==2)return list.get(rowIndex).getBasic_race();
        else if(columnIndex==3)return list.get(rowIndex).getCard_list().size();

        return "";
    }

    private static final List<String> columnNames =new ArrayList<String>();

    static
    {
        columnNames.add("Nazwa");
        columnNames.add("Uzytkownik");
        columnNames.add("Rasa Podstawowa");
        columnNames.add("Ilosc kart");
    }
}
