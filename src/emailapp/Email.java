package emailapp;
import java.util.*;
import java.io.*;
import java.lang.*;
public class Email {
    public Scanner s = new Scanner(System.in); //Scanner class
    //Setting Variables(as private) for security reasons
    private String First_Name;
    private String Last_Name;
    private String Dept;
    private String email;
    private String Password;
    private int mailCapacity = 500 ;
    private String alter_Email;
    //Constructor for receiving first name , lats name
    public Email(String First_Name, String Last_Name){
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        System.out.println("New employee:" + this.First_Name + this.Last_Name);
        //Calling methods
        this.Dept = this.setDept();
        this.Password = this.generate_password(12);//Password
        this.email = this.generate_email(); //email generation
    }
    //Email Generation
    private String generate_email(){
        return this.First_Name.toLowerCase() + "." + this.Last_Name.toLowerCase() + "@" + this.Dept.toLowerCase() + "company.com";
    }
    //Ask for Department
    private String setDept(){
        System.out.println("DEPARTMENT CODES:\n1 Sales\n2 Development\n3 Accounting\n0 None");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code:");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                     return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice");
            }
        }while (!flag);
        return null;
    }
    //Generate Random Password
    private String generate_password(int length){
        Random r = new Random();
        String Capital_Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_Chars = "abcdefghijklmnopqrstuvwxyz";
        String Number = "1234567890";
        String Symbols = "!@#$%^&*(){}}<>?,./";
        String values = Capital_Chars + Small_Chars + Number + Symbols;
        String password = "";
        for (int i = 0; i< length; i++){
            password =password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    //Change Password Method
    public void set_password(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password?(Y/N)");
            char choice = s.next().charAt(0);
            if (choice== 'Y' || choice == 'y'){
                flag = true;
                System.out.println("Enter Current Password");
                String temp = s.next();
                if(temp.equals(this.Password)){
                    System.out.println("Enter new Password");
                    this.Password = s.next();
                    System.out.println("Password changed Successfuly");

                }
                else{
                    System.out.println("Incorrect Password");
                }

            }else if(choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("Password changed option cancelled");
            }
            else{
                System.out.println("Please Enter Valid Password");
            }
        }while(!flag);
    }
    //Set mailbox Capacity Method
    public void Set_mailCap(){
        System.out.println("Current Capacity ="+ this.mailCapacity+"mb");
        System.out.println("Enter New MailBox Capacity ");
        this.mailCapacity = s.nextInt();
        System.out.println("Your MailBox Capacity Has Changed.");
    }
    //set Alternate Email
    public void alternate_Email(){
        System.out.println("Enter new Alternate Email");
        this.alter_Email =s.next();
        System.out.println("Alternat Email is Set");
    }
    //Display user Info
    public void getInfo(){
        System.out.println("New" + this.First_Name + " " + this.Last_Name);
        System.out.println("DEPARTMENT:" + this.Dept);
        System.out.println("Email" + this.email);
        System.out.println("Mailbox Capacity" + this.mailCapacity);
        System.out.println("Alternate Email"+ this.alter_Email);

    }

}
