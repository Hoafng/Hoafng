package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class GUI_ThemDichVu extends JFrame {

	private JPanel contentPane;
	private JTable tableLeft;
	private JTable tableRight;
	private JTextField textFieldMaDichVu;
	private JTextField textFieldTenDichVu;
	private JTextField textFieldMaPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThemDichVu frame = new GUI_ThemDichVu();
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
	public GUI_ThemDichVu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDichVu = new JLabel("Dịch Vụ");
		lblDichVu.setBounds(680, 23, 190, 35);
		lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblDichVu);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 91, 722, 652);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);
		

		JButton btnadd = new JButton("");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnadd.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\add.png"));
		btnadd.setBounds(617, 36, 53, 35);
		panelLeft.add(btnadd);
		
		panelLeft.setLayout(null);
		tableLeft = new JTable();
		tableLeft.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableLeft.setBounds(10, 21, 683, 410);
		tableLeft.setToolTipText("");
		tableLeft.setModel(new DefaultTableModel(
			new Object[][] {
				{"DVBiaTiger", "Bia tiger",22000 , 60,btnadd},
				{"DVBiaHeineken","Bia heineken" , 25000, 60, btnadd},
				{"DVBiaSaiGon","Bia saigon", 20000, 80, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
				{"DVSting", "Sting",15000 , 50, btnadd},
			},
			new String[] {
				"Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Thêm"
			}
		));
		panelLeft.add(tableLeft);
		
		JScrollPane scrollPane = new JScrollPane(tableLeft);
		scrollPane.setBounds(10, 92, 702, 343);
		panelLeft.add(scrollPane);
		
		
		JLabel lblTatCaDichVu = new JLabel("Tất cả dịch vụ");
		lblTatCaDichVu.setBounds(273, 6, 186, 35);
		lblTatCaDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelLeft.add(lblTatCaDichVu);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(724, 91, 743, 652);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JButton btnIconxoa= new JButton("");
		btnIconxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIconxoa.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\dauTru.png"));
		btnIconxoa.setBounds(617, 36, 53, 35);
		panelRight.add(btnIconxoa);
		
		panelRight.setLayout(null);
		tableRight = new JTable();
		tableRight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableRight.setBounds(10, 92, 702, 343);
		tableRight.setToolTipText("");
		tableRight.setModel(new DefaultTableModel(
			new Object[][] {
				{"DVBiaTiger", "Bia tiger",22000 , 60,btnIconxoa},
				{"DVBiaHeineken","Bia heineken" , 25000, 60, btnIconxoa},
				{"DVBiaSaiGon","Bia saigon", 20000, 80, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
				{"DVSting", "Sting",15000 , 50, btnIconxoa},
			},
			new String[] {
				"Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Hủy"
			}
		));
		panelLeft.add(tableRight);
		
		JScrollPane scrollPane1 = new JScrollPane(tableRight);
		
		JLabel lblMaDichVu = new JLabel("Mã dịch vụ");
		lblMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaDichVu.setBounds(10, 494, 89, 35);
		panelLeft.add(lblMaDichVu);
		
		textFieldMaDichVu = new JTextField();
		textFieldMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaDichVu.setColumns(10);
		textFieldMaDichVu.setBounds(100, 489, 158, 40);
		panelLeft.add(textFieldMaDichVu);
		
		JButton btnsearch = new JButton("");
		btnsearch.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\search.png"));
		btnsearch.setBounds(256, 489, 41, 40);
		panelLeft.add(btnsearch);
		
		JLabel lblTendichvu = new JLabel("Tên dịch vụ");
		lblTendichvu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTendichvu.setBounds(349, 494, 89, 35);
		panelLeft.add(lblTendichvu);
		
		textFieldTenDichVu = new JTextField();
		textFieldTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldTenDichVu.setColumns(10);
		textFieldTenDichVu.setBounds(439, 489, 158, 40);
		panelLeft.add(textFieldTenDichVu);
		
		JButton btnsearch1 = new JButton("");
		btnsearch1.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\search.png"));
		btnsearch1.setBounds(595, 489, 41, 40);
		panelLeft.add(btnsearch1);
		scrollPane1.setBounds(10, 92, 702, 343);
		panelRight.add(scrollPane1);
		
		contentPane.add(panelRight);
		
		JLabel lblDichVuDaThem = new JLabel("Dịch vụ đã thêm");
		lblDichVuDaThem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelRight.add(lblDichVuDaThem);
		
		JLabel lblMPhng = new JLabel("Mã phòng");
		lblMPhng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMPhng.setBounds(54, 486, 89, 35);
		panelRight.add(lblMPhng);
		
		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setEnabled(false);
		textFieldMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaPhong.setColumns(10);
		textFieldMaPhong.setBounds(130, 486, 158, 40);
		panelRight.add(textFieldMaPhong);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(543, 579, 158, 40);
		panelRight.add(btnXacNhan);
		
		JLabel lblDchVThm = new JLabel("Dịch vụ thêm");
		lblDchVThm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDchVThm.setBounds(269, 10, 239, 35);
		panelRight.add(lblDchVThm);
	}
}
