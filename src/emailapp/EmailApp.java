package emailapp;
import java.util.*;
public class EmailApp {
    public  static void main(String[] args){
        Scanner s=new Scanner(System.in);
        //user info
        System.out.println("enter first name");
        String fname=s.next();
        System.out.println("Enter last name");
        String lastname=s.next();

        //creating obj for email
        Email em1= new Email(fname,lastname);
        int choice = -1;
        do {
            System.out.println("\n**********\nENTER YOUR CHOICE\n1.Show Info\n2.Change Password"
                    + "\n3.Change Mailbox Capacity\n4.Set Alternate Email\n5.Store data in file\n6.Show file\n7.Exit");
            choice = s.nextInt();
            switch(choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    em1.storefile();
                    break;
                case 6:
                    em1.read_file();
                    break;
                case 7:
                    System.out.println("\nTHANKS!!!");
                    break;
                default:
                    System.out.println("INVALID CHOICE! ENTER AGAIN!");
            }

        }while(choice!=7);


    }

}
