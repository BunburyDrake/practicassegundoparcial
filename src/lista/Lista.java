package lista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Lista {

	private JFrame frmLista;
	private JTextField txtNombre;
	private JList listNombres;
	private JButton btnAgregar;
	private JLabel lblNombre;
	DefaultListModel model=new DefaultListModel();

	
	private JButton btnBorrar;
	private JLabel lblHola;/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lista window = new Lista();
					window.frmLista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Lista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLista = new JFrame();
		frmLista.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLista.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmLista.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmLista.setTitle("Lista");
		frmLista.setBounds(100, 100, 342, 300);
		frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLista.getContentPane().setLayout(null);
		
		listNombres = new JList();
		listNombres.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
		        String hex = (String) listNombres.getSelectedValue(); 
		        if (hex.startsWith("#")) {
		            hex = hex.substring(1);
		        }

		        int r = Integer.parseInt(hex.substring(0, 2), 16);
		        int g = Integer.parseInt(hex.substring(2, 4), 16);
		        int b = Integer.parseInt(hex.substring(4, 6), 16);

		        Color color = new Color(r, g, b);
		        lblHola.setBackground(color);

		    

			}
		});
		
		listNombres.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listNombres.setBounds(31, 73, 161, 150);
		frmLista.getContentPane().add(listNombres);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		frmLista.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(58, 8, 86, 20);
		frmLista.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(txtNombre.getText());
				listNombres.setModel(model);
			}
		});
		btnAgregar.setBounds(10, 39, 89, 23);
		frmLista.getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtNombre.setText("");
			lblHola.setText(null);
			model.clear();
			listNombres.setModel(model);
			}
		});
		btnBorrar.setBounds(117, 39, 89, 23);
		frmLista.getContentPane().add(btnBorrar);
		
		lblHola = new JLabel("");
		lblHola.setOpaque(true);
		lblHola.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		lblHola.setBounds(202, 101, 114, 96);
		frmLista.getContentPane().add(lblHola);
		frmLista.setLocationRelativeTo(null);	}
}
