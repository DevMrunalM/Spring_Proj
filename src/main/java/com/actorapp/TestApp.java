package com.actorapp;



import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Interact with session API to ask Hibernate to perform persistence
		 */
	

    	try
    	{
    		SessionFactory factory=new Configuration().configure().buildSessionFactory();
    		int ch=0;
    	Scanner sc1=new Scanner(System.in);
    	Scanner sc2=new Scanner(System.in);
    	while(ch!=5)
    	{
    		System.out.println("press 1 to create actor");
    		System.out.println("press 2 to list Actors");
    		System.out.println("press 3 to Update actor");
    		System.out.println("press 4 to delete actor");
    		System.out.println("press 5 to  exit");
    		ch=sc1.nextInt();
    		switch(ch)
    		{
    		case 1:System.out.println("creating Actor....");
    		System.out.println("enter the actor name");
        	String name=sc2.nextLine();
        	System.out.println("enter the dob");
        	String dob=sc2.nextLine();
        	System.out.println("enter the gender ");
        	String gender=sc2.nextLine();
        	System.out.println("enter the famous dailouge");
        	String famousd=sc2.nextLine();
        	Actor a=new Actor(name,dob,gender,famousd);
        	Session s1=factory.openSession();
            s1.beginTransaction();
             Long id=(Long)s1.save(a);
             System.out.println("generated pkey = "+id);
             s1.getTransaction().commit();
             s1.close();
            
    			break;
    			
    			
    		case 2:System.out.println("listing Actor....");
    		Session s3=factory.openSession();
    		s3.beginTransaction();
    		List<Actor> actors=s3.createQuery("from Actor").getResultList();
    		for(Actor x:actors)
    			System.out.println("name-"+x.getName()+" Dob"+x.getDob()+" gender-"+x.getGender()+" famous dialouge-"+x.getFamousD());
    		
    		
    		s3.getTransaction().commit();
    		s3.close();
    			break;
    		case 3:System.out.println("updating Actor....");
    		System.out.println("enter sl of the actor");
    		Long sl=sc1.nextLong();
    		Session s2=factory.openSession();
    		s2.beginTransaction();
    		Actor a2=s2.get(Actor.class,sl);
    		
    		
    		System.out.println("enter to change the DOB");
    		String dia=sc2.nextLine();
    		a2.setDob(dia);//dirty check
    		
    		System.out.println("enter to change the dialouge");
    		String di=sc2.nextLine();
    		a2.setFamousD(di);
    		s2.getTransaction().commit();
    		
    		s2.close();
    			break;
    		case 4:System.out.println("deleting Actor....");
    		System.out.println("enter sl of the actor");
    		Long sl1=sc1.nextLong();
    		Session s4=factory.openSession();
    		s4.beginTransaction();
    		Actor a3=s4.get(Actor.class,sl1);
    		s4.delete(a3);
    		s4.getTransaction().commit();
    		s4.close();
    		
    		
    			break;
    		case 5:System.out.println("tata bye bye... miss you");
    			break;
    		
    		}
    		factory.close();
    		
    	}
    	
    	
       
    	}
    	catch(Throwable t)
    	{
    		t.printStackTrace();
    	}
        
        
    }

	
}
