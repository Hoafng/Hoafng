package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GUI_XuLy extends JFrame {

	private JPanel contentPane;
	private JPanel pnInit1;
	private JPanel pnInit2;
	private JLabel lblIcon;
	private JLabel lblNamePhong;
	private JLabel lblSoLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_XuLy frame = new GUI_XuLy();
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
	public GUI_XuLy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(5, 100, 1470, 110);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTinhTrang = new JLabel("Tình trạng phòng");
		lblTinhTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTinhTrang.setBounds(313, 24, 150, 30);
		panel.add(lblTinhTrang);

		JComboBox cbTinhTrang = new JComboBox();
		cbTinhTrang.setBounds(313, 54, 150, 30);
		panel.add(cbTinhTrang);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(544, 24, 150, 30);
		panel.add(lblLoaiPhong);

		JRadioButton rdLoaiPhongTatCa = new JRadioButton("Tất cả");
		rdLoaiPhongTatCa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongTatCa.setBounds(544, 54, 80, 30);
		panel.add(rdLoaiPhongTatCa);

		JRadioButton rdLoaiPhongThuong = new JRadioButton("Phòng thường");
		rdLoaiPhongThuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongThuong.setBounds(626, 54, 120, 30);
		panel.add(rdLoaiPhongThuong);

		JRadioButton rdLoaiPhongVip = new JRadioButton("Phòng vip");
		rdLoaiPhongVip.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongVip.setBounds(748, 54, 100, 30);
		panel.add(rdLoaiPhongVip);

		ButtonGroup groupLoaiPhong = new ButtonGroup();
		groupLoaiPhong.add(rdLoaiPhongTatCa);
		groupLoaiPhong.add(rdLoaiPhongThuong);
		groupLoaiPhong.add(rdLoaiPhongVip);

		JButton btnTimPhong = new JButton("Tìm phòng");
		btnTimPhong.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/baseline_search_black_24dp.png")));
		btnTimPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimPhong.setBounds(1220, 23, 180, 30);
		panel.add(btnTimPhong);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy().setVisible(true);
			}
		});
		btnLamMoi.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/baseline_update_black_24dp.png")));
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLamMoi.setBounds(1220, 54, 180, 30);
		panel.add(btnLamMoi);

		JLabel lblLoaiPhong_1 = new JLabel("Mã phòng");
		lblLoaiPhong_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong_1.setBounds(950, 24, 150, 30);
		panel.add(lblLoaiPhong_1);

		JComboBox cbTinhTrang_1 = new JComboBox();
		cbTinhTrang_1.setBounds(950, 54, 150, 30);
		panel.add(cbTinhTrang_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(5, 675, 1470, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Đang chờ");
		lblNewLabel_1_1.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-dangcho.png")));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(190, 20, 150, 30);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Đang sử dụng");
		lblNewLabel_1_2.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-dangsudung.png")));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(326, 20, 150, 30);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Trống");
		lblNewLabel_1_3.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-trong.png")));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(481, 20, 150, 30);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Phòng vip");
		lblNewLabel_1_4.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/295-2959091_vip-comments-vip-icon-png.png")));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(602, 20, 150, 30);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đã đặt");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-dadat.png")));
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(30, 20, 150, 30);
		panel_1.add(lblNewLabel_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 215, 1480, 460);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 5, 286, 450);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JButton btnThuePhong = new JButton("Thuê phòng");
		btnThuePhong.setBackground(new Color(128, 128, 128));
		btnThuePhong.setBounds(53, 70, 180, 30);
		btnThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_3.add(btnThuePhong);

		JButton btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DatPhong().setVisible(true);
			}
		});
		btnDatPhong.setBackground(new Color(128, 128, 128));
		btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDatPhong.setBounds(53, 140, 180, 30);
		panel_3.add(btnDatPhong);

		JButton btnChuyenPhong = new JButton("Chuyển phòng");
		btnChuyenPhong.setBackground(new Color(128, 128, 128));
		btnChuyenPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChuyenPhong.setBounds(53, 210, 180, 30);
		panel_3.add(btnChuyenPhong);

		JButton btnThemDichVu = new JButton("Thêm dịch vụ");
		btnThemDichVu.setBackground(new Color(128, 128, 128));
		btnThemDichVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThemDichVu.setBounds(53, 280, 180, 30);
		panel_3.add(btnThemDichVu);

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(128, 128, 128));
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThanhToan.setBounds(53, 350, 180, 30);
		panel_3.add(btnThanhToan);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(301, 5, 1174, 450);
		panel_2.add(panel_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		lblNewLabel_1_5.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-trong.png")));
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNamePhong_1_1 = new JLabel();
		lblNamePhong_1_1.setText("P0101");
		lblNamePhong_1_1.setPreferredSize(new Dimension(140, 20));
		lblNamePhong_1_1.setName("");
		lblNamePhong_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSoLuong_1_1 = new JLabel();
		lblSoLuong_1_1.setText("30");
		lblSoLuong_1_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_panel_6_1 = new GroupLayout(panel_6_1);
		gl_panel_6_1.setHorizontalGroup(
			gl_panel_6_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 145, Short.MAX_VALUE)
				.addGroup(gl_panel_6_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_6_1.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(lblSoLuong_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
				.addGroup(gl_panel_6_1.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNamePhong_1_1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_panel_6_1.setVerticalGroup(
			gl_panel_6_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 105, Short.MAX_VALUE)
				.addGroup(gl_panel_6_1.createSequentialGroup()
					.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNamePhong_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(lblSoLuong_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_6_1.setLayout(gl_panel_6_1);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(42)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(panel_6_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(786, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(316, Short.MAX_VALUE))
		);
		gl_panel_4.setAutoCreateGaps(true);
		gl_panel_4.setAutoCreateContainerGaps(true);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-trong.png")));
		
		JLabel lblNamePhong_1 = new JLabel();
		lblNamePhong_1.setText("P0101");
		lblNamePhong_1.setPreferredSize(new Dimension(140, 20));
		lblNamePhong_1.setName("");
		lblNamePhong_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSoLuong_1 = new JLabel();
		lblSoLuong_1.setText("30");
		lblSoLuong_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
					.addContainerGap(66, Short.MAX_VALUE)
					.addComponent(lblSoLuong_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(54)
					.addComponent(lblNamePhong_1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
					.addGap(55))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNamePhong_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(lblSoLuong_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_6.setLayout(gl_panel_6);
		panel_4.setLayout(gl_panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 255, 0));
		panel_5.setBounds(5, 20, 1470, 70);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel = new JLabel("Xử lí phòng");
		lblNewLabel.setBounds(6, 5, 1470, 69);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		panel_5.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 1, 377, 20);
		contentPane.add(menuBar);

		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnTrangChu);
		
		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 new GUI_DoiMatKhau().setVisible(true);
			}
		});
		
		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		mnTrangChu.add(mntmTrangChu);
		
		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_ThongTinTaiKhoan().setVisible(true);
			}
		});
		mnTrangChu.add(mntmThongTinTaiKhoan);
		mnTrangChu.add(mntmDoiMatKhau);
		
		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
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
		mnDanhMuc.add(mntmDanhMucDichVu);
		
		JMenuItem mntmDanhMucKhachHang = new JMenuItem("Khách hàng");
		mnDanhMuc.add(mntmDanhMucKhachHang);
		
		JMenuItem mntmDanhMucPhong = new JMenuItem("Phòng");
		mntmDanhMucPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Phong().setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucPhong);
		
		JMenuItem mntmDanhMucNhanVien = new JMenuItem("Nhân viên");
		mnDanhMuc.add(mntmDanhMucNhanVien);
		
		JMenuItem mnXuLi = new JMenuItem(" Xử lí  ");
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy().setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm");
		menuBar.add(mnTimKiem);

		JSeparator separator_2 = new JSeparator();
		mnTimKiem.add(separator_2);
		
		JMenuItem mntmTimKiemDichVu = new JMenuItem("Dịch vụ");
		mnTimKiem.add(mntmTimKiemDichVu);
		
		JMenuItem mntmTimKiemHoaDon = new JMenuItem("Hóa đơn");
		mnTimKiem.add(mntmTimKiemHoaDon);

		JMenu mnThongKe = new JMenu("Thống kê");
		menuBar.add(mnThongKe);

		JSeparator separator_3 = new JSeparator();
		mnThongKe.add(separator_3);
		
		JMenuItem mntmThongKeDoanhThu = new JMenuItem("Doanh thu");
		mnThongKe.add(mntmThongKeDoanhThu);
		
		JMenuItem mntmThongKeDichVu = new JMenuItem("Dịch vụ");
		mnThongKe.add(mntmThongKeDichVu);
		
		JMenuItem mnTroGiup = new JMenuItem("Trợ giúp ");
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		menuBar.add(mnTroGiup);
		docDuLieuPhong();
	}
	public void docDuLieuPhong(){
		initComponent();
	}
	private void initComponent() {
		pnInit1 = new JPanel();
		lblIcon = new JLabel();
		pnInit2 = new JPanel();
		lblNamePhong = new JLabel();
		lblSoLuong = new JLabel();
		setBackground(new Color(255,255,255));
		setMaximumSize(new Dimension(140,120));
		setMinimumSize(new Dimension(140, 120));
		setPreferredSize(new Dimension(140, 120));
		getContentPane().setLayout(new BorderLayout());
		
		pnInit1.setOpaque(false);
		pnInit1.setPreferredSize(new Dimension(140,80));
		lblIcon.setIcon(new ImageIcon(GUI_XuLy.class.getResource("/image/home-icon-trong.png")));
		GroupLayout pnInit1Layout = new GroupLayout(pnInit1);
		pnInit1.setLayout(pnInit1Layout);
		pnInit1Layout.setHorizontalGroup(
			pnInit1Layout.createParallelGroup(Alignment.LEADING).addComponent(lblIcon,Alignment.CENTER)
		);
		pnInit1Layout.setVerticalGroup(
			pnInit1Layout.createParallelGroup(Alignment.LEADING).addComponent(lblIcon)
		);
		
		getContentPane().add(pnInit1,BorderLayout.LINE_START);
		
		pnInit2.setOpaque(false);
		
		lblNamePhong.setFont(new Font("Segoe UI", 1, 12));
		lblNamePhong.setText("P0101");
		lblNamePhong.setName("");
		lblNamePhong.setPreferredSize(new Dimension(140,20));
		
		lblSoLuong.setFont(new Font("Segoe UI", 1, 12));
		lblSoLuong.setText("30");
		
		GroupLayout pnInit2Layout = new GroupLayout(pnInit2);
		pnInit2.setLayout(pnInit2Layout);
		pnInit2Layout.setHorizontalGroup(
			pnInit2Layout.createParallelGroup(Alignment.CENTER)
			.addGroup(pnInit2Layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(pnInit2Layout.createParallelGroup(Alignment.LEADING)
					.addComponent(lblNamePhong)
					.addGroup(pnInit2Layout.createSequentialGroup()
						.addComponent(lblSoLuong)
						.addGap(50)))
			)
		);
		pnInit2Layout.setVerticalGroup(
			pnInit2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnInit2Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNamePhong)
					.addGap(5)
					.addComponent(lblSoLuong)
					.addContainerGap())
		);
		getContentPane().add(pnInit2,BorderLayout.SOUTH);
	}
}
