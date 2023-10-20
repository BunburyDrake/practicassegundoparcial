package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class crudUsuario {

	public JFrame frmUsuario;
	private JTextField txtCorreo;
	private JTextField txtPassword;
	private JTextField txtTelefono;
	private JTextField txtNombre;
	private JTable tblUsuarios;
	public ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	public DefaultTableModel model= new DefaultTableModel();
	Usuario x;
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
		frmUsuario = new JFrame();
		frmUsuario.setTitle("Usuario");
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmUsuario.setBounds(100, 100, 450, 370);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("idUser");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo");
		lblNewLabel_1.setBounds(10, 33, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(10, 120, 46, 14);
		frmUsuario.getContentPane().add(lblNewLabel_4);
		
		JLabel lblID = new JLabel("0");
		lblID.setBounds(56, 11, 46, 14);
		frmUsuario.getContentPane().add(lblID);
		
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
		frmUsuario.getContentPane().add(txtCorreo);
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
		frmUsuario.getContentPane().add(txtPassword);
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
		frmUsuario.getContentPane().add(txtTelefono);
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
		frmUsuario.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Usuario Usuario = new Usuario();
					Usuario.setCorreo(txtCorreo.getText());
					Usuario.setTelefono(txtTelefono.getText());
					Usuario.setPasword(encriptarPasword(txtPassword.getText()));
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
		btnAgregar.setBounds(10, 145, 159, 47);
		frmUsuario.getContentPane().add(btnAgregar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\actualizar1.png"));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setCorreo(txtCorreo.getText());
					x.setTelefono(txtTelefono.getText());
					x.setPasword(txtPassword.getText());
					x.setNombre(txtNombre.getText());
					
					if(x.actualizarUsuario()) {
						JOptionPane.showMessageDialog(null, "correcto");
						actualizarTabla();
						limpiarFormulario();
					}else {
						JOptionPane.showMessageDialog(null, "error");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnActualizar.setBounds(10, 196, 159, 34);
		frmUsuario.getContentPane().add(btnActualizar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\borrrar1.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrar.setBounds(10, 241, 159, 34);
		frmUsuario.getContentPane().add(btnBorrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\eliminar1.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
							JOptionPane.YES_NO_OPTION);
					System.out.print(op);
					if (op == 0) {

						if (x.EliminarUsuario()) {
							JOptionPane.showMessageDialog(null, "se elimino correctamente");
							actualizarTabla();
						} else {
							JOptionPane.showMessageDialog(null, "Error");
						}
					}
				
			}
		});
		btnEliminar.setBounds(10, 286, 159, 45);
		frmUsuario.getContentPane().add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(179, 11, 245, 309);
		frmUsuario.getContentPane().add(scrollPane);
		
		tblUsuarios = new JTable();
		tblUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblUsuarios.getSelectedRow();
				x = lista.get(fila);
				lblID.setText("" + x.getIduser());
				txtCorreo.setText(x.getCorreo());
				txtTelefono.setText(x.getTelefono());
				txtPassword.setText(x.getPasword());
				txtNombre.setText(x.getNombre());
				
			}
		});
		model.addColumn("ID USER");
		model.addColumn("CORREO");
		model.addColumn("TELEFONO");
		model.addColumn("PASSWORD");
		model.addColumn("NOMBRE");
		tblUsuarios.setModel(model);
		scrollPane.setViewportView(tblUsuarios);
	}
	public String encriptarPasword(String Pasword) {
		MessageDigest md;
		byte[] encoded=null;
		try {
			md=MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
			md.update(Pasword.getBytes());
			byte[]digest = md .digest();
			for (byte b : digest ) {
				//System.out.print(Integer.toHexString(0xFF & b));
				
			}
			System.out.println();
			encoded=Base64.encodeBase64(digest);
			//System.out.println(new String(encoded));
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(encoded);
	}

	
	public void limpiarFormulario() {
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtPassword.setText("");
		txtNombre.setText("");
	}
	
}