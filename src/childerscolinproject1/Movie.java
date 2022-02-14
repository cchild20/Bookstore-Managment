/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childerscolinproject1;

import static childerscolinproject1.Book.stock;

/**
 *
 * @author child
 */
public class Movie
{
    public String movieName;
    public double price;
    public static int stock;
    
    public Movie(String name, double moviePrice, int inStock)
    {
        movieName = name; 
        price = moviePrice; 
        stock = inStock; 
    }
    
        // Getters & Setters
    public double getPrice()
    {
        return price;
    }
    
    public String getMovieName()
    {
        return movieName;
    }
    
    public void  setPrice(double newPrice)
    {
        newPrice = price; 
    }
    
    public void setMovieName(String newName)
    {
        newName = movieName;
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
