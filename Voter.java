import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Voter {

	private JPanel panel;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	private JTextField firstName;
	private JTextField lastName;

	private JLabel fNameLabel;
	private JLabel lNameLabel;
	private JLabel status;
	
	public Voter()
	{
		panel = new JPanel();

		button1 = new JButton("Demon's Souls");
		button2 = new JButton("Dark Souls");
		button3 = new JButton("Dark Souls 2");
		button4 = new JButton("Bloodborne");
		
		fNameLabel = new JLabel("First Name:");
		firstName = new JTextField(10);//3 cols, not 20 chars
		lNameLabel = new JLabel("Last Name:");
		lastName = new JTextField(10);
		
		status = new JLabel("Please place your vote!");
		
		//Load the listeners
		button1.addActionListener(button1Listener());
		button2.addActionListener(button2Listener());	
		button3.addActionListener(button3Listener());	
		button4.addActionListener(button4Listener());	
		
		//load the panel
		panel.add(fNameLabel);	
		panel.add(firstName);
		panel.add(lNameLabel);		
		panel.add(lastName);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);

		panel.add(status);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private boolean voteChecker(String first, String last, String vote)
	{
		boolean result = false;
		String text = "You've already voted!";
		try
		{
			InputStream is = new FileInputStream(first+"_"+last+"_"+"ballot.txt");
			status.setText(text);
			System.out.println(text);
			is.close();
		}catch(Exception e){
			result = true;
		}
		return result;
	}
	
	private void fileWriter(String first, String last, String vote)
	{
		byte[] voteBytes = vote.getBytes(StandardCharsets.UTF_8);
		String newText1 = "Thanks for your vote!";
		String newText2 = "Please try again.";
		try
		{
			OutputStream os = new FileOutputStream(first+"_"+last+"_"+"ballot.txt");
			os.write(voteBytes);
			os.close();
			status.setText(newText1);
			System.out.println(newText1);
		} catch(Exception e) {
			status.setText(newText2);
			System.out.println(newText2);
		}
	}
	
	
	//The listeners pass to voteChecker, which looks to see if the ballot.txt file already exists.
	//If it does, a message is displayed, but nothing further happens.
	//If it does not, the listeners pass to fileWriter, which writes out a new ballot.txt file.
	private ActionListener button1Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String fName = firstName.getText();
				String lName = lastName.getText();
				String choice = "Demon's Souls";
				if(voteChecker(fName, lName, choice))
				{
					fileWriter(fName, lName, choice);
				}
			}
		};
		
		return listener;
	}
	private ActionListener button2Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String fName = firstName.getText();
				String lName = lastName.getText();
				String choice = "Dark Souls";
				if(voteChecker(fName, lName, choice))
				{
					fileWriter(fName, lName, choice);
				}
			}
		};
		
		return listener;
	}
	private ActionListener button3Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String fName = firstName.getText();
				String lName = lastName.getText();
				String choice = "Dark Souls 2";
				if(voteChecker(fName, lName, choice))
				{
					fileWriter(fName, lName, choice);
				}
			}
		};
		
		return listener;
	}
	private ActionListener button4Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String fName = firstName.getText();
				String lName = lastName.getText();
				String choice = "Bloodborne";
				if(voteChecker(fName, lName, choice))
				{
					fileWriter(fName, lName, choice);
				}
			}
		};
		
		return listener;
	}
}
