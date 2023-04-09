import java.util.*;
import java.lang.*;
public class Account {
    private String name;
    private String user_id;
    private User holder;
    private ArrayList<Transaction> transactions;
    public Account(String name,User holder,Bank theBank){
        this.name = name;
        this.holder = holder;
        this.user_id = theBank.getNewAccountUUID();
        this.transactions = new ArrayList<Transaction>();
         
    }
    public String getUUID(){
        return this.user_id;
    }
    public String getSummaryLine(){
        double balance = this.getBalance();
        if(balance>=0){
            return String.format(this.user_id+" : $"+balance+" : "+this.name);
        }else{
            return String.format(this.user_id+" : $"+balance+" : "+this.name);
        }
    }
    public double getBalance(){
        double balance = 0;
        for(Transaction t : this.transactions){
            balance += t.getAmount();
        }
        return balance;
    }
    public void printTransHistory(){
        System.out.println("Transaction history for account : "+this.user_id);
        for(int t = this.transactions.size()-1;t>=0;t--){
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }
    public void addTransaction(double amount,String memo){
        Transaction newTrans = new Transaction(amount,memo,this);
        this.transactions.add(newTrans);
    }
}