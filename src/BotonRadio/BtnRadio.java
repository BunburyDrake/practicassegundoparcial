package BotonRadio;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BtnRadio {

	private JFrame frmBotonRadio;
	private JLabel lblColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BtnRadio window = new BtnRadio();
					window.frmBotonRadio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BtnRadio() {
		initialize();
	}

	private void initialize() {
		frmBotonRadio = new JFrame();
		frmBotonRadio.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\descarga.jpg"));
		frmBotonRadio.setTitle("Boton radio");
		frmBotonRadio.setBounds(100, 100, 450, 300);
		frmBotonRadio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBotonRadio.getContentPane().setLayout(null);
		frmBotonRadio.setLocationRelativeTo(null);
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 255, 153), null, null, null));
		lblColor.setBounds(245, 69, 140, 100);
		frmBotonRadio.getContentPane().add(lblColor);
		
		JRadioButton RadRojo = new JRadioButton("Rojo");
		RadRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.red);
			}
		});
		RadRojo.setBounds(22, 43, 109, 23);
		frmBotonRadio.getContentPane().add(RadRojo);
		
		JRadioButton radVerde = new JRadioButton("Verde");
		radVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.green);
			}
		});
		radVerde.setActionCommand("radVerde");
		radVerde.setBounds(22, 69, 109, 23);
		frmBotonRadio.getContentPane().add(radVerde);
		
		JRadioButton radAzul = new JRadioButton("Azul");
		radAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.blue);
			}
		});
		radAzul.setActionCommand("radAzul");
		radAzul.setBounds(22, 95, 109, 23);
		frmBotonRadio.getContentPane().add(radAzul);
		
		
		JRadioButton radRosa = new JRadioButton("Rosa");
		radRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.pink);
			}
		});
		radRosa.setBounds(22, 121, 109, 23);
		frmBotonRadio.getContentPane().add(radRosa);
		
		JRadioButton RadMorado = new JRadioButton("Morado");
		RadMorado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.magenta);
			}
		});
		RadMorado.setBounds(22, 146, 109, 23);
		frmBotonRadio.getContentPane().add(RadMorado);
		
		JRadioButton radCian = new JRadioButton("Cian");
		radCian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.cyan);
			}
		});
		radCian.setBounds(22, 172, 109, 23);
		frmBotonRadio.getContentPane().add(radCian);
		
		JRadioButton RadAmarillo = new JRadioButton("Amarillo");
		RadAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.yellow);
			}
		});
		RadAmarillo.setBounds(22, 198, 109, 23);
		frmBotonRadio.getContentPane().add(RadAmarillo);
		
		JRadioButton RadNegro = new JRadioButton("negro");
		RadNegro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblColor.setBackground(Color.black);
			}
		});
		RadNegro.setBounds(22, 224, 109, 23);
		frmBotonRadio.getContentPane().add(RadNegro);
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(radAzul);
		grupo.add(radVerde);
		grupo.add(RadRojo);
		grupo.add(radRosa);
		grupo.add(RadMorado);
		grupo.add(radCian);
		grupo.add(RadNegro);
		grupo.add(RadAmarillo);
	}
}
