/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Renderer.ItemRenderer;
import UI.TableModel.ItemTableModel;
import beans.Item;
import beans.ItemDb;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author guilh
 */
public class ItemListPanel extends JPanel
{
    private TableRowSorter<TableModel> rowSorter;
    public ItemListPanel()
    {
	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	
	JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JTextField searchBox = new JTextField();
	searchBox.setPreferredSize(new Dimension(150, searchBox.getPreferredSize().height));
	searchBox.setMinimumSize(searchBox.getPreferredSize());
	
	searchPanel.add(new JLabel("Search:"));
	searchPanel.add(searchBox);
	searchPanel.setPreferredSize(new Dimension(300, searchPanel.getPreferredSize().height));
	searchPanel.setMaximumSize(searchPanel.getPreferredSize());
	
	add(searchPanel);
	
	JTable table = new JTable(new ItemTableModel(ItemDb.GetItemList()));
	
	rowSorter = new TableRowSorter<>(table.getModel());
	table.setRowSorter(rowSorter);
	
	searchBox.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchBox.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchBox.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
	
	table.setDefaultRenderer(Item.class, new ItemRenderer());
	table.setRowHeight(80);
	add(table);
    }
}
