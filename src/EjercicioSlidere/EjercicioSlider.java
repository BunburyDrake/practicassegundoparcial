package EjercicioSlidere;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class EjercicioSlider {

	private JFrame frmSlider;
	private JLabel lblVRojo;
	private JLabel lblValorRGB;
	private JSlider sldVerde;
	private JLabel lblAzul;
	private JSlider sldAzul;
	private JLabel lblVerde;
	private JLabel lblRojo;
	private JSlider sldRojo;
	private JLabel lblVAzul;
	private JLabel lblVVerde;
	int r = 0, g = 0, b = 0;
	private JLabel lblColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioSlider window = new EjercicioSlider();
					window.frmSlider.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjercicioSlider() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSlider = new JFrame();
		frmSlider.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmSlider.setTitle("Slider");
		frmSlider.setBounds(100, 100, 450, 300);
		frmSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSlider.getContentPane().setLayout(null);
		frmSlider.setLocationRelativeTo(null);
		lblRojo = new JLabel("Rojo");
		lblRojo.setBounds(10, 26, 149, 14);
		frmSlider.getContentPane().add(lblRojo);

		lblVerde = new JLabel("Verde");
		lblVerde.setBounds(10, 85, 46, 14);
		frmSlider.getContentPane().add(lblVerde);

		lblAzul = new JLabel("Azul");
		lblAzul.setBounds(10, 140, 46, 14);
		frmSlider.getContentPane().add(lblAzul);
		lblValorRGB = new JLabel("RGB");
		lblValorRGB.setBounds(10, 208, 277, 42);
		frmSlider.getContentPane().add(lblValorRGB);

		lblColor = new JLabel("");
		lblColor.setOpaque(true);
		lblColor.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblColor.setBounds(227, 11, 185, 195);
		frmSlider.getContentPane().add(lblColor);

		lblVRojo = new JLabel("0");
		lblVRojo.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lblVRojo.setBounds(183, 49, 30, 25);
		frmSlider.getContentPane().add(lblVRojo);

		lblVVerde = new JLabel("0");
		lblVVerde.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lblVVerde.setBounds(183, 151, 30, 25);
		frmSlider.getContentPane().add(lblVVerde);

		lblVAzul = new JLabel("0");
		lblVAzul.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lblVAzul.setBounds(183, 103, 30, 25);
		frmSlider.getContentPane().add(lblVAzul);

		sldRojo = new JSlider();
		sldRojo.setValue(0);
		sldRojo.setMaximum(255);
		sldRojo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				cambiarColor();
			}
		});
		sldRojo.setBounds(10, 48, 163, 26);
		frmSlider.getContentPane().add(sldRojo);

		sldVerde = new JSlider();
		sldVerde.setValue(0);
		sldVerde.setMaximum(255);
		sldVerde.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				cambiarColor();
			}
		});
		sldVerde.setBounds(10, 103, 163, 26);
		frmSlider.getContentPane().add(sldVerde);

		sldAzul = new JSlider();
		sldAzul.setMaximum(255);
		sldAzul.setValue(0);
		sldAzul.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				cambiarColor();
			}
		});
		sldAzul.setBounds(10, 151, 163, 26);
		frmSlider.getContentPane().add(sldAzul);
	}

	public void cambiarColor() {
		int hexadecimal = 0;
		String caracteresHexadecimales = "0123456789abcdef";
		while (r > 0) {
			int residuo = r % 16;
			hexadecimal = caracteresHexadecimales.charAt(residuo) + hexadecimal;
			r /= 16;
		}

		r = sldRojo.getValue();
		g = sldVerde.getValue();
		b = sldAzul.getValue();
		
		lblVRojo.setText("" +r);
		lblVVerde.setText("" +b);
		lblVAzul.setText("" +g);
		String hex = String.format("#%02X%02X%02X", r, g, b);
		
		lblValorRGB.setText("Hecadecimal:" +  hex+" \nRGB:"+r+","+g+","+b);
		lblColor.setBackground(new Color(r,g,b));
	}

	private String toLowerCase(String hex) {
		// TODO Auto-generated method stub
		return null;
	}
}
