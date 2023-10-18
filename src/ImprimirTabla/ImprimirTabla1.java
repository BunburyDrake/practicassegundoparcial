package ImprimirTabla;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Tabla.Pokemon;
import Tabla.Tabla1;

public class ImprimirTabla1 {

	private JFrame frmRegistroPokemon;
	JTextField txtNumControl;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnBorrar;
	private JButton btnAgregar;
	public DefaultTableModel modelo = new DefaultTableModel();

	private JScrollPane scrollPane;
	private JButton btnBorrarTabla;
	public ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
	private JLabel lblNPokemon_2;
	private JLabel lblNPokemon_3;
	private JLabel lblNPokemon_4;
	private JTextField txtAP;
	private JTextField txtAM;
	private JTextField txtCurp;
	private JTextField txtFecha;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTextField txtGrupo;
	private JTextField txtCarrera;
	private JTable tblAlumno;

	public static void main(String[] args) {

		ImprimirTabla1 x = new ImprimirTabla1();
		x.frmRegistroPokemon.setVisible(true);
	}

	public ImprimirTabla1() {
		crearInterfaz();
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */

	public void actualizarTabla() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		for (Alumno Alumno : listaAlumnos) {
			Object o[] = new Object[12];
			o[0] = Alumno.getID();
			o[1] = Alumno.getNombre();
			o[2] = Alumno.getAP();
			o[3] = Alumno.getAM();
			o[4] = Alumno.getDireccion();
			o[5] = Alumno.getCurp();
			o[6] = Alumno.getFecha();
			o[7] = Alumno.getTelefono();
			o[8] = Alumno.getCorreo();
			o[9] = Alumno.getCarrera();
			o[10] = Alumno.getGrupo();
			o[11] = Alumno.getNumControl();

			modelo.addRow(o);
		}
	}

	public void borrarTabla1() {
		listaAlumnos.clear();
		actualizarTabla();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void crearInterfaz() {
		frmRegistroPokemon = new JFrame();
		frmRegistroPokemon.setTitle("Tabla");
		frmRegistroPokemon.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmRegistroPokemon.getContentPane().setForeground(Color.LIGHT_GRAY);
		frmRegistroPokemon.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmRegistroPokemon.setBounds(100, 100, 813, 624);
		frmRegistroPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroPokemon.setLocationRelativeTo(null);
		frmRegistroPokemon.getContentPane().setLayout(null);

		JLabel lblNumControl = new JLabel("NumControl");
		lblNumControl.setBounds(10, 11, 139, 14);
		lblNumControl.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroPokemon.getContentPane().add(lblNumControl);

		txtNumControl = new JTextField();
		txtNumControl.setBounds(159, 10, 129, 20);
		txtNumControl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNumControl.getText().length() > 20) {
					e.consume();
				}
			}
		});
		frmRegistroPokemon.getContentPane().add(txtNumControl);
		txtNumControl.setColumns(10);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 36, 139, 14);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroPokemon.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(159, 35, 129, 20);
		txtNombre.setColumns(10);
		frmRegistroPokemon.getContentPane().add(txtNombre);
	 btnBorrar= new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumControl.setText("");
				txtNombre.setText("");
				txtAP.setText("");
				txtAM.setText("");
				txtCurp.setText("");
			}
		});
		btnBorrar.setBounds(417, 219, 89, 23);
		frmRegistroPokemon.getContentPane().add(btnBorrar);

		btnBorrarTabla = new JButton("borrar");
		btnBorrarTabla.setBounds(516, 219, 89, 23);
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTabla1();
			}
		});
		frmRegistroPokemon.getContentPane().add(btnBorrarTabla);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(307, 12, 455, 181);
		frmRegistroPokemon.getContentPane().add(scrollPane);

		tblAlumno = new JTable();

		scrollPane.setViewportView(tblAlumno);
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("AP");
		modelo.addColumn("AM");
		modelo.addColumn("Fecha");
		modelo.addColumn("Curp");
		modelo.addColumn("Direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Correo");
		modelo.addColumn("Grupo");
		modelo.addColumn("Carrera");
		tblAlumno.setModel(modelo);
		lblNPokemon_2 = new JLabel("Color");
		lblNPokemon_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNPokemon_2.setBounds(10, 61, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblNPokemon_2);
		lblNPokemon_3 = new JLabel("Textura");
		lblNPokemon_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNPokemon_3.setBounds(10, 86, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblNPokemon_3);
		lblNPokemon_4 = new JLabel("Procesador");
		lblNPokemon_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNPokemon_4.setBounds(10, 111, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblNPokemon_4);
		txtAP = new JTextField();
		txtAP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtAP.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtAP.setColumns(10);
		txtAP.setBounds(159, 60, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtAP);
		txtAM = new JTextField();
		txtAM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtAM.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtAM.setColumns(10);
		txtAM.setBounds(159, 85, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtAM);
		txtCurp = new JTextField();
		txtCurp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCurp.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtCurp.setColumns(10);
		txtCurp.setBounds(159, 110, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtCurp);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(159, 141, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtFecha);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 173, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtDireccion);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(159, 204, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(159, 235, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtTelefono);
		
		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		txtGrupo.setBounds(159, 266, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtGrupo);
		
		txtCarrera = new JTextField();
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(159, 297, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtCarrera);
		
		JLabel lblMarca_1 = new JLabel("Marca");
		lblMarca_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_1.setBounds(10, 144, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_1);
		
		JLabel lblMarca_2 = new JLabel("Marca");
		lblMarca_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_2.setBounds(10, 176, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_2);
		
		JLabel lblMarca_3 = new JLabel("Marca");
		lblMarca_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_3.setBounds(10, 207, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_3);
		
		JLabel lblMarca_4 = new JLabel("Marca");
		lblMarca_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_4.setBounds(10, 238, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_4);
		
		JLabel lblMarca_5 = new JLabel("Marca");
		lblMarca_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_5.setBounds(10, 269, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_5);
		
		JLabel lblMarca_6 = new JLabel("Marca");
		lblMarca_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_6.setBounds(10, 300, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_6);
		
		JLabel lblMarca_7 = new JLabel("Marca");
		lblMarca_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca_7.setBounds(10, 331, 139, 14);
		frmRegistroPokemon.getContentPane().add(lblMarca_7);
	btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(315, 219, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarTabla();
				Alumno x=new Alumno();
				x.setNumControl(txtNumControl.getText());
				x.setNombre(txtNombre.getText());
				x.setAP(txtAP.getText());
				x.setAM(txtAM.getText());
				x.setCurp(txtCurp.getText());
				x.setCorreo(txtCorreo.getText());
				x.setFecha(txtFecha.getText());
				x.setDireccion(txtDireccion.getText());
				x.setCorreo(txtCorreo.getText());
				x.setTelefono(txtTelefono.getText());
				x.setCarrera(txtCarrera.getText());
			}
		});
		frmRegistroPokemon.getContentPane().add(btnAgregar);

	
	}
}
