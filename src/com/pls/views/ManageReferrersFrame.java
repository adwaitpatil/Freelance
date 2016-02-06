package com.pls.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManageReferrersFrame extends JFrame
{
	
	private static final long serialVersionUID = 5357358967716742938L;
	
	//JComponents in frame
	public JPanel contentPane;
	public JMenuBar menuBar = new JMenuBar();
	public JSplitPane splitPane = new JSplitPane();
	public JPanel panelLHS = new JPanel();
	public JPanel panelRHS = new JPanel();
	public JButton btnListOfReferers = new JButton("List of Referers");
	public JButton btnAddNewReferer = new JButton("Add New Referer");
	public JLabel lblClickOnOne = new JLabel("Click on one of the options on the left");
	
	//Facilitates attaching an ActionListener to a JButton
	public void addButtonActionListener(ActionListener listener, JButton jButton)
	{
	    jButton.addActionListener(listener);
	}
	
	//Initialize the JFrame
	public ManageReferrersFrame()
	{
		setTitle("Manage Referers");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		splitPane.setLeftComponent(panelLHS);
		panelLHS.setLayout(new GridLayout(0, 1, 0, 0));
		panelLHS.add(btnListOfReferers);
		panelLHS.add(btnAddNewReferer);
		
		splitPane.setRightComponent(panelRHS);
		panelRHS.setLayout(new GridLayout(1, 0, 0, 0));
		lblClickOnOne.setHorizontalAlignment(SwingConstants.CENTER);
		panelRHS.add(lblClickOnOne);
	}

}
