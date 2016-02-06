package com.pls.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*									CHANGES MADE ON 15/1/2016
 * 	THE RETRIVE FUNCTIONS DO NOT COMMIT OR CLOSE THE SESSION , TO ALLOW LAZY FETCH
 * 				WARNING: THIS WILL EVENTUALLY LEAD TO RESOURCE LEAKAGE
 * */






@Component("GDBean")
@Scope("singleton")
public class GenericDAO 
{ 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	public static int accessCount=0;
	
	public GenericDAO()
	{
			System.out.println("Constructing a GenericDAO instance ..... done!");
	}
	
	
	public Boolean insertNew(Object pObj)
	{
		debug();
		Session session = sessionFactory.openSession();
		
		try
		{
		 session.beginTransaction();
		 session.save(pObj);
		 session.getTransaction().commit();	 
		 session.close();
		}
		catch(org.hibernate.exception.ConstraintViolationException cve)
		{
			//Roll back
			session.getTransaction().rollback();
			session.close();
			//Stack trace not required			//e.printStackTrace();
			System.out.println("Caught ConstraintViolationException");
			System.out.println("Had to rollback! . . . Everything is fine");
			return false;
		}
		catch(Exception e)
		{
			//Roll back
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			System.out.println("Had to rollback!");
			return false;
		}
		return true;
	}
	
	
	 //Inserts or Updates the give
	 public Boolean insertUpdate(Object pObj)
	 {
		debug();
		Session session = sessionFactory.openSession();

		try
		{
		 session.beginTransaction();
		 session.saveOrUpdate(pObj);
		 session.getTransaction().commit();	 
		 session.close();
		}

		catch(Exception e)
		{
			//Roll back
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			System.out.println("Had to rollback!");
			return false;
		}
		return true;
	 }
	 
	 
	 
	//Just to check if Object with given pKey exists (String primary key)
	public Boolean isExist(Class<?> className, String pKey)
	{
		debug();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Object retObject = session.get(className, pKey);
		 session.close();
		 if(retObject == null)
			 return false;
		 else
			 return true;
	}
	
	

	 //Just to check if Object with given pKey exists (Integer primary key)
	 public Boolean isExist(Class<?> className, int pKey)
	 {
		 debug();
		 Session session = sessionFactory.openSession();
		 session.beginTransaction();
		 Object retObject = session.get(className, pKey);
		 session.close();
		 if(retObject == null)
			 return false;
		 else
			 return true;
	 }
	  
	 
	 
	 //Retrieve object with giver primary key (String primary key)
	 public Object retrieve(Class<?> className, String pKey)
	 {
		 debug();
		 Session session = sessionFactory.openSession();
		
		 Object retObject = null;
		 try
		 {
			 session.beginTransaction();
			 retObject = session.get(className, pKey);
			 //session.getTransaction().commit();
			 //session.close();
		 }
		 catch(Exception e)
		{
			//Roll back
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			System.out.println("Had to rollback!");
			return null;
		}
		 return retObject;
	 }
	 
	 
	 
	 //Retrieve object with given primary key (Integer primary key)
	 public Object retrieve(Class<?> className, int pKey)
	 {
		 debug();
		 Session session = sessionFactory.openSession();
		
		 Object retObject = null;
		 try
		 {
			 session.beginTransaction();
			 retObject = session.get(className, pKey);
			 //session.getTransaction().commit();
			 //session.close();
		 }
		 catch(Exception e)
		{
			//Roll back
			session.getTransaction().rollback();
			session.close();
			e.printStackTrace();
			System.out.println("Had to rollback!");
			return null;
		}
		 return retObject;
	 }
	 
	 
	 
	 //Removes given object from database
	 public Boolean remove(Object pObj)
	 {
		 debug();
		 Session session = sessionFactory.openSession();
		
		 try
		 {
			 session.beginTransaction();
			 session.delete(pObj);
			 session.getTransaction().commit();	 
			 session.close();
		 }
		 catch(Exception e)
		 {
			 //Roll back
			 session.getTransaction().rollback();
			 session.close();
			 e.printStackTrace();
			 System.out.println("Had to rollback!");
			 return false;
		 }
		 return true;
	 }
	 
	 //Debug operations
	 public void debug()
	 {
		 accessCount++;
		 System.out.println("Total number of access to DAO = " + accessCount);
	 }
}