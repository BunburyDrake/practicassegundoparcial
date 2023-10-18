package botonCheck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bonotCheck {

	private JFrame frmBotonCheck;
	private JLabel lblColor;
	private JCheckBox boxVerde;
	private JCheckBox boxAzul;
	private JCheckBox boxRojo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bonotCheck window = new bonotCheck();
					window.frmBotonCheck.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bonotCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBotonCheck = new JFrame();
		frmBotonCheck.setTitle("Boton Check");
		frmBotonCheck.setBounds(100, 100, 450, 300);
		frmBotonCheck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBotonCheck.getContentPane().setLayout(null);
		
		
		boxRojo = new JCheckBox("Rojo");
		boxRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarcolor();
			}
		});
		boxRojo.setBounds(6, 7, 97, 23);
		frmBotonCheck.getContentPane().add(boxRojo);
		
		boxAzul = new JCheckBox("Azul");
		boxAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarcolor();
			}
		});
		boxAzul.setBounds(6, 34, 97, 23);
		frmBotonCheck.getContentPane().add(boxAzul);
		
		
		
		
		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblColor.setBounds(190, 38, 155, 152);
		frmBotonCheck.getContentPane().add(lblColor);
		
		boxVerde = new JCheckBox("Verde");
		boxVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				asignarcolor();
			}
		});
		boxVerde.setBounds(6, 60, 97, 23);
		frmBotonCheck.getContentPane().add(boxVerde);
	}
	public void asignarcolor() {
	 int r=(boxRojo.isSelected())?255:0;
	 int v=(boxVerde.isSelected())?255:0;
	 int a=(boxAzul.isSelected())?255:0;
	 lblColor.setBackground(new Color(r,v,a));
	}
}
