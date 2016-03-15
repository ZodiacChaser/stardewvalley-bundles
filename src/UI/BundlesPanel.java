/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import beans.Bundle;
import beans.BundleDb;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class BundlesPanel extends JPanel
{
    private JComboBox comboBox;
    
    
    public BundlesPanel()
    {
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(new JLabel("Bundle: "));
	comboBox = new JComboBox();
	comboBox.addActionListener(this::BundleSelected);
	for (Bundle bundle : BundleDb.GetBundles())
	    comboBox.addItem(bundle);
	add(comboBox);
    }
    
    public void BundleSelected(ActionEvent e)
    {
	Bundle bundle = (Bundle)comboBox.getSelectedItem();
	System.out.println(bundle.getName());
    }
}
