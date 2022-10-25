package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI_ChuyenPhong extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaPhongChuyenDi;
	private JLabel lbl_iconhome;
	private JLabel lbl_iconhome1;
	private JLabel lbl_icon_rightsmall;
	private JLabel lblMaPhong;
	private JComboBox comboBox_MaPhongChuyenDi;
	private JTextField textField_MaPhongChuyenDen;
	private JLabel lblLoaiPhong;
	private JTextField textField_LoaiPhong;
	private JLabel lblSucChua;
	private JTextField textField;
	private JLabel lblGiaPhong;
	private JTextField textField_1;
	private JLabel lblMaPhong_1;
	private JComboBox comboBox_MaPhongChuyenDi_1;
	private JLabel lblLoaiPhong_1;
	private JTextField textField_2;
	private JLabel lblSucChua_1;
	private JTextField textField_3;
	private JLabel lblGiaPhong_1;
	private JTextField textField_4;
	private JLabel lbl_icon_rightbig;
	private JButton btnXacNhan;
	private JButton btnHuy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChuyenPhong frame = new GUI_ChuyenPhong();
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
	public GUI_ChuyenPhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720,572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChuynphng = new JLabel("Chuyển Phòng");
		lblChuynphng.setBounds(258, 10, 190, 46);
		lblChuynphng.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblChuynphng);
		
		textField_MaPhongChuyenDi = new JTextField();
		textField_MaPhongChuyenDi.setEnabled(false);
		textField_MaPhongChuyenDi.setBounds(155, 106, 131, 33);
		contentPane.add(textField_MaPhongChuyenDi);
		textField_MaPhongChuyenDi.setColumns(10);
		
		lbl_iconhome = new JLabel("");
		lbl_iconhome.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\home.png"));
		lbl_iconhome.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconhome.setBounds(183, 46, 65, 60);
		contentPane.add(lbl_iconhome);
		
		lbl_iconhome1 = new JLabel("");
		lbl_iconhome1.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\home.png"));
		lbl_iconhome1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconhome1.setBounds(452, 46, 65, 60);
		contentPane.add(lbl_iconhome1);
		
		lbl_icon_rightsmall = new JLabel("");
		lbl_icon_rightsmall.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\right_small.png"));
		lbl_icon_rightsmall.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_icon_rightsmall.setBounds(337, 67, 65, 60);
		contentPane.add(lbl_icon_rightsmall);
		
		lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(49, 168, 120, 40);
		contentPane.add(lblMaPhong);
		
		String [] maPhongChuyenDi = {"P001001","P001002","PVip001003"};
		comboBox_MaPhongChuyenDi = new JComboBox(maPhongChuyenDi);
		comboBox_MaPhongChuyenDi.setBounds(155, 169, 131, 40);
		contentPane.add(comboBox_MaPhongChuyenDi);
		
		textField_MaPhongChuyenDen = new JTextField();
		textField_MaPhongChuyenDen.setEnabled(false);
		textField_MaPhongChuyenDen.setColumns(10);
		textField_MaPhongChuyenDen.setBounds(418, 106, 131, 33);
		contentPane.add(textField_MaPhongChuyenDen);
		
		lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(49, 242, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		textField_LoaiPhong = new JTextField();
		textField_LoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_LoaiPhong.setEnabled(false);
		textField_LoaiPhong.setColumns(10);
		textField_LoaiPhong.setBounds(155, 242, 131, 40);
		contentPane.add(textField_LoaiPhong);
		
		lblSucChua = new JLabel("Số lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(49, 313, 120, 40);
		contentPane.add(lblSucChua);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(155, 313, 131, 40);
		contentPane.add(textField);
		
		lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(49, 390, 120, 40);
		contentPane.add(lblGiaPhong);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(155, 390, 131, 40);
		contentPane.add(textField_1);
		
		lblMaPhong_1 = new JLabel("Mã Phòng");
		lblMaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong_1.setBounds(418, 168, 120, 40);
		contentPane.add(lblMaPhong_1);
		
		String [] maPhongChuyenDen = {"P001001","P001002","PVip001003"};
		comboBox_MaPhongChuyenDi_1 = new JComboBox(maPhongChuyenDen);
		comboBox_MaPhongChuyenDi_1.setBounds(524, 169, 131, 40);
		contentPane.add(comboBox_MaPhongChuyenDi_1);
		
		lblLoaiPhong_1 = new JLabel("Loại Phòng");
		lblLoaiPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong_1.setBounds(418, 242, 120, 40);
		contentPane.add(lblLoaiPhong_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(524, 242, 131, 40);
		contentPane.add(textField_2);
		
		lblSucChua_1 = new JLabel("Số lượng người");
		lblSucChua_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua_1.setBounds(418, 313, 120, 40);
		contentPane.add(lblSucChua_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(524, 313, 131, 40);
		contentPane.add(textField_3);
		
		lblGiaPhong_1 = new JLabel("Giá Phòng");
		lblGiaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong_1.setBounds(418, 390, 120, 40);
		contentPane.add(lblGiaPhong_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(524, 390, 131, 40);
		contentPane.add(textField_4);
		
		lbl_icon_rightbig = new JLabel("");
		lbl_icon_rightbig.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\right_big.png"));
		lbl_icon_rightbig.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_icon_rightbig.setBounds(317, 268, 85, 60);
		contentPane.add(lbl_icon_rightbig);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(212, 474, 123, 40);
		contentPane.add(btnXacNhan);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(404, 474, 123, 40);
		contentPane.add(btnHuy);
	}

}
