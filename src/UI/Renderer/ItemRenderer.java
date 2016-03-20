/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Renderer;

import beans.Item;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author guilh
 */
public class ItemRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	Item item = (Item)value;
	
	JButton addButton = new JButton("Put on Bundle");
	addButton.addActionListener((ActionEvent arg0) -> {
	    JOptionPane.showMessageDialog(null, "HA-HA!");
	});
	
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(
		"<strong>" + item.getName() + "</strong>"+
		item.getSource()
	));
	panel.add(addButton);
 
	if (isSelected) {
	  panel.setBackground(table.getSelectionBackground());
	}else{
	  panel.setBackground(table.getBackground());
	}
	return panel;
    }
    
}
