  // Bank Management System

  import java.util.Scanner;

  public class main {

    static void createAccount(String name,String email,String phone,String password ){
           System.out.println("*********YOUR ACCOUNT IS CREATED*********");
            System.out.println();
           System.out.println("your name : " + name);
           System.out.println("your email : " + email);
            System.out.println("your phone number : " + phone);
           System.out.println("your password : " + password);
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

      static void historyOfTransaction( int[] transDeposit,  int[] transBalance,  int[] transWithdraw,int size){
                for(int x = 0;x<size;x++){
                           if(transBalance[x]>0){
                               System.out.println( (x+1) + " Transaction  deposit : " + transDeposit[x] + " balance : " + transBalance[x] + " withdraw : " + transWithdraw[x] );
                           }

                        System.out.println();

                }

      }
      static void Totaldeposits(int[] transDeposit,int size){
         int sum = 0;
         for(int y = 0;y<size;y++){
             sum = sum +transDeposit[y];
         }
          System.out.println("Total deposits of your account : " + sum);
      }
      static void Totalwithdraw(int[] transWithdraw,int size){
          int sum = 0;
          for(int y = 0;y<size;y++){
              sum = sum + transWithdraw[y];
          }
          System.out.println("Total withdraws of your account : " + sum);
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
      createAccount(name,email,phone,password);
      System.out.println();

      int balance = 0;
      int i = 0;
        int size = 9;
        int[] transDeposit = new int[size];
        int[] transBalance = new int[size];
        int[] transWithdraw =  new int[size];
      while(i<=size){
          System.out.println("Search features : ");
          System.out.println("1.Deposit");
          System.out.println("2.Withdraw");
          System.out.println("3.Balance");
          System.out.println("4.check transacton history");
          System.out.println("5.Total deposit");
          System.out.println("6.Total withdraw");
          System.out.println();
          System.out.print("Enter your choice : " );
           int choice = input.nextInt();
           if(choice == 1){
               System.out.print("Enter your deposit : ");
                 int deposit = input.nextInt();
                     System.out.println("You have deposited " + deposit);
                     balance =  deposit(balance,deposit);
                     transDeposit[i] = deposit;
                     transBalance[i] = balance;
                     transWithdraw[i] = 0;


           }
           else if(choice == 2){
               System.out.print("Enter your withdraw : ");
                int withdraw = input.nextInt();
                    balance = withdraw(balance,withdraw);
                    transDeposit[i] = 0;
                    transBalance[i] = balance;
                    transWithdraw[i] =  withdraw;


           }
           else if(choice == 3){
               checkBalance(balance);
           }
           else if(choice == 4){
               System.out.println("TRANSACTION HISTORY");
               System.out.println();
               historyOfTransaction(transDeposit, transBalance, transWithdraw, size);
           }
           else if (choice == 5){
               System.out.println("Total deposit : ");
               Totaldeposits(transDeposit,size);
           }
           else if (choice == 6){
               System.out.println("Total withdraw : ");
               Totalwithdraw(transWithdraw,size);
           }

          i++;
      }

















    }
}
