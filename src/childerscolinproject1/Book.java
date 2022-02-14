/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childerscolinproject1;

/**
 *
 * @author child
 */
public class Book
{
    public String bookname;
    public double price; 
    public static int stock;
    
   // Constructor for Book
    
   public Book(String name, double bookPrice, int inStock)
   {
       bookname = name;
       price = bookPrice;
       stock = inStock;
   }
   
   // Getters & Setters
   
   public String getBookName()
   {
       return bookname; 
   }
   
   public void setBookName(String name)
   {
       name = bookname;
   }
   
   public double getPrice()
   {
       return price;
   }
   
   public void setBookPrice(double newPrice)
   {
       newPrice = price;
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
