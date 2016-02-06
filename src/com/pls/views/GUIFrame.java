package com.pls.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JMenuItem;

import com.pls.views.labtests.TestMetaCreation;

public class GUIFrame extends ViewFrame
{
	private static final long serialVersionUID = 1394788978172818848L;
	JPanel contentPane;
	JPanel panelMenu;
	JPanel panelL;
	JPanel panelR;

	public GUIFrame()
	{
		//Content
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1024, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Top Panel and Menu
		panelMenu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelMenu.getLayout();
		flowLayout.setHgap(100);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelMenu.setBorder(new LineBorder(new Color(255, 255, 0), 2));
		contentPane.add(panelMenu, BorderLayout.NORTH);
		JMenuBar menuBar = new JMenuBar();
		panelMenu.add(menuBar);
		JMenu mnFile = new JMenu("            File            ");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnFile);
		JMenuItem mntmOpen = new JMenuItem("            Open            ");
		mnFile.add(mntmOpen);
		JMenuItem mntmClose = new JMenuItem("            Close            ");
		mnFile.add(mntmClose);
		JMenuItem mntmNew = new JMenuItem("            New            ");
		mnFile.add(mntmNew);
		JMenuItem mntmPrintScreen = new JMenuItem("            Print Screen            ");
		mnFile.add(mntmPrintScreen);
		JMenuItem mntmPrint = new JMenuItem("            Print            ");
		mnFile.add(mntmPrint);
		JMenuItem mntmExit = new JMenuItem("            Exit            ");
		mnFile.add(mntmExit);
		JMenu mnEdit = new JMenu("            Edit            ");
		mnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnEdit);
		JMenu mnTemporaryMenu = new JMenu("            Temporary menu to Eat up space      ");
		mnTemporaryMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnTemporaryMenu);
		JMenu mnTools = new JMenu("            Tools            ");
		mnTools.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnTools);
		JMenu mnHelp = new JMenu("            Help & Support            ");
		mnHelp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(mnHelp);
		JMenuItem mntmUserMannual = new JMenuItem("User Mannual");
		mnHelp.add(mntmUserMannual);
		JMenuItem mntmSupport = new JMenuItem("Support");
		mnHelp.add(mntmSupport);
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		JMenu mnNewMenu = new JMenu("New menu");
		panelMenu.add(mnNewMenu);
		
		//Left Side Panel
		contentPane.add(panelL = new PanelLHome(), BorderLayout.WEST);
		
		//Right Side Panel
		//panelR = new TestMetaCreation();
		//panelR.setBorder(new LineBorder(Color.RED, 2));
		contentPane.add(panelR = new TestMetaCreation(), BorderLayout.CENTER);
		//panelR.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

	public static void main(String[] args)
	{
		GUIFrame myFrame = new GUIFrame();
		
		//PanelLHome panelL= new PanelLHome();
		//myFrame.panelL = panelL;
		//myFrame.contentPane.remove(myFrame.panelL);
		//myFrame.contentPane.add(panelL, BorderLayout.WEST);
		
		myFrame.setVisible(true);
	}
}
