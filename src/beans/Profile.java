/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author guilh
 */
public class Profile
{
    private static final String profilesPath = "data/profiles";
    private static final String profileExt = ".prf";
    
    public static String[] GetProfileList()
    {
	List<String> profileList = new ArrayList<>();
	File folder = new File(profilesPath);
	
	if (!folder.exists())
	{
	    folder.mkdirs();
	}
	
	for (File fileEntry : folder.listFiles())
	{
	    if (!fileEntry.isDirectory())
		profileList.add(fileEntry.getName());
	}
	
	return profileList.toArray(new String[0]);
    }

    public static int Create(String profileName)
    {
	profileName += profileExt;
	try {
	    File file = new File(profilesPath+File.separatorChar+profileName);
	    System.out.println(profilesPath+File.separatorChar+profileName);
	    if (file.exists()) return 1;
	    else if (!file.createNewFile()) return 2;
	    return 0;
	} catch (IOException ex) {
	    return 2;
	}
    }
    
    public Profile(String name) throws FileNotFoundException
    {
	if (!name.endsWith("."+profileExt))
	    name += "."+profileExt;
		    
	File file = new File(profilesPath+File.separatorChar+name);
	if (!file.exists() || !file.canRead())
	    throw new FileNotFoundException("Profile file doesn't exists or you doesn't have permission to read it.");
	
	try
	{
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(file);

	    //optional, but recommended
	    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    doc.getDocumentElement().normalize();

	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	    NodeList nList = doc.getElementsByTagName("staff");

	    System.out.println("----------------------------");

	    for (int temp = 0; temp < nList.getLength(); temp++) {

		    Node nNode = nList.item(temp);

		    System.out.println("\nCurrent Element :" + nNode.getNodeName());

		    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			    Element eElement = (Element) nNode;

			    System.out.println("Staff id : " + eElement.getAttribute("id"));
			    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		    }
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
}
