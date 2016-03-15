/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author guilh
 */
public class BundleDb
{
    private static List<Bundle> bundles;
    private static String bundleDbPath = "data/bundles.xml";
    
    public static void Load() throws FileNotFoundException
    {
	bundles = new ArrayList<>();
	
	File file = new File(bundleDbPath);
	if (!file.exists() || !file.canRead())
	    throw new FileNotFoundException("Bundle Db file doesn't exists or you doesn't have permission to read it.");
	
	try
	{
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(file);

	    //optional, but recommended
	    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    doc.getDocumentElement().normalize();

	    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	    NodeList nList = doc.getElementsByTagName("bundle");

	    System.out.println("----------------------------");

	    for (int temp = 0; temp < nList.getLength(); temp++) {

		    Node nNode = nList.item(temp);

		    System.out.println("\nCurrent Element :" + nNode.getNodeName());

		    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			    Element eElement = (Element) nNode;

			    System.out.println("Bundle id : " + eElement.getAttribute("id"));
			    NodeList itemList = ((Element)eElement.getElementsByTagName("items").item(0)).getElementsByTagName("item");
			    System.out.println(itemList.getLength());
			    for  (int i = 0; i < itemList.getLength(); i++)
			    {
				Element itemEntry = (Element)nList.item(i);
				System.out.println(itemEntry.getElementsByTagName("id").item(0).getTextContent());
			    }
			    /*System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
			    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());*/
		    }
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public Bundle GetBundle(int id)
    {
	return null;
    }
	
}
