package RedSocial;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class crudComentario {

	public JFrame frame;
	private JTable tblComentarios;
	 ArrayList<Usuario> listaUsuario=null;
	 ArrayList<Publicacion>listaPub=null;
	 ArrayList<Comentario>listaCom=null;
	 DefaultTableModel model=new DefaultTableModel();
	 DefaultComboBoxModel modelCombo=null;
	 DefaultComboBoxModel modelCombo2=null;
	 DataComentario dc=new DataComentario();
	 Comentario p=null;
	 int fila=0;
	 private JComboBox cmbPub;
	 private JComboBox cmbUser;
	 private JTextArea txtTexto;
	 private JLabel lblID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crudComentario window = new crudComentario();
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
	public crudComentario() {
		initialize();
		
		 DataUsuario du=new DataUsuario();
		  listaUsuario=du.SelectUsuario();
		  Object nombresUsuario[]=new Object[listaUsuario.size()];
		  for (int i = 0; i <listaUsuario.size(); i++) {
		   nombresUsuario[i]=listaUsuario.get(i).getNombre();
		  }
		  modelCombo=new DefaultComboBoxModel(nombresUsuario);
		  cmbUser.setModel(modelCombo);
		  
		  DataPublicacion dp = new DataPublicacion();
		  listaPub = dp.SelectPublicaciones();
		  Object nombresPub[] = new Object[listaPub.size()];
		 for (int i = 0; i< listaPub.size();i++) {
		  nombresPub[i] = getNombre(listaPub.get(i).getIduser())+":"+listaPub.get(i).getTexto();
		 }
		 modelCombo = new DefaultComboBoxModel(nombresPub);
		 cmbPub.setModel(modelCombo);
		 
		 actualizarTabla();
		
		  
		 }
		 public void actualizarTabla() {
		  while (model.getRowCount()>0) { 
		   model.removeRow(0);
		   }
		   listaCom = dc.SelectComentario();
		   for (Comentario u : listaCom) {
		    Object o[]=new Object[5];
		    o[0]=u.getIdCom();
		    o[1]=u.getIdPub();
		    o[2]=u.getIdUser();
		    o[3]=u.getTexto();
		    o[4]=u.getFecha();
		    
		    model.addRow(o);
		   }
		   tblComentarios.setModel(model);
		 }
		 public String getPub(int idPub) {
		  String pub = "";
		  for (Publicacion u: listaPub) {
		   if(u.getIdPub()== idPub){
		    System.out.println("id user:"+u.getIduser());
		    pub = u.getTexto();
		   }
		  }
		  return pub;
		  
		 }	
		 public String getNombre(int idUser) {
		  String nombre = null;
		  for (Usuario u: listaUsuario) {
		   if(u.getIduser()== idUser){
		    nombre = u.getNombre();
		    
		   }
		  }
		  return nombre;
		 }
		
		  public int seleccionarUsuario(Comentario p) {
		   int pos =0;
		   for (Publicacion u : listaPub) {
		   if (u.getIduser() == p.getIdPub()) {
		    
		   }
		  }
		  return pos;
		   
		  }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frame.setTitle("Comentario");
		frame.setBounds(100, 100, 706, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblID = new JLabel("ID");
		lblID.setBounds(66, 11, 46, 14);
		frame.getContentPane().add(lblID);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario");
		lblNewLabel_2.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		cmbUser = new JComboBox();
		cmbUser.setBounds(66, 32, 106, 22);
		frame.getContentPane().add(cmbUser);
		
		cmbPub = new JComboBox();
		cmbPub.setBounds(66, 61, 106, 22);
		frame.getContentPane().add(cmbPub);
		
		JLabel lblNewLabel_2_1 = new JLabel("Publicacion");
		lblNewLabel_2_1.setBounds(10, 65, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("texto");
		lblNewLabel_3.setBounds(10, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		txtTexto = new JTextArea();
		txtTexto.setBounds(66, 94, 106, 86);
		frame.getContentPane().add(txtTexto);
		
		JButton btnAgregar = new JButton("agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				     Comentario p= new Comentario();
				     p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIduser());
				     p.setIdPub(listaPub.get(cmbPub.getSelectedIndex()).getIdPub());
				     p.setTexto(txtTexto.getText());
				     if(p.insertarComentario()) {
				      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
				      actualizarTabla();
				      limpiar();
				     }else {
				      JOptionPane.showConfirmDialog(null, "ERROR");
				     }
				    } catch (Exception e2) {
				     JOptionPane.showConfirmDialog(null, "ERROR");
				    }
			}
		});
		btnAgregar.setBounds(182, 21, 89, 23);
		frame.getContentPane().add(btnAgregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 212, 628, 264);
		frame.getContentPane().add(scrollPane);
		
		tblComentarios = new JTable();
		tblComentarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 fila = tblComentarios.getSelectedRow();
				    p = listaCom.get(fila);
				    lblID.setText(""+p.getIdCom());
				    cmbUser.setSelectedIndex(seleccionarUsuario(p));
				    cmbPub.setSelectedIndex(seleccionarUsuario(p));
				    txtTexto.setText(p.getTexto());
			}
		});
		
		 JButton btnEliminar = new JButton("Eliminar");
		 btnEliminar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int op = JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar este registro?","eliminar",JOptionPane.YES_NO_OPTION);
		 	    if(op==0) {
		 	     if(p.EliminarComentario()) {
		 	      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
		 	      actualizarTabla();
		 	      limpiar();
		 	     }else {
		 	      JOptionPane.showConfirmDialog(null, "ERROR");
		 	     }
		 	    }
		 	}
		 });
		 btnEliminar.setBounds(182, 61, 89, 23);
		 frame.getContentPane().add(btnEliminar);
		 
		 JButton btnActualizar = new JButton("Actualizar");
		 btnActualizar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 try {
		 		     p.setIdUser(listaUsuario.get(cmbUser.getSelectedIndex()).getIduser());
		 		     p.setIdPub(listaPub.get(cmbPub.getSelectedIndex()).getIdPub());
		 		     p.setTexto(txtTexto.getText());
		 		     if(p.actualizarComentario()) {
		 		      JOptionPane.showConfirmDialog(null, "se inserto correctamente");
		 		     actualizarTabla();
		 		     limpiar();
		 		     }else {
		 		      JOptionPane.showConfirmDialog(null, "ERROR");
		 		     }
		 		    } catch (Exception e2) {
		 		     JOptionPane.showConfirmDialog(null, "ERROR");
		 		    }
		 		    
		 	}
		 });
		 btnActualizar.setBounds(182, 95, 89, 23);
		 frame.getContentPane().add(btnActualizar);
		
		  model.addColumn("ID COM");
		  model.addColumn("USUARIO");
		  model.addColumn("PUBLICACION");
		  model.addColumn("TEXTO");
		  model.addColumn("FECHA");
		  tblComentarios.setModel(model);
		  scrollPane.setViewportView(tblComentarios);
	}
	public void limpiar() {
		txtTexto.setText("");
		lblID.setText("0");
	}
}
