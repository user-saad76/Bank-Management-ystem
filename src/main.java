  // Bank Management System

  import java.util.Scanner;

  public class main {

    static void createAccount(String name,String email,String phone){
           System.out.println("*********YOUR ACCOUNT IS CREATED*********");
            System.out.println();
           System.out.println("your name : " + name);
           System.out.println("your email : " + email);
            System.out.println("your phone number : " + phone);
          System.out.println();
         System.out.println("************************************");
    }
    static void checkBalance(int balance){
            System.out.println("There are your current balance in account : " + balance);
    }
    static int deposit(int balance,int deposit){
         balance = balance + deposit;
        System.out.println("There are your current balance in account : " + balance);
        return balance;
    }
      static int withdraw(int balance,int withdraw){
          balance = balance - withdraw;
          System.out.println("There are your current balance in account : " + balance);
          return balance;
      }

      static void historyOfTransaction( int[] transDeposit,  int[] transBalance,  int[] transWithdraw,int i){
             int x = 0;
             for( x = x+1;x<i;x++){

                 System.out.println( x + " Transaction  deposit : " + transDeposit[x] + " balance : " + transBalance[x] + " withdraw : " + transWithdraw[x] );


                }

      }
      static void Totaldeposits(int[] transDeposit,int i ){
         int sum = 0;
         for(int y = 0;y<i;y++){
             sum = sum +transDeposit[y];
         }
          System.out.println("Total deposits of your account : " + sum);
      }
      static void Totalwithdraw(int[] transWithdraw,int i){
          int sum = 0;
          for(int y = 0;y<i;y++){
              sum = sum + transWithdraw[y];
          }
          System.out.println("Total withdraws of your account : " + sum);
      }
      static void MaximumWithdrawal(int[] transWithdraw,int i){
          int max = 0;
          int j = 0;
          while(j<i){
              if(transWithdraw[j]>max){
                  max = transWithdraw[j];
              }
              j++;
          }
          System.out.println("The maximum withdrawal from your transactions in account = " + max);
      }
       static void searchTransaction(int search,int[] transDeposit ,int[] transBalance ,int[] transWithdraw , int i ){
         boolean isSearch = false;
         for(int x = 1;x<i;x++){
             if(search == x){
                 System.out.println( x  + " Transaction  deposit : " + transDeposit[x] + " balance : " + transBalance[x] + " withdraw : " + transWithdraw[x] );
                 isSearch = true;
                 break;
             }
         }
         if(!isSearch){
             System.out.println("Your transaction are not found ");
         }


       }



    public static void main(String[] args) {

      System.out.println("*************BANK MANAGEMENT SYSTEM*****************");
      Scanner input = new Scanner(System.in);
      System.out.println();
      System.out.println("First you have to create account : ");
      System.out.println();
      System.out.print("Enter your name : ");
       String name = input.nextLine();
      System.out.print("Enter your email : ");
      String email = input.nextLine();
      System.out.print("Enter your phone number : ");
      String phone = input.nextLine();
      System.out.print("Enter your secure password (@#$) : ");
      String password = input.nextLine();
      createAccount(name,email,phone);
      System.out.println();

      int balance = 0;
      int i = 0;
        int size = 9;
        int[] transDeposit = new int[size];
        int[] transBalance = new int[size];
        int[] transWithdraw =  new int[size];
        System.out.println("Search features : ");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Balance");
        System.out.println("4.check transacton history");
        System.out.println("5.Total deposit");
        System.out.println("6.Total withdraw");
        System.out.println("7.Maximum withdrawal");
        System.out.println("8.Search transactions");
        System.out.println("9.Exit");
        System.out.println();
      while(i<size){
          System.out.print("Enter your choice : " );
           int choice = input.nextInt();
           boolean istransaction = false;
           if(choice == 1){
               System.out.print("Enter your deposit : ");
                 int deposit = input.nextInt();
                     if(deposit<=0){
                         System.out.println("You deposit is invalid, ,try again");
                     }
                     else{
                         System.out.println("You have deposited " + deposit);
                         balance =  deposit(balance,deposit);
                         transDeposit[i] = deposit;
                         transBalance[i] = balance;
                         transWithdraw[i] = 0;
                         istransaction = true;
                     }


           }
           else if(choice == 2){
               System.out.print("Enter your withdraw : ");
                int withdraw = input.nextInt();
                   if(withdraw<=0){
                       System.out.println("Your withdraw is invalid ,try again");
                   }
                   else if(withdraw<=balance){
                       balance = withdraw(balance,withdraw);
                       transDeposit[i] = 0;
                       transBalance[i] = balance;
                       transWithdraw[i] =  withdraw;
                       istransaction = true;
                   }
                   else if(withdraw>balance){
                       System.out.println("Your are withdrawing out of balance");
                   }

           }
           else if(choice == 3){
               checkBalance(balance);
           }
           else if(choice == 4){
               System.out.println("TRANSACTION HISTORY");
               System.out.println();
               historyOfTransaction(transDeposit, transBalance, transWithdraw, i);

           }
           else if (choice == 5){
               System.out.println("Total deposit : ");
               Totaldeposits(transDeposit,i);
           }
           else if (choice == 6){
               System.out.println("Total withdraw : ");
               Totalwithdraw(transWithdraw,i);

           }
           else if (choice == 7){
               System.out.println("Maximum withdrawal : ");
               MaximumWithdrawal(transWithdraw,i);


           }
           else if(choice == 8){
               System.out.print("Search your transaction : ");
               int search = input.nextInt();
               searchTransaction(search,transDeposit, transBalance , transWithdraw,i);

           }
           else if(choice == 9){
               System.out.println("BYE BYE");
               break;
           }

           if(istransaction){
               i++;
           }

      }

    }
}
