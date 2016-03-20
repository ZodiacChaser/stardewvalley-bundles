/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.TableModel;

import beans.Item;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author guilh
 */
public class ItemTableModel extends AbstractTableModel {
    List items;
    
    public ItemTableModel(List items) { this.items = items; }
    
    public Class getColumnClass(int columnIndex) { return Item.class; }
    public int getColumnCount() { return 1; }
    public String getColumnName(int columnIndex) { return "Item"; }
    public int getRowCount() { return (items == null) ? 0 : items.size(); }
    public Object getValueAt(int rowIndex, int columnIndex) { return (items == null) ? null : items.get(rowIndex); }
    public boolean isCellEditable(int rowIndex, int columnIndex) { return true; }
}
