package com.crm.management.CRMsalesManagement;
import org.hibernate.Session;

import com.crm.entities.*;

import jakarta.persistence.*;

public class ProductServices {

    private Session session;

    public ProductServices(Session session){
        this.session=session;
    }

    public void addProduct(String name,double price){
        EntityTransaction tx = session.getTransaction();
        try{
            tx.begin();

            Product p = new Product();
            p.setName(name);
            p.setPrice(price);

            session.persist(p);

            tx.commit();
            System.out.println("Product added");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}