/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.project;

/**
 *
 * @author AMRITHA ANIL
 */
import java.util.*;
import java.io.*;
import static javafx.application.Platform.exit;

public class admin_access {
    
  
    
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner scn= new Scanner(System.in);
        admin a= new admin();
        boolean b;
        b=a.passwordchecker();
        if(b==true)
        {    
            a.display_mainmenu();
            int chh;
            chh=scn.nextInt();
            int x=1;
            while(x==1){           
                switch(chh)
                {
                    case 1 : a.add_order(); break;
                    case 2 : a.add_member(); break;
                    case 3 : a.generate_bill();break;
                    case 4 : a.manage_staff(); break;
                    case 5 : a.manage_menu(); break;
                    default: System.out.println("You entered invalid choice");
                }
                System.out.println("Do you want to enter again? Y->1/N->0");
                x=scn.nextInt();
            }
        }
        else
        {
            System.out.println("You have been denied access  to the system");
            exit();
            
        }
       
                    
   }
    
}
