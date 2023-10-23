package customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hola.Alumno;
import hola.DataAlumno;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class crudCustomer {

	private JFrame frmCustomer;
	private JTextField txtCompanyName;
	private JTextField txtContactName;
	private JTextField txtContactTitle;
	private JTextField txtAddress;
	private JTextField txtCity;
	private JTextField txtRegion;
	private JTextField txtPostalCode;
	private JTextField txtCountry;
	private JTextField txtPhone;
	private JTextField txtFax;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnBorrar;
	private JButton btnAgregar;
	Customer x = null;
	ArrayList<Customer> lista;
	int fila = 0;
	int id = 0;
	public DefaultTableModel modelo = new DefaultTableModel();
	public ArrayList<Customer> listaCustomer = new ArrayList<Customer>();
	private JTable tblCustomer;
	private JLabel lblID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crudCustomer window = new crudCustomer();
					window.frmCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public crudCustomer() {
		initialize();
		actualizarTabla();
	}
	public void actualizarTabla() {
		DataCustomer da = new DataCustomer();

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		lista = da.SelectCustomer();
		for (Customer Alumnoss : lista) {
			Object o[] = new Object[11];
			o[0] = Alumnoss.getCustomerID();
			o[1] = Alumnoss.getCompanyName();
			o[2] = Alumnoss.getContactName();
			o[3] = Alumnoss.getContactTitle();
			o[4] = Alumnoss.getAddress();
			o[5] = Alumnoss.getCity();
			o[6] = Alumnoss.getRegion();
			o[7] = Alumnoss.getPostalCode();
			o[8] = Alumnoss.getCountry();
			o[9] = Alumnoss.getPhone();
			o[10] = Alumnoss.getFax();


			modelo.addRow(o);

		}
		tblCustomer.setModel(modelo);
	}


	private void initialize() {
		frmCustomer = new JFrame();
		frmCustomer.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmCustomer.setTitle("Customer");
		frmCustomer.setBounds(100, 100, 924, 656);
		frmCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCustomer.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 11, 86, 14);
		frmCustomer.getContentPane().add(lblId);
		
		JLabel lblCompanyName = new JLabel("company name");
		lblCompanyName.setBounds(10, 36, 86, 14);
		frmCustomer.getContentPane().add(lblCompanyName);
		
		JLabel lblContactName = new JLabel("Contact Name");
		lblContactName.setBounds(10, 61, 86, 14);
		frmCustomer.getContentPane().add(lblContactName);
		
		JLabel lblContactTitle = new JLabel("ContactTitle");
		lblContactTitle.setBounds(10, 86, 86, 14);
		frmCustomer.getContentPane().add(lblContactTitle);
		
		txtCompanyName = new JTextField();
		txtCompanyName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCompanyName.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtCompanyName.setBounds(106, 33, 86, 20);
		frmCustomer.getContentPane().add(txtCompanyName);
		txtCompanyName.setColumns(10);
		
		txtContactName = new JTextField();
		txtContactName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtContactName.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtContactName.setBounds(106, 58, 86, 20);
		frmCustomer.getContentPane().add(txtContactName);
		txtContactName.setColumns(10);
		
		txtContactTitle = new JTextField();
		txtContactTitle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtContactTitle.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtContactTitle.setBounds(106, 83, 86, 20);
		frmCustomer.getContentPane().add(txtContactTitle);
		txtContactTitle.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtAddress.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtAddress.setBounds(106, 108, 86, 20);
		frmCustomer.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCity.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtCity.setBounds(106, 133, 86, 20);
		frmCustomer.getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 111, 86, 14);
		frmCustomer.getContentPane().add(lblAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 136, 86, 14);
		frmCustomer.getContentPane().add(lblCity);
		
		JLabel lblRegion = new JLabel("Region");
		lblRegion.setBounds(10, 161, 86, 14);
		frmCustomer.getContentPane().add(lblRegion);
		
		JLabel lblPostalCode = new JLabel("PostalCode");
		lblPostalCode.setBounds(10, 186, 86, 14);
		frmCustomer.getContentPane().add(lblPostalCode);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(10, 211, 86, 14);
		frmCustomer.getContentPane().add(lblCountry);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(10, 233, 86, 14);
		frmCustomer.getContentPane().add(lblPhone);
		
		JLabel lblFax = new JLabel("Fax");
		lblFax.setBounds(10, 258, 86, 14);
		frmCustomer.getContentPane().add(lblFax);
		
		txtRegion = new JTextField();
		txtRegion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtRegion.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtRegion.setColumns(10);
		txtRegion.setBounds(106, 158, 86, 20);
		frmCustomer.getContentPane().add(txtRegion);
		
		txtPostalCode = new JTextField();
		txtPostalCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPostalCode.getText().length() >= 5) {
					e.consume();
				}
			}
		});
		txtPostalCode.setColumns(10);
		txtPostalCode.setBounds(106, 183, 86, 20);
		frmCustomer.getContentPane().add(txtPostalCode);
		
		txtCountry = new JTextField();
		txtCountry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCountry.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtCountry.setColumns(10);
		txtCountry.setBounds(106, 208, 86, 20);
		frmCustomer.getContentPane().add(txtCountry);
		
		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtPhone.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtPhone.setColumns(10);
		txtPhone.setBounds(106, 230, 86, 20);
		frmCustomer.getContentPane().add(txtPhone);
		
		txtFax = new JTextField();
		txtFax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtRegion.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtFax.setColumns(10);
		txtFax.setBounds(106, 255, 86, 20);
		frmCustomer.getContentPane().add(txtFax);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Customer alumno = new Customer();
				alumno.setCompanyName(txtCompanyName.getText());
				alumno.setContactName(txtContactName.getText());
				alumno.setContactTitle(txtContactTitle.getText());
				alumno.setAddress(txtAddress.getText());
				alumno.setCity(txtCity.getText());
				alumno.setRegion(txtRegion.getText());
				alumno.setPostalCode(txtPostalCode.getText());
				alumno.setCountry(txtCountry.getText());
				alumno.setPhone(txtPhone.getText());
				alumno.setFax(txtFax.getText());
				
				listaCustomer.add(alumno);
				actualizarTabla();
				if (alumno.insertarCustomer()) {
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
		btnAgregar.setBounds(239, 32, 89, 23);
		frmCustomer.getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnBorrar.setBounds(239, 61, 89, 23);
		frmCustomer.getContentPane().add(btnBorrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
							JOptionPane.YES_NO_OPTION);
					System.out.print(op);
					if (op == 0) {

						if (x.EliminarCustomer()) {
							JOptionPane.showMessageDialog(null, "se elimino correctamente");
							actualizarTabla();
						} else {
							JOptionPane.showMessageDialog(null, "error");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "error");
				}
			}
		});
		btnEliminar.setBounds(239, 105, 89, 23);
		frmCustomer.getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				x.setCompanyName(txtCompanyName.getText());
				x.setContactName(txtContactName.getText());
				x.setContactTitle(txtContactTitle.getText());
				x.setAddress(txtAddress.getText());
				x.setCity(txtCity.getText());
				x.setRegion(txtRegion.getText());
				x.setPostalCode(txtPostalCode.getText());
			x.setCountry(txtCountry.getText());
				x.setPhone(txtPhone.getText());
				x.setFax(txtFax.getText());
				
				if(x.actualizarCustomer()) {
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
		btnActualizar.setBounds(239, 132, 89, 23);
		frmCustomer.getContentPane().add(btnActualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 283, 802, 323);
		frmCustomer.getContentPane().add(scrollPane);
		
		tblCustomer = new JTable();
		tblCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblCustomer.getSelectedRow();
				x = lista.get(fila);
				lblID.setText("" + x.getCustomerID());
				txtCompanyName.setText(x.getCompanyName());
				txtContactTitle.setText(x.getContactName());
				txtContactName.setText(x.getContactTitle());
				txtAddress.setText(x.getAddress());
				txtCity.setText(x.getCity());
				txtRegion.setText(x.getRegion());
				txtPostalCode.setText(x.getPostalCode());
				txtCountry.setText(x.getCountry());
				txtPhone.setText(x.getPhone());
				txtFax.setText(x.getFax());
			}
		});
		modelo.addColumn("customerID");
		modelo.addColumn("CompanyName");
		modelo.addColumn("ContactName");
		modelo.addColumn("ContactTitle");
		modelo.addColumn("Address");
		modelo.addColumn("City");
		modelo.addColumn("Region");
		modelo.addColumn("PostalCode");
		modelo.addColumn("Country");
		modelo.addColumn("Phone");
		modelo.addColumn("Fax");
		
		tblCustomer.setModel(modelo);
		scrollPane.setViewportView(tblCustomer);
		
		lblID = new JLabel("0");
		lblID.setBounds(106, 11, 86, 14);
		frmCustomer.getContentPane().add(lblID);
	}
	public void limpiarFormulario() {
		txtCompanyName.setText("");
		txtContactTitle.setText("");
		txtContactName.setText("");
		txtAddress.setText("");
		txtCity.setText("");
		txtRegion.setText("");
		txtPostalCode.setText("");
		txtCountry.setText("");
		txtPhone.setText("");
		txtFax.setText("");
		
	}
}
