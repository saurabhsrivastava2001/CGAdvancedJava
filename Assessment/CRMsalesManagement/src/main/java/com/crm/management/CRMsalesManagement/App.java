package com.crm.management.CRMsalesManagement;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.crm.entities.Address;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfgConfiguration= new Configuration().configure();
        SessionFactory sessionFactory=cfgConfiguration.buildSessionFactory();
        Session session=sessionFactory.openSession();
                 CustomerService customerService =
                     new CustomerService(session);

                 ProductServices productService =
                     new ProductServices(session);

                 OrderService orderService =
                     new OrderService(session);

                

                 Scanner sc = new Scanner(System.in);

                 while(true){

                	    System.out.println("\n--- CRM MENU ---");
                	    System.out.println("1 Register Customer");
                	    System.out.println("2 Add Address to Customer");
                	    System.out.println("3 Update Customer");
                	    System.out.println("4 Delete Customer");
                	    System.out.println("5 View Customer");
                	    System.out.println("6 View All Customers");
                	    System.out.println("7 Add Product");
                	    System.out.println("8 Place Order");
                	    System.out.println("9 Exit");

                	    int ch = sc.nextInt();

                	    switch(ch){

                	    case 1:
                	        System.out.print("Name: ");
                	        String name = sc.next();
                	        System.out.print("Email: ");
                	        String email = sc.next();
                	        System.out.print("Phone: ");
                	        String phone = sc.next();
                	        customerService.registerCustomer(name,email,phone);
                	        break;

                	    case 2:
                	        System.out.print("Customer Id: ");
                	        Long cid = sc.nextLong();

                	        Address a = new Address();
                	        System.out.print("Street: ");
                	        a.setStreet(sc.next());
                	        System.out.print("City: ");
                	        a.setCity(sc.next());
                	        System.out.print("State: ");
                	        a.setState(sc.next());
                	        System.out.print("Zip: ");
                	        a.setZipCode(sc.next());

                	        customerService.addAddressToCustomer(cid,a);
                	        break;

                	    case 3:
                	        System.out.print("Customer Id: ");
                	        Long uid = sc.nextLong();
                	        customerService.updateCustomer(uid);
                	        break;

                	    case 4:
                	        System.out.print("Customer Id: ");
                	        Long did = sc.nextLong();
                	        customerService.deleteCustomer(did);
                	        break;

                	    case 5:
                	        System.out.print("Customer Id: ");
                	        Long vid = sc.nextLong();
                	        customerService.viewCustomer(vid);
                	        break;

                	    case 6:
                	        customerService.viewAllCustomers();
                	        break;

                	    case 7:
                	        System.out.print("Product Name: ");
                	        String pname = sc.next();
                	        System.out.print("Price: ");
                	        double price = sc.nextDouble();
                	        productService.addProduct(pname,price);
                	        break;

                	    case 8:
                	        System.out.print("Customer Id: ");
                	        Long ocid = sc.nextLong();

                	        System.out.println("Enter order date (yyyy-MM-dd): ");
                	        String dateString = sc.next();

                	        System.out.print("How many products: ");
                	        int n = sc.nextInt();

                	        List<Long> pids = new ArrayList<>();
                	        for(int i=0;i<n;i++){
                	            pids.add(sc.nextLong());
                	        }

                	        orderService.placeOrder(ocid,dateString,pids);
                	        break;

                	    case 9:
                	        session.close();
                	        sessionFactory.close();
                	        System.exit(0);
                	    }
                	}
                 }
             }
         
 

