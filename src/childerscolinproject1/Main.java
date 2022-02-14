/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package childerscolinproject1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author child
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void showMenu() {
        System.out.println("=================================");
        System.out.println("=== Welcome to the Book Store ===");
        System.out.println("=================================");
        System.out.println("  Please select an option:   ");
        System.out.println("1) Register new member");
        System.out.println("2) Add item to cart");
        System.out.println("3) Display cart");
        System.out.println("4) Checkout");
        System.out.println("5) Exit");
        System.out.println("=================================");

    }

    public static void main(String[] args) {

        int choice;
        boolean mainLoop = true;

        Scanner scan = new Scanner(System.in);
        ArrayList<ItemOrder> orderList = new ArrayList<ItemOrder>();
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<Music_CD> cdList = new ArrayList<Music_CD>();
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        Membership c = new Membership();

        Book book1 = new Book("Cool Book", 15.99, 5);
        Movie movie1 = new Movie("Cool Movie", 9.99, 10);
        Music_CD cd1 = new Music_CD("Cool CD", 5.99, 20);

        // User Menu with switch statement 
        while (mainLoop == true) {
            showMenu();
            choice = scan.nextInt();

            // Variables for making Users    
            String password = "";
            String name = "";
            String payment = "";
            double balance = 0;
            int premChoice = 0;

            //ItemOrder ArrayList    
            ItemOrder order = new ItemOrder(bookList, cdList, movieList, 1);
            switch (choice) {

                case 1:

                    System.out.println("Please enter your username: ");
                    name = scan.next();
                    c.setMemberName(name);

                    System.out.println("Please enter a password: ");
                    password = scan.next();
                    c.setMemberPassword(password);

                    System.out.println("Please enter a payment type (Cash or Card): ");
                    payment = scan.next();
                    c.setPaymentType(payment);

                    System.out.println("What's your balance?");
                    balance = scan.nextDouble();
                    c.setBalance(balance);
                    c.setAmountSpent(0.0);

                    System.out.println("Want to make it premium? Monthly fee is $5");
                    System.out.println("1 means yes. 2 means no.");
                    premChoice = scan.nextInt();
                    if (premChoice == 1) {
                        if (c.getBalance() < 5) {
                            System.out.println("Invalid Purchase");
                        }
                        c.deductBalance(5.0);
                        c.setIsFeePaid(true);
                        c.makePremium();
                        System.out.println("Congratulations " + c.getMemberName() + " your premium account is created!");
                    }
                    if (premChoice == 2) {
                        c.setIsFeePaid(false);
                        System.out.println("Congratulations " + c.getMemberName() + " your regular account is created!");
                    }
                    break;

                case 2:
                    int opt = 0;
                    System.out.println("Please select items you want and amount: ");
                    System.out.println("1) Book");
                    System.out.println("2) Movie");
                    System.out.println("3) CD");
                    opt = scan.nextInt();
                    if (opt == 1) {
                        int bookNum = 0;
                        System.out.println("How many to add to cart?");
                        bookNum = scan.nextInt();
                        order.addBook(bookNum);
                        System.out.println(bookNum + " book/s added to cart.");
                    }
                    if (opt == 2) {
                        int movieNum = 0;
                        System.out.println("How many to add to cart?");
                        movieNum = scan.nextInt();
                        order.addMovie(movieNum);
                        System.out.println(movieNum + " movie/s added to cart.");
                    }
                    if (opt == 3) {
                        int cdNum = 0;
                        System.out.println("How many to add to cart?");
                        cdNum = scan.nextInt();
                        order.addCD(cdNum);
                        System.out.println(cdNum + " CDs added to cart");
                    }
                    break;

                case 3:
                    order.displayCart();
                    break;

                case 4:

                    String input1 = "";
                    String input2 = "";

                    System.out.println("Please sign in to checkout.");
                    System.out.println("Username: ");
                    input1 = scan.next();
                    if (input1.equals(c.getMemberName())) {
                        System.out.println("Password:");
                        input2 = scan.next();
                        if (input2.equals(c.getPassword())) {

                            double bookTotal = 0;
                            double movieTotal = 0;
                            double cdTotal = 0;
                            double cartTotal = 0;

                            // Arithemetic to calculate total cost of order
                            bookTotal = (bookList.size() * book1.getPrice());
                            movieTotal = (movieList.size() * movie1.getPrice());
                            cdTotal = (cdList.size() * cd1.getPrice());

                            cartTotal = bookTotal + movieTotal + cdTotal;

                            // Little Cart Fee
                            if (cartTotal < 50 && c.getIsFeePaid() == false) {
                                
                                System.out.println("==============================");
                                System.out.println("Your Order Number is: " + order.getOrderID());
                                System.out.println("Non-Premium Little Cart Fee: %5");
                                System.out.println("Your total is: " + (cartTotal / .5));
                                System.out.println("==============================");
                                System.out.println("Total for premium members: " + cartTotal);
                                System.out.println("==============================");

                                int inputA = 0;
                                System.out.println("Ready to pay? 1 is Yes. 2 is No");
                                inputA = scan.nextInt();
                                if (inputA == 1) {
                                    System.out.println("==============================");
                                    System.out.println("Your payment type is: " + c.getPaymentType());
                                    System.out.println("Processing Payment...");
                                    c.deductBalance(cartTotal);
                                    c.amountSpent = +cartTotal;
                                    System.out.println("New Account Balance is: " + c.getBalance());
                                    System.out.println("Total Amount Spent in Store " + c.amountSpent);
                                    System.out.println("==============================");
                                    System.out.println("PURCHASE COMPLETE. THANK YOU!");

                                    // Emptys Cart
                                    bookList.clear();
                                    movieList.clear();
                                    cdList.clear();

                                    if (inputA == 2) {
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("================================");
                                System.out.println("Your Order Number is: " + order.getOrderID());
                                System.out.println("Your total is: " + cartTotal);
                                int input3 = 0;
                                System.out.println("Ready to pay? 1 is Yes. 2 is No");
                                input3 = scan.nextInt();
                                if (input3 == 1) {
                                    System.out.println("==============================");
                                    System.out.println("Your payment type is: " + c.getPaymentType());
                                    System.out.println("Processing Payment...");
                                    c.deductBalance(cartTotal);
                                    c.amountSpent = +cartTotal;
                                    System.out.println("New Account Balance is: " + c.getBalance());
                                    System.out.println("Total Amount Spent in Store " + c.amountSpent);
                                    System.out.println("==============================");
                                    System.out.println("PURCHASE COMPLETE. THANK YOU!");

                                    // Emptys carts
                                    bookList.clear();
                                    movieList.clear();
                                    cdList.clear();
                                }
                                if (input3 == 2) {
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Incorrect Password");
                        }

                    } else {
                        System.out.println("Incorrect Username");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for Shopping!");
                    System.out.println("Goodbye...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please select a valid option.");
            }
        }

    }

}// end of Main Class
