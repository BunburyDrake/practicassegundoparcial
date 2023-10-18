package barraProgreso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Hola {

	 JFrame frmHola;
     String nombre="";
     private JLabel lblHola;
     private JProgressBar BarraProgreso1;
	
	public Hola(String nombre) {
		this.nombre=nombre;
		initialize();
		lblHola.setText("   hola "+nombre);
		Thread hilo=new Thread (new Runnable() {

			
			public void run() {
				
				for(int i=0;i<=100;i++) {
					BarraProgreso1.setValue(i);
					try {
						Thread.sleep(20);
					}catch(InterruptedException e) {
							e.printStackTrace();
						}
					if(i==100) {
						HolaD Hola=new HolaD(nombre);
						Hola.frmHolaD.show(true);
						frmHola.show(false);
					}
				}
					
				}
				
				
			});
		hilo.start();
		
		BarraProgreso1 = new JProgressBar();
		BarraProgreso1.setStringPainted(true);
		BarraProgreso1.setBounds(108, 193, 173, 29);
		frmHola.getContentPane().add(BarraProgreso1);
	}

	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHola = new JFrame();
		frmHola.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmHola.setTitle("Hola");
		frmHola.setBounds(100, 100, 450, 300);
		frmHola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHola.setLocationRelativeTo(null);
		frmHola.getContentPane().setLayout(null);
		
		lblHola = new JLabel("         Hola");
		lblHola.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.CYAN, Color.BLUE, Color.RED));
		lblHola.setFont(new Font("Tahoma", Font.PLAIN, 51));
		lblHola.setBounds(10, 22, 396, 148);
		frmHola.getContentPane().add(lblHola);
	}

}
