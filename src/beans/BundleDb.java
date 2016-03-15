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
    private static HashMap<Integer, Bundle> bundles;
    private static final String bundleDbPath = "data/bundles.xml";
    
    public static void Load() throws FileNotFoundException
    {
	bundles = new HashMap<>();
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

	    NodeList nList = doc.getElementsByTagName("bundle");

	    for (int temp = 0; temp < nList.getLength(); temp++)
	    { // For each bundle
		Node nNode = nList.item(temp);
		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE)
		{
		    Element eElement = (Element) nNode;
		    
		    int bundleId = Integer.parseInt(eElement.getAttribute("id"));
		    String bundleName = eElement.getElementsByTagName("name").item(0).getTextContent();
		    List<BundleItem> bundleItems = new ArrayList<>();
		    
		    NodeList itemList = ((Element)eElement.getElementsByTagName("items").item(0)).getElementsByTagName("item");
		    for  (int i = 0; i < itemList.getLength(); i++)
		    { // For each required item
			Element itemEntry = (Element)itemList.item(i);
			int itemId = Integer.parseInt(itemEntry.getElementsByTagName("id").item(0).getTextContent());
			int itemQuantity = Integer.parseInt(itemEntry.getElementsByTagName("quantity").item(0).getTextContent());
			bundleItems.add(new BundleItem(itemId, itemQuantity));
		    }
		    
		    int required = Integer.parseInt(eElement.getElementsByTagName("required").item(0).getTextContent());
		    
		    Element rewardElement = (Element)eElement.getElementsByTagName("reward").item(0);
		    int rewardId = Integer.parseInt(rewardElement.getElementsByTagName("id").item(0).getTextContent());
		    int rewardQuantity = Integer.parseInt(rewardElement.getElementsByTagName("quantity").item(0).getTextContent());
		    BundleItem reward = new BundleItem(rewardId, rewardQuantity);
		    
		    Bundle bundle = new Bundle(bundleId, bundleName, required, bundleItems.toArray(new BundleItem[0]), reward);
		    bundles.put(bundleId, bundle);
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
