package com.pls.model.labtests;

import com.pls.dao.GenericDAO;

public class QuickReadTest
{
	public static void main(String args[])
	{
		GenericDAO dao = new GenericDAO();
		
		//Name of test is provided, all associated info is to be displayed
		
			String testName = "Haematology1";
		
			//Use testName as the pkey to pull testMetaBean object
			META_LABTEST_BEAN testMetaBean = new META_LABTEST_BEAN();
			testMetaBean = (META_LABTEST_BEAN) dao.retrieve(testMetaBean.getClass(), testName);
			
			//List<String> outList = testMetaBean.getField_titles();
			
			//Print the results
			System.out.print(testMetaBean.getName());
			System.out.println(" has " + testMetaBean.getRows() + " number of fields as bellow:");
			//for(String fieldVal : outList)
			//{
			//	System.out.println(fieldVal);
			//}


			//All is well, exit
			System.exit(1);
	}
}
