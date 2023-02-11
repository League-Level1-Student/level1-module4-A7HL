package _10_slot_machine;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel pane = new JPanel();
	JButton spin = new JButton("spin");
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	
	
	
	
	
	public void machine() {
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1600,1000));
		frame.add(pane);
		
		try {
						slot1 = createLabelImage("video_slot_machine_symbols_7_thumbnail_square_0000.png");
						slot2 = createLabelImage("video_slot_machine_symbols_cherries_thumbnail_square_0000.png");
						slot3 =  createLabelImage("video_slot_machine_symbols_lemon_thumbnail_square_0000.png");
		}catch(MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
		
		pane.add(slot1);
		pane.add(slot2);
		pane.add(slot3);
		pane.add(spin);
		
		spin.addActionListener(this);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		spin();
	}
	public void spin() {
		int num1;
		int num2;
		int num3;
		pane.removeAll();
	
		
		JLabel current;
		try {
			for(int i =0;i<3;i++) {
				int ran = (int)(Math.random()*3);	
				if(i==0) {
					current = slot1;
					num1=ran;
				}else if(i==1) {
					current = slot2;
					num2=ran;
				}else {
					current = slot3;
					num3=ran;
				}
					
				
				if(ran==0) {
						current = createLabelImage("video_slot_machine_symbols_7_thumbnail_square_0000.png");
					
				}else if(ran==1) {
						current = createLabelImage("video_slot_machine_symbols_cherries_thumbnail_square_0000.png");
					
				}else{
						current =  createLabelImage("video_slot_machine_symbols_lemon_thumbnail_square_0000.png");
				}
				pane.add(current);
			}
		}catch(MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		}
			
		//pane.add(slot1);
		//pane.add(slot2);
		//pane.add(slot3);
		//if(num1==num2&&num2==num3) {
			//ON THIS STEP
		//}
		pane.add(spin);
		frame.pack();
	}
	
}
