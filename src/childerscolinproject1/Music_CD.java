/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childerscolinproject1;

import static childerscolinproject1.Movie.stock;

/**
 *
 * @author child
 */
public class Music_CD
{
    public String cdName;
    public double price; 
    public static int stock;
    
    // Constructor
    public Music_CD(String name, double cdPrice, int inStock)
    {
        cdName = name;
        price = cdPrice;
        stock = inStock;
    }
    
    // Getters & Setters
    public double getPrice()
    {
        return price;
    }
    
    public String getCDName()
    {
        return cdName;
    }
    
    public void  setPrice(double newPrice)
    {
        newPrice = price; 
    }
    
    public void setCDName(String newName)
    {
        newName = cdName;
    }
    
    public int getStock()
    {
        return stock;
    }
    
   public static void decreaseStock()
    {
      stock--;
    }
    
    // Method to check stock
    
    public boolean inStock()
   {
     boolean flag = true; 
     
       if (stock == 0)
       {
           flag = false;
       }
      return flag;
   }
}
       

