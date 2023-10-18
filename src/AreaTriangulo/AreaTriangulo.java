package AreaTriangulo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AreaTriangulo {
	public JFrame frmArea;
	public JButton btnBorrar;
	public JButton btnCalcular;
	public JTextField txtBase;
	public JTextField txtAltura;
	public JLabel lblResultado;
	public JLabel lblBase;
	public JLabel lblAltura;

	public static void main(String[] cecyte) {
		AreaTriangulo x = new AreaTriangulo();
		x.frmArea.show(true);
	}

	public AreaTriangulo() {
		crearInterfaz();
	}

	public void crearInterfaz() {
		frmArea = new JFrame();

		frmArea.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
frmArea.setTitle("Area Triangulo");
		frmArea.setBounds(100, 100, 500, 400);
		frmArea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArea.setLocationRelativeTo(null);
		frmArea.getContentPane().setLayout(null);
		lblBase = new JLabel("Base");
		lblBase.setBounds(20, 20, 80, 30);
		frmArea.getContentPane().add(lblBase);
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(20, 70, 80, 30);
		frmArea.getContentPane().add(lblAltura);
		txtBase = new JTextField("");
		txtBase.setBounds(120, 20, 80, 30);
		frmArea.getContentPane().add(txtBase);

		txtAltura = new JTextField("");
		txtAltura.setBounds(120, 70, 80, 30);
		frmArea.getContentPane().add(txtAltura);
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Arial", Font.BOLD, 30));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		lblResultado.setBounds(50, 250, 400, 70);
		frmArea.getContentPane().add(lblResultado);

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double base = Double.parseDouble(txtBase.getText());
				double altura = Double.parseDouble(txtAltura.getText());
				double area = (base * altura) / 2;
				DecimalFormat f = new DecimalFormat("#,00");
				lblResultado.setText("Area:" + f.format(area));
			}
		});
		btnCalcular.setBounds(350, 20, 80, 30);
		frmArea.getContentPane().add(btnCalcular);
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtBase.setText("");
				txtAltura.setText("");
				lblResultado.setText("Area:");
			}
		});
		btnBorrar.setBounds(350, 70, 80, 30);
		frmArea.getContentPane().add(btnBorrar);
	}
}
