package _09_whack_a_mole;
	import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JApplet;
import javax.swing.JButton;
public class whackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel pane = new JPanel();
	boolean start = false;
	int score = 0;
	int missed =0;
	Date timeStart = new Date();
	
	
	public void setUp() {
		if(score==10) {
			endGame(timeStart, score);
			
		}else if(missed==5) {
			JOptionPane.showMessageDialog(null, "You lost");
			
		}
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(300,350));
		frame.add(pane);
		
		
		int mole = (int)(Math.random()*24);
		
		for(int i =0; i<24;i++) {
			
			if(i==mole) {
				JButton mle = new JButton("mole");
				mle.addActionListener(this);
				pane.add(mle);
			}else {
				JButton b = new JButton();
				b.addActionListener(this);
				pane.add(b);
			}
		}
		//frame.pack();
		frame.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton)e.getSource();
		if(pressed.getText().equals("mole")) {
			score++;
			pane.removeAll();
			setUp();
		}else {
			missed++;
			//speak("nope");
		}
		
	}
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	private void playSound(String fileName) { 
	    AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
	    sound.play();
	}

}
