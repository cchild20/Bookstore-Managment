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
public class Membership {
    private static String memberName;
    private static String memberPassword;
    private String paymentType;
    private double storeBalance;
    public double amountSpent;
    public boolean premiumAcct;
    private boolean isFeePaid;
    
    public Membership(String name, String password, String payment, double balance, double spent, boolean premium, boolean monthlyFee)
    {
       this.memberName = name;
        this.memberPassword = password;
        this.paymentType = payment;
        this.storeBalance = balance;
        this.amountSpent = spent;
        this.premiumAcct = premium; 
        this.isFeePaid = monthlyFee;
    }
    
    public Membership(){
        
    }
    
    // Method to change member to premium
    public void makePremium(){
        if (this.getIsFeePaid() == true){
            this.setPremium(true);
        }
        else{
            this.setPremium(false);
        }
    }
    
    // Method to deduct from balance
    public void deductBalance(double amount){
        double newAmount = 0;
        newAmount = (this.getBalance() - amount);
        this.setBalance(newAmount);
        
    }
    
    
    // Getters & Setters
    
    public String getMemberName(){
        return memberName;
    }
    public void setMemberName(String name){
        memberName = name;
    }
    
    public String getPassword(){
        return memberPassword;
    }
    public void setMemberPassword(String newPass){
        memberPassword = newPass;
    }
    
    public double getBalance(){
        return storeBalance;
    }
    public void setBalance(double amount){
        storeBalance = amount;
    }
    
    public double getAmountSpent(){
        return amountSpent;
    }
    public void setAmountSpent(double amount){
        amount = amountSpent;
    }
    
    public String getPaymentType(){
        return paymentType;
    }
    public void setPaymentType(String payment){
        paymentType = payment;
    }
    
    public boolean getIsFeePaid(){
        return isFeePaid;
    }
    public void setIsFeePaid(boolean flag){
        isFeePaid = flag;
    }
    
    public void setPremium(boolean flag){
        premiumAcct = flag;
    }
    
}

        
       
