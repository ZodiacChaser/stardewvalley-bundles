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
public class ItemDb
{
    private static HashMap<Integer, Item> items;
    private static final String itemDbPath = "data/items.xml";
    
    public static void Load() throws FileNotFoundException
    {
	items = new HashMap<>();
	File file = new File(itemDbPath);
	if (!file.exists() || !file.canRead())
	    throw new FileNotFoundException("Item Db file doesn't exists or you doesn't have permission to read it.");
	
	try
	{
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(file);

	    //optional, but recommended
	    //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	    doc.getDocumentElement().normalize();

	    NodeList nList = doc.getElementsByTagName("item");

	    for (int temp = 0; temp < nList.getLength(); temp++)
	    { // For each bundle
		Node nNode = nList.item(temp);

		if (nNode.getNodeType() == Node.ELEMENT_NODE)
		{
		    Element eElement = (Element) nNode;
		    
		    int itemId = Integer.parseInt(eElement.getAttribute("id"));
		    String itemName = eElement.getElementsByTagName("name").item(0).getTextContent();
		    String itemSource = eElement.getElementsByTagName("source").item(0).getTextContent();
		    
		    Item item = new Item(itemId, itemName, itemSource);
		    items.put(itemId, item);
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public static Item GetItem(int itemId)
    {
	return items.get(itemId);
    }
}
