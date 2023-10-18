package botonCheck;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class gasparin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gasparin frame = new gasparin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gasparin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(gasparin.class.getResource("/ing/LOGO.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Jlista");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"morado", "azul", "amarillo", "verde", "negro"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(92, 58, 81, 104);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("enviar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String enviar;
				if(list.getSelectedIndex()==-1) {
					enviar="NO HAY COLOR";
				}else {
				
				enviar ="el color seleccionado es :" + list.getSelectedValue().toString();
				}
				textField.setText(enviar);       
				
			}
		}
		);
		btnNewButton.setBounds(92, 173, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 236, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(117, 230, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
