package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_DatPhong extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DatPhong frame = new GUI_DatPhong();
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
	public GUI_DatPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPhiutPhng = new JLabel("Phiếu đặt phòng");
		lblPhiutPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiutPhng.setBounds(590, 33, 300, 60);
		lblPhiutPhng.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblPhiutPhng);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(275, 157, 350, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã phiếu đặt phòng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(0, 0, 150, 30);
		panel_1.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(150, 0, 200, 30);
		panel_1.add(textField);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(855, 157, 350, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mã phòng");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(0, 0, 90, 30);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(150, 0, 200, 30);
		panel_1_1.add(textField_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(275, 237, 350, 30);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Loai phòng");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(0, 0, 90, 30);
		panel_1_2.add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(150, 0, 200, 30);
		panel_1_2.add(textField_2);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(855, 237, 350, 30);
		contentPane.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Giá phòng");
		lblNewLabel_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(0, 0, 90, 30);
		panel_1_2_1.add(lblNewLabel_1_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(150, 0, 200, 30);
		panel_1_2_1.add(textField_3);
		
		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBounds(275, 317, 350, 30);
		contentPane.add(panel_1_2_2);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2.setBounds(0, 0, 140, 30);
		panel_1_2_2.add(lblNewLabel_1_1_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 0, 200, 30);
		panel_1_2_2.add(textField_4);
		
		JPanel panel_1_2_2_1 = new JPanel();
		panel_1_2_2_1.setLayout(null);
		panel_1_2_2_1.setBounds(855, 317, 350, 30);
		contentPane.add(panel_1_2_2_1);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Tên khách hàng");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_1.setBounds(0, 0, 140, 30);
		panel_1_2_2_1.add(lblNewLabel_1_1_2_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(150, 0, 200, 30);
		panel_1_2_2_1.add(textField_5);
		
		JPanel panel_1_2_2_2 = new JPanel();
		panel_1_2_2_2.setLayout(null);
		panel_1_2_2_2.setBounds(275, 397, 350, 30);
		contentPane.add(panel_1_2_2_2);
		
		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Ngày đặt phòng");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2.setBounds(0, 0, 121, 30);
		panel_1_2_2_2.add(lblNewLabel_1_1_2_2_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(150, 0, 200, 30);
		panel_1_2_2_2.add(textField_6);
		
		JPanel panel_1_2_2_2_1 = new JPanel();
		panel_1_2_2_2_1.setLayout(null);
		panel_1_2_2_2_1.setBounds(275, 477, 350, 30);
		contentPane.add(panel_1_2_2_2_1);
		
		JLabel lblNewLabel_1_1_2_2_2_1 = new JLabel("Giờ nhận phòng");
		lblNewLabel_1_1_2_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2_1.setBounds(0, 0, 126, 30);
		panel_1_2_2_2_1.add(lblNewLabel_1_1_2_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 0, 50, 30);
		panel_1_2_2_2_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Giờ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(200, 0, 50, 30);
		panel_1_2_2_2_1.add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(250, 0, 50, 30);
		panel_1_2_2_2_1.add(comboBox_1);
		
		JLabel lblPht = new JLabel("Phút");
		lblPht.setHorizontalAlignment(SwingConstants.CENTER);
		lblPht.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPht.setBounds(300, 0, 50, 30);
		panel_1_2_2_2_1.add(lblPht);
		
		JPanel panel_1_2_2_2_1_1 = new JPanel();
		panel_1_2_2_2_1_1.setLayout(null);
		panel_1_2_2_2_1_1.setBounds(855, 397, 350, 30);
		contentPane.add(panel_1_2_2_2_1_1);
		
		JLabel lblNewLabel_1_1_2_2_2_1_1 = new JLabel("Ngày nhân phòng");
		lblNewLabel_1_1_2_2_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2_1_1.setBounds(0, 0, 128, 30);
		panel_1_2_2_2_1_1.add(lblNewLabel_1_1_2_2_2_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(150, 0, 200, 30);
		panel_1_2_2_2_1_1.add(textField_8);
		
		JPanel panel_1_2_2_2_1_2 = new JPanel();
		panel_1_2_2_2_1_2.setLayout(null);
		panel_1_2_2_2_1_2.setBounds(855, 477, 350, 30);
		contentPane.add(panel_1_2_2_2_1_2);
		
		JLabel lblNewLabel_1_1_2_2_2_1_2 = new JLabel("Số giờ đặt");
		lblNewLabel_1_1_2_2_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2_1_2.setBounds(0, 0, 90, 30);
		panel_1_2_2_2_1_2.add(lblNewLabel_1_1_2_2_2_1_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(150, 0, 50, 30);
		panel_1_2_2_2_1_2.add(comboBox_2);
		
		JLabel lblNewLabel_1 = new JLabel("Giờ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(200, 0, 50, 30);
		panel_1_2_2_2_1_2.add(lblNewLabel_1);
		
		JLabel lblPht_1 = new JLabel("Phút");
		lblPht_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPht_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPht_1.setBounds(300, 0, 50, 30);
		panel_1_2_2_2_1_2.add(lblPht_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(250, 0, 50, 30);
		panel_1_2_2_2_1_2.add(comboBox_1_1);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(585, 631, 120, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Hủy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(795, 631, 120, 30);
		contentPane.add(btnNewButton_1);
	}

}
