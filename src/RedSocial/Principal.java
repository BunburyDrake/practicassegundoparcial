package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public JFrame frmPrincipal;
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
					window.frmPrincipal.setVisible(true);
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
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Principal");
		frmPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmPrincipal.setBounds(100, 100, 450, 300);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudU.frmUsuario.setVisible(true);
			}
		});
		btnUsuario.setBounds(265, 11, 159, 57);
		frmPrincipal.getContentPane().add(btnUsuario);
		
		JButton btnPulicacion = new JButton("Publicacion");
		btnPulicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudP.frame.setVisible(true);
			}
			
		});
		btnPulicacion.setBounds(10, 11, 132, 57);
		frmPrincipal.getContentPane().add(btnPulicacion);
		
		JButton btnComentario = new JButton("Comentario");
		btnComentario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				crudC.frame.setVisible(true);
			}
		});
		btnComentario.setBounds(10, 79, 132, 57);
		frmPrincipal.getContentPane().add(btnComentario);
	}
}
