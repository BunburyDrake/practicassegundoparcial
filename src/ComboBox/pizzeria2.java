package ComboBox;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class pizzeria2 {

	private JFrame frmPizzeriaDondimadon;

	private JCheckBox chkPapas;

	private JCheckBox chkAlitas;

	private JCheckBox chkRefresco;

	private JCheckBox chkCerveza;
	
	private JLabel lblCantidad;

	private JRadioButton radIndividual;

	private JRadioButton radGrande;

	private JRadioButton radFamiliar;

	private JRadioButton radJumbo;

	private JComboBox cmbEspecialidad;

	private JSlider sldCantidad;

	private JButton btnBorrar;

	private JLabel lblTotal;

	private JTextArea txtResumen;
	String c1="", c2="", c3="", c4="",c5="";
int totalComplementos;
	String tamaño = "";
String especialidad="";
	int total;
	int Cantidad=0;

	int precioPizza = 0;
	private JCheckBox chkBurritos;
	

	public void orden() {
		

		int cp = sldCantidad.getValue();
		lblCantidad.setText(""+cp);
		

		switch (tamaño) {

		case "Jumbo":
			precioPizza = 150;
			break;

		case "Familiar":
			precioPizza = 120;
			break;

		case "Grande":
			precioPizza = 100;
			break;

		case "Individual":
			precioPizza = 30;
			break;

		}

		total = (cp * precioPizza)+totalComplementos;
		txtResumen.setText("Cantidad"
				+ sldCantidad.getValue()+"\n Tamaño:"+tamaño+"\nEspecialidad:"+especialidad+"\n\nComplementos\n"+c1+"\n"+c2+"\n"+c3+"\n"+c4);
		DecimalFormat f=new DecimalFormat("0.00");
		lblTotal.setText("$ " + f.format(total) + " MXN");

	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					pizzeria2 window = new pizzeria2();

					window.frmPizzeriaDondimadon.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * 
	 * Create the application.
	 * 
	 */

	public pizzeria2() {

		initialize();

	}

	/**
	 * 
	 * Initialize the contents of the frame.
	 * 
	 */

	private void initialize() {

		frmPizzeriaDondimadon = new JFrame();
		frmPizzeriaDondimadon.setLocationRelativeTo(null);
		frmPizzeriaDondimadon.getContentPane().setBackground(Color.BLACK);

		frmPizzeriaDondimadon.getContentPane().setForeground(Color.BLUE);

		frmPizzeriaDondimadon.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\dondiamdon.jpeg"));

		frmPizzeriaDondimadon.setTitle("Pizzeria Dondimadon");

		frmPizzeriaDondimadon.setBounds(100, 100, 848, 612);

		frmPizzeriaDondimadon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmPizzeriaDondimadon.setLocationRelativeTo(null);

		frmPizzeriaDondimadon.getContentPane().setLayout(null);

		JLabel lblDimadon = new JLabel("");

		lblDimadon.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\dondiamdon.jpeg"));

		lblDimadon.setBounds(396, 15, 426, 463);

		frmPizzeriaDondimadon.getContentPane().add(lblDimadon);
		
		lblCantidad = new JLabel("1");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setForeground(new Color(255, 255, 255));
		lblCantidad.setBounds(306, 38, 37, 26);
		frmPizzeriaDondimadon.getContentPane().add(lblCantidad);
		
		lblTotal = new JLabel("$ 0.00");

		lblTotal.setBorder(new LineBorder(Color.GREEN, 4));

		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTotal.setForeground(Color.GREEN);

		lblTotal.setBounds(6, 467, 211, 57);

		frmPizzeriaDondimadon.getContentPane().add(lblTotal);

		txtResumen = new JTextArea();

		txtResumen.setBounds(209, 211, 177, 168);

		frmPizzeriaDondimadon.getContentPane().add(txtResumen);

		sldCantidad = new JSlider();
		sldCantidad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				orden();
			}
		});

		sldCantidad.setValue(1);

		sldCantidad.setMaximum(10);

		sldCantidad.setMinimum(1);

		sldCantidad.setBorder(new LineBorder(Color.YELLOW));

		sldCantidad.setForeground(Color.MAGENTA);

		sldCantidad.setBackground(Color.GRAY);

		sldCantidad.setBounds(6, 38, 277, 26);

		frmPizzeriaDondimadon.getContentPane().add(sldCantidad);

		JLabel lblNewLabel_2 = new JLabel("Especialidad");

		lblNewLabel_2.setForeground(Color.WHITE);

		lblNewLabel_2.setBounds(6, 69, 81, 26);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_2);

		cmbEspecialidad = new JComboBox();
		cmbEspecialidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				especialidad=String.valueOf(cmbEspecialidad.getSelectedItem());
				orden();
			}
		});

		cmbEspecialidad.setModel(new DefaultComboBoxModel(
				new String[] { "chorizo,", "longaniza", "extra queso", "3 quesos", "carpincho" }));

		cmbEspecialidad.setBackground(Color.WHITE);

		cmbEspecialidad.setForeground(Color.RED);

		cmbEspecialidad.setBounds(6, 89, 277, 22);

		frmPizzeriaDondimadon.getContentPane().add(cmbEspecialidad);

		radJumbo = new JRadioButton("JUMBO $=150");

		radJumbo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radJumbo.isSelected()) {

					tamaño = "Jumbo";

				}

				orden();

			}

		});

		radJumbo.setForeground(Color.ORANGE);

		radJumbo.setBackground(Color.LIGHT_GRAY);

		radJumbo.setBounds(6, 134, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(radJumbo);

		radFamiliar = new JRadioButton("FAMILIAR $=120");

		radFamiliar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radFamiliar.isSelected()) {

					tamaño = "Familiar";

				}

				orden();

			}

		});

		radFamiliar.setForeground(Color.YELLOW);

		radFamiliar.setBackground(Color.LIGHT_GRAY);

		radFamiliar.setBounds(6, 160, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(radFamiliar);

		radGrande = new JRadioButton("GRANDE $=100");

		radGrande.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radGrande.isSelected()) {

					tamaño = "Grande";

				}

				orden();

			}

		});

		radGrande.setForeground(Color.GREEN);

		radGrande.setBackground(Color.LIGHT_GRAY);

		radGrande.setBounds(6, 186, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(radGrande);

		radIndividual = new JRadioButton("INDIVIDUAL $=30");

		radIndividual.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (radIndividual.isSelected()) {

					tamaño = "Individual";

				}

				orden();

			}

		});

		radIndividual.setForeground(Color.RED);

		radIndividual.setBackground(Color.LIGHT_GRAY);

		radIndividual.setBounds(6, 212, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(radIndividual);

		JLabel lblNewLabel_2_1 = new JLabel("complementos");

		lblNewLabel_2_1.setForeground(Color.WHITE);

		lblNewLabel_2_1.setBounds(6, 252, 91, 14);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("TamaÃ±os");

		lblNewLabel_2_1_1.setForeground(Color.WHITE);

		lblNewLabel_2_1_1.setBounds(6, 113, 81, 14);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_2_1_1);

		chkPapas = new JCheckBox("PAPAS A LA FRANCESA $=70");
		chkPapas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkPapas.isSelected()) {
					totalComplementos += 70;
					c1 = "Una orden de papas";

				} else {
					totalComplementos -= 70;
					c1 = "";

				}
				orden();
			}
		});

		chkPapas.setForeground(Color.ORANGE);

		chkPapas.setBackground(Color.LIGHT_GRAY);

		chkPapas.setBounds(6, 272, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(chkPapas);

		chkAlitas = new JCheckBox("ALITAS $=75");
		chkAlitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkAlitas.isSelected()) {
					totalComplementos += 75;
					c2 = "Una Orden de Alitas";

				} else {
					totalComplementos -= 0;
					c2 = "";

				}
				orden();
			}
		});

		chkAlitas.setForeground(Color.YELLOW);

		chkAlitas.setBackground(Color.LIGHT_GRAY);

		chkAlitas.setBounds(6, 298, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(chkAlitas);

		chkRefresco = new JCheckBox("REFRESCO $=30");
		chkRefresco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkAlitas.isSelected()) {
					totalComplementos += 30;
					c3 = "Refresco de 2lt";

				} else {
					totalComplementos -= 0;
					c3 = "";

				}
				orden();
			}

		});

		chkRefresco.setForeground(Color.GREEN);

		chkRefresco.setBackground(Color.LIGHT_GRAY);

		chkRefresco.setBounds(6, 325, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(chkRefresco);

		chkCerveza = new JCheckBox("CERVEZA $=60");
		chkCerveza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkAlitas.isSelected()) {
					totalComplementos += 60;
					c4 = "Cerveza";

				} else {
					totalComplementos -= 0;
					c4 = "";

				}
				orden();

			}
		});

		chkCerveza.setForeground(Color.RED);

		chkCerveza.setBackground(Color.LIGHT_GRAY);

		chkCerveza.setBounds(6, 351, 177, 23);

		frmPizzeriaDondimadon.getContentPane().add(chkCerveza);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbEspecialidad.setSelectedIndex(0);

				radJumbo.setSelected(false);

				radFamiliar.setSelected(false);

				radGrande.setSelected(false);

				radIndividual.setSelected(false);

				chkPapas.setSelected(false);

				chkAlitas.setSelected(false);

				chkRefresco.setSelected(false);

				chkCerveza.setSelected(false);
