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
public class BundleItem
{
    private int itemId;
    private int quantity;
    
    public BundleItem(int id, int quantity)
    {
	this.itemId = id;
	this.quantity = quantity;
    }

    public int getItemId() {
	return itemId;
    }

    public int getQuantity() {
	return quantity;
    }
    
    
}
