package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_ThuePhong extends JFrame {

	private JPanel contentPane;
	private JTextField textField_TenKhachHang;
	private JTextField textField_SoDienThoai;
	private JTextField textField_MaNhanVien;
	private JTextField textField_LoaiPhong;
	private JTextField textField_SoLuongNguoi;
	private JTextField textField_MaPhong;
	private JTextField textField_GiaPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThuePhong frame = new GUI_ThuePhong();
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
	public GUI_ThuePhong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThuPhng = new JLabel("Thuê Phòng");
		lblThuPhng.setBounds(280, 10, 158, 48);
		lblThuPhng.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblThuPhng);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenKhachHang.setBounds(60, 68, 120, 40);
		contentPane.add(lblTenKhachHang);
		
		textField_TenKhachHang = new JTextField();
		textField_TenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenKhachHang.setColumns(10);
		textField_TenKhachHang.setBounds(165, 68, 158, 40);
		contentPane.add(textField_TenKhachHang);
		
		textField_SoDienThoai = new JTextField();
		textField_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoDienThoai.setColumns(10);
		textField_SoDienThoai.setBounds(470, 68, 158, 40);
		contentPane.add(textField_SoDienThoai);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(374, 68, 120, 40);
		contentPane.add(lblSoDienThoai);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên ");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaNhanVien.setBounds(60, 142, 120, 40);
		contentPane.add(lblMaNhanVien);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(374, 142, 120, 40);
		contentPane.add(lblMaPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(60, 218, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		JLabel lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(374, 218, 120, 40);
		contentPane.add(lblGiaPhong);
		
		JLabel lblSucChua = new JLabel("Số lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(60, 288, 120, 40);
		contentPane.add(lblSucChua);
		
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(374, 288, 120, 40);
		contentPane.add(lblGioVaoPhong);
		
		String[] hour = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		JComboBox comboBox_Gio = new JComboBox(hour);
		comboBox_Gio.setBounds(479, 288, 54, 40);
		contentPane.add(comboBox_Gio);
		
		JLabel lblGio = new JLabel("giờ");
		lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio.setBounds(537, 288, 40, 40);
		contentPane.add(lblGio);
		
		JLabel lblPhut = new JLabel("phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut.setBounds(634, 288, 40, 40);
		contentPane.add(lblPhut);
		
		String[] minute = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
							"21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40",
							"41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
		JComboBox comboBox_Phut = new JComboBox(minute);
		comboBox_Phut.setBounds(576, 288, 54, 40);
		contentPane.add(comboBox_Phut);
		
		textField_MaNhanVien = new JTextField();
		textField_MaNhanVien.setEnabled(false);
		textField_MaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaNhanVien.setColumns(10);
		textField_MaNhanVien.setBounds(165, 142, 158, 40);
		contentPane.add(textField_MaNhanVien);
		
		textField_LoaiPhong = new JTextField();
		textField_LoaiPhong.setEnabled(false);
		textField_LoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_LoaiPhong.setColumns(10);
		textField_LoaiPhong.setBounds(165, 218, 158, 40);
		contentPane.add(textField_LoaiPhong);
		
		textField_SoLuongNguoi = new JTextField();
		textField_SoLuongNguoi.setEnabled(false);
		textField_SoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoLuongNguoi.setColumns(10);
		textField_SoLuongNguoi.setBounds(165, 288, 158, 40);
		contentPane.add(textField_SoLuongNguoi);
		
		textField_MaPhong = new JTextField();
		textField_MaPhong.setEnabled(false);
		textField_MaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaPhong.setColumns(10);
		textField_MaPhong.setBounds(470, 142, 158, 40);
		contentPane.add(textField_MaPhong);
		
		textField_GiaPhong = new JTextField();
		textField_GiaPhong.setEnabled(false);
		textField_GiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_GiaPhong.setColumns(10);
		textField_GiaPhong.setBounds(470, 218, 158, 40);
		contentPane.add(textField_GiaPhong);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(200, 367, 123, 40);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(392, 367, 123, 40);
		contentPane.add(btnHuy);
	}
}
