package emailapp;
import java.util.*;


public class EmailApplication {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        //User info
        System.out.println("Enter First Name");
        String First_Name = s.next();
        System.out.println("Enter Last Name");
        String Last_Name = s.next();

        //Creating object for email class
        Email em1 = new Email(First_Name,Last_Name);
        int choice = -1;
        do{
            System.out.println("\n*****\nEnter your choice\n1Show Info\n2 Change Password\n3 Change Mailbox Capacity\n4 Set alternate mail\n5 Exit");
            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.Set_mailCap();
                    break;
                case 4:
                    em1.alternate_Email();
                    break;
                case 5:
                    System.out.println("Thank you for using our Application");
                    break;
                default:
                    System.out.println("Enter a valid choice");

            }
        }while (choice!=5);
    }
}
