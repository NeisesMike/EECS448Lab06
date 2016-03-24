import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;

public class SafeConverter {

	private JPanel panel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;

	private JTextField text;
	private JLabel label;
	
	public SafeConverter()
	{
		panel = new JPanel();
		button1 = new JButton("Convert F to C");
		button2 = new JButton("Convert F to K");
		button3 = new JButton("Convert C to K");
		button4 = new JButton("Convert C to F");
		button5 = new JButton("Convert K to F");
		button6 = new JButton("Convert K to C");

		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a temperature from F to C");
		
		//Load the listener
		button1.addActionListener(button1Listener());
		button2.addActionListener(button2Listener());	
		button3.addActionListener(button3Listener());	
		button4.addActionListener(button4Listener());	
		button5.addActionListener(button5Listener());	
		button6.addActionListener(button6Listener());	

		
		//load the panel
		panel.add(text);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	
	//inputValidator checks to see if the input is empty or non-numerical.
	//If the input is a valid number, it returns true.
	//Otherwise, it returns false.
	private boolean inputValidator(String userInput)
	{
		if(userInput.equals(""))
		{
			return false;
		}
		try
		{
			Double.parseDouble(userInput);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
	
	private ActionListener button1Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					if(tempInF < -459.67)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInC = (tempInF-32)*(5.0/9.0); //convert F to C
						newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
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
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInF = Double.parseDouble(input);//convert String to double
					if(tempInF < -459.67)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInK = (tempInF-32)*(5.0/9.0)+273.15; //convert F to K
						newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
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
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInC = Double.parseDouble(input);//convert String to double
					if(tempInC < -273.15)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInK = (tempInC+273.15); //convert C to K
						newText = "Temp in K: " + String.format("%.2f",tempInK);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
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
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInC = Double.parseDouble(input);//convert String to double
					if(tempInC < -273.15)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInF = (tempInC*1.8+32); //convert C to F
						newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}
	private ActionListener button5Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					if(tempInK < 0)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInF = ((tempInK-273.15)*1.8+32); //convert K to F
						newText = "Temp in F: " + String.format("%.2f",tempInF);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}
	private ActionListener button6Listener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				String newText = "";
				if(inputValidator(input))
				{
					double tempInK = Double.parseDouble(input);//convert String to double
					if(tempInK < 0)
					{
						newText = "Input is below absolute zero.";
					}
					else
					{
						double tempInC = (tempInK-273.15); //convert K to C
						newText = "Temp in C: " + String.format("%.2f",tempInC);//convert double to String and
											       //	only display 2 places past decimal
					}

				}
				else
				{
					newText = "Invalid input";
				}	
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}
}

	
