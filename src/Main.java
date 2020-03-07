import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private Controller control;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		control = new Controller();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.setMap("HashMap");
				control.fillMap();
			}
		});
		btnNewButton.setBounds(143, 120, 114, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.print();
			}
		});
		button.setBounds(143, 172, 114, 34);
		frame.getContentPane().add(button);
	}
}
