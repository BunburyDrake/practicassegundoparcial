package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public JFrame frame;
	crudComentario crudC=new crudComentario();
	crudUsuario crudU=new crudUsuario();
	crudPublicacion crudP=new crudPublicacion();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudU.frame.setVisible(true);
			}
		});
		btnUsuario.setBounds(265, 11, 159, 57);
		frame.getContentPane().add(btnUsuario);
		
		JButton btnPulicacion = new JButton("Publicacion");
		btnPulicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudP.frame.setVisible(true);
			}
			
		});
		btnPulicacion.setBounds(10, 11, 132, 57);
		frame.getContentPane().add(btnPulicacion);
		
		JButton btnComentario = new JButton("Comentario");
		btnComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudC.frame.setVisible(true);
			}
		});
		btnComentario.setBounds(10, 79, 132, 57);
		frame.getContentPane().add(btnComentario);
	}
}
