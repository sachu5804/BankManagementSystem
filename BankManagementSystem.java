import java.util.Scanner;
class Newaccount{
   private final String Name;
   private final String AccountType;
   private final String phoneNumber;
   private final String AccountNumber;
   public Newaccount (String Name, String AccountType, String phoneNumber){
       this.Name = Name;
       this.AccountType = AccountType;
       this.phoneNumber = phoneNumber;
       this.AccountNumber = generateAccountNumber(AccountType) ;
   }  
   public String generateAccountNumber(String g){
      String prefix = switch(g.toLowerCase()){
        case "savings" -> "SB";
        case "current" -> "CUR";
        case "salary" -> "SAL";
        default -> "GEN";
      };
      int random = 1000+ new java.util.Random().nextInt(9000);
      return prefix + random;

   }
    
     public void  displayinfo(String Name, String AccountType, String phoneNumber){
         System.out.println("AccountHolder Name: " + Name);
         System.out.println("AccounType: " + AccountType); 
         System.out.println("Phone Number: " + phoneNumber);
         System.out.println("Account Number: " + AccountNumber);
         System.out.println("New Account Created Thank you!");
    }

}
class ExistingAccount{
    double Balance = 56789.90;

    public void deposit(Scanner sc){
        System.out.print("Enter the amount for deposit: ");
        double depositmoney = sc.nextDouble();
        Balance += depositmoney;
        System.out.print("Balance: " + Balance);
        
           
    }
    public void withdraw(Scanner sc){
        System.out.print("Enter the amount: ");
        double cash = sc.nextDouble();
        if(cash > Balance){
            System.out.println("Insufficient Balance: " + Balance);
        }
        else{
            Balance -= cash;
            System.out.println("Rs."+ cash + " were withdrawen from your account your current balance is: " + Balance);
        }

    }
    public void balanceEnquiry(){
        System.out.print("your Curent Balance: " + Balance);
    }

}
class SavingsAccount{
    private double interestRate = 4.0;
    
      public void applyInterest(){
        System.out.println("Intrest rate per year: " + interestRate);
    }
    

}
class CurrentAccount{
 public void withdraw(){
    System.out.print("Overdraft allowed");     
 }
}
class SalaryAccount {
    public void balance(){
        System.out.print("No minimum balance required in account");
    }
}
class BankManagementSystem{

    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        System.out.print("New Account Creation / Existing Account: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch(option){
        case 1:
        System.out.println("Welcome, To create your new account fill the below deatils");
        System.out.print("Enter your Name: ");
        String Name =sc.nextLine();
        System.out.print("Account Type ( 1-Savings/ 2-Current/ 3-Salary): ");
        int AccountTypeOption = sc.nextInt();
        sc.nextLine();
        String AccountType = "";
          switch(AccountTypeOption) {
           case 1: 
                 AccountType = "Savings";
                 SavingsAccount sa = new SavingsAccount();
                 sa.applyInterest();
                break;
           case 2: 
                 AccountType = "Current";
                 CurrentAccount ca = new CurrentAccount();
                 ca.withdraw();
                 break;
           case 3: 
           AccountType = "Salary";
           SalaryAccount sac = new SalaryAccount();
           sac.balance();
            break; 
        default:
            System.out.println("Invalid Account Type");
           return;
        }
        sc.nextLine();
        System.out.print("Enter Phone number: ");
        String phoneNumber = sc.nextLine();
        Newaccount n = new Newaccount(Name, AccountType, phoneNumber);
        n.displayinfo(Name,AccountType, phoneNumber);
        break;

        case 2:
        ExistingAccount e = new ExistingAccount();
        System.out.print("deposit/withdraw/balanceEnquiry: ");
        int  enteroption = sc.nextInt();
             if(enteroption == 1){
                 
                 e.deposit(sc);
             }
             else if(enteroption == 2)  {
                e.withdraw(sc);
             }
             else if(enteroption == 3){
                e.balanceEnquiry();
             }
             else{
                System.out.println("enter correct option");
             } 
             break;

        default:{
                System.out.println("Invalid Detail");
             }
        
    }
    
    }
 }
