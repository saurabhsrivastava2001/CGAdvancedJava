package com.saurabh.ManyToMany;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg=new Configuration();
        SessionFactory sessionFactory=cfg.configure().buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction=session.beginTransaction();
        
        Course c1=new Course();
        c1.setCourseName("JUnit");
        
        Course c2=new Course();
        c2.setCourseName("Mockito");
        
        Student s1 = new Student();
        s1.setName("Saurabh");
        s1.setCourses(new ArrayList<>(Arrays.asList(c1,c2)));
        
        session.persist(s1);
        transaction.commit();
        
        
    }
}










