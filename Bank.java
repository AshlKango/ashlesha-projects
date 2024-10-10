import java.util.*;
class Bank
{
    static String username;
    static long mobile;
    static String pan;
    static long adhar;
    static String address;
    static int pin;
    static double bal;
    final static Long accountnumber=1234123412343L;
    final static String ifscCode= "LCF1234";
    static ArrayList<String> statement = new ArrayList<>(); 
    public static void main(String[]args)
    {
       welcome();
    }
    public static void welcome()
    {
        for( ; ; )
        {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("     *****WELCOME*****       ");
            System.out.println("        Bank      ");
            System.out.println();
            System.out.println("1. Existing User ");
            System.out.println("2. Create Bank Account ");
            System.out.println();
            System.out.println(" Enter an option: ");
            int opt= sc.nextInt();
            switch(opt)
            {
                case 1: login(sc);break;
                case 2: createAccount(sc);break;
                default : System.out.println(" Wrong Option Entered");
            }
        }
    }
    public static void login(Scanner sc)
    {
        if (username!=null)
        {
            for (int i=1; i<=3;i++)
            {
               System.out.println();
               System.out.println("    ****LOGIN MODULE****   ");
               System.out.println();
               System.out.println("Mobile : ");
               Long mobile1=sc.nextLong();
               System.out.println("pin :");
               int pin1=sc.nextInt();
               if((mobile==mobile1)&&(pin==pin1))
               {
                 homePage(sc);
               }
               else
               {
                System.out.println();
                System.out.println(" Wrong Credentials Entered");
                System.out.println();
               }
            }
            System.exit(0);
        }
          
        else
        {
            System.out.println();
            System.out.println(" Create Your Account First ");
            System.out.println();
        }
    }
    public static void createAccount(Scanner sc)
    {
        System.out.println();
        System.out.println("  *******Account Creation Moudule********     ");
        System.out.println();
        System.out.println("Username :");
        sc.nextLine();
        username= sc.nextLine();
        System.out.println("Mobile : ");
        mobile = sc.nextLong();
        System.out.println("Adhar :");
        adhar = sc.nextLong();
        System.out.println("Pancard : ");
        pan = sc.next();
        System.out.println("Address : ");
        sc.nextLine();
        address = sc.nextLine();
        System.out.println("Pin : ");
        pin = sc.nextInt();
        System.out.println("Enter the amount to deposit : ");
        bal = sc.nextDouble();
        statement.add("Deposit : " + bal);

        System.out.println();
        System.out.println("Account Created Successfully ");
        System.out.println();
    }
    public static void homePage(Scanner sc)
    {
        for( ; ; )
        {
            System.out.println();
            System.out.println("     ***HOME PAGE MODULE***     ");
            System.out.println();
            System.out.println("1. Deposit Amount ");
            System.out.println("2. Withdraw Amount ");
            System.out.println("3. Check Balance ");
            System.out.println("4. Statement ");
            System.out.println("5. Edit Profile ");
            System.out.println("6. Logout ");
            System.out.println();
            System.out.println("Enter an option : ");
            int option = sc.nextInt();
            System.out.println();
            switch(option)
            {
                case 1: deposit(sc);break;
                case 2: withdraw(sc);break;
                case 3: checkBalance(sc);break;
                case 4: statement(sc);break;
                case 5: editProfile(sc);break;
                case 6: System.exit(0);
                default : System.out.println("Wrong option entered");
            }
        }
    }
    public static void deposit(Scanner sc)
    {
        System.out.println("  ****Deposit Amount****   ");
        System.out.println();
        System.out.print(" Enter the amount : ");
        double depositAmount=sc.nextDouble();
        bal+=depositAmount;
        statement.add("Deposit : " +depositAmount);
        System.out.println();
        System.out.println("Amount Deposited Successfully");
    }
    public static void withdraw(Scanner sc)
    {
        for (int i=1;i<=3;i++)
        {
            System.out.println("  *******Withdraw Amount******     ");
            System.out.println();
            System.out.print("Enter the amount : ");
            double withdrawAmount= sc.nextDouble();
            System.out.println("Enter your pin : ");
            int pin1 = sc.nextInt();
            if(pin==pin1)
            {
                if(withdrawAmount<=bal)
                {
                    bal -= withdrawAmount;
                    statement.add("Withdraw : " + withdrawAmount);
                    System.out.println("Amount debited successfully");
                }
                else 
                {
                    System.out.println(" Insufficient Funds");
                }
                return;
            }
            else 
            {
                System.out.println();
                System.out.println("Wrong pin entered");
            }
        }
        System.out.println();
        System.out.println(" Your account has been deactivated for 24 hours");
        System.exit(0);
    }
    public static void checkBalance(Scanner sc)
    {
        for(int i=1;i<=3;i++)
        {
            System.out.println("  *****CHECK BALANCE******");
            System.out.println("Enter your pin :");
            int pin1=sc.nextInt();
            if(pin==pin1)
            {
                System.out.println();
                System.out.println("Account balance is : " + bal + "rs");
                return;
            }
            else
            {
                System.out.println();
                System.out.println(" Wrong pin entered");
            }
        }
        System.out.println();
        System.out.println("Your account has been deactivated for 24 hours");
        System.exit(0);
    }
    public static void statement(Scanner sc)
    {
        System.out.println("   *******Statement******   ");
        System.out.println();
        for(String tran:statement)
        {
            System.out.println(tran);
        }
    }
    public static void editProfile(Scanner sc)
    {   
        for ( ; ; )
        {
           System.out.println("    *******Edit Profile Module******    ");
           System.out.println();
           System.out.println("Edit Options");
           System.out.println();
           System.out.println("1. Name");
           System.out.println("2. Mobile");
           System.out.println("3. Address");
           System.out.println("4.Pin");
           System.out.println("Enter an Option ");
           int option= sc.nextInt();
           switch (option)
            {
             case 1: newUserName(sc);break;
             case 2: newMobile(sc);break;
             case 3: newAddress(sc);break;
             case 4: newPin(sc);break;
             default: System.out.println("Wrong otion entered");
           }
        }
    }
    public static void newUserName(Scanner sc)
    {
        System.out.println("New Usernname :");
        sc.nextLine();
        String newUsername= sc.nextLine();
        username=newUsername;
        System.out.println("Enter your pin :");
        int pin1= sc.nextInt();
        if(pin==pin1)
        {
            System.out.println(" Username changed successfully ");

        }
        else 
        {
            System.out.println("wrong pin entered");
        }

    }
    public static void newMobile(Scanner sc)
    {
        System.out.println("New mobile :");
        long newMobile= sc.nextLong();
        mobile=newMobile;
        System.out.println("Enter your pin :");
        int pin1= sc.nextInt();
        if(pin==pin1)
        {
            System.out.println(" Mobile changed successfully ");

        }
        else 
        {
            System.out.println("wrong pin entered");
        }
        
    }
    public static void newAddress(Scanner sc)
    {
        System.out.println("New address :");
        String newAddress= sc.nextLine();
        address=newAddress;
        System.out.println("Enter your pin :");
        int pin1= sc.nextInt();
        if(pin==pin1)
        {
            System.out.println(" Address changed successfully ");

        }
        else 
        {
            System.out.println("wrong pin entered");
        }
        
    }
    public static void newPin(Scanner sc)
    {
        System.out.println("New Pin :");
        int newPin= sc.nextInt();
        pin=newPin;
        System.out.println("Enter your mobile :");
        long mobile1= sc.nextLong();
        if(mobile==mobile1)
        {
            System.out.println(" Pin changed successfully ");

        }
        else 
        {
            System.out.println("wrong mobile entered");
        }
        
    }

}