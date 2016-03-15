/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author guilh
 */
public class Item
{
    private int id;
    private String name;
    private String source;
    
    public Item(int id, String name, String source)
    {
	this.id = id;
	this.name = name;
	this.source = source;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public String getSource() {
	return source;
    }
    
    public String toString()
    {
	return name;
    }
}
