package com.pls.model.labtests;


import com.pls.dao.GenericDAO;

public class QuickInsertTest
{

	//Program logic for the "New Test Wizard"
	
	public static void main(String args[])
	{
		//A new test needs to be created: this bean will be used by the DAO
		META_LABTEST_BEAN testMetaBean = new META_LABTEST_BEAN();
		
		//User enters test-name and number of rows
		//During deployment, this will be in the form of a JDialogBox
		
			String testName = "Haematology";
		
			int rows = 2;			
			
		//A form should be displayed and entered values will be inserted into appropriate ArrayList 
		//During deployment, this will be in the form of a JPanel with required number of fields
			
			//TODO URGENT dynamically create jPanelForm with appropriate number of jTextFields
		
			testMetaBean.setName(testName);
			testMetaBean.setRows(rows);
			
			testMetaBean.getField_titles_list().add("WBC");
			testMetaBean.getField_min_list().add("10");
			testMetaBean.getField_max_list().add("100");
			testMetaBean.getField_unit_list().add("mil/ml");
			
			testMetaBean.getField_titles_list().add("RBC");
			testMetaBean.getField_min_list().add("80");
			testMetaBean.getField_max_list().add("1000");
			testMetaBean.getField_unit_list().add("mil/ml");

			
		//Activate DB action
		com.pls.dao.GenericDAO dao = new GenericDAO();
		dao.insertNew(testMetaBean);
		
		
		//Success
		System.out.println("Success!  . . . . . . . . Performing System.exit()");
		System.exit(1);
	}
}
