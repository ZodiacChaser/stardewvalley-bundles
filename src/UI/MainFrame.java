/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import beans.Profile;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class MainFrame extends JFrame {
    private Profile activeProfile = null;
    private ProfileSelector profileSelector;
    private BundlesPanel bundlesPanel;
    private ItemListPanel itemListPanel;
    
    public MainFrame()
    {
	super("Stardew Valley Bundles");
	setLayout(new BorderLayout());
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	profileSelector = new ProfileSelector(this);
	add(profileSelector, BorderLayout.NORTH);
	
	JPanel midPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	bundlesPanel = new BundlesPanel();
	itemListPanel = new ItemListPanel();
	
	//midPanel.add(bundlesPanel);
	//midPanel.add(itemListPanel);
	
	//add(midPanel, BorderLayout.);
	
	add(bundlesPanel, BorderLayout.WEST);
	add(itemListPanel, BorderLayout.EAST);
	
	
	
	pack();
    }
    
    public void ProfileSelected(String fileName)
    {
	try {
	    this.activeProfile = new Profile(fileName);
	    
	    
	} catch (FileNotFoundException ex) {
	    JOptionPane.showMessageDialog(
		    null,
		    "Failed to load profile.\nError:"+ex.getMessage(),
		    "Failed to load profile.", 
		    JOptionPane.ERROR_MESSAGE
	    );
	}
    }
}
