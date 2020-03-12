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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.mxrck.autocompleter.AutoCompleter;
import com.mxrck.autocompleter.TextAutoCompleter;

import javax.swing.event.ChangeEvent;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Main {

	private JFrame frame;
	private Controller control;
	private JRadioButton rdbtnTreemap,rdbtnNewRadioButton,rdbtnLinkedhashmap;
	private JPanel ElegirMap,Principal;
	private JButton btnNewButton_1;
	private JPanel panel_1;
	private JScrollPane spCartas;
	private JScrollPane spHechizo;
	private JScrollPane spTrampa;
	private JScrollPane spMountrosUsuario;
	private JScrollPane spHechizoUsuario,spcartasUsuario ;
	private JScrollPane spTrampaUsuario,spMonstruo;
	private TextAutoCompleter auto,auto1;
	private JTextField txtTIpoEspecifico;
	private JLabel lblTipo;
	private JLabel lblTipoPedido;
	private JPanel panel_3;
	private JTextField txtagregarCartaUsuario;
	private JLabel lblAgregarCartaA;
	private JLabel c1;
	private JLabel c2;
	private JLabel c3;
	private JLabel c4;
	private JLabel c5;
	private JLabel c6;
	private JLabel c7;
	private JLabel c8;
	private JLabel lblNewLabel_1;
	private JLabel lblGeneral;
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
		frame.setBounds(100, 100, 1287, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		ElegirMap = new JPanel();
		ElegirMap.setBackground(Color.WHITE);
		frame.getContentPane().add(ElegirMap, "name_436410592120900");
		ElegirMap.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(428, 216, 379, 253);
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
		
		btnNewButton_1 = new JButton("Leer Archivo");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				control.fillMap();
	
				AutoCompleteFill();
				setCardTable();
				fillTypesTables();
				setCardTableUsuario();
				fillTypesTablesUser();
				UpdateSizes();
				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "No se pudo leer el archivo txt");
				}
			}
		});
		btnNewButton_1.setBounds(12, 13, 155, 39);
		Principal.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);

		panel_1.setBounds(22, 75, 1235, 685);
		Principal.add(panel_1);
		panel_1.setLayout(null);
		
		spCartas = new JScrollPane();
		spCartas.setBounds(12, 169, 411, 219);
		panel_1.add(spCartas);
		
		spcartasUsuario = new JScrollPane();
		spcartasUsuario.setBounds(12, 453, 411, 219);
		panel_1.add(spcartasUsuario);
		
		spMonstruo = new JScrollPane();
		spMonstruo.setBounds(449, 169, 247, 219);
		panel_1.add(spMonstruo);
		
		spHechizo = new JScrollPane();
		spHechizo.setBounds(708, 169, 247, 219);
		panel_1.add(spHechizo);
		
		spTrampa = new JScrollPane();
		spTrampa.setBounds(967, 169, 247, 219);
		panel_1.add(spTrampa);
		
		spMountrosUsuario = new JScrollPane();
		spMountrosUsuario.setBounds(449, 453, 247, 219);
		panel_1.add(spMountrosUsuario);
		
		spHechizoUsuario = new JScrollPane();
		spHechizoUsuario.setBounds(708, 453, 247, 219);
		panel_1.add(spHechizoUsuario);
		
		spTrampaUsuario = new JScrollPane();
		spTrampaUsuario.setBounds(967, 453, 247, 219);
		panel_1.add(spTrampaUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(12, 13, 419, 95);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		lblTipoPedido = new JLabel("");
		lblTipoPedido.setBounds(243, 45, 145, 32);
		panel_2.add(lblTipoPedido);
		lblTipoPedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtTIpoEspecifico = new JTextField();
		txtTIpoEspecifico.setBounds(12, 45, 199, 32);
		panel_2.add(txtTIpoEspecifico);
		txtTIpoEspecifico.setColumns(10);
		auto = new TextAutoCompleter(txtTIpoEspecifico);
		
		JLabel lblNewLabel = new JLabel("Carta especifica");
		lblNewLabel.setBounds(12, 0, 134, 32);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(243, 0, 52, 32);
		panel_2.add(lblTipo);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(498, 13, 351, 95);
		panel_1.add(panel_3);
		
		txtagregarCartaUsuario = new JTextField();
		txtagregarCartaUsuario.setColumns(10);
		txtagregarCartaUsuario.setBounds(12, 45, 205, 32);
		panel_3.add(txtagregarCartaUsuario);
		auto1 = new TextAutoCompleter(txtagregarCartaUsuario);
		
		lblAgregarCartaA = new JLabel("Agregar Carta a Usuario");
		lblAgregarCartaA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgregarCartaA.setBounds(12, 0, 205, 32);
		panel_3.add(lblAgregarCartaA);
		
		JButton btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtagregarCartaUsuario.getText().isEmpty()) {
					control.insertCard(txtagregarCartaUsuario.getText());
					txtagregarCartaUsuario.setText(null);
					setCardTable();
					fillTypesTables();
					setCardTableUsuario();
					fillTypesTablesUser();
					UpdateSizes();
					
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(236, 49, 97, 25);
		panel_3.add(btnNewButton_2);
		
		c1 = new JLabel("Cantidad:");
		c1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c1.setBounds(162, 129, 165, 27);
		panel_1.add(c1);
		
		c2 = new JLabel("Cantidad:");
		c2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c2.setBounds(508, 129, 144, 27);
		panel_1.add(c2);
		
		c3 = new JLabel("Cantidad:");
		c3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c3.setBounds(766, 129, 165, 27);
		panel_1.add(c3);
		
		c4 = new JLabel("Cantidad:");
		c4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c4.setBounds(1034, 129, 151, 27);
		panel_1.add(c4);
		
		c5 = new JLabel("Cantidad:");
		c5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c5.setBounds(162, 413, 165, 27);
		panel_1.add(c5);
		
		c6 = new JLabel("Cantidad:");
		c6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c6.setBounds(516, 413, 136, 27);
		panel_1.add(c6);
		
		c7 = new JLabel("Cantidad:");
		c7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c7.setBounds(766, 413, 144, 27);
		panel_1.add(c7);
		
		c8 = new JLabel("Cantidad:");
		c8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		c8.setBounds(1034, 413, 151, 27);
		panel_1.add(c8);
		
		lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 413, 84, 27);
		panel_1.add(lblNewLabel_1);
		
		lblGeneral = new JLabel("General:");
		lblGeneral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGeneral.setBounds(12, 135, 84, 27);
		panel_1.add(lblGeneral);
		txtTIpoEspecifico.getDocument().addDocumentListener(new MyDocumentListener());
	}
	
	private void UpdateSizes() {
		c1.setText("Cantidad: " + control.getMapSize());
		c2.setText("Cantidad: " + control.getTypeSize("Monstruo"));
		c3.setText("Cantidad: " + control.getTypeSize("Hechizo"));
		c4.setText("Cantidad: " + control.getTypeSize("Trampa"));
		
		c5.setText("Cantidad: " + control.getMapSizeUser());
		c6.setText("Cantidad: " + control.getTypeSizeUser("Monstruo"));
		c7.setText("Cantidad: " + control.getTypeSizeUser("Hechizo"));
		c8.setText("Cantidad: " + control.getTypeSizeUser("Trampa"));
	}
	
	private void AutoCompleteFill() {
		Object[] data = control.getKEys();
		for (Object l : data) {
			auto.addItem(l);
			auto1.addItem(l);
		}
		
	}
	
	private void setCardTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Carta","Tipo"});
		model.setRowCount(control.getMapSize());
		Object[] list = control.getKeysMap();
		
		for (int i = 0;i< list.length;i++) {
			model.setValueAt(list[i], i, 0);
			model.setValueAt(control.getType((String)list[i]), i, 1);
		}
		spCartas.setViewportView(new JTable(model));
	}
	
	private void fillTypesTables() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(1);
		model.setRowCount(control.getTypeSize("Monstruo"));
		model.setColumnIdentifiers(new String[] {"Monstruos"});
		Object[] list1 = control.getListType("Monstruo");
		
		for (int i = 0;i< list1.length;i++) {
			model.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnCount(1);
		model1.setRowCount(control.getTypeSize("Hechizo"));
		model1.setColumnIdentifiers(new String[] {"Hechizos"});
		list1 =  control.getListType("Hechizo");
		
		for (int i = 0;i< list1.length;i++) {
			model1.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnCount(1);
		model2.setRowCount(control.getTypeSize("Trampa"));
		model2.setColumnIdentifiers(new String[] {"Trampas"});
		list1 =  control.getListType("Trampa");
		
		for (int i = 0;i< list1.length;i++) {
			model2.setValueAt(list1[i], i, 0);
		}
		
		spMonstruo.setViewportView(new JTable(model));
		spHechizo.setViewportView(new JTable(model1));
		spTrampa.setViewportView(new JTable(model2));
		
	}
	
	
	private void setCardTableUsuario() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Carta","Tipo"});
		model.setRowCount(control.getMapSizeUser());
		Object[] list =  control.getUserKeysOrderedByValue();
		
		for (int i = 0;i< list.length;i++) {
			model.setValueAt(list[i], i, 0);
			model.setValueAt(control.getType((String)list[i]), i, 1);
		}
		spcartasUsuario.setViewportView(new JTable(model));
	}
	
	
	
	private void fillTypesTablesUser() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(1);
		model.setRowCount(control.getTypeSizeUser("Monstruo"));
		model.setColumnIdentifiers(new String[] {"Monstruos"});
		Object[] list1 = control.getListTypeUser("Monstruo");
		
		for (int i = 0;i< list1.length;i++) {
			model.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnCount(1);
		model1.setRowCount(control.getTypeSizeUser("Hechizo"));
		model1.setColumnIdentifiers(new String[] {"Hechizos"});
		list1 =  control.getListTypeUser("Hechizo");
		
		for (int i = 0;i< list1.length;i++) {
			model1.setValueAt(list1[i], i, 0);
		}
		
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnCount(1);
		model2.setRowCount(control.getTypeSizeUser("Trampa"));
		model2.setColumnIdentifiers(new String[] {"Trampas"});
		list1 =  control.getListTypeUser("Trampa");
		
		for (int i = 0;i< list1.length;i++) {
			model2.setValueAt(list1[i], i, 0);
		}
		
		spMountrosUsuario.setViewportView(new JTable(model));
		spHechizoUsuario.setViewportView(new JTable(model1));
		spTrampaUsuario.setViewportView(new JTable(model2));
	}
	
	
	/**
	 * Clase privada para document listener
	 */
	private class MyDocumentListener implements DocumentListener {
	 
	    public void insertUpdate(DocumentEvent e) {
	        String s = control.getType(txtTIpoEspecifico.getText());
	        if (s != null) {
	        	lblTipoPedido.setText(s);
	        }else {
	        	lblTipoPedido.setText("");
	        }
	    }
	    public void removeUpdate(DocumentEvent e) {
	    	 String s = control.getType(txtTIpoEspecifico.getText());
		        if (s != null) {
		        	lblTipoPedido.setText(s);
		        }else {
		        	lblTipoPedido.setText("");
		        }
	    }
	    public void changedUpdate(DocumentEvent e) {
	        //Plain text components do not fire these events
	    	 String s = control.getType(txtTIpoEspecifico.getText());
		        if (s != null) {
		        	lblTipoPedido.setText(s);
		        }else {
		        	lblTipoPedido.setText("");
		        }
	    }
	}
}
