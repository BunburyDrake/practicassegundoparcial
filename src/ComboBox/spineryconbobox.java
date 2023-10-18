package ComboBox;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class spineryconbobox {

	private JFrame frmPizzeria;
	private JLabel lblColor;
	private JComboBox cmbOpciones;
	private JLabel lblOpciones;
	private JSlider sldNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					spineryconbobox window = new spineryconbobox();
					window.frmPizzeria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public spineryconbobox() {
		initialize();
		cambiarColor();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPizzeria = new JFrame();
		frmPizzeria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga.jpg"));
		frmPizzeria.setTitle("Ejemplo Combo");
		frmPizzeria.setBounds(100, 100, 450, 300);
		frmPizzeria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPizzeria.setLocationRelativeTo(null);
		frmPizzeria.getContentPane().setLayout(null);
		
		cmbOpciones = new JComboBox();
		cmbOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor();
			}
		});
		cmbOpciones.setModel(new DefaultComboBoxModel(new String[] {"rojo", "azul", "verde", "negro"}));
		cmbOpciones.setBounds(52, 50, 151, 22);
		frmPizzeria.getContentPane().add(cmbOpciones);
		
		lblOpciones = new JLabel("OPCIONES");
		lblOpciones.setBounds(52, 25, 79, 14);
		frmPizzeria.getContentPane().add(lblOpciones);
		lblOpciones.setOpaque(true);
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblColor.setBounds(52, 113, 337, 120);
		frmPizzeria.getContentPane().add(lblColor);
		
		sldNumero = new JSlider();
		sldNumero.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cambiarColor();
			}
		});
		sldNumero.setValue(1);
		sldNumero.setMinimum(1);
		sldNumero.setBounds(213, 46, 200, 26);
		frmPizzeria.getContentPane().add(sldNumero);
		
	}
	public void cambiarColor() {
	int n=sldNumero.getValue();
	lblColor.setText(" "+n);
		String opcion=String.valueOf(cmbOpciones.getSelectedItem());
		switch (opcion) {
		case "rojo":
			lblColor.setBackground(Color.red);;
			break;
		case "azul":
			lblColor.setBackground(Color.blue);
			break;
		case "negro":
			lblColor.setBackground(Color.black);
			break;
		case "verde":
			lblColor.setBackground(Color.green);
			break;
		}
	}
}
