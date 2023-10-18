package Tabla;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Tabla1 {

	private JFrame frmRegistroPokemon;
	JTextField txtMarca;
	private JLabel lblNPokemon_1;
	private JTextField txtModelo;
	private JButton btnBorrar;
	private JButton btnAgregar;
	public DefaultTableModel modelo = new DefaultTableModel();

	private JScrollPane scrollPane;
	private JTable tblPokemones;
	private JButton btnBorrarTabla;
	public ArrayList<Pokemon> listaPokemones = new ArrayList<Pokemon>();
	private JLabel lblNPokemon_2;
	private JLabel lblNPokemon_3;
	private JLabel lblNPokemon_4;
	private JTextField txtColor;
	private JTextField txtTextura;
	private JTextField txtProcesador;

	public static void main(String[] args) {

		Tabla1 x = new Tabla1();
		x.frmRegistroPokemon.setVisible(true);
	}

	public Tabla1() {
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
		for (Pokemon pokemon : listaPokemones) {
			Object o[] = new Object[5];
			o[0] = pokemon.getMarca();
			o[1] = pokemon.getModelo();
			o[2] = pokemon.getColor();
			o[3] = pokemon.getTextura();
			o[4] = pokemon.getProcesador();

			modelo.addRow(o);
		}
	}

	public void borrarTabla1() {
		listaPokemones.clear();
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
		frmRegistroPokemon.setBounds(100, 100, 518, 409);
		frmRegistroPokemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegistroPokemon.setLocationRelativeTo(null);
		frmRegistroPokemon.getContentPane().setLayout(null);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 139, 14);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroPokemon.getContentPane().add(lblMarca);

		txtMarca = new JTextField();
		txtMarca.setBounds(159, 10, 129, 20);
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtMarca.getText().length() > 20) {
					e.consume();
				}
			}
		});
		frmRegistroPokemon.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		lblNPokemon_1 = new JLabel("Modelo");
		lblNPokemon_1.setBounds(10, 36, 139, 14);
		lblNPokemon_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmRegistroPokemon.getContentPane().add(lblNPokemon_1);

		txtModelo = new JTextField();
		txtModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtModelo.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtModelo.setBounds(159, 35, 129, 20);
		txtModelo.setColumns(10);
		frmRegistroPokemon.getContentPane().add(txtModelo);
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 132, 89, 23);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon celular = new Pokemon();
				celular.setMarca(txtMarca.getText());
				celular.setModelo(txtModelo.getText());
				celular.setColor(txtColor.getText());
				celular.setTextura(txtTextura.getText());
				celular.setProcesador(txtProcesador.getText());
				listaPokemones.add(celular);
				actualizarTabla();
			}
		});
		frmRegistroPokemon.getContentPane().add(btnAgregar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMarca.setText("");
				txtModelo.setText("");
				txtColor.setText("");
				txtTextura.setText("");
				txtProcesador.setText("");
			}
		});
		btnBorrar.setBounds(109, 132, 89, 23);
		frmRegistroPokemon.getContentPane().add(btnBorrar);

		btnBorrarTabla = new JButton("borrar");
		btnBorrarTabla.setBounds(208, 132, 89, 23);
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarTabla1();
			}
		});
		frmRegistroPokemon.getContentPane().add(btnBorrarTabla);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 178, 455, 181);
		frmRegistroPokemon.getContentPane().add(scrollPane);

		tblPokemones = new JTable();

		scrollPane.setViewportView(tblPokemones);
		modelo.addColumn("Modelo");
		modelo.addColumn("Marca");
		modelo.addColumn("Color");
		modelo.addColumn("Textura");
		modelo.addColumn("Procesador");
		tblPokemones.setModel(modelo);
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
		txtColor = new JTextField();
		txtColor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtColor.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtColor.setColumns(10);
		txtColor.setBounds(159, 60, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtColor);
		txtTextura = new JTextField();
		txtTextura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtTextura.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtTextura.setColumns(10);
		txtTextura.setBounds(159, 85, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtTextura);
		txtProcesador = new JTextField();
		txtProcesador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtProcesador.getText().length() > 20) {
					e.consume();
				}
			}
		});
		txtProcesador.setColumns(10);
		txtProcesador.setBounds(159, 110, 129, 20);
		frmRegistroPokemon.getContentPane().add(txtProcesador);

	}
}
