/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms.project;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AMRITHA ANIL
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class admin {
    
    Scanner scn=new Scanner(System.in);
      final String syspass;
           admin(){
               syspass="abcd";
           }
   
    
     public boolean passwordchecker()
    {
        Scanner scn= new Scanner(System.in);
        System.out.println("Confirm Your Authorisation");
        Console c=System.console();
        System.out.println("Enter the password");
        char[] ch=c.readPassword();
        String upass=String.valueOf(ch);
        if(syspass.equals(upass)==true)
            return true;
        else return false;
        
    }
    public void add_member() throws IOException, ClassNotFoundException
    {
        customer c= new customer();
        c.get_customer();
        
            FileInputStream fin;
            FileOutputStream fout;
            try 
            {
               cust_array cst=new cust_array();
               fin = new FileInputStream("customer.txt");
               ObjectInputStream ofin;
               ofin = new ObjectInputStream(fin);
               cst=(cust_array) ofin.readObject();
               cst.cust.add(c);
               ofin.close();
               fin.close();
               fout=new FileOutputStream("customer.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(cst);
               ofout.close();
               fout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }          
        }
     public void add_food() throws IOException, ClassNotFoundException
    {
        eatable e= new eatable();
        e.get_food();
        
            FileInputStream fin;
            FileOutputStream fout;
            try 
            {
               food ff=new food();
               fin = new FileInputStream("food.txt");
               ObjectInputStream ofin;
               ofin = new ObjectInputStream(fin);
               ff=(food) ofin.readObject();
               ff.foodlist.add(e);
               ofin.close();
               fin.close();
               fout=new FileOutputStream("food.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  

    
    
    public void add_staff() throws IOException, ClassNotFoundException
    {
        staff_arr st= new staff_arr();
        chef c= new chef();
        servicemen s=new servicemen();
        System.out.println ("DO you want to add a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
             
            FileInputStream fin=null;
            FileOutputStream fout=null;
            ObjectInputStream ofin=null;
            ObjectOutputStream ofout=null;
            try 
            {
               
               fin = new FileInputStream("staff.txt");
               ofin = new ObjectInputStream(fin);
               st=(staff_arr) ofin.readObject();
               ofin.close();
               fin.close();
               if(x==1)
               {
                   c.get_staff();
                   st.chef_arr.add(c);
               }    
               else if(x==2)
               {
                   s.get_staff();
                   st.service_arr.add(s);
               }    
               fout=new FileOutputStream("staff.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(st);
               ofout.close();
               fout.close();
               
            } 
            catch (FileNotFoundException ex)
            {
                if(x!=2&&x!=3) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  

       
    public void delete_staff() throws IOException, ClassNotFoundException
    {
        staff_arr st= new staff_arr();
        chef c= new chef();
        servicemen s=new servicemen();
        System.out.println ("DO you want to delete a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
        System.out.println("Enter the staff id of that person");
        int did;
        did=scn.nextInt();
             
            FileInputStream fin=null;
            FileOutputStream fout=null;
            ObjectInputStream ofin=null;
            ObjectOutputStream ofout=null;
            try 
            {
               
               fin = new FileInputStream("staff.txt");
               ofin = new ObjectInputStream(fin);
               st=(staff_arr) ofin.readObject();
               ofin.close();
               fin.close();
               if(x==1)
               {
                   for(int i=0;i<st.chef_arr.size();i++)
                   {
                        if(st.chef_arr.get(i).s_id==did)   
                       {
                           st.chef_arr.remove(i);
                             break;
                       } 
                   }
               }    
               else if(x==2)
               {
                   for(int i=0;i<st.service_arr.size();i++){
                        if(st.service_arr.get(i).s_id==did)   
                       {
                           st.service_arr.remove(i);
                             break;
                       }                 
                   }    
               }
               fout=new FileOutputStream("staff.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(st);
               ofout.close();
               fout.close();
               
            } 
            catch(FileNotFoundException ex)
            {
                if(x!=2&&x!=3) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  
    
        public void modify_staff() throws IOException, ClassNotFoundException
    {
        staff_arr st= new staff_arr();
        chef c= new chef();
        servicemen s=new servicemen();
        System.out.println ("DO you want to modify a chef or a serviceman? 1-> chef 2-> service man");
        int x;
        x=scn.nextInt();
        System.out.println("Enter the staff id of that person");
        int did;
        did=scn.nextInt();
             
            FileInputStream fin=null;
            FileOutputStream fout=null;
            ObjectInputStream ofin=null;
            ObjectOutputStream ofout=null;
            try 
            {
               
               fin = new FileInputStream("staff.txt");
               ofin = new ObjectInputStream(fin);
               st=(staff_arr) ofin.readObject();
               ofin.close();
               fin.close();
               if(x==1)
               {
                   for(int i=0;i<st.chef_arr.size();i++)
                   {
                        if(st.chef_arr.get(i).s_id==did)   
                       {
                           st.chef_arr.remove(i);
                           c.get_staff();
                           st.chef_arr.add(c);
                             break;
                       } 
                   }
               }    
               else if(x==2)
               {
                   for(int i=0;i<st.service_arr.size();i++){
                        if(st.service_arr.get(i).s_id==did)   
                       {
                           st.service_arr.remove(i);
                           s.get_staff();
                           st.service_arr.add(s);
                             break;
                       }                 
                   }    
               }
               fout=new FileOutputStream("staff.txt");
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(st);
               ofout.close();
               fout.close();
               
            } 
            catch(FileNotFoundException ex)
            {
                if(x!=2&&x!=3) {System.out.println("invalid choice! Addition failed"); }
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        
    }  
    
    
    /**
     *
     * @param did
     */
    public void delete_food(int did) throws IOException, ClassNotFoundException
    {
        eatable e=new eatable();
        FileInputStream fin;
        FileOutputStream fout;
        try
        {
            food ff=new food();
            fin = new FileInputStream("food.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            ff=(food) ofin.readObject();
            for(int i=0;i<ff.foodlist.size();i++)
            {
                if(ff.foodlist.get(i).dish_id==did)
                {
                    ff.foodlist.remove(i);
                    break;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("food.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
   public void modify_food(int did) throws IOException, ClassNotFoundException
    {
        eatable e=new eatable();
        FileInputStream fin;
        FileOutputStream fout;
        try
        {
            food ff=new food();
            fin = new FileInputStream("food.txt");
            ObjectInputStream ofin;
            ofin = new ObjectInputStream(fin);
            ff=(food) ofin.readObject();
            for(int i=0;i<ff.foodlist.size();i++)
            {
                if(ff.foodlist.get(i).dish_id==did)
                {
                    ff.foodlist.remove(i);
                    System.out.println("Enter the new details of the dish item");
                    e.get_food();
                    ff.foodlist.add(e);
                    break;
                }
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("food.txt");
               ObjectOutputStream ofout;
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(ff);
               ofout.close();
               fout.close();
            
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            } 
        
    }
   
   

    // add modiy and delete staff to be written
   
   public void manage_staff() throws IOException, ClassNotFoundException
    {
        // clrscr
        
        System.out.println("Select an operation to be performed");
        int ch;
        System.out.println("1-> Add staff");
        System.out.println("2-> Delete staff");
        System.out.println("3-> Modify staff");
        System.out.println("Enter your choice");
        ch=scn.nextInt();
        switch(ch)
        {
            case 1 : { add_staff(); break;}
            case 2 : { System.out.println("Enter the id number of the staff you want to delete");
                        int d; d=scn.nextInt();
                        dele
                                
                                te_staff(d);break;}
            case 3 : { System.out.println("Enter the id number of the staff you want to modify");
                        int d; d= scn.nextInt();
                        modify_staff(d); break; }
            default : System.out.println("Wrong choice entered!"); break;
            }
            
        }
   
   
   
    public void display_mainmenu()
    {
        System.out.println("WELCOME TO NSIT CAFETRIA");
        System.out.println("\nThe options are: ");
        System.out.println("\t1. Add order");
        System.out.println("\t2. Add member");
        System.out.println("\t3. generte bill");
        System.out.println("\t4. manage staff");
        System.out.println("\t5. manage canteen menu");
        System.out.println("\nEnter Your Choice: ");
    }
    
    public void manage_menu() throws IOException, ClassNotFoundException
    {
         // clrscr
        System.out.println("Select an operation to be performed");
        int ch;
        System.out.println("1-> Add menu");
        System.out.println("2-> Delete menu");
        System.out.println("3-> Modify menu");
        System.out.println("Enter your choice");
        ch=scn.nextInt();
        switch(ch)
        {
            case 1 : { add_food(); break;}
            case 2 : { System.out.println("Enter the dish id which you want to delete");
                        int d; d=scn.nextInt();
                        delete_food(d);break;}
            case 3 : { System.out.println("Enter the dish id which you want to modify");
                        int d; d= scn.nextInt();
                        modify_food(d); break; }
            default : System.out.println("Wrong choice entered!"); break;
            }
            
        }
    
 public void display_menu() throws IOException, ClassNotFoundException
    {
        
            FileInputStream fin = null;
            ObjectInputStream ofin = null;
            try 
            {
               food f=new food();
               fin = new FileInputStream("food.txt");
               
               ofin = new ObjectInputStream(fin);
               f=(food) ofin.readObject();
               for(int i=0;i<f.foodlist.size();i++){
                   System.out.print((i+1)+" ");
                   f.foodlist.get(i).display_food();
               }
               ofin.close();
               fin.close();
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex); 
               ofin.close();
               fin.close();
            }
    }
      
    public boolean check_member(String id) throws IOException, ClassNotFoundException
    {
        
            FileInputStream fin = null;
            ObjectInputStream ofin = null;
            boolean milaKya=false;
            try 
            {
               cust_array f=new cust_array();
               fin = new FileInputStream("customer.txt");
              
               ofin = new ObjectInputStream(fin);
               f=(cust_array) ofin.readObject();
               for(int i=0;i<f.cust.size();i++){
                    if(f.cust[i].c_id==id)
                        milaKya=true;
               }
               ofin.close();
               fin.close();
            } 
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        return milaKya;
    }
    public void add_order(String id) throws IOException, ClassNotFoundException
    {
        if (check_member(id)==false){
                add_member();
                display_menu();
                place_order(id);
            }
        else {
                display_menu(); 
                place_order(id);
        }
    }
    
    void manage_staff()
    
    void manage_menu()
    
    public void place_order(String id) throws IOException, ClassNotFoundException
    {   
        Scanner scn=new Scanner(System.in);
        int ch=1;
        String ss;
        food order=new food();
        FileInputStream fin=null;
        ObjectOutputStream ofout=null;
        ObjectInputStream ofin=null;
        cust_array d;
        FileOutputStream fout=new FileOutputStream(id);
        try{
            do
            {
                System.out.println("Enter the food id");
                ss=scn.next();
                food f=new food();
                fin = new FileInputStream("food.txt");
                ofin = new ObjectInputStream(fin);
                f=(food) ofin.readObject();
                for(int i=0;i<f.foodlist.size();i++){
                   if(f.foodlist[i].dish_id==ss){
                       order.foodlist.add(f.foodlist[i]);
                       break;
                   }
                }
                System.out.println("Do you want to order more?(Y=1/N=0)");
                ch=scn.nextInt();
            }while(ch==1);
             
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try 
            {
               
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(order);
               ofout.close();
               fout.close();
               
            } 
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
    }
    
    public void place_order(String id,boolean deliver) throws IOException, ClassNotFoundException
    {
        Scanner scn=new Scanner(System.in);
        int ch=1;
        String ss;
        food order=new food();
        FileInputStream fin=null;
        ObjectOutputStream ofout=null;
        ObjectInputStream ofin=null;
        cust_array d = null;
        FileOutputStream fout=null;
        try{
            do
            {
                System.out.println("Enter the food id");
                ss=scn.next();
                food f=new food();
                fin = new FileInputStream("food.txt");
                ofin = new ObjectInputStream(fin);
                f=(food) ofin.readObject();
                for(int i=0;i<f.foodlist.size();i++){
                   if(f.foodlist[i].dish_id==ss){
                       order.foodlist.add(f.foodlist[i]);
                       break;
                   }
                }
                System.out.println("Do you want to order more?(Y=1/N=0)");
                ch=scn.nextInt();
            }while(ch==1);
             
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try 
            {
                fout= new FileOutputStream(id);
               
               ofout= new ObjectOutputStream(fout);
               ofout.writeObject(order);
               ofout.close();
               fout.close();
               
            } 
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
        try{
            fin=new FileInputStream("customer.txt");
            cust_array cc= new cust_array();
            
            ofin = new ObjectInputStream(fin);        //wht if it is the first time we are adding?
            cc=(cust_array) ofin.readObject();
            customer b=new customer();
            for(int k=0;k<cc.cust.size();k++)
            {
                if(cc.cust.get(k).c_id==id)
                {
                   d.cust.add(cc.cust.get(k))   ;
                }
            }
        }
        catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofin.close();
                fin.close();
            }
        try{
            fout=new FileOutputStream("delivery");
            ofout= new ObjectOutputStream(fout);
            ofout.writeObject(d);
                                                                    
                                                                   
        }
         catch (FileNotFoundException ex)
            {
                Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                ofout.close();
                fout.close();
            }
    }
    
    public void generate_bill(String id) throws IOException, ClassNotFoundException // with print bill
    {
        float total=0;
        FileInputStream fin=null;
        FileOutputStream fout=null;
        ObjectInputStream ofin=null;
        ObjectOutputStream ofout=null;
        try{
            
            food f=new food();
            fin = new FileInputStream("id");
            
            ofin = new ObjectInputStream(fin);
            f=(food) ofin.readObject();
            for(int i=0;i<f.foodlist.size();i++)
            {
               System.out.println("   "+f.foodlist.get(i).dish_id + "    "+f.foodlist.get(i).dish_name+"    "+f.foodlist.get(i).price);
               total+=f.foodlist.get(i).price;
            }
            System.out.println("Your total bill amount is "+total);
            ofin.close();
            fin.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            ofin.close();
            fin.close();
        }
        System.out.println("Did he pay? y/n");
        Scanner scn=new Scanner(System.in);
        char ans;
        ans=scn.next().charAt(0);
        if(ans=='y'){
        try{
            cust_array cus=new cust_array();
            fin = new FileInputStream("Customer.txt");
            ofin = new ObjectInputStream(fin);
            cus=(cust_array) ofin.readObject();
            for(int i=0;i<cus.cust.size();i++){
                if(cus.cust.get(i).c_id==id)
                    cus.cust.remove(i);
            }
            ofin.close();
            fin.close();
            fout=new FileOutputStream("customer.txt");
            ofout= new ObjectOutputStream(fout);
            ofout.writeObject(cus);
            ofout.close();
            fout.close();
        }
        catch (FileNotFoundException ex){
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
            ofin.close();
            fin.close();
            ofout.close();
            fout.close();
        } 
        }
        
    }    
        
}