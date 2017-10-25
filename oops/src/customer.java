/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// no inheritance 
// for online -> hostel delivery send parameter dine in -> char y hostel  -> bool delivery
package dbms.project;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AMRITHA ANIL
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author AMRITHA ANIL
 */

    
 public class customer 
 {
    
   public String c_id;
    String c_name;
    String c_address;
    String c_phone;
    boolean bill_paid;
    // enum mode
    void get_customer()
    {
       Scanner scn= new Scanner(System.in); 
       System.out.println("Enter the customer details:");
       System.out.println("Name : ");
       this.c_name=scn.next();
       System.out.println("Rol no:");
       this.c_id=scn.next();
       System.out.println("Address : ");
       this.c_address=scn.next();
       System.out.println("Phone no : ");
       this.c_phone=scn.next(); 
       scn.close();
    }
    void put_customer()
   {
       System.out.println("The customer details are: ");
       System.out.println("Name: "+ this.c_name);
       System.out.println("Roll no: "+ this.c_id);
       System.out.println("Address: "+ this.c_address);
       System.out.println("Phone: "+ this.c_phone);      
   }
    
 }
