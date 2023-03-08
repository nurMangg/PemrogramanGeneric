/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generic;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author mangg
 */
public class KoleksiDokumen extends AbstractTableModel {
    List<Dokumen> list = new ArrayList<>();
    

    @Override
    public int getRowCount() {
       return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getFileName();
            case 1 : return list.get(rowIndex).getFileSize();
            default : return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "NAMA DOKUMEN";
            case 1 : return "UKURAN";
            default : return "";
        }
    }
    
    public void add(Dokumen d) {
        list.add(d);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }

    public void set(int i, Dokumen d) {
        list.set(i, d);
        fireTableDataChanged();
    }
    
    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    
    public void remove(int row){
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public Dokumen get(int row) {
        return (Dokumen) list.get(row);
    }
}
