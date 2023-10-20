package RedSocial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class crudPublicacion {

	public JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTable tblPublicacion;
	private JLabel lblNewLabel;
	private JButton btnAgrgar;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private JComboBox comboBox;

	public crudPublicacion() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(21, 22, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Texto");
		lblNewLabel_1.setBounds(21, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(77, 18, 99, 22);
		frame.getContentPane().add(comboBox);
		
		btnAgrgar = new JButton("Agregar");
		btnAgrgar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnAgrgar.setBounds(263, 18, 89, 23);
		frame.getContentPane().add(btnAgrgar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(263, 51, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(263, 85, 89, 23);
		frame.getContentPane().add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(263, 119, 89, 23);
		frame.getContentPane().add(btnActualizar);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		textArea.setBounds(77, 55, 99, 87);
		frame.getContentPane().add(textArea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 414, 191);
		frame.getContentPane().add(scrollPane);
		
		tblPublicacion = new JTable();
		scrollPane.setViewportView(tblPublicacion);
		
	}
}
