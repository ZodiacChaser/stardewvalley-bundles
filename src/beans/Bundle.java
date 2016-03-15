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
public class Bundle
{
    private int id;
    private String name;
    private int requiredCount;
    private BundleItem[] requiredItems;
    private BundleItem reward;
    
    public Bundle(int id, String name, int requiredCount, BundleItem[] items, BundleItem reward)
    {
	
    }
}
