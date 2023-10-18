package barraProgreso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarraProgreso {

	 JFrame frmBarraProgreso;
	private JProgressBar BarrarProgreso;
	private JButton btnStart;
String nombre="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraProgreso window = new BarraProgreso();
					window.frmBarraProgreso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BarraProgreso() {
		initialize();
	}
	public void start() {
		nombre=JOptionPane.showInputDialog("ingresa tu nombre");
		Thread hilo=new Thread (new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<=100;i++) {
					BarrarProgreso.setValue(i);
					try {
						Thread.sleep(20);
					}catch(InterruptedException e) {
							e.printStackTrace();
						}
					if(i==100) {
						Hola Hola=new Hola(nombre);
						Hola.frmHola.show(true);
						frmBarraProgreso.show(false);
					}
				}
					
				}
				
				
			});
		hilo.start();
		
			
		
	}
	private void initialize() {
		frmBarraProgreso = new JFrame();
		frmBarraProgreso.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmBarraProgreso.setTitle("Barra Progreso");
		frmBarraProgreso.setBounds(100, 100, 450, 300);
		frmBarraProgreso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBarraProgreso.getContentPane().setLayout(null);
		frmBarraProgreso.setLocationRelativeTo(null);
		BarrarProgreso = new JProgressBar();
		BarrarProgreso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BarrarProgreso.setStringPainted(true);
		BarrarProgreso.setForeground(Color.GREEN);
		BarrarProgreso.setBounds(10, 51, 414, 82);
		frmBarraProgreso.getContentPane().add(BarrarProgreso);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStart.setBounds(159, 144, 111, 40);
		frmBarraProgreso.getContentPane().add(btnStart);
	}
}
