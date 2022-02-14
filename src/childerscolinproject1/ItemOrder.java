/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childerscolinproject1;

import java.util.ArrayList;

/**
 *
 * @author child
 */
public class ItemOrder {
    // Private Array List to hold items
    public ArrayList<Book> bookList = new ArrayList<Book>();
    public ArrayList<Music_CD> cdList = new ArrayList<Music_CD>();
    public ArrayList<Movie> movieList = new ArrayList<Movie>();
    private int orderNum;
     
    
    
    // Object Instantiation for Items that can be ordered
    Book book1 = new Book("Cool Book", 15.99,5);
    Movie movie1 = new Movie("Cool Movie", 9.99,10);
    Music_CD cd1 = new Music_CD("Cool CD", 5.99,20);
    
    // Constructor
    public ItemOrder(ArrayList<Book> numOfBook, ArrayList<Music_CD> numOfCD, ArrayList<Movie> numOfMovie, int num)
    {
        bookList = numOfBook;
        cdList = numOfCD;
        movieList = numOfMovie; 
        orderNum = num;
        
    }
    
    // Method to display list
    
    
    // Methods to add item to order list
     int bookNum = 0;
     int movieNum = 0;
     int cdNum = 0;
    
    public void addBook(int amount) {
        
        if (book1.getStock() == 0){
            System.out.println("Sorry! " + book1.getBookName() + " is out of stock");
            System.exit(0);
        }
        if (amount > book1.getStock()){
            System.out.println("Sorry! Amount requested exceeds amount in stock.");
            System.exit(0);
        }
        for (int i = 0; i < amount; i++) {
            bookList.add(book1);
            book1.decreaseStock();
            
        }
       System.out.println(book1.getStock() + " Books left in stock.");
    }

    public void addMovie(int amount) {
        
        if (movie1.getStock() == 0){
            System.out.println("Sorry! " + movie1.getMovieName() + " is out of stock.");
            System.exit(0);
        }
        if (amount > movie1.getStock()){
            System.out.println("Sorry! Amount requested exceeds amount in stock.");
            System.exit(0);
        }
        for (int i = 0; i < amount; i++) {
            movieList.add(movie1);
            movie1.decreaseStock();
            
        }
        System.out.println(movie1.getStock() + " Movies left in stock.");
    }

    public void addCD(int amount) {
        
        if (cd1.getStock() == 0){
            System.out.println("Sorry! " + cd1.getCDName() + " is out of stock.");
            System.exit(0);
        }
        if (amount > cd1.getStock()){
            System.out.println("Sorry! Amount requested exceeds amount in stock.");
            System.exit(0);
        }
            
        for (int i = 0; i < amount; i++) {
            cdList.add(cd1);
            cd1.decreaseStock();
        }
        System.out.println(cd1.getStock() + " CDs left in stock.");
    }

    public void displayCart(){
       // System.out.println("Books in cart: " + bookList.size() + " Movies in cart: " + movieList.size() + " CDs in cart: " + cdList.size());
        
            int list1 = bookList.size();
            int list2 = movieList.size();
            int list3 = cdList.size();
            
            int totalItems = list1 + list2 + list3;
            
            System.out.println("Your Cart:");
            System.out.println("====================================");
            System.out.println("Books in cart: " + list1 + " Movies in cart: " + list2 + " CDs in cart: " + list3);
            System.out.println("Total items in cart: " + totalItems);
 
    }
    
    public int getOrderID(){
        return orderNum;
    }
    
    
   
    
    
    
}
