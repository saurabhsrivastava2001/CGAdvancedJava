package com.crm.management.CRMsalesManagement;


import com.crm.entities.*;
import jakarta.persistence.*;
import java.util.List;

import org.hibernate.Session;

public class OrderService {

    private Session session;

    public OrderService(Session session){
        this.session=session;
    }

    public void placeOrder(Long customerId,String orderDate, List<Long> productIds){
        EntityTransaction tx = session.getTransaction();
        try{
            tx.begin();

            Customer c = session.get(Customer.class, customerId);

            Order o = new Order();
            o.setCustomer(c);
            o.setOrderDate(orderDate);

            double total = 0;

            for(Long pid : productIds){
                Product p = session.find(Product.class, pid);
                o.getProducts().add(p);
                total += p.getPrice();
            }

            o.setTotalAmount(total);

            session.persist(o);

            tx.commit();
            System.out.println("Order placed");
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
    }
}
