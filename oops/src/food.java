/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author AMRITHA ANIL
 */

/**
 *
 * @author AMRITHA ANIL
 */
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class food
{
    ArrayList<eatable> foodlist;

    void add(eatable e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class eatable
{
    int dish_id;
    String dish_name;
    String cuisine;
    float price;
    String desc;
    public enum eatable_type{Starter, Main_course, Dessert, Beverage}
    boolean veg;
    eatable_type e;
    eatable()
    {
        this.dish_id=0;
        this.price=0; 
        
    }
   
    void get_food()
   {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the details");
        System.out.print("Dish id no: ");
        this.dish_id=scn.nextInt();
        System.out.println("Enter the course(1->starters 2->main course 3-> desserts 4->beverages)");
        int ch;
        ch=scn.nextInt();
        switch(ch)
        {
            case 1: e=e.Starter;break;
            case 2 : e=e.Main_course; break;
            case 3 :e=e.Dessert; break;
            case 4 : e=e.Beverage; break;
        }
        System.out.print("Dish name: ");
        this.dish_name=scn.next();
        System.out.print("Price: ");
        this.price=scn.nextInt();
        System.out.print("Cuisine: ");
        this.cuisine=scn.next();
        System.out.print("Description: ");
        this.desc=scn.next();
        scn.close();
    }
    void display_food()
    {
        System.out.println("The dish details are");
        System.out.println("Dish id no: ");
        System.out.print(this.dish_id);
        System.out.println("Course: ");
        System.out.print(e);
        System.out.println("Dish name: ");
        System.out.print(this.dish_name);
        System.out.println("Price: ");
        System.out.print(this.price);
        System.out.println("Cuisine: ");
        System.out.print(this.cuisine);
        System.out.println("Description: ");
        System.out.print(this.desc);
    }
  
}