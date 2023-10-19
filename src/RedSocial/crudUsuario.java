package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hola.Alumno;
import hola.DataAlumno;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.util.ArrayList;

public class crudUsuario {

	public JFrame frame;
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTable tblUsuarios;
	public ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	public DefaultTableModel model= new DefaultTableModel();
	Usuario x = null;
	ArrayList<Usuario> lista;
	int fila = 0;
	int iduser = 0;
	
	public void actualizarTabla() {
		DataUsuario da = new DataUsuario();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		lista = da.SelectUsuario();
		for (Usuario Alumnoss : lista) {
			Object o[] = new Object[12];
			o[0] = Alumnoss.getIduser();
			o[1] = Alumnoss.getCorreo();
			o[2] = Alumnoss.getTelefono();
			o[3] = Alumnoss.getPasword();
			o[4] = Alumnoss.getNombre();
			
			model.addRow(o);

		}
		tblUsuarios.setModel(model);
	}
	
	public crudUsuario() {
		initialize();
		actualizarTabla();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idUser");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo");
		lblNewLabel_1.setBounds(10, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(10, 120, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0");
		lblNewLabel_5.setBounds(56, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtCorreo.getText().length()>=10) {
					e.consume();
				}
			}
		});
		txtCorreo.setBounds(56, 30, 86, 20);
		frame.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtPassword.getText().length()>=100) {
					e.consume();
				}
			}
		});
		txtPassword.setBounds(56, 58, 86, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtTelefono.getText().length()>=10) {
					e.consume();
				}
			}
		});
		txtTelefono.setBounds(56, 86, 86, 20);
		frame.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length()>=100) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(56, 117, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario Usuario = new Usuario();
					Usuario.setCorreo(txtCorreo.getText());
					Usuario.setTelefono(txtTelefono.getText());
					Usuario.setPasword(txtPassword.getText());
					Usuario.setNombre(txtNombre.getText());
					
					listaUsuario.add(Usuario);
					actualizarTabla();
					limpiarFormulario();
					if (Usuario.insertarUsuario()) {
						JOptionPane.showMessageDialog(null, "Se inseto correctamente ");

					} else {
						JOptionPane.showMessageDialog(null, "ERRROR ");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "ERRROR ");
				}
				actualizarTabla();

			}
		});
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\add (1).png"));
		btnAgregar.setBounds(10, 145, 132, 34);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(10, 190, 89, 23);
		frame.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(10, 261, 132, 34);
		frame.getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(152, 11, 272, 309);
		frame.getContentPane().add(scrollPane);
		
		tblUsuarios = new JTable();
		model.addColumn("ID USER");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("PASSWORD");
		model.addColumn("NOMBRE");
		tblUsuarios.setModel(model);
		scrollPane.setViewportView(tblUsuarios);
	}
	public void limpiarFormulario() {
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtPassword.setText("");
		txtNombre.setText("");
	}
	public String encriptarPaswsword(String pasword) {
		MessageDigest md;
		byte[] encoded=null;
		try {
			md=MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
		}
	}
	
}
