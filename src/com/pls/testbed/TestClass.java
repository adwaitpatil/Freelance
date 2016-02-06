/*

package com.pls.testbed;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pls.dao.GenericDAO;
import com.pls.model.RefererBean;


public class TestClass 
{
	public static void main(String[] args) 
	{
		GenericDAO dao;
		
		//INIT()
		System.out.println("Performing INIT() . . . . . OK");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
		try
		{
			 dao = (GenericDAO) context.getBean("GDBean");
		}
		finally
		{
			((AbstractApplicationContext) context).close();
		}
		if(dao==null)
		{
			System.out.println("DAO is null >> PANIC >> EXIT");
			System.exit(1);
		}		
		System.out.println("INIT() finished! . . . . . OK");
		
		//Inserting record
		RefererBean doc = new RefererBean();
		doc.setRefererName("Doctor Dre");
		doc.setRefererCutRate(50);
			//doc.setRefererDesignation("MBBS");
			//doc.setNotes("Is not a real doctor");
		dao.insertUpdate(doc);
		System.out.println("Last ID = " + doc.getId());
		System.out.println("Inserted record . . . . . OK");
		
		//Retrieving record
		RefererBean ret = new RefererBean();
		for(int i=1; i<=doc.getId();i++)
		{
			ret = (RefererBean) dao.retrieve(RefererBean.class, i);
			System.out.println("\n"+ret.getId());
			System.out.println(ret.getRefererName());
			System.out.println(ret.getRefererCutRate());
			System.out.println("Retrieved record . . . . . OK");
		}
		
		System.out.println("\nExiting Successfully");
		System.gc();
		System.exit(1);
	}
}

*/