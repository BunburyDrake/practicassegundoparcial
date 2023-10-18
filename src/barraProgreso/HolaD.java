package barraProgreso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class HolaD {

	 JFrame frmHolaD;
String nombre="";
private JProgressBar bar3;
protected Object frmBarraProgreso;
	
	public HolaD(String nombre) {
		initialize();
Thread hilo=new Thread (new Runnable() {

			
			public void run() {
				
				for(int i=0;i<=100;i++) {
					bar3.setValue(i);
					try {
						Thread.sleep(20);
					}catch(InterruptedException e) {
							e.printStackTrace();
						}
					if(i==100) {
						BarraProgreso Hola1=new BarraProgreso();
						Hola1.frmBarraProgreso.show(true);
						frmHolaD.show(false);
					}
				}
					
				}
				
				
			});
		hilo.start();
		bar3 = new JProgressBar();
		bar3.setStringPainted(true);
		bar3.setBounds(109, 114, 203, 52);
		frmHolaD.getContentPane().add(bar3);
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
		frmHolaD = new JFrame();
		frmHolaD.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmHolaD.setTitle("3erVentana");
		frmHolaD.setBounds(100, 100, 450, 300);
		frmHolaD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHolaD.getContentPane().setLayout(null);
		frmHolaD.setLocationRelativeTo(null);
		
		
	}
}
