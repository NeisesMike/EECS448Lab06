import javax.swing.JFrame;

public class VoterDriver {

	private static void createAndDisplayGUI()
	{
		JFrame frame = new JFrame("Voting System");
		Voter demo = new Voter();
		
		frame.getContentPane().add(demo.getContent());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		createAndDisplayGUI();
	}
}