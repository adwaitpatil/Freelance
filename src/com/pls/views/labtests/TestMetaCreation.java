package com.pls.views.labtests;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

import com.pls.dao.GenericDAO;
import com.pls.model.labtests.META_LABTEST_BEAN;

import javax.swing.JOptionPane;


/*
 *This component is an independent module hosted on a JPanel. 
 * It's only function is to add new test types into the META_TABLES
 */


@SuppressWarnings("serial")
public class TestMetaCreation extends JPanel
{
	int MAX_FIELDS = 8;
	public static GenericDAO dao = new GenericDAO();
	META_LABTEST_BEAN metaLabtestBean = new META_LABTEST_BEAN();
	
	
	JLabel lblTestName = new JLabel("Test Name");
	JTextField txtTestName = new JTextField("TEST NAME");
	JLabel lblNmberOfFields = new JLabel("Number of fields");
	final Choice choice = new Choice();
	JButton btnOk = new JButton("OK");
	
	JLabel lblFieldTitle = new JLabel("Field Title");
	JLabel lblFieldMinimum = new JLabel("Field Minimum Value");
	JLabel lblFieldMaximum = new JLabel("Field Maximim Value");
	JLabel lblFieldUnit = new JLabel("Field Unit");
	
	//Data entry JTextFields
	JTextField[] txtTitleVals = new JTextField[MAX_FIELDS];
	JTextField[] txtMinVals = new JTextField[MAX_FIELDS];
	JTextField[] txtMaxVals = new JTextField[MAX_FIELDS];
	JTextField[] txtUnitsVals = new JTextField[MAX_FIELDS];
	
	JButton btnReset = new JButton("Reset");
	JButton btnSave = new JButton("Save");
	
	/**
	 * Create the panel.
	 */
	public TestMetaCreation()
	{
		/* A FormLayout with 25 rows and 5 columns*/
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		//Initial Input from user
		add(lblTestName, "2, 4");
		add(txtTestName, "4, 4");
		add(lblNmberOfFields, "6, 4");
		add(choice, "8, 4");
		
		//Controller action
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				okController();
			}
		});
		
		add(btnOk, "10, 4");
		
		//Column headings JTitles for this form
		add(lblFieldTitle, "2, 8");
		add(lblFieldMinimum, "4, 8");
		add(lblFieldMaximum, "6, 8");
		add(lblFieldUnit, "8, 8");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hideAllFields();
			}
		});
		
		add(btnReset, "4, 26");
		btnSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveController();
			}
		});
		add(btnSave, "8, 26");


		//The colno and String offsets are used to prevent ConstraintException violation caused by JGoodies restrictions
		String colno = null;
		for(int i=0 ; i<MAX_FIELDS ; i++)
		{
			colno = Integer.toString(10+(2*i));
			String titleOffsets = "2," + colno ;
			String minOffsets = "4," + colno ;
			String maxOffsets = "6," + colno ;
			String unitOffsets = "8," + colno ;
			
			System.out.println("DEBUG of OFFSETS: " + titleOffsets);
			
			txtTitleVals[i] = new JTextField();
			txtTitleVals[i].setText("title_" + Integer.toString(i));
			txtTitleVals[i].setVisible(false);
			add(txtTitleVals[i],titleOffsets);
			
			txtMinVals[i] = new JTextField();
			txtMinVals[i].setText("0");
			txtMinVals[i].setVisible(false);
			add(txtMinVals[i],minOffsets);
			
			txtMaxVals[i] = new JTextField();
			txtMaxVals[i].setText("1");
			txtMaxVals[i].setVisible(false);
			add(txtMaxVals[i],maxOffsets);
			
			txtUnitsVals[i] = new JTextField();
			txtUnitsVals[i].setText("units");
			txtUnitsVals[i].setVisible(false);
			add(txtUnitsVals[i],unitOffsets);
		}
		
		//Initializing choice list
		for(int i=1 ; i<MAX_FIELDS ; i++)
			choice.add(Integer.toString(i));
		
		hideAllFields();
	}
	
	public void okController()
	{
		
		String testNameText = this.txtTestName.getText();
		int rowCount = Integer.parseInt(this.choice.getSelectedItem());
		
		//Check1: If test name already exists
		if(dao.isExist(metaLabtestBean.getClass(),testNameText) == true)
		{
			JOptionPane.showMessageDialog(null, testNameText + " already exists in database!");
			hideAllFields();
			return;
		}
		
		//All checks are clear, hide previous fields, show relevant form
		hideAllFields();
		for(int i=0 ; i<rowCount ; i++)
		{
			txtTitleVals[i].setVisible(true);
			txtMinVals[i].setVisible(true);
			txtMaxVals[i].setVisible(true);
			txtUnitsVals[i].setVisible(true);
		}
		btnReset.setEnabled(true);
		btnSave.setEnabled(true);
		this.revalidate();
		this.repaint();
	}
	
	public void saveController()
	{
		String testNameText = this.txtTestName.getText();
		int rowCount = Integer.parseInt(this.choice.getSelectedItem());
		
		//TODO: Validation
		
		metaLabtestBean.setName(testNameText);
		metaLabtestBean.setRows(rowCount);
		for(int i=0 ; i< rowCount ; i++)
		{
			metaLabtestBean.getField_titles_list().add(txtTitleVals[i].getText());
			metaLabtestBean.getField_min_list().add(txtMinVals[i].getText());
			metaLabtestBean.getField_max_list().add(txtMaxVals[i].getText());
			metaLabtestBean.getField_unit_list().add(txtUnitsVals[i].getText());
		}
		
		if(dao.insertNew(metaLabtestBean) == true)
			JOptionPane.showMessageDialog(null, testNameText + " successfully added to database: check the database");
		hideAllFields();
	}
	
	public void hideAllFields()
	{
		for(int i=0 ; i<MAX_FIELDS ; i++)
		{
			txtTitleVals[i].setVisible(false);
			txtMinVals[i].setVisible(false);
			txtMaxVals[i].setVisible(false);
			txtUnitsVals[i].setVisible(false);
			btnReset.setEnabled(false);
			btnSave.setEnabled(false);
		}
		this.revalidate();
		this.repaint();
	}
}
