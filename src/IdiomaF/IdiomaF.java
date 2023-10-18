package IdiomaF;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class IdiomaF {

	private JFrame frmIdiomaf;
	private JTextField txtTexto;
	private JTextArea txtTraduccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdiomaF window = new IdiomaF();
					window.frmIdiomaf.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IdiomaF() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIdiomaf = new JFrame();
		frmIdiomaf.setTitle("IdiomaF");
		frmIdiomaf.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmIdiomaf.setBounds(100, 100, 450, 300);
		frmIdiomaf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIdiomaf.getContentPane().setLayout(null);
		
		txtTexto = new JTextField();
		txtTexto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String texto=txtTexto.getText().toString();
				texto=texto.replace("a", "afa");
				texto=texto.replace("e", "efe");
				texto=texto.replace("i", "ifi");
				texto=texto.replace("o", "ofo");
				texto=texto.replace("u", "ufu");
				texto=texto.replace("A", "AFA");
				texto=texto.replace("E", "EFE");
				texto=texto.replace("I", "IFI");
				texto=texto.replace("O", "OFO");
				texto=texto.replace("U", "UFU");
				txtTraduccion.setText(texto);
			
			}
		});
		txtTexto.setBounds(10, 11, 414, 113);
		frmIdiomaf.getContentPane().add(txtTexto);
		txtTexto.setColumns(10);
		
		txtTraduccion = new JTextArea();
		txtTraduccion.setBounds(10, 135, 414, 115);
		frmIdiomaf.getContentPane().add(txtTraduccion);
	}
}
