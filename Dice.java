
import javax.swing.*;

import java.awt.event.*;
import java.awt.Component;
import java.util.Random;

public class Dice {

	private JPanel panel;
	private JButton button;
	private JTextField text;
	private JLabel label;
	Random randomGenerator = new Random();
		
	public Dice()
	{
		panel = new JPanel();
		button = new JButton("Roll");
		text = new JTextField(3);//3 cols, not 20 chars
		label = new JLabel("Enter a number of sides");
		
		//Load the listener
		button.addActionListener(buttonListener());	
		
		//load the panel
		panel.add(text);
		panel.add(button);
		panel.add(label);
	}
	
	public Component getContent()
	{
		return (panel);
	}
	
	private ActionListener buttonListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = text.getText();
				int numSides = Integer.parseInt(input);//convert String to int
				int result = randomGenerator.nextInt(numSides) + 1; //randomize with upper bound numSides
				String newText = "Result: " + result; //Display results
				label.setText(newText);
				System.out.println(newText);
			}
		};
		
		return listener;
	}
}
