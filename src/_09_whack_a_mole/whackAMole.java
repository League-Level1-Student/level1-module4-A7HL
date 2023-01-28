package _09_whack_a_mole;
	import javax.swing.JFrame;
	import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class whackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel pane = new JPanel();
	
	
	
	public void setUp() {
	
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500,800));
		frame.add(pane);
		
		for(int i =0; i<24;i++) {
			JButton b = new JButton();
			b.addActionListener(this);
			pane.add(b);
			//decide if mole
		}
		frame.pack();
		frame.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton)e.getSource();
		if(pressed.getText().equals("mole")) {
			
		}
		
	}
	

}
