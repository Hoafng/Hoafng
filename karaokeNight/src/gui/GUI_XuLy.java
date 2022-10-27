package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import connectDB.ConnectDB;
import dao.DanhSachPhong;
import dao.Dao_NhanVien;
import dao.Dao_Phong;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_XuLy extends JFrame implements MouseListener {

	private JPanel contentPane;
//	private JPanel pnInit1;
//	private JPanel pnInit2;
//	private JLabel lblIcon;
//	private JLabel lblNamePhong;
//	private JLabel lblSoLuong;
	private JPanel pnDanhSachPhong;
	private Dao_Phong dao_Phong = new Dao_Phong();
	private JComboBox<String> cbTinhTrang;
	private JComboBox<String> cbMaPhong;
	private ButtonGroup groupLoaiPhong;
	private JRadioButton rdLoaiPhongTatCa;
	private JRadioButton rdLoaiPhongThuong;
	private JRadioButton rdLoaiPhongVip;
//	private JLabel lblIconPhong;
//	private JLabel lblSoPhong;
//	private JLabel lblSoLuongNguoi;
	private ArrayList<Phong> danhSachPhong;
	private JPanel pnPhong;
	private GridBagConstraints gbc_pnPhong;
	private DanhSachPhong dSP = new DanhSachPhong();
	private JTextField txtThongTinLoaiPhong;
	private JTextField txtThongTinGiaPhong;
	private JTextField txtTinTrangPhong;
	private JTextField txtThongTinMaPhong;
	private Phong phong;
	private TaiKhoan tk;
	private JLabel lblThongTinNhanVien;
	private Dao_NhanVien dao_NhanVien=new Dao_NhanVien();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public GUI_XuLy(TaiKhoan taiKhoan) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tk =taiKhoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		danhSachPhong = dao_Phong.getAllPhong();
		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(101, 186, 118));
		panel.setBounds(296, 100, 1288, 110);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTinhTrang = new JLabel("Tình trạng phòng");
		lblTinhTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTinhTrang.setBounds(80, 24, 150, 30);
		panel.add(lblTinhTrang);

		cbTinhTrang = new JComboBox<String>();
		cbTinhTrang.setModel(
				new DefaultComboBoxModel<>(new String[] { "Tất cả", "Trống", "Đang sử dụng", "Đang chờ", "Đã đặt" }));
		cbTinhTrang.setBounds(80, 55, 150, 30);
		panel.add(cbTinhTrang);
		cbTinhTrang.setSelectedIndex(0);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(291, 24, 150, 30);
		panel.add(lblLoaiPhong);

		rdLoaiPhongTatCa = new JRadioButton("Tất cả");
		rdLoaiPhongTatCa.setSelected(true);
		rdLoaiPhongTatCa.setBackground(new Color(101, 186, 118));
		rdLoaiPhongTatCa.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongTatCa.setBounds(287, 54, 80, 30);
		panel.add(rdLoaiPhongTatCa);

		rdLoaiPhongThuong = new JRadioButton("Phòng thường");
		rdLoaiPhongThuong.setBackground(new Color(101, 186, 118));
		rdLoaiPhongThuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongThuong.setBounds(367, 54, 120, 30);
		panel.add(rdLoaiPhongThuong);

		rdLoaiPhongVip = new JRadioButton("Phòng vip");
		rdLoaiPhongVip.setBackground(new Color(101, 186, 118));
		rdLoaiPhongVip.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdLoaiPhongVip.setBounds(489, 54, 100, 30);
		panel.add(rdLoaiPhongVip);

		groupLoaiPhong = new ButtonGroup();
		groupLoaiPhong.add(rdLoaiPhongTatCa);
		groupLoaiPhong.add(rdLoaiPhongThuong);
		groupLoaiPhong.add(rdLoaiPhongVip);

		JButton btnTimPhong = new JButton("Tìm phòng");
		btnTimPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});

		btnTimPhong.setIcon(new ImageIcon("image\\baseline_search_black_24dp.png"));
		btnTimPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnTimPhong.setBounds(850, 23, 180, 30);
		panel.add(btnTimPhong);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		btnLamMoi.setIcon(new ImageIcon("image\\baseline_update_black_24dp.png"));
		btnLamMoi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLamMoi.setBounds(850, 54, 180, 30);
		panel.add(btnLamMoi);

		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(626, 24, 150, 30);
		panel.add(lblMaPhong);

		cbMaPhong = new JComboBox<String>();
		cbMaPhong.setBounds(636, 55, 150, 30);
		cbMaPhong.addItem("Không");
		for (Phong p : dao_Phong.getAllPhong()) {
			cbMaPhong.addItem(p.getMaPhong());
		}
		cbMaPhong.setSelectedIndex(0);
		panel.add(cbMaPhong);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(5, 675, 1470, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Đang chờ");
		lblNewLabel_1_1.setIcon(new ImageIcon("image\\home-icon-dangcho.png"));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(150, 20, 150, 30);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Đang sử dụng");
		lblNewLabel_1_2.setIcon(new ImageIcon("image\\home-icon-dangsudung.png"));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(295, 20, 150, 30);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Trống");
		lblNewLabel_1_3.setIcon(new ImageIcon("image\\home-icon-trong.png"));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(455, 20, 150, 30);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Phòng vip");
		lblNewLabel_1_4.setIcon(new ImageIcon("image\\295-2959091_vip-comments-vip-icon-png.png"));
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(602, 20, 150, 30);
		panel_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_1_1 = new JLabel("Đã đặt");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("image\\home-icon-dadat.png"));
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(30, 20, 150, 30);
		panel_1.add(lblNewLabel_1_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(296, 215, 1184, 460);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		pnDanhSachPhong = new JPanel();
		pnDanhSachPhong.setBorder(new LineBorder(new Color(29, 222, 131)));
		pnDanhSachPhong.setBounds(301, 5, 1174, 450);
		JScrollPane scpDanhSachPhong = new JScrollPane(pnDanhSachPhong);
		scpDanhSachPhong.setLocation(5, 5);
		scpDanhSachPhong.setSize(1168, 450);
		scpDanhSachPhong.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scpDanhSachPhong);
		pnDanhSachPhong.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
		pnDanhSachPhong.setMaximumSize(new java.awt.Dimension(1168, 2000));
		pnDanhSachPhong.setPreferredSize(new java.awt.Dimension(1168, 2000));
		scpDanhSachPhong.setViewportView(pnDanhSachPhong);
		dSP.setPnDanhSachPhong(pnDanhSachPhong);
		dSP.setPnPhong(pnPhong);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 140));
		panel_5.setBounds(5, 20, 1470, 70);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel = new JLabel("Xử lí phòng");
		lblNewLabel.setBounds(6, 5, 1470, 69);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(255, 255, 140));
		panel_5.add(lblNewLabel);
		
		lblThongTinNhanVien = new JLabel("");
		lblThongTinNhanVien.setIcon(new ImageIcon("image\\nhanVien.png"));
		lblThongTinNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThongTinNhanVien.setBounds(1210, 12, 228, 48);
		NhanVien nv=dao_NhanVien.getNhanVien(tk.getTenTaiKhoan());
		lblThongTinNhanVien.setText(nv.getTenNhanVien());
		panel_5.add(lblThongTinNhanVien);

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

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		panel_3_1.setBounds(5, 100, 286, 289);
		contentPane.add(panel_3_1);
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(101, 186, 118));

		JLabel lblThongTinMaPhong = new JLabel("Mã phòng");
		lblThongTinMaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThongTinMaPhong.setBounds(5, 30, 120, 30);
		panel_3_1.add(lblThongTinMaPhong);

		JLabel lblThongTinLoaiPhong = new JLabel("Loại phòng");
		lblThongTinLoaiPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThongTinLoaiPhong.setBounds(5, 80, 120, 30);
		panel_3_1.add(lblThongTinLoaiPhong);

		JLabel lblThongTinGiaPhong = new JLabel("Giá phòng");
		lblThongTinGiaPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThongTinGiaPhong.setBounds(5, 130, 120, 30);
		panel_3_1.add(lblThongTinGiaPhong);

		JLabel lblThongTinTinhTrang = new JLabel("Tình trạng");
		lblThongTinTinhTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblThongTinTinhTrang.setBounds(5, 180, 120, 30);
		panel_3_1.add(lblThongTinTinhTrang);

		txtThongTinLoaiPhong = new JTextField();
		txtThongTinLoaiPhong.setEditable(false);
		txtThongTinLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtThongTinLoaiPhong.setBounds(126, 80, 150, 30);
		panel_3_1.add(txtThongTinLoaiPhong);
		txtThongTinLoaiPhong.setColumns(10);

		txtThongTinGiaPhong = new JTextField();
		txtThongTinGiaPhong.setEditable(false);
		txtThongTinGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtThongTinGiaPhong.setColumns(10);
		txtThongTinGiaPhong.setBounds(126, 130, 150, 30);
		panel_3_1.add(txtThongTinGiaPhong);

		txtTinTrangPhong = new JTextField();
		txtTinTrangPhong.setEditable(false);
		txtTinTrangPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTinTrangPhong.setColumns(10);
		txtTinTrangPhong.setBounds(126, 180, 150, 30);
		panel_3_1.add(txtTinTrangPhong);

		txtThongTinMaPhong = new JTextField();
		txtThongTinMaPhong.setEditable(false);
		txtThongTinMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtThongTinMaPhong.setColumns(10);
		txtThongTinMaPhong.setBounds(126, 30, 150, 30);
		panel_3_1.add(txtThongTinMaPhong);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(5, 399, 286, 270);
		contentPane.add(panel_3);
		panel_3.setBackground(new Color(101, 186, 118));
		panel_3.setLayout(null);

		JButton btnThuePhong = new JButton("Thuê phòng");
		btnThuePhong.setBackground(new Color(255, 255, 140));
		btnThuePhong.setBounds(53, 30, 180, 30);
		btnThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_3.add(btnThuePhong);

		JButton btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (phong!=null&&phong.getTinhTrang().equals("Trống")) {
					dispose();
					new GUI_DatPhong(phong,tk).setVisible(true);
				}		
			}
		});
		btnDatPhong.setBackground(new Color(255, 255, 140));
		btnDatPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDatPhong.setBounds(53, 75, 180, 30);
		panel_3.add(btnDatPhong);

		JButton btnChuyenPhong = new JButton("Chuyển phòng");
		btnChuyenPhong.setBackground(new Color(255, 255, 140));
		btnChuyenPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChuyenPhong.setBounds(53, 120, 180, 30);
		panel_3.add(btnChuyenPhong);

		JButton btnThemDichVu = new JButton("Thêm dịch vụ");
		btnThemDichVu.setBackground(new Color(255, 255, 140));
		btnThemDichVu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThemDichVu.setBounds(53, 165, 180, 30);
		panel_3.add(btnThemDichVu);

		JButton btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(255, 255, 140));
		btnThanhToan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThanhToan.setBounds(53, 210, 180, 30);
		panel_3.add(btnThanhToan);

		gbc_pnPhong = new GridBagConstraints();
		gbc_pnPhong.ipady = 0;
		gbc_pnPhong.ipadx = 0;
		gbc_pnPhong.insets = new Insets(10, 6, 10, 8);
		gbc_pnPhong.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnPhong.gridx = 0;
		gbc_pnPhong.gridy = 0;
		dSP.docDuLieuTuSQL(p -> {
			for (Phong ph : danhSachPhong) {
				ph.getMaPhong().equalsIgnoreCase(p.getMaPhong());
				xemThongTin(p);
			}
		});

	}

	public void xemThongTin(Phong p) {
		txtThongTinMaPhong.setText(p.getMaPhong());
		txtThongTinLoaiPhong.setText(p.getMaLoaiPhong().getTenLoaiPhong());
		txtThongTinGiaPhong.setText(String.valueOf(p.getGiaPhong()));
		txtTinTrangPhong.setText(p.getTinhTrang());
		phong = p;
	}

	public void timKiemTheoMaPhong() {
		String maPhong = cbMaPhong.getSelectedItem().toString();
		danhSachTimKiem(dao_Phong.getPhongTheoMaPhong(maPhong));
	}

	public void timKiemTheoTinhTrang() {
		String tinhTrang = cbTinhTrang.getSelectedItem().toString();
		danhSachTimKiem(dao_Phong.getPhongTheoTinhTrang(tinhTrang));
	}

	public void timKiemTheoLoaiPhong() {
		String maLoaiPhong = null;
		if (rdLoaiPhongThuong.isSelected())
			maLoaiPhong = "PT";
		else if (rdLoaiPhongVip.isSelected())
			maLoaiPhong = "PVip";
		danhSachTimKiem(dao_Phong.getPhongTheoLoaiPhong(maLoaiPhong));
	}

	public void timKiem() {
		String maPhong = cbMaPhong.getSelectedItem().toString();
		String tinhTrang = cbTinhTrang.getSelectedItem().toString();
		String maLoaiPhong = "Tất cả";
		if (rdLoaiPhongThuong.isSelected())
			maLoaiPhong = "PT";
		else if (rdLoaiPhongVip.isSelected())
			maLoaiPhong = "PVip";
		ArrayList<Phong> ds = new ArrayList<Phong>();
		ArrayList<Phong> dsMaPhong = null;
		ArrayList<Phong> dsTinhTrang = null;
		ArrayList<Phong> dsLoaiPhong = null;
		if (cbMaPhong.getSelectedIndex() != 0) {
			dsMaPhong = dao_Phong.getPhongTheoMaPhong(maPhong);
		}
		if (cbTinhTrang.getSelectedIndex() != 0) {
			dsTinhTrang = dao_Phong.getPhongTheoTinhTrang(tinhTrang);
		}
		if (rdLoaiPhongTatCa.isSelected() == false) {
			dsLoaiPhong = dao_Phong.getPhongTheoLoaiPhong(maLoaiPhong);
		} else {
			dsLoaiPhong = danhSachPhong;
		}
		if (dsMaPhong != null) {
			if (dsTinhTrang != null) {
				for (Phong phong : dsMaPhong) {
					if (dsLoaiPhong.contains(phong) && dsTinhTrang.contains(phong))
						ds.add(phong);
				}
			} else {
				for (Phong phong : dsMaPhong) {
					if (dsLoaiPhong.contains(phong))
						ds.add(phong);
				}
			}
		} else {
			if (dsTinhTrang != null) {
				for (Phong phong : dsTinhTrang) {
					if (dsLoaiPhong.contains(phong))
						ds.add(phong);
				}
			}
		}
		if (dsTinhTrang == null && dsMaPhong == null) {
			ds = dsLoaiPhong;

		}
		danhSachTimKiem(ds);
	}

	public void danhSachTimKiem(ArrayList<Phong> ds) {
		pnDanhSachPhong.removeAll();
		dSP.docDuLieuTimKiem(p -> {
			for (Phong phong : ds) {
				phong.getMaPhong().equalsIgnoreCase(p.getMaPhong());
				xemThongTin(p);
			}
		}, ds);
	}

//	private void docDuLieuTimKiem() {
//		String a;
//		if (rdLoaiPhongThuong.isSelected())
//			a = "PT";
//		else if (rdLoaiPhongVip.isSelected())
//			a = "PVip";
//		else {
//			docDuLieuTuSQL();
//			return;
//		}
//		pnDanhSachPhong.removeAll();
//		int x = 0, y = 0;
//		for (Phong p : dao_Phong.getPhongTheoTinhTrang(a)) {
//			pnPhong= themPhong(p);
//			x++;
//			if (x == 6) {
//				x = 0;
//				y++;
//			}
//		}
//	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
