package emailapp;
import com.sun.source.tree.WhileLoopTree;

import java.sql.Struct;
import java.util.*;
import java.io.*;
public class Email  {
    public  Scanner s= new Scanner(System.in);
    //Setting variables as private to not give directly
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity=500;
    private String alter_email;

    //constructor to receive first name , last name
    public Email(String fname,String lname){
        this.fname=fname;
        this.lname=lname;
        System.out.println("new Employee:"+this.fname+""+this.lname);
        this.dept=this.setDept();
        this.password=this.generatea_password(8);
        this.email=this.generate_email();




    }
    //Genrate mail method
    private String generate_email(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+dept.toLowerCase();
    }
    //Asking for department
    private String  setDept(){
        System.out.println("Department codes \n1 for sales \n2 for devolopment\n3 for Accounting \n0 ");
        boolean flag=false;
        do {
            System.out.println("Enter department code");
            int cohoce=s.nextInt();
            switch (cohoce){
                case 1:
                    return "Sales";
                case  2:
                    return "Devolopment";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Dogru secim yapınız");
            }
        } while (!flag);

        return null;
    }
    // Generate random password metod
    private  String generatea_password(int lenght){

        Random r=new Random();
        String Capital_chars="ABCVZXNDJHFYRIOQPERMSKYT";
        String Small_chars="asdfghjklqwertyuıopzxcvbnm";
        String  num="123456789";
        String symbols="!'^+%&/()?";
        String values= Capital_chars+Small_chars+num+symbols;

        for (int i=0;i<lenght;i++){
            password=password+values.charAt(r.nextInt(values.length()));
        }
        return password;

    }

    //change password method

    public void set_password(){
        boolean flag =false;
        do{
            System.out.println("şifre değiştirmek istiyormusunuz!(E/H)");
            char choice=s.next().charAt(0);
            if (choice=='E'||choice=='e'){
                flag=true;
                System.out.println("eski şifrenizi giriniz");
                String temp=s.next();
                if (temp.equals(this.password)){
                    System.out.println("yeni şifrenizi giriniz");
                    this.password=s.next();
                    System.out.println("şifre değiştirildi");
                }
                else {
                    System.out.println("eski şifrenizi doğru giriniz!");
                }
            }
            else if (choice=='H'|| choice=='h'){
                flag=true;
                System.out.println("eski şifrenizde kaldınız");
            }
            else {
                System.out.println("Dogru giriş seçimini apınız");
            }

        }while (!flag);

    }
    public void set_mailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.print("Enter new capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");

    }

    // Set the alternate email
    public void alternate_email() {
        System.out.print("Enter new alternate email: ");
        this.alter_email = s.next();
        System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
    }

    // Displaying the employee's information
    public void getInfo() {
        System.out.println("NAME: " + this.fname + " " + this.lname);
        System.out.println("DEPARTMENT: " + this.dept);
        System.out.println("EMAIL: " + this.email);
        System.out.println("PASSWORD: " + this.password);
        System.out.println("MAILBOX CAPACITY: " + this.mailCapacity + "mb");
        System.out.println("ALTER EMAIL: " + this.alter_email);
    }

    public void storefile() {
        try {
            FileWriter in = new FileWriter("C:\\javaYou\\Info.txt");
            in.write("First Name: "+this.fname);
            in.append("Last Name: "+this.lname);
            in.append("Email: "+this.email);
            in.append("Password: "+this.password);
            in.append("Capacity: "+this.mailCapacity);
            in.append("Alternate mail: "+this.alter_email);
            in.close();
            System.out.println("Stored..");
        }catch (Exception e){System.out.println(e);}
    }



    public void read_file() {
        try {
            FileReader f1 = new
                    FileReader("C:\\javaYou\\Info.txt");
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }
}
