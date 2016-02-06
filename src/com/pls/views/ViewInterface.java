package com.pls.views;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface ViewInterface
{
	//Facilitates attaching an ActionListener to a JButton
	public void addButtonActionListener(ActionListener listener, JButton jButton);
	
	//Initializations in a view
	//public void initView();
}