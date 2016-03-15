/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import beans.Profile;
import java.awt.FlowLayout;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class ProfileSelector extends JPanel {
    private MainFrame parentFrame;
    
    private JComboBox comboProfile;
    
    public ProfileSelector(MainFrame parentFrame)
    {
	super(new FlowLayout(FlowLayout.LEFT));
	this.parentFrame = parentFrame;
	setBorder(BorderFactory.createTitledBorder("Profile Selector"));
	
	JLabel lblProfile = new JLabel("Profile: ");
	add(lblProfile);
	
	comboProfile = new JComboBox(); 
	comboProfile.setPrototypeDisplayValue("11111111111111111111.txt");
	add(comboProfile);
	
	JButton loadButton = new JButton("Load");
	loadButton.addActionListener(this::loadButton_Click);
	add(loadButton);
	
	JButton newButton = new JButton("New");
	newButton.addActionListener(this::newButton_Click);
	add(newButton);
	
	String[] profiles = Profile.GetProfileList();
	
	if (profiles.length == 0)
	{
	    comboProfile.setEnabled(false);
	    loadButton.setEnabled(false);
	}
	else
	{
	    for (String name : profiles)
		comboProfile.addItem(name);
	}
	
    }
    
    private void loadButton_Click(ActionEvent e)
    {
	parentFrame.ProfileSelected(comboProfile.getSelectedItem().toString());
    }
    
    private void newButton_Click(ActionEvent e)
    {
	String profileName = 
	    JOptionPane.showInputDialog(
		null,
		"Input the new profile Name",
		"New Profile",
		JOptionPane.QUESTION_MESSAGE
	    );
	
	switch (Profile.Create(profileName)) {
	    case 0:
		JOptionPane.showMessageDialog(
			null,
			"Profile created successfully.",
			"Profile Created",
			JOptionPane.PLAIN_MESSAGE
		);
		parentFrame.ProfileSelected(profileName);
		break;
	    case 1:
		JOptionPane.showMessageDialog(
			null,
			"This profile name is already in use.",
			"Profile already exists",
			JOptionPane.ERROR_MESSAGE
		);
		break;
	    case 2:
		JOptionPane.showMessageDialog(
			null,
			"Failed to create profile, try using another name.",
			"Profile already exists", 
			JOptionPane.ERROR_MESSAGE
		);
		break;
	    default:
		throw new AssertionError();
	}
    }
}
