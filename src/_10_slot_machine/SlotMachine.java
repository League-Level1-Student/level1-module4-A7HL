package _10_slot_machine;


import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SlotMachine {
	JFrame frame = new JFrame();
	JPanel pane = new JPanel();
	JButton spin = new JButton();
	JLabel seven = new JLabel();
	
	
	public void machine() {
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,1000));
		frame.add(pane);
		try {
			seven = createLabelImage("video_slot_machine_symbols_7_thumbnail_square_0000.png");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pane.add(seven);
		frame.pack();
		frame.setVisible(true);
		
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	
}
