package commons.models;

import entity.ActionEntity;
import entity.CardEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 27.12.13.
 */
public class ActionListTableModel extends AbstractTableModel {

    List<ActionEntity> list= new ArrayList<ActionEntity>();

    public void setActionList(List<ActionEntity> list)
    {
        this.list=list;
    }

    public List<ActionEntity> getActionList()
    {
        return list;
    }

    public String getColumnName(int col) {return columnNames.get(col); }

    @Override
    public int getRowCount(){ return list.size(); }

    @Override
    public boolean isCellEditable(int row, int col){ return false; }

    @Override
    public int getColumnCount(){ return 3; }

    public ActionEntity getRowAt(int rowIndex){ return list.get(rowIndex); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        ActionEntity card=getRowAt(rowIndex);

        if(columnIndex==0)return card.getName();
        if(columnIndex==1)return card.getTriger();
        if(columnIndex==2)return card.getType();

        return "";
    }

    private static final List<String> columnNames =new ArrayList<String>();

    static
    {
        columnNames.add("Nazwa");

        columnNames.add("Wyzwalacz");
        columnNames.add("Typ");

    }
}
