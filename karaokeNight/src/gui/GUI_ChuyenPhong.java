package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_Phong;
import entity.Phong;
import entity.TaiKhoan;

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
	private JTextField textField_SoLuongNguoi;
	private JLabel lblGiaPhong;
	private JTextField textField_GiaPhong;
	private JLabel lblMaPhong_1;
	private JComboBox comboBox_MaPhongChuyenDen;
	private JLabel lblLoaiPhong_1;
	private JTextField textField_LoaiPhong1;
	private JLabel lblSucChua_1;
	private JTextField textField_SoLuongNguoi1;
	private JLabel lblGiaPhong_1;
	private JTextField textField_GiaPhong1;
	private JLabel lbl_icon_rightbig;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private String  maPhongChuyenDi ;
	private String  maPhongChuyenDen ;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */
	


	/**
	 * Create the frame.
	 */
	public GUI_ChuyenPhong(TaiKhoan taiKhoan) {
		tk=taiKhoan;
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720,572);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		setLocationRelativeTo(null);
		JLabel lblChuyenphong = new JLabel("Chuyển Phòng");
		lblChuyenphong.setBounds(258, 10, 190, 46);
		lblChuyenphong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblChuyenphong);
		
		textField_MaPhongChuyenDi = new JTextField();
		textField_MaPhongChuyenDi.setEditable(false);
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
		
		comboBox_MaPhongChuyenDi = new JComboBox();
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
		textField_LoaiPhong.setEditable(false);
		textField_LoaiPhong.setColumns(10);
		textField_LoaiPhong.setBounds(155, 242, 131, 40);
		contentPane.add(textField_LoaiPhong);
		
		lblSucChua = new JLabel("Số lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(49, 313, 120, 40);
		contentPane.add(lblSucChua);
		
		textField_SoLuongNguoi1 = new JTextField();
		textField_SoLuongNguoi1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoLuongNguoi1.setEditable(false);
		textField_SoLuongNguoi1.setColumns(10);
		textField_SoLuongNguoi1.setBounds(155, 313, 131, 40);
		contentPane.add(textField_SoLuongNguoi1);
		
		lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(49, 390, 120, 40);
		contentPane.add(lblGiaPhong);
		
		textField_GiaPhong = new JTextField();
		textField_GiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_GiaPhong.setEditable(false);
		textField_GiaPhong.setColumns(10);
		textField_GiaPhong.setBounds(155, 390, 131, 40);
		contentPane.add(textField_GiaPhong);
		
		lblMaPhong_1 = new JLabel("Mã Phòng");
		lblMaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong_1.setBounds(418, 168, 120, 40);
		contentPane.add(lblMaPhong_1);
		
		comboBox_MaPhongChuyenDen = new JComboBox();
		comboBox_MaPhongChuyenDen.setBounds(524, 169, 131, 40);
		contentPane.add(comboBox_MaPhongChuyenDen);
		
		lblLoaiPhong_1 = new JLabel("Loại Phòng");
		lblLoaiPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong_1.setBounds(418, 242, 120, 40);
		contentPane.add(lblLoaiPhong_1);
		
		textField_LoaiPhong1 = new JTextField();
		textField_LoaiPhong1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_LoaiPhong1.setEditable(false);
		textField_LoaiPhong1.setColumns(10);
		textField_LoaiPhong1.setBounds(524, 242, 131, 40);
		contentPane.add(textField_LoaiPhong1);
		
		lblSucChua_1 = new JLabel("Số lượng người");
		lblSucChua_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua_1.setBounds(418, 313, 120, 40);
		contentPane.add(lblSucChua_1);
		
		textField_SoLuongNguoi1 = new JTextField();
		textField_SoLuongNguoi1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoLuongNguoi1.setEditable(false);
		textField_SoLuongNguoi1.setColumns(10);
		textField_SoLuongNguoi1.setBounds(524, 313, 131, 40);
		contentPane.add(textField_SoLuongNguoi1);
		
		lblGiaPhong_1 = new JLabel("Giá Phòng");
		lblGiaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong_1.setBounds(418, 390, 120, 40);
		contentPane.add(lblGiaPhong_1);
		
		textField_GiaPhong1 = new JTextField();
		textField_GiaPhong1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_GiaPhong1.setEditable(false);
		textField_GiaPhong1.setColumns(10);
		textField_GiaPhong1.setBounds(524, 390, 131, 40);
		contentPane.add(textField_GiaPhong1);
		
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
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			
			}
		});
		contentPane.add(btnHuy);
		
		docDuLieuTuSQL();
	}
	
	private void docDuLieuTuSQL() {
		
	    Dao_Phong phong = new Dao_Phong();
	    double GiaPhong,GiaPhong1;
	    String LoaiPhong,LoaiPhong1;
	    int soLuongNguoi,soLuongNguoi1;
	
		for (Phong p : phong.getAllPhong()) {
			maPhongChuyenDi = p.getMaPhong();
			comboBox_MaPhongChuyenDi.addItem(maPhongChuyenDi);
			maPhongChuyenDen = p.getMaPhong();
			comboBox_MaPhongChuyenDen.addItem(maPhongChuyenDen);
			
		
			
			
		}
		
		
	}

}
