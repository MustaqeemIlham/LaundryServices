import java.util.*;
import java.text.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class mainApp {
    
    public static void clrscr() throws Exception
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\n\n\n\t\t\t<< Press ENTER to continue >> ");
		sc.nextLine();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}

    public static void menu()
	{
		System.out.println("\t\t\tPEARL SERVICE CUSTOMER MANAGEMENT SYSTEM");
		System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n\t\t\t1. Store new Customer");
		System.out.println("\t\t\t2. Display all Customer");
        System.out.println("\t\t\t3. Update Customer");
		System.out.println("\t\t\t4. Delete Customer");
        System.out.println("\t\t\t5. Display total charges for dry cleaning services");
        System.out.println("\t\t\t6. Display customer with highest and lowest charges");
        System.out.println("\t\t\t7. Search Customer");
		System.out.println("\t\t\t8. Exit");
		System.out.print("\n\t\t\tPlease input your choice >> ");
	}

    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        
        //System.out.print("Enter total customer :"); //temp variable
        int customerSize = 100;              //temp variable

        PearlService[] customers = new PearlService[customerSize];
        
        int custTotal = 0;
        double totalDryCharges = 0;
        
        for(;;) {
        
            menu();
            int choice = input.nextInt(); 
            input.nextLine();
            
            if( choice == 1) {
                if(custTotal == customers.length)
                {
                   System.out.println("\n\n\n\t\t\tThe storage limit has been reached! Please contact the IT Department.\n\n\n");
                   clrscr(); 
                }
                else
                {
                    System.out.print("\n\t\t\tCustomer ID : " + (custTotal + 1) + "\n");
                    System.out.print("\n\t\t\tPlease enter Customer Name >>> ");
                    String custName = input.nextLine();
                    
                    int id = custTotal + 1;
                    
                    System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                    String phoneNum = input.next();
        
                    System.out.print("\t\t\tPlease enter Customer's desired service (Dry / Normal)>>>");
                    String type = input.next();
                  
                        if(type.equalsIgnoreCase("Normal")) {
                            input.nextLine();
                             System.out.print("\t\t\tPlease Enter Quantity >>> ");
                             int quantity = input.nextInt();                                  
                                customers[custTotal] = new LaundryService(custName, id, phoneNum, type, "None", quantity);
                                custTotal++;
                                System.out.print("\n\t\t\t<< Data Stored Successfully >> ");
                                clrscr();
                        }  
                        else if(type.equalsIgnoreCase("Dry")) {
                                System.out.print("\t\t\tPlease Enter Cloth Type if neccessary (Baju Kurung/Melayu, Blazer, Jacket/Coat ) >>> ");
                                input.nextLine();
                                String clothType = input.nextLine();            
        
                                System.out.print("\t\t\tPlease Enter Quantity >>> ");
                                int quantity = input.nextInt();        
        
                                customers[custTotal] = new LaundryService(custName, id, phoneNum, type, clothType, quantity);
                                
                                totalDryCharges += customers[custTotal].calculateCharge();
                                
                                custTotal++;
                                System.out.print("\n\t\t\t<< Data Stored Success.fully >> ");
                                clrscr();
                        } else {
                            System.out.print("\n\t\t\t<< WRONG INPUT! PLEASE REPEAT >> ");
                            clrscr();
                        }
                    }
                    

                       
                    
                } else if(choice == 5) { 
                    System.out.print("\n\t\t\tTotal charges for Dry Cleaning is RM"); 
                    System.out.println(totalDryCharges);
                    clrscr();
               } else if(choice == 2) {
                 for(int i=0; i<custTotal; i++)
                {  if(customers[i] != null){
                    System.out.println(customers[i].toString());
                   }else
                     {
                          System.out.println("\t\t\tNo data found");
                          clrscr();  
                     }
                    
                       
                }
                
            } else if(choice == 6) {
                
                double highestCharge = 0;
                double lowestCharge = 999999;
                int custLowest = 999999;
                int custHighest = 0;
                
                
                for(int i=0; i<custTotal; i++)
                {                      
                   if(customers[i].calculateCharge() > highestCharge) {                       
                       highestCharge = customers[i].calculateCharge();        
                       custHighest = i;
                   }
                   
                   if(customers[i].calculateCharge() < lowestCharge) {                       
                       lowestCharge = customers[i].calculateCharge();      
                       custLowest = i;
                   }                    
                }
                
                System.out.println("\t\t\tCustomer with Highest Charge info");
                System.out.println("\t\t\t******************************************");
                System.out.println(customers[custHighest].toString());
                System.out.println("\t\t\t******************************************");
                System.out.println("\t\t\tCustomer with Lowest Charge info");
                System.out.println("\t\t\t******************************************");
                System.out.println(customers[custLowest].toString());
                System.out.println("\t\t\t******************************************\n");
                
                clrscr();  
            } else if(choice == 7) {
                
                int totalSearch = 0;
                
                System.out.println("\n\t\t\tCustomer Database");
                System.out.println("\t\t\tPress Enter if Not Related ");
                System.out.println("\t\t\t******************************************");
                
                System.out.print("\t\t\tPlease enter Customer Name >>> ");
                String custName = input.nextLine();

                System.out.print("\t\t\tPlease enter Customer's IC number >>> ");
                int IC = input.nextInt();
                    
                /*System.out.print("\t\t\tPlease enter Customer's phone number >>> ");
                String phoneNum = input.nextLine();*/            
                
                System.out.println("\n\t\t\t******************************************");
                System.out.println("\t\t\tResult");
                System.out.println("\t\t\t******************************************\n");
                for(int i=0; i<custTotal; i++)
                {     
                    if(customers[i].getCustName().equalsIgnoreCase(custName) && customers[i].getIC()==IC) {
                        System.out.println(customers[i].toString());
                        totalSearch++;
                     }

                }
                
                if(totalSearch == 0) {
                    System.out.println("\t\t\tNo Data found!");
                    System.out.println("\t\t\t******************************************\n");
                }
                
                else 
                    System.out.println("\t\t\t******************************************\n");
                
                clrscr();
                
            } else if(choice == 8) {
                 	System.out.println("\n\n\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.print("\t\t\tExiting.... ");
                    break;
            }else if(choice == 3){
                       System.out.print("\t\t\tEnter Customer ID >>>");
                       int IC = input.nextInt();
                       for(int b=0; b<custTotal; b++){
                              if(customers[b].getIC()==IC) {
                               
                                    System.out.print("\t\t\tEnter Customer Name >>>");
                                    input.nextLine();
                                    String name1 = input.nextLine();
                                    System.out.print("\t\t\tEnter Customer phone number >>>");
                                    String phone = input.nextLine();
                                    customers[b].setCustInfo(name1, IC, phone);
                              }
                       }
                         clrscr();
            }else if(choice == 4){
                System.out.print("\t\t\tEnter Customer ID >>>");
                       int IC = input.nextInt();
                       for(int b=0; b<custTotal; b++){
                              if(customers[b].getIC()==IC) {
                                    customers[b] = null;
                              }
                       }
            }
            else {
                  input.nextLine();
                  System.out.println("\n\n\n\t\t\tWrong input! Please re-enter your choice!\n\n\n");
                  clrscr();
            }
    }               
  }
}
