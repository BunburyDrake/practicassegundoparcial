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

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class crudPublicacion {

	public JFrame crudP;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable tblPublicacion;
	private JLabel lblNewLabel;
	private JButton btnAgrgar;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JComboBox cmbUser;
	ArrayList<Usuario> listaUsuario=null;
	ArrayList<Publicacion> listaPub;
	public DefaultTableModel model= new DefaultTableModel();
	public DefaultComboBoxModel modelCombo= new DefaultComboBoxModel();
	public crudPublicacion() {
		initialize();
		DataUsuario du=new DataUsuario();
		listaUsuario=du.SelectUsuario();
		Object nombresUsuario[]=new Object[listaUsuario.size()];
		for(int i=0;i < listaUsuario.size();i++) {
			nombresUsuario[i]=listaUsuario.get(i).getNombre();
		}
		modelCombo=new DefaultComboBoxModel(nombresUsuario);
		cmbUser.setModel(modelCombo);
		actualizarTabla();
	}
	public void actualizarTabla() {
		DataPublicacion dp = new DataPublicacion();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		listaPub = dp.SelectPublicacion();
		for (Publicacion u : listaPub) {
			Object o[] = new Object[4];
			o[0] = u.getIdpub();
			o[1] = getNombre(u.getIduser());
			o[2] = u.getTexto();
			o[3] = u.getFecha();
			model.addRow(o);

		}
		tblPublicacion.setModel(model);
	}

	public String getNombre(int Iduser) {
		String nombre="";
		for (Usuario u : listaUsuario) {
			if(u.getIduser()==Iduser) {
				nombre=u.getNombre();
			}
			
		}
		return nombre;
	}
	private void initialize() {
		crudP = new JFrame();
		crudP.setBounds(100, 100, 450, 394);
		crudP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crudP.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(21, 22, 46, 14);
		crudP.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Texto");
		lblNewLabel_1.setBounds(21, 55, 46, 14);
		crudP.getContentPane().add(lblNewLabel_1);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(77, 18, 99, 22);
		crudP.getContentPane().add(cmbUser);
		
		btnAgrgar = new JButton("Agregar");
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Publicacion p=new Publicacion();
				p.setIduser(listaUsuario.get(cmbUser.getSelectedIndex()).getIduser());
				p.setTexto(textArea.getText());
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
		btnAgrgar.setBounds(263, 18, 89, 23);
		crudP.getContentPane().add(btnAgrgar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(263, 51, 89, 23);
		crudP.getContentPane().add(btnEliminar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(263, 85, 89, 23);
		crudP.getContentPane().add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(263, 119, 89, 23);
		crudP.getContentPane().add(btnActualizar);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(77, 55, 99, 87);
		crudP.getContentPane().add(textArea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 414, 191);
		crudP.getContentPane().add(scrollPane);
		
		tblPublicacion = new JTable();
		model.addColumn("ID PUB");
		model.addColumn("Usuario");
		model.addColumn("Texto");
		model.addColumn("Fecha");
		tblPublicacion.setModel(model);
		scrollPane.setViewportView(tblPublicacion);
		
	}
}
