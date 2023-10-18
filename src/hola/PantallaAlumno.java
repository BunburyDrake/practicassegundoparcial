package hola;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaAlumno {

	private JFrame frmCrudAlumno;
	private JLabel lblNumero;
	private JTextField txtNumeroControl;
	private JButton btnBorrar;
	private JButton btnAgregar;
	public DefaultTableModel modelo = new DefaultTableModel();
	public ArrayList<Alumno> listaAlumno = new ArrayList<Alumno>();
	private JScrollPane gerwges;
	private JTable tblAlumnos;

	private JLabel lblNombre;
	private JLabel lblApellidoP;
	private JTextField txtApellidoP;
	private JTextField txtNombre;
	private JTextField txtApellidoM;
	private JLabel lblCorreo;
	private JLabel lblGrupo;
	private JLabel lblCarrera;
	private JLabel lblFecha;
	private JTextField txtCurp;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtGrupo;
	private JTextField txtCarrera;
	private JTextField txtFechaNac;
	private JLabel lblDireccion;
	private JLabel lblCurp;
	private JLabel lblApellidoM;
	private JLabel lblTelefono;
	private JButton btnEliminar;
	Alumno x = null;
	ArrayList<Alumno> lista;
	int fila = 0;
	int id = 0;
	private JButton btnActualizar;

	public static void main(String[] args) {

		PantallaAlumno x = new PantallaAlumno();
		x.frmCrudAlumno.setVisible(true);
	}

	public PantallaAlumno() {
		crearInterfaz();
		actualizarTabla();
	}

	public void actualizarTabla() {
		DataAlumno da = new DataAlumno();

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		lista = da.SelectAlumno();
		for (Alumno Alumnoss : lista) {
			Object o[] = new Object[12];
			o[0] = Alumnoss.getID();
			o[1] = Alumnoss.getNumControl();
			o[2] = Alumnoss.getNombre();
			o[3] = Alumnoss.getApellidoM();
			o[4] = Alumnoss.getApellidoP();
			o[5] = Alumnoss.getCurp();
			o[6] = Alumnoss.getFecha();
			o[7] = Alumnoss.getDireccion();
			o[8] = Alumnoss.getTelefono();
			o[9] = Alumnoss.getCorreo();
			o[10] = Alumnoss.getGrupo();
			o[11] = Alumnoss.getCarrera();

			modelo.addRow(o);

		}
		tblAlumnos.setModel(modelo);
	}

	private void crearInterfaz() {
		frmCrudAlumno = new JFrame();
		frmCrudAlumno.setTitle("Crud alumno");
		frmCrudAlumno.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmCrudAlumno.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmCrudAlumno.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmCrudAlumno.setBounds(100, 100, 1051, 538);
		frmCrudAlumno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrudAlumno.setLocationRelativeTo(null);
		frmCrudAlumno.getContentPane().setLayout(null);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 16, 139, 14);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmCrudAlumno.getContentPane().add(lblId);

		lblNumero = new JLabel("Numero Control");
		lblNumero.setBounds(10, 47, 139, 14);
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmCrudAlumno.getContentPane().add(lblNumero);

		txtNumeroControl = new JTextField();
		txtNumeroControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNumeroControl.getText().length() >= 14) {
					e.consume();
				}
			}
		});

		txtNumeroControl.setBounds(159, 41, 129, 20);
		txtNumeroControl.setColumns(10);
		frmCrudAlumno.getContentPane().add(txtNumeroControl);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(10, 72, 139, 14);
		frmCrudAlumno.getContentPane().add(lblNombre);
		lblApellidoP = new JLabel("Apellido Paterno");
		lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidoP.setBounds(10, 97, 139, 14);
		frmCrudAlumno.getContentPane().add(lblApellidoP);
		lblApellidoM = new JLabel("Apellido Materno");
		lblApellidoM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidoM.setBounds(10, 135, 139, 14);
		frmCrudAlumno.getContentPane().add(lblApellidoM);
		txtApellidoP = new JTextField();
		txtApellidoP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() >= 30) {
					e.consume();
				}
			}
		});

		txtApellidoP.setColumns(10);
		txtApellidoP.setBounds(159, 103, 129, 20);
		frmCrudAlumno.getContentPane().add(txtApellidoP);
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellidoP.getText().length() >= 30) {
					e.consume();
				}
			}
		});

		txtNombre.setColumns(10);
		txtNombre.setBounds(159, 72, 129, 20);
		frmCrudAlumno.getContentPane().add(txtNombre);
		txtApellidoM = new JTextField();
		txtApellidoM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellidoM.getText().length() >= 30) {
					e.consume();
				}
			}
		});

		txtApellidoM.setColumns(10);
		txtApellidoM.setBounds(159, 134, 129, 20);
		frmCrudAlumno.getContentPane().add(txtApellidoM);

		lblCurp = new JLabel("Curp");
		lblCurp.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurp.setBounds(10, 166, 139, 14);
		frmCrudAlumno.getContentPane().add(lblCurp);

		lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDireccion.setBounds(10, 191, 139, 14);
		frmCrudAlumno.getContentPane().add(lblDireccion);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(10, 216, 139, 14);
		frmCrudAlumno.getContentPane().add(lblTelefono);

		lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo.setBounds(10, 241, 139, 14);
		frmCrudAlumno.getContentPane().add(lblCorreo);

		lblGrupo = new JLabel("Grupo");
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrupo.setBounds(10, 266, 139, 14);
		frmCrudAlumno.getContentPane().add(lblGrupo);

		lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCarrera.setBounds(10, 291, 139, 14);
		frmCrudAlumno.getContentPane().add(lblCarrera);

		lblFecha = new JLabel("Fecha Nacimiento ");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFecha.setBounds(10, 316, 139, 14);
		frmCrudAlumno.getContentPane().add(lblFecha);

		txtCurp = new JTextField();
		txtCurp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCurp.getText().length() >= 18) {
					e.consume();
				}
			}
		});
		txtCurp.setColumns(10);
		txtCurp.setBounds(159, 165, 129, 20);
		frmCrudAlumno.getContentPane().add(txtCurp);

		txtDireccion = new JTextField();
		txtDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDireccion.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 190, 129, 20);
		frmCrudAlumno.getContentPane().add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTelefono.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(159, 215, 129, 20);
		frmCrudAlumno.getContentPane().add(txtTelefono);

		txtCorreo = new JTextField();
		txtCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (txtCorreo.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(159, 240, 129, 20);
		frmCrudAlumno.getContentPane().add(txtCorreo);

		txtGrupo = new JTextField();
		txtGrupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtGrupo.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(159, 265, 129, 20);
		frmCrudAlumno.getContentPane().add(txtGrupo);

		txtCarrera = new JTextField();
		txtCarrera.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCarrera.getText().length() >= 30) {
					e.consume();
				}
			}
		});
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(159, 290, 129, 20);
		frmCrudAlumno.getContentPane().add(txtCarrera);

		txtFechaNac = new JTextField();
		txtFechaNac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFechaNac.getText().length() >= 100) {
					e.consume();
				}
			}
		});
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(159, 315, 129, 20);
		frmCrudAlumno.getContentPane().add(txtFechaNac);
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Alumno alumno = new Alumno();
					alumno.setNumControl(txtNumeroControl.getText());
					alumno.setNombre(txtApellidoP.getText());
					alumno.setApellidoP(txtNombre.getText());
					alumno.setApellidoM(txtApellidoM.getText());
					alumno.setCurp(txtCurp.getText());
					alumno.setDireccion(txtDireccion.getText());
					alumno.setTelefono(txtTelefono.getText());
					alumno.setCorreo(txtCorreo.getText());
					alumno.setGrupo(txtGrupo.getText());
					alumno.setCarrera(txtCarrera.getText());
					alumno.setFecha(txtFechaNac.getText());
					listaAlumno.add(alumno);
					actualizarTabla();
					if (alumno.insertarAlumno()) {
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

		btnAgregar.setBounds(10, 341, 89, 23);

		frmCrudAlumno.getContentPane().add(btnAgregar);
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(109, 341, 89, 23);
		frmCrudAlumno.getContentPane().add(btnBorrar);

		gerwges = new JScrollPane();
		gerwges.setBounds(300, 16, 725, 472);
		frmCrudAlumno.getContentPane().add(gerwges);

		tblAlumnos = new JTable();
		tblAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fila = tblAlumnos.getSelectedRow();
				x = lista.get(fila);
				lblId.setText("" + x.getID());
				txtNumeroControl.setText(x.getNumControl());
				txtNombre.setText(x.getNombre());
				txtApellidoP.setText(x.getApellidoP());
				txtApellidoM.setText(x.getApellidoM());
				txtFechaNac.setText(x.getFecha());
				txtCurp.setText(x.getCurp());
				txtDireccion.setText(x.getDireccion());
				txtTelefono.setText(x.getTelefono());
				txtCorreo.setText(x.getCorreo());
				txtGrupo.setText(x.getGrupo());
				txtCarrera.setText(x.getCarrera());
			}
		});

		gerwges.setViewportView(tblAlumnos);
		modelo.addColumn("ID");
		modelo.addColumn("Numero ctr");
		modelo.addColumn("Nombre");
		modelo.addColumn("ApellidoP");
		modelo.addColumn("ApellidoM");
		modelo.addColumn("Curp");
		modelo.addColumn("Direccion");
		modelo.addColumn("telefono");
		modelo.addColumn("Correo");
		modelo.addColumn("Grupo");
		modelo.addColumn("Carrera");
		modelo.addColumn("Fecha nacimiento");
		tblAlumnos.setModel(modelo);
		gerwges.setViewportView(tblAlumnos);

		JLabel lblId_1 = new JLabel("Id");
		lblId_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId_1.setBounds(159, 18, 139, 14);
		frmCrudAlumno.getContentPane().add(lblId_1);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int op = JOptionPane.showConfirmDialog(null, "estas seguro de eliminar?", "Eliminar",
							JOptionPane.YES_NO_OPTION);
					System.out.print(op);
					if (op == 0) {

						if (x.EliminarAlumno()) {
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
		btnEliminar.setBounds(208, 341, 89, 23);
		frmCrudAlumno.getContentPane().add(btnEliminar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x.setNumControl(txtNumeroControl.getText());
					x.setNombre(txtApellidoP.getText());
					x.setApellidoP(txtNombre.getText());
					x.setApellidoM(txtApellidoM.getText());
					x.setCurp(txtCurp.getText());
					x.setDireccion(txtDireccion.getText());
					x.setTelefono(txtTelefono.getText());
				x.setCorreo(txtCorreo.getText());
					x.setGrupo(txtGrupo.getText());
					x.setCarrera(txtCarrera.getText());
					x.setFecha(txtFechaNac.getText());
					if(x.actualizarAlumno()) {
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
		btnActualizar.setBounds(109, 373, 89, 23);
		frmCrudAlumno.getContentPane().add(btnActualizar);
	}

	public void limpiarFormulario() {
		txtNumeroControl.setText("");
		txtNombre.setText("");
		txtApellidoP.setText("");
		txtApellidoM.setText("");
		txtFechaNac.setText("");
		txtCurp.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtGrupo.setText("");
		txtCarrera.setText("");
	}
}
