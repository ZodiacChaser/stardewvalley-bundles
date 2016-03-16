/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import beans.Bundle;
import beans.BundleItem;
import beans.ItemDb;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class BundleInfoPanel extends JPanel
{
    public BundleInfoPanel(Bundle bundle)
    {
	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	setPreferredSize(new Dimension(200, 400));
	
	if (bundle == null) return;
	
	add(new JLabel("Progress: " + bundle.getRequiredCount()));
	
	for (BundleItem item : bundle.getRequiredItems())
	{
	    add(new JLabel(item.getQuantity() + "x " + ItemDb.GetItem(item.getItemId()).getName()));
	}
    }
    
}
