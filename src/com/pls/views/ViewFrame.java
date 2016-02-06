package com.pls.views;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewFrame extends JFrame implements ViewInterface
{
	public void addButtonActionListener(ActionListener listener, JButton jButton)
	{
		jButton.addActionListener(listener);
	}
}