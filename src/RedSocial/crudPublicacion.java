package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import hola.Alumno;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class crudPublicacion {

	public JFrame crudP;
	private JTextArea txtTexto;
	private JScrollPane scrollPane;
	private JTable tblPublicaciones;
	private JLabel lblNewLabel;
	private JButton btnAgrgar;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JComboBox cmbUser;
	private JButton btnEliminar;
	ArrayList<Usuario> listaUsuario=null;
	ArrayList<Publicacion> listaPub=null;
	DefaultTableModel modelo=new DefaultTableModel();
	DefaultComboBoxModel modelCombo=null;
	Publicacion x=null;
	DataPublicacion dp=new DataPublicacion();
	int fila = 0;
	
	ArrayList<Publicacion> lista;
	private JLabel lblID;
	
	public crudPublicacion() {
		initialize();
		DataUsuario du=new DataUsuario();
		listaUsuario=du.SelectUsuario();
		Object nombresUsuario[]=new Object[listaUsuario.size()];
		for (int i = 0; i < listaUsuario.size(); i++) {
			nombresUsuario[i]=listaUsuario.get(i).getNombre();
		}
		
		modelCombo=new DefaultComboBoxModel(nombresUsuario);
		cmbUser.setModel(modelCombo);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(21, 22, 46, 14);
		crudP.getContentPane().add(lblNewLabel_2);
		
		lblID = new JLabel("ID");
		lblID.setBounds(77, 22, 46, 14);
		crudP.getContentPane().add(lblID);
		actualizarTabla();
	}
	
	public void actualizarTabla() {
		DataPublicacion dp = new DataPublicacion();

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		listaPub = dp.SelectPublicaciones();
		for (Publicacion u : listaPub) {
			Object o[] = new Object[4];
			o[0] = u.getIdPub();
			o[1] = getNombre(u.getIduser());
			o[2] = u.getTexto();
			o[3] = u.getFecha();
			modelo.addRow(o);

		}
		tblPublicaciones.setModel(modelo);
	}

	public String getNombre(int idUser) {
		String nombre="";
		for (Usuario u : listaUsuario) {
			if(u.getIduser()==idUser) {
				nombre=u.getNombre();
			}
			
		}
		return nombre;
	}
	public int seleccionarUsuario(Publicacion x) {
		int pos=0;
		for (Usuario u : listaUsuario) {
			if(u.getIduser()==x.getIduser()) {
				break;
			}
			pos++;
		}
		return pos;
	}
	private void initialize() {
		crudP = new JFrame();
		crudP.setTitle("Publicaciones");
		crudP.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		crudP.setBounds(100, 100, 692, 592);
		crudP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crudP.setLocationRelativeTo(null);
		crudP.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(21, 55, 46, 14);
		crudP.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Texto");
		lblNewLabel_1.setBounds(21, 89, 46, 14);
		crudP.getContentPane().add(lblNewLabel_1);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(77, 47, 99, 22);
		crudP.getContentPane().add(cmbUser);
		
		btnAgrgar = new JButton("Agregar");
		btnAgrgar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\agregrarer.jpg"));
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Publicacion p=new Publicacion();
				p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIduser());
				p.setTexto(txtTexto.getText());
				if(p.insertarPublicacion()) {
					JOptionPane.showMessageDialog(null, "se insertio correctamente");
					actualizarTabla();
				}else {
					JOptionPane.showMessageDialog(null, "Error");
				}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnAgrgar.setBounds(245, 18, 133, 51);
		crudP.getContentPane().add(btnAgrgar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\eliminar1.png"));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
						JOptionPane.YES_NO_OPTION);
				System.out.print(op);
				if (op == 0) {
					if (x.EliminarPublicacion()) {
						JOptionPane.showMessageDialog(null, "se elimino correctamente");
						actualizarTabla();
					} else {
						JOptionPane.showMessageDialog(null, "error");
					}
				}
				
			}
		});
		btnEliminar.setBounds(421, 18, 133, 51);
		crudP.getContentPane().add(btnEliminar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\borrrar1.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnBorrar.setBounds(421, 89, 133, 53);
		crudP.getContentPane().add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\actualizar1.png"));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIduser());
					x.setTexto(txtTexto.getText());
					
					if(x.actualizarPublicacion()) {
						JOptionPane.showMessageDialog(null, "correcto");
						actualizarTabla();
						limpiarFormulario();
					}else {
						JOptionPane.showMessageDialog(null, "Error");
					}
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnActualizar.setBounds(245, 89, 133, 57);
		crudP.getContentPane().add(btnActualizar);
		
		txtTexto = new JTextArea();
		txtTexto.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTexto.setBounds(77, 85, 99, 87);
		crudP.getContentPane().add(txtTexto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 179, 656, 347);
		crudP.getContentPane().add(scrollPane);
		
		tblPublicaciones = new JTable();
		tblPublicaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblPublicaciones.getSelectedRow();			
				x=listaPub.get(fila);
				lblID.setText(""+x.getIdPub());
				cmbUser.setSelectedIndex(seleccionarUsuario(x));;
				txtTexto.setText(x.getTexto());
				
			}
		});
		modelo.addColumn("ID PUB");
		modelo.addColumn("Usuario");
		modelo.addColumn("Texto");
		modelo.addColumn("Fecha");
		tblPublicaciones.setModel(modelo);
		scrollPane.setViewportView(tblPublicaciones);
		
	}
	public void limpiarFormulario() {
		txtTexto.setText("");
		
	}
}