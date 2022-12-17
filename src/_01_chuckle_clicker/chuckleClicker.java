package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


	/*We are going to tell the user jokes that have punchlines.


	1. Make a ChuckleClicker class with a main method and a makeButtons() method.
	Open a pop-up that shows the message "Make Buttons" in the makeButtons method, to prove that it is working.
	(You will need to instantiate your class before you can call the method).

	2. Now change the makeButtons() method, to make a JFrame and get it to show.

	3.Add a JPanel and two JButtons to the frame, so it looks a lot like this:

	4. *[Optional] Customize your GUI with setText, setSize, etc.

	5. Make a pop-up that says “hi” when either of the buttons are pressed. You will need to add listeners to the buttons for this to work.

	6. Check if the ActionEvent came from the joke button or the punchline button.

	if(event.getSource() == jokeButton)

	Hint: You might need to move the declaration of your buttons outside of the makeButtons() method.


	7. Use JOptionPane to print the joke or the punchline depending on which button was clicked.
	*/
public class chuckleClicker implements ActionListener {	
		JFrame frame = new JFrame("Chuckle Clicker");
		JPanel pane = new JPanel();
		JButton button1 = new JButton("joke");
		JButton button2 = new JButton("punchline");
	
	
	public void makeButtons() {
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(pane);
		pane.add(button1);
		pane.add(button2);
		frame.pack();
		
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(buttonPressed == button1) {
			JOptionPane.showMessageDialog(null, "this is a joke.");
		}
		if(buttonPressed == button2) {
			JOptionPane.showMessageDialog(null, "laugh.");
		}
		
	}
	
}
