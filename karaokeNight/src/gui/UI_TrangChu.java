package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;

public class UI_TrangChu extends JFrame {

	private JPanel contentPane;
	public TaiKhoan taiKhoan ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_TrangChu frame = new UI_TrangChu();
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
	public UI_TrangChu() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenu mnTrangChu = new JMenu("Trang Chủ");
		mnTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnTrangChu.setBounds(10, 10, 111, 24);
		mnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		mnTrangChu.setForeground(SystemColor.inactiveCaptionText);
		contentPane.add(mnTrangChu);
		
		JMenu mnDanhMuc = new JMenu("Danh Mục\r\n");
		mnDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnDanhMuc.setBounds(131, 10, 111, 24);
		mnDanhMuc.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(mnDanhMuc);
		
		JMenuItem mntmPhong = new JMenuItem("Phòng");
		mnDanhMuc.add(mntmPhong);
		
		JMenuItem mntmNhanVien = new JMenuItem("Nhân Viên\r\n");
		mnDanhMuc.add(mntmNhanVien);
		
		JMenuItem mntmKhachHang = new JMenuItem("Khách Hàng");
		mnDanhMuc.add(mntmKhachHang);
		
		JMenuItem mntmDichVu = new JMenuItem("Dịch Vụ");
		mnDanhMuc.add(mntmDichVu);
		
		JMenu mnXuLy = new JMenu("Xử Lý");
		mnXuLy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnXuLy.setBounds(252, 10, 111, 24);
		contentPane.add(mnXuLy);
		
		JMenuItem mntmDatPhong = new JMenuItem("Đặt Phòng");
		mnXuLy.add(mntmDatPhong);
		
		JMenuItem mntmThuePhong = new JMenuItem("Thuê Phong");
		mnXuLy.add(mntmThuePhong);
		
		JMenuItem mntmChuyenPhong = new JMenuItem("Chuyển Phòng");
		mnXuLy.add(mntmChuyenPhong);
		
		JMenuItem mntmThanhToan = new JMenuItem("Thanh Toán");
		mnXuLy.add(mntmThanhToan);
		
		JMenuItem mntmThemDichVu = new JMenuItem("Thêm Dịch Vụ");
		mnXuLy.add(mntmThemDichVu);
		
		JMenu mnTimKiem = new JMenu("Tìm Kiếm");
		mnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnTimKiem.setBounds(373, 10, 111, 24);
		contentPane.add(mnTimKiem);
		
		JMenuItem mntmTKPhong = new JMenuItem("Phòng");
		mnTimKiem.add(mntmTKPhong);
		
		JMenuItem mntmTKNhanVien = new JMenuItem("Nhân Viên");
		mnTimKiem.add(mntmTKNhanVien);
		
		JMenuItem mntmTKKhachHang = new JMenuItem("Khách Hàng");
		mnTimKiem.add(mntmTKKhachHang);
		
		JMenuItem mntmTKDichVu = new JMenuItem("Dịch Vụ");
		mnTimKiem.add(mntmTKDichVu);
		
		JMenu mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnThongKe.setBounds(494, 10, 111, 24);
		contentPane.add(mnThongKe);
		
		JMenuItem mntmHoaDon = new JMenuItem("Hoá Đơn");
		mnThongKe.add(mntmHoaDon);
		
		JMenuItem mntmDanhMuc = new JMenuItem("Doanh Thu");
		mnThongKe.add(mntmDanhMuc);
		
		JMenu mnTroGiup = new JMenu("Trợ Giúp\r\n");
		mnTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnTroGiup.setBounds(615, 10, 111, 24);
		contentPane.add(mnTroGiup);
		
		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setBounds(587, 44, 155, 35);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblTrangChu);
		
		JButton btnThongTinTaiKhoan = new JButton("Thông Tin Tài Khoản");
		btnThongTinTaiKhoan.setBounds(55, 440, 222, 60);
		btnThongTinTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnThongTinTaiKhoan);
		
		JButton btnDangXuat = new JButton("Đăng Xuất\r\n");
		btnDangXuat.setBounds(55, 600, 222, 60);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnDangXuat);
		
		JButton btnDoiMatKhau = new JButton("Đổi Mật Khẩu\r\n");
		btnDoiMatKhau.setBounds(55, 520, 222, 60);
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnDoiMatKhau);
		
		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHinhNen.setBounds(319, 104, 1119, 585);
		lblHinhNen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhNen.setIcon(new ImageIcon("image/Quanly.png"));
		contentPane.add(lblHinhNen);
		
		JLabel lblMaNhanVien = new JLabel("NV001");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblMaNhanVien.setBounds(1309, 48, 105, 30);
		contentPane.add(lblMaNhanVien);
	}
}
