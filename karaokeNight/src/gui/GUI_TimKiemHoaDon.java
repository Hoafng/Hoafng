package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import entity.TaiKhoan;

public class GUI_TimKiemHoaDon extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelDsHoaDon;
	private JTable tblDsHoaDon;
	private JTextField txtTenNhanVienLapHD;
	private JDateChooser dateChooser;
	private JTextField txtTenKhachHang;
	private JTextField txtNgayLapHD;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_TimKiemHoaDon(TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1480,780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tk=taiKhoan;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 1, 377, 20);
		contentPane.add(menuBar);

		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnTrangChu);

		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmTrangChu);

		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmThongTinTaiKhoan);

		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DoiMatKhau(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmDoiMatKhau);

		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		});
		mnTrangChu.add(mntmDangXuat);

		JSeparator separator = new JSeparator();
		mnTrangChu.add(separator);

		JMenu mnDanhMuc = new JMenu("Danh mục");
		menuBar.add(mnDanhMuc);

		JSeparator separator_1 = new JSeparator();
		mnDanhMuc.add(separator_1);

		JMenuItem mntmDanhMucDichVu = new JMenuItem("Dịch vụ");
		mntmDanhMucDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DichVu(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucDichVu);

		JMenuItem mntmDanhMucKhachHang = new JMenuItem("Khách hàng");
		mntmDanhMucKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_KhachHang(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucKhachHang);

		JMenuItem mntmDanhMucPhong = new JMenuItem("Phòng");
		mntmDanhMucPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Phong(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucPhong);

		JMenuItem mntmDanhMucNhanVien = new JMenuItem("Nhân viên");
		mntmDanhMucNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_NhanVien(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucNhanVien);

		JMenuItem mnXuLi = new JMenuItem(" Xử lí  ");
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm");
		menuBar.add(mnTimKiem);

		JSeparator separator_2 = new JSeparator();
		mnTimKiem.add(separator_2);

		JMenuItem mntmTimKiemDichVu = new JMenuItem("Dịch vụ");
		mntmTimKiemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemDichVu(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemDichVu);

		JMenuItem mntmTimKiemHoaDon = new JMenuItem("Hóa đơn");
		mntmTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemHoaDon(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemHoaDon);

		JMenu mnThongKe = new JMenu("Thống kê");
		menuBar.add(mnThongKe);

		JSeparator separator_3 = new JSeparator();
		mnThongKe.add(separator_3);

		JMenuItem mntmThongKeDoanhThu = new JMenuItem("Doanh thu");
		mntmThongKeDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeHoaDon(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDoanhThu);

		JMenuItem mntmThongKeDichVu = new JMenuItem("Dịch vụ");
		mntmThongKeDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeDichVu(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDichVu);

		JMenuItem mnTroGiup = new JMenuItem("Trợ giúp ");
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setForeground(new Color(101, 186, 118));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setBounds(588, 44, 300, 50);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblTrangChu);


		JPanel pnTop = new JPanel();
		pnTop.setBounds(0, 10, 1466, 52);
		pnTop.setBackground(new Color(101, 186, 118));
		contentPane.add(pnTop);

		JLabel lblTimKiemHoaDon = new JLabel("Tìm kiếm hóa đơn");
		lblTimKiemHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblTimKiemHoaDon);


		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 66, 392, 673);
		pnLeft.setToolTipText("");
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập thông tin hóa đơn cần tìm"));
		pnLeft.setLayout(null);

		JLabel lblTenNhanVienLapHD = new JLabel("Tên nhân viên lâp:");
		lblTenNhanVienLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenNhanVienLapHD.setBounds(22, 56, 143, 30);
		pnLeft.add(lblTenNhanVienLapHD);

		txtTenNhanVienLapHD = new JTextField();
		txtTenNhanVienLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenNhanVienLapHD.setBounds(169, 56, 200, 30);
		pnLeft.add(txtTenNhanVienLapHD);
		txtTenNhanVienLapHD.setColumns(10);

		JLabel lblNgaylapHD = new JLabel("Ngày lập hóa đơn:");
		lblNgaylapHD.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNgaylapHD.setBounds(22, 136, 137, 30);
		pnLeft.add(lblNgaylapHD);

		dateChooser = new JDateChooser();
		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
						if ("date".equals(e.getPropertyName())) {
							String a = sf.format(e.getNewValue());		   
							txtNgayLapHD.setText(a + "");
						}
					}
				});
		dateChooser.getCalendarButton().setBounds(170, 0, 30, 33);
		dateChooser.setBounds(169, 136, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);
		
		txtNgayLapHD = new JTextField();
		txtNgayLapHD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtNgayLapHD.setColumns(10);
		txtNgayLapHD.setBounds(0, 0, 172, 30);
		dateChooser.add(txtNgayLapHD);

		JLabel lblTenKhacHang = new JLabel("Tên khách hàng  :");
		lblTenKhacHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTenKhacHang.setBounds(22, 216, 143, 30);
		pnLeft.add(lblTenKhacHang);


		ImageIcon iconLamMoi = new ImageIcon("image//iconButton//Refresh.png");
		JButton btnLamMoiHoaDon = new JButton("Làm mới", iconLamMoi);
		btnLamMoiHoaDon.setBackground(new Color(255, 255, 140));
		btnLamMoiHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLamMoiHoaDon.setBounds(54, 377, 300, 33);
		pnLeft.add(btnLamMoiHoaDon);

		ImageIcon iconTimKiem = new ImageIcon("image//iconButton//Search.png");
		JButton btnTimKiemHoaDon = new JButton("Tìm kiếm", iconTimKiem);
		btnTimKiemHoaDon.setBackground(new Color(255, 255, 140));
		btnTimKiemHoaDon.setForeground(new Color(0, 0, 0));
		btnTimKiemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnTimKiemHoaDon.setBounds(54, 307, 300, 33);
		pnLeft.add(btnTimKiemHoaDon);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(169, 216, 200, 30);
		pnLeft.add(txtTenKhachHang);



		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 66, 1036, 673);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "Mã hóa đơn", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Tổng tiền hóa đơn","Tên khách hàng", "Tiền nhận của khách", "Tiên dư của khách"};
		modelDsHoaDon = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblDsHoaDon = new JTable(modelDsHoaDon);
		JScrollPane scrtbl = new JScrollPane(tblDsHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		scrtbl.setBounds(10, 23, 1016, 640);
		pnCenter.add(scrtbl);

	}
}
