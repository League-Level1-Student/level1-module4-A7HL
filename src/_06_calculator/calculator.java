package _06_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class calculator implements ActionListener {
		JFrame frame = new JFrame("Calculator");
		
		JPanel pane = new JPanel();
		
		JTextField n1 = new JTextField();
		JTextField n2 = new JTextField();
		
		private String answer = "";
		JLabel ans = new JLabel(answer);
		
		JButton add = new JButton("+");
		JButton sub = new JButton("-");
		JButton mult = new JButton("X");
		JButton div = new JButton("/");
		
		private double a;
		private double b;

	public calculator(){
		
	}
	public void calcGUI() {
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setPreferredSize(new Dimension(325,300));
		
		frame.add(pane);
		
		pane.add(n1);
		pane.add(n2);
		
		n1.setPreferredSize(new Dimension(150,30));
		n2.setPreferredSize(new Dimension(150,30));
		
		pane.add(add);
		pane.add(sub);
		pane.add(mult);
		pane.add(div);
		pane.add(ans);
		
		frame.pack();
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		
	}
	
	
	public void add(double a, double b) {
		double i = a+b;
		answer = ""+i;
		ans.setText(answer);
		
	}
	public void subtract(double a, double b) {
		double i = a-b;
		answer = ""+i;
		ans.setText(answer);
		
	}
	public void multiply(double a, double b){
		double i = a*b;
		answer = ""+i;
		ans.setText(answer);
		
	}
	public void divide(double a, double b) {
		double i = a/b;
		answer = ""+i;
		ans.setText(answer);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		
		if(n1.getText().equals("")||n2.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"please enter a value in both fields");
		}else {
		String s1 = n1.getText();
		String s2 = n2.getText();
		a = Double.parseDouble(s1);
		b = Double.parseDouble(s2);
		}
		
		if(buttonPressed==add)
			add(a,b);
		else if(buttonPressed==sub)
			subtract(a,b);
		else if(buttonPressed==mult)
			multiply(a,b);
		else
			divide(a,b);
	}
}
