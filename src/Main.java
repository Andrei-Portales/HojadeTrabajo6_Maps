import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Main {

	private JFrame frame;
	private Controller control;
	private JRadioButton rdbtnTreemap,rdbtnNewRadioButton,rdbtnLinkedhashmap;
	private JPanel ElegirMap,Principal;
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
		frame.setBounds(100, 100, 737, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		ElegirMap = new JPanel();
		ElegirMap.setBackground(Color.WHITE);
		frame.getContentPane().add(ElegirMap, "name_436410592120900");
		ElegirMap.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(161, 135, 379, 253);
		ElegirMap.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!rdbtnNewRadioButton.isSelected() && !rdbtnTreemap.isSelected() && !rdbtnLinkedhashmap.isSelected()) {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguno");
				}else {
					if (rdbtnNewRadioButton.isSelected()) {
						control.setMap("HashMap");
					}else if (rdbtnTreemap.isSelected()) {
						control.setMap("TreeMap");
					}else if (rdbtnLinkedhashmap.isSelected()) {
						control.setMap("LinkedHashMap");
					}
					Principal.setVisible(true);
					ElegirMap.setVisible(false);
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(136, 200, 97, 25);
		panel.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("HashMap");
		rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				rdbtnTreemap.setSelected(false);
				rdbtnLinkedhashmap.setSelected(false);
			}
		});
		rdbtnNewRadioButton.setBounds(106, 46, 127, 25);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnTreemap = new JRadioButton("TreeMap");
		rdbtnTreemap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnLinkedhashmap.setSelected(false);
				
			}
		});
		rdbtnTreemap.setBackground(Color.LIGHT_GRAY);
		rdbtnTreemap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnTreemap.setBounds(106, 89, 127, 25);
		panel.add(rdbtnTreemap);
		
		rdbtnLinkedhashmap = new JRadioButton("LinkedHashMap");
		rdbtnLinkedhashmap.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnNewRadioButton.setSelected(false);
				rdbtnTreemap.setSelected(false);
				
			}
		});
		rdbtnLinkedhashmap.setBackground(Color.LIGHT_GRAY);
		rdbtnLinkedhashmap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLinkedhashmap.setBounds(106, 130, 193, 25);
		panel.add(rdbtnLinkedhashmap);
		
		Principal = new JPanel();
		Principal.setBackground(Color.WHITE);
		frame.getContentPane().add(Principal, "name_436413107575200");
		Principal.setLayout(null);
	}
}
