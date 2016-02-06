package com.pls.views;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Font;

@SuppressWarnings("serial")
public class PanelLHome extends JPanel
{
	//Create the panel.
	public PanelLHome()
	{
		setLayout(new GridLayout(10, 1, 2, 2));
		
		JMenuBar menuBar_1 = new JMenuBar();
		add(menuBar_1);
		JMenu mnManagerReferrers = new JMenu(resizeTo31chars("Manager Referrers"));
		mnManagerReferrers.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_1.add(mnManagerReferrers);
		
		JMenuBar menuBar_2 = new JMenuBar();
		add(menuBar_2);
		JMenu mnTests = new JMenu(resizeTo31chars("Tests"));
		mnTests.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_2.add(mnTests);
		
		JMenuBar menuBar_3 = new JMenuBar();
		add(menuBar_3);
		
		JMenu mnReports = new JMenu(resizeTo31chars("Reports"));
		mnReports.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_3.add(mnReports);
		
		JMenuBar menuBar_4 = new JMenuBar();
		add(menuBar_4);
		
		JMenu mnBilling = new JMenu(resizeTo31chars("Billing"));
		mnBilling.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_4.add(mnBilling);
		
		JMenuBar menuBar_5 = new JMenuBar();
		add(menuBar_5);
		
		JMenu mnRateChart = new JMenu(resizeTo31chars("Rate Chart"));
		mnRateChart.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_5.add(mnRateChart);
		
		JMenuBar menuBar_6 = new JMenuBar();
		add(menuBar_6);
		
		JMenu mnPrintingSetup = new JMenu(resizeTo31chars("Printing Setup"));
		mnPrintingSetup.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_6.add(mnPrintingSetup);
		
		JMenuBar menuBar_7 = new JMenuBar();
		add(menuBar_7);
		
		JMenu mnLastNTests = new JMenu(resizeTo31chars("Last N Tests"));
		mnLastNTests.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_7.add(mnLastNTests);
		
		JMenuBar menuBar_8 = new JMenuBar();
		add(menuBar_8);
		
		JMenu mnLastNTransactions = new JMenu(resizeTo31chars("Last N Transactions"));
		mnLastNTransactions.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_8.add(mnLastNTransactions);
		
		JMenuBar menuBar_9 = new JMenuBar();
		add(menuBar_9);
		
		JMenu mnFinancialAnalytics = new JMenu(resizeTo31chars("Financial Analytics"));
		mnFinancialAnalytics.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_9.add(mnFinancialAnalytics);
		
		JMenuBar menuBar_10 = new JMenuBar();
		add(menuBar_10);
		
		JMenu mnComissionManagement = new JMenu(resizeTo31chars("Comission Managemet"));
		mnComissionManagement.setFont(new Font("Monospaced", Font.PLAIN, 18));
		menuBar_10.add(mnComissionManagement);

	}
	
	//A utility function to pad strings with spaces, so that they remain of same length
	private static String resizeTo31chars(String inString)
	{
		int N = 30;
		int inStringLength = inString.length();
		String strRet = "";
		StringBuffer sb = new StringBuffer("");
		
		if(inStringLength >= 30)
		{
			//Set N to a value more than 40
			System.out.println("EXIT - - See code");
			System.exit(1);
		}
		else
		{
			//System.out.println(inString + "\t is of length " + inStringLength);
			if( (N - inStringLength) % 2  ==  0)
			{
				N = (N - inStringLength) / 2;
				sb.append(" ");
			}
			else
				N = (N - inStringLength + 1) / 2;
			
			//System.out.println("Padding of " + N + " spaces will be required");
			for(int i=0 ; i<N ; i++ )
				sb.append(" ");
			sb.append(inString);
			while( N-- > 0 )
				sb.append(" ");

			//Make sure it is resized to 30 chars
			//System.out.println(sb + "resized to " + sb.length() + "\n");
			
			strRet = sb.toString();
		}
		return strRet;
	}

}
