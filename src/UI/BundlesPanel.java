/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import beans.BundleDb;
import java.awt.FlowLayout;
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
    
    public BundlesPanel()
    {
	setLayout(new FlowLayout(FlowLayout.LEFT));
	add(new JLabel("Bundle: "));
	add(new JComboBox());
    }
    
}