total=0;
totalComplementos=0;
precioPizza=0;
txtResumen.setText("");
				lblCantidad.setText("1");

				lblTotal.setText("$ 0.0 MXN");
			}
		});

		btnBorrar.setBounds(209, 134, 147, 33);

		frmPizzeriaDondimadon.getContentPane().add(btnBorrar);

		JLabel lblNewLabel_3 = new JLabel("resumen de orden");

		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		lblNewLabel_3.setForeground(Color.GREEN);

		lblNewLabel_3.setBackground(Color.WHITE);

		lblNewLabel_3.setBounds(219, 172, 216, 23);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_2_2 = new JLabel("Cantidad");

		lblNewLabel_2_2.setForeground(Color.WHITE);

		lblNewLabel_2_2.setBounds(6, 11, 81, 26);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_5 = new JLabel("total a pagar\r\n\r\n\r\n\r\n$");

		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblNewLabel_5.setForeground(Color.WHITE);

		lblNewLabel_5.setBounds(6, 430, 211, 26);

		frmPizzeriaDondimadon.getContentPane().add(lblNewLabel_5);

		

		ButtonGroup grupo = new ButtonGroup();

		grupo.add(radJumbo);

		grupo.add(radIndividual);

		grupo.add(radFamiliar);

		grupo.add(radGrande);
		
		chkBurritos = new JCheckBox("Burritos $=10");
		chkBurritos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chkBurritos.isSelected()) {
					totalComplementos += 10;
					c5 = "Cerveza";

				} else {
					totalComplementos -= 0;
					c5 = "";

				}
				orden();

			}
			
		});
		chkBurritos.setBounds(6, 377, 177, 23);
		frmPizzeriaDondimadon.getContentPane().add(chkBurritos);
		
		

	}
}
