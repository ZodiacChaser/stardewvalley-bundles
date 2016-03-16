/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stardewvalleybundles;

import UI.MainFrame;
import beans.BundleDb;
import beans.ItemDb;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guilh
 */
public class StardewValleyBundles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	try {
	    ItemDb.Load();
	    BundleDb.Load();
	    
	    MainFrame mainFrame = new MainFrame();
	    mainFrame.setSize(600, 600);
	    mainFrame.setVisible(true);
	    mainFrame.pack();
	} catch (FileNotFoundException ex) {
	    
	}
    }
    
}
