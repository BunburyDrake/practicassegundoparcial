package togle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Binario {

	private JFrame frmBinario;
	private JLabel lblBinario;
	private JLabel lblNewLabel_1;
	private JToggleButton btnM;
	private JToggleButton btnK;
	private JToggleButton bntP;
	private JToggleButton btnI;
	private JToggleButton btnH;
	private JToggleButton btnF;
	private JToggleButton btnE;
	private JToggleButton btnD;
	private JToggleButton btnC;
	private JToggleButton btnB;
	private JToggleButton btnA;
int decimal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Binario window = new Binario();
					window.frmBinario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Binario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBinario = new JFrame();
		frmBinario.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Alumno\\Downloads\\6.png"));
		frmBinario.setTitle("BINARIO");
		frmBinario.setBounds(100, 100, 1004, 356);
		frmBinario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBinario.setLocationRelativeTo(null);
		frmBinario.getContentPane().setLayout(null);
		
		btnK = new JToggleButton("0");
		btnK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnK.isSelected()) {
					btnK.setText("1");
					decimal+=512;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnK.setText("0");
					decimal-=512;
					lblBinario.setText("                                                                 "+decimal);
			}
			}
		});
		btnK.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnK.setBounds(171, 11, 72, 67);
		frmBinario.getContentPane().add(btnK);
		lblBinario = new JLabel("                                                                 0");
		lblBinario.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblBinario.setFont(new Font("Arial", Font.BOLD, 21));
		lblBinario.setBounds(96, 127, 803, 93);
		frmBinario.getContentPane().add(lblBinario);
		
		bntP = new JToggleButton("0");
		bntP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bntP.isSelected()) {
					bntP.setText("1");
					decimal+=256;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					bntP.setText("0");
					decimal-=256;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		bntP.setFont(new Font("Tahoma", Font.BOLD, 18));
		bntP.setBounds(253, 11, 72, 67);
		frmBinario.getContentPane().add(bntP);
		
		btnI = new JToggleButton("0");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnI.isSelected()) {
					btnI.setText("1");
					decimal+=128;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnI.setText("0");
					decimal-=128;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnI.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnI.setBounds(335, 11, 72, 67);
		frmBinario.getContentPane().add(btnI);
		
		btnH = new JToggleButton("0");
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnH.isSelected()) {
					btnH.setText("1");
					decimal+=64;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnH.setText("0");
					decimal-=64;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnH.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnH.setBounds(417, 11, 72, 67);
		frmBinario.getContentPane().add(btnH);
		
		btnC = new JToggleButton("0");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnC.isSelected()) {
					btnC.setText("1");
					decimal+=4;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnC.setText("0");
					decimal-=4;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnC.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnC.setBounds(745, 11, 72, 67);
		frmBinario.getContentPane().add(btnC);
		
		btnD = new JToggleButton("0");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnD.isSelected()) {
					btnD.setText("1");
					decimal+=8;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnD.setText("0");
					decimal-=8;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnD.setBounds(663, 11, 72, 67);
		frmBinario.getContentPane().add(btnD);
		
		btnE = new JToggleButton("0");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnE.isSelected()) {
					btnE.setText("1");
					decimal+=16;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnE.setText("0");
					decimal-=16;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnE.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnE.setBounds(581, 11, 72, 67);
		frmBinario.getContentPane().add(btnE);
		
		btnF = new JToggleButton("0");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnF.isSelected()) {
					btnF.setText("1");
					decimal+=32;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnF.setText("0");
					decimal-=32;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnF.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnF.setBounds(499, 11, 72, 67);
		frmBinario.getContentPane().add(btnF);
		
		btnB = new JToggleButton("0");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnB.isSelected()) {
					btnB.setText("1");
					decimal+=2;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnB.setText("0");
					decimal-=2;
					lblBinario.setText("                                                                 "+decimal);
			}
			}
		});
		
		btnB.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnB.setBounds(827, 11, 72, 67);
		frmBinario.getContentPane().add(btnB);
		
		btnA = new JToggleButton("0");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnA.isSelected()) {
					btnA.setText("1");
					decimal+=1;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnA.setText("0");
					decimal-=1;
					lblBinario.setText("                                                                 "+decimal);
				}
			}
		});
		btnA.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnA.setBounds(909, 11, 72, 67);
		frmBinario.getContentPane().add(btnA);
		
		
		
		lblNewLabel_1 = new JLabel("512");
		lblNewLabel_1.setBounds(181, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("256");
		lblNewLabel_1_1.setBounds(263, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("128");
		lblNewLabel_1_2.setBounds(345, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("64");
		lblNewLabel_1_3.setBounds(427, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("32");
		lblNewLabel_1_4.setBounds(509, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("16");
		lblNewLabel_1_5.setBounds(591, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("8");
		lblNewLabel_1_6.setBounds(673, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("4");
		lblNewLabel_1_7.setBounds(755, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("2");
		lblNewLabel_1_8.setBounds(837, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("1");
		lblNewLabel_1_9.setBounds(919, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_9);
		
		btnM = new JToggleButton("0");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnM.isSelected()) {
					btnM.setText("1");
					decimal+=1024;
					lblBinario.setText("                                                                 "+decimal);
				}else {
					btnM.setText("0");
					decimal-=1024;
					lblBinario.setText("                                                                 "+decimal);
			}
			}
		});
		btnM.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnM.setBounds(89, 11, 72, 67);
		frmBinario.getContentPane().add(btnM);
		
		JLabel lblNewLabel_1_10 = new JLabel("1024");
		lblNewLabel_1_10.setBounds(99, 89, 46, 14);
		frmBinario.getContentPane().add(lblNewLabel_1_10);
	}
}
