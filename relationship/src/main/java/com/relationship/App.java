package com.relationship;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	  SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
   			   addAnnotatedClass(Instructor.class). addAnnotatedClass(Details.class).buildSessionFactory();
    	  
   	   Session session=factory.getCurrentSession();
        Details d = new Details();
        d.setYoutube("http://youtube.com/homie");
        d.setTwitter("http://twitter.com/homie");
        Instructor i = new Instructor();
        i.setFirstName("Ashik");
        i.setLastName("K");
        i.setEmail("ashbro@gmail.com");
        i.setDetails(d);
        session.getTransaction().begin();
        session.persist(d);
        session.persist(i);
        session.getTransaction().commit();
        session.close();
        
        
    }
}
