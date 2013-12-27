package commons.models;

import entity.ActionEntity;
import entity.UserEntity;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 27.12.13.
 */
public class UserListTableModel extends AbstractTableModel {

    List<UserEntity> list= new ArrayList<UserEntity>();

    public void setCardList(List<UserEntity> list)
    {
        this.list=list;
    }

    public List<UserEntity> getCardList()
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

    public UserEntity getRowAt(int rowIndex){ return list.get(rowIndex); }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        UserEntity card=getRowAt(rowIndex);

        if(columnIndex==0)return card.getNick();
        if(columnIndex==1)return card.getRole();
        if(columnIndex==2)return card.getDecks().size();

        return "";
    }

    private static final List<String> columnNames =new ArrayList<String>();

    static
    {
        columnNames.add("Nick");

        columnNames.add("Rola");
        columnNames.add("Ilosć tali");

    }
}
