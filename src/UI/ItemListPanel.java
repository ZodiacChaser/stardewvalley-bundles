/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author guilh
 */
public class ItemListPanel extends JPanel
{
    public ItemListPanel()
    {
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(new JLabel("Search:"));
	add(new JTextField());
    }
}
