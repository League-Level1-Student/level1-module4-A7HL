package _04_book_of_illusions;

import java.awt.Dimension;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
/** We’re going to make a slideshow of cool optical illusions. When the user clicks on an illusion, a new one will be loaded. **/

public class BookOfIllusions extends MouseAdapter {

	// 1. Make a JFrame variable and initialize it using "new JFrame()"
	int frameWidth = 2000;
	int frameHeight = 1000;
	JFrame fraem = new JFrame();
	JLabel lablel;

	public void run() {
		// 2. make the frame visible
		fraem.setDefaultCloseOperation(fraem.EXIT_ON_CLOSE);
		fraem.setVisible(true);
		// 3. set the size of the frame
		fraem.setSize(frameWidth, frameHeight);
		// 4. find 2 images and save them to your project’s _06_book_of_illusions folder
		
		// 5. make a variable to hold the location of your image. e.g. "illusion.jpg"
		// 6. create a variable of type "JLabel" but don’t initialize it yet
		
		// 7. use the "loadImage..." methods below to initialize your JLabel
		lablel = loadImageFromComputer("ladderAndManIllusion.png");
		lablel.setPreferredSize(new Dimension(frameWidth,frameHeight));
		// 8. add your JLabel to the frame
		fraem.add(lablel);
		// 9. call the pack() method on the frame
		fraem.pack();
		// 10. add a mouse listener to your frame (hint: use *this*)
		fraem.addMouseListener(this);
	}

	public void mousePressed(MouseEvent e) {
		// 11. Print "clicked!" to the console when the mouse is pressed
		
		System.out.println("clicked");
		// 12. remove everything from the frame that was added earlier
		fraem.remove(lablel);
		// 13. load a new image like before (this is more than one line of code)
		JLabel lablel2;
		// 7. use the "loadImage..." methods below to initialize your JLabel
		lablel2 = loadImageFromComputer("sharpieIllusion.png");
		lablel2.setPreferredSize(new Dimension(frameWidth,frameHeight));
		// 14. pack the frame
		fraem.add(lablel2);
		fraem.pack();
		
	}

	// [OPTIONAL] 15. goad your users with some annoying or witty pop-ups

	/*
	 * To use this method, the image must be placed in your Eclipse project under "default package".
	 */
	public JLabel loadImageFromComputer(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
	}

}


