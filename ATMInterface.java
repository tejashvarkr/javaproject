/*[
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//The ATMs in our cities are built on Java, as we have all seen them. It is a console-based application with five different classes. In order to use the system, the user must enter his or her user ID and pin when it starts. Once the details are entered successfully, ATM functionality is unlocked. As a result of the project, the following operations can be performed:

//Transactions History
//Withdraw
//Deposit
//Transfer
//Quit//

package atminterface;
import static java.lang.System.exit;
import java.util.Scanner;
/**
 *
 * @author tejas
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 class TransactionHistory {
    String type;
    int amount;
    static List<TransactionHistory> transactionHistory = new ArrayList<>();

    TransactionHistory(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + " of " + amount;
    }

    static void addTransaction(String type, int amount) {
        transactionHistory.add(new TransactionHistory(type, amount));
    }

    static void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (TransactionHistory transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
class withdraw
{
    int amount;
    withdraw()
    {
        amount=0;
    }
    int withdraw(int am)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw");
        amount=s.nextInt();
        if (amount > am){
                System.out.println("Less Balance");
        }
        else{
             am=am-amount;
        System.out.println("Your balance is "+am );
        TransactionHistory.addTransaction("Withdrawal", amount);
        System.out.println("Successfully withdrawn");
        }
        return am;
    }
 
 
}
     class Deposit{
         int amount;
         int deposit(int am){
              Scanner s = new Scanner(System.in);
        System.out.println("Enter the amount you want deposit");
        amount=s.nextInt();
        am=am+amount;
         TransactionHistory.addTransaction("Deposit", amount);
       System.out.println("Successfully Deposited");
       return am;
    }
  
         }
class Transfer{
   int accno;
   int amount;
    int transfer(int am)
    {
        Scanner s = new Scanner(System.in);
       System.out.println("Enter the account no or user id to transfer the amount");
       accno=s.nextInt();
       System.out.println("Enter the amount  to transfer the amount");
       amount=s.nextInt();
       if (amount > am){
                System.out.println("Less Balance");
        }
       else{
           am=am-amount;
        TransactionHistory.addTransaction("Transfer", amount);
      System.out.println("Successfully Transfered");
      
       } 
       return am;
    }

        }
public class ATMInterface {

   
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String userid;
        String password;
        int choice=0;
        int am=1000;
        
        System.out.println("Enter your username");
        userid= s.next();
        System.out.println("Enter your password");
        password= s.next();
       System.out.println("You have logged in");
        do{
        System.out.println("Type 1 for Transactions History");
        System.out.println("Type 2 for withdrawal");
        System.out.println("Type 3 for Deposit");
        System.out.println("Type 4 for Transfer");
        System.out.println("Type 5 for Quit");
        ATMInterface a =new ATMInterface();
      //  TransactionHistory th = new TransactionHistory();
        withdraw b=new withdraw();
        Deposit d = new Deposit();
        Transfer t= new Transfer();
        System.out.println("Enter your choice");
        choice=s.nextInt();
         switch(choice)  {
             case 1:
                 TransactionHistory.printTransactionHistory();
                    break;
          
          case 2:
                 int ch = 0;
              do{
              System.out.println("Enter 1 for withdraw");
              
              System.out.println("Enter 2 for exit ");
           System.out.println("Enter your choice ");
           ch=s.nextInt();
              switch(ch){
              case 1:
                  b.withdraw( am);  
              break;
              case 2:
                 
                      break;
              
              default: 
                  System.out.println("Wrong choice ");
                  break;
              }
              
              }while(ch!=2);
              
      
       break;
          case 3:
              int cho;
              do{
              System.out.println("Enter 1 for deposit");
   
              System.out.println("Enter 2 for exit ");
           System.out.println("Enter your choice ");
           cho=s.nextInt();
              switch(cho){
              case 1:
                  d.deposit( am);  
              break;
              case 2:
                
                      break;
             
             default: 
                  System.out.println("Wrong choice ");
                  break;
              }
              
              }while(cho!=2);
              
      
       break; 
          case 4:
             int choi;
              do{
              System.out.println("Enter 1 for transfer");
              
                System.out.println("Enter 2 for exit ");
           System.out.println("Enter your choice ");
           choi=s.nextInt();
              switch(choi){
              case 1:
                  t.transfer(am);  
              break;
              case 2:
                  
                      break;
            
             default: 
                  System.out.println("Wrong choice ");
                  break;
              }
              
              }while(choi!=2);
              
      
       break;  
          case 5:
             System.out.println("exit");
             exit(0);
             break;
          default: 
                  System.out.println("Wrong choice ");
                  break;
        }} while(choice!=5);
        
    }
}
   
