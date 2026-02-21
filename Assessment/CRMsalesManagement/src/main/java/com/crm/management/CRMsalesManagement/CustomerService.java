package com.crm.management.CRMsalesManagement;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crm.entities.*;



public class CustomerService {

    private Session session;

    public CustomerService(Session session){
        this.session=session;
    }

    public void registerCustomer(String name, String email, String phone){
        Transaction tx = session.beginTransaction();
        try{
            Customer c = new Customer();
            c.setName(name);
            c.setEmail(email);
            c.setPhone(phone);

            session.persist(c);

            tx.commit();
            System.out.println("Customer registered");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
    public void updateCustomer(Long id){

        Transaction tx = session.getTransaction();
        Scanner sc = new Scanner(System.in);

        try{
            tx.begin();

            Customer c = session.find(Customer.class, id);

            if(c == null){
                System.out.println("Customer not found");
                return;
            }

            System.out.println("What do you want to update?");
            System.out.println("1 Name");
            System.out.println("2 Email");
            System.out.println("3 Phone");

            int ch = sc.nextInt();
            sc.nextLine(); // consume

            switch(ch){

            case 1:
                System.out.print("Enter new name: ");
                c.setName(sc.nextLine());
                break;

            case 2:
                System.out.print("Enter new email: ");
                c.setEmail(sc.nextLine());
                break;

            case 3:
                System.out.print("Enter new phone: ");
                c.setPhone(sc.nextLine());
                break;

            default:
                System.out.println("Invalid choice");
                return;
            }

            tx.commit();
            System.out.println("Customer updated");

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
    public void viewCustomer(Long id){

        Customer c = session.find(Customer.class, id);

        if(c == null){
            System.out.println("Customer not found");
            return;
        }

        System.out.println("ID : " + c.getId());
        System.out.println("Name : " + c.getName());
        System.out.println("Email : " + c.getEmail());
        System.out.println("Phone : " + c.getPhone());

        if(c.getAddress()!=null){
            System.out.println("City : " + c.getAddress().getCity());
        }
    }
    public void deleteCustomer(Long id){

        Transaction tx = session.beginTransaction();

        try{
        
            Customer c = session.get(Customer.class, id);

            if(c == null){
                System.out.println("Customer not found");
                return;
            }

            session.remove(c);

            tx.commit();
            System.out.println("Customer deleted");

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
    
    public void viewAllCustomers(){

        List<Customer> list =
            session.createQuery("from Customer", Customer.class)
              .getResultList();

        for(Customer c : list){
            System.out.println(
                c.getId()+"  "+
                c.getName()+"  "+
                c.getEmail()
            );
        }
    }
    
    public void addAddressToCustomer(Long customerId, Address address){
        Transaction tx = session.beginTransaction();
        try{

            Customer c = session.find(Customer.class, customerId);
            c.setAddress(address);

            tx.commit();
            System.out.println("Address added");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}