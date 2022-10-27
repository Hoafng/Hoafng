package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

import connectDB.ConnectDB;
import dao.Dao_DichVu;
import entity.DichVu;
import entity.TaiKhoan;

public class GUI_ThongKeDichVu extends JFrame implements ActionListener, PropertyChangeListener {

	private JPanel contentPane;
	private DefaultTableModel modelTkDichVu;
	private JTable tblTkDichVu;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextField txtTuNgay;
	private JTextField txtDenNgay;
	private Dao_DichVu dao_dv;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_ThongKeDichVu(TaiKhoan taiKhoan) {
		// khởi tạo kết nối đến CSDL
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao_dv = new Dao_DichVu();
		tk = taiKhoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

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
		pnTop.setBounds(0, 35, 1466, 52);
		pnTop.setBackground(new Color(101, 186, 118));
		contentPane.add(pnTop);
		pnTop.setLayout(null);

		JLabel lblThongKeDichVu = new JLabel("Thống kê dịch vụ");
		lblThongKeDichVu.setBounds(731, 10, 224, 35);
		lblThongKeDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeDichVu);

		JPanel pnLeft = new JPanel();
		pnLeft.setBounds(10, 97, 392, 636);
		pnLeft.setBackground(new Color(101, 186, 118));
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập vào để thống kê"));
		pnLeft.setLayout(null);

		JLabel lblTuNgay = new JLabel("Từ ngày :");
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTuNgay.setBounds(60, 65, 81, 34);

		dateChooser = new JDateChooser();
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtTuNgay.setText(a + "");
				}
			}
		});
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(151, 69, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);

		txtTuNgay = new JTextField();
		txtTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTuNgay.setBounds(0, 0, 170, 30);
		dateChooser.add(txtTuNgay);
		txtTuNgay.setColumns(10);
		pnLeft.add(lblTuNgay);

		JLabel lblDenNgay = new JLabel("Đến ngày:");
		lblDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDenNgay.setBounds(57, 142, 84, 30);
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		dateChooser_1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtDenNgay.setText(a + "");
				}
			}
		});
		dateChooser_1.getCalendarButton().setBounds(170, 0, 30, 30);
		dateChooser_1.setBounds(151, 142, 200, 30);
		pnLeft.add(dateChooser_1);
		dateChooser_1.setLayout(null);

		txtDenNgay = new JTextField();
		txtDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDenNgay.setColumns(10);
		txtDenNgay.setBounds(0, 0, 172, 30);
		dateChooser_1.add(txtDenNgay);
		pnLeft.add(lblDenNgay);

		ImageIcon iconLamMoi = new ImageIcon("image//iconButton//Refresh.png");
		JButton btnLamMoiDichVu = new JButton("Làm mới", iconLamMoi);
		btnLamMoiDichVu.setBackground(new Color(255, 255, 140));
		btnLamMoiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiDichVu.setBounds(60, 371, 291, 33);
		pnLeft.add(btnLamMoiDichVu);

		ImageIcon iconThongKe = new ImageIcon("image//iconButton//statistical.png");
		JButton btnThongKe = new JButton("Thống kê", iconThongKe);
		btnThongKe.setBackground(new Color(255, 255, 140));
		btnThongKe.setForeground(new Color(0, 0, 0));
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThongKe.setBounds(60, 301, 291, 33);
		pnLeft.add(btnThongKe);

		JButton btnInThongKe = new JButton("In thống kê", new ImageIcon("image//iconButton//print.png"));
		btnInThongKe.setForeground(Color.BLACK);
		btnInThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInThongKe.setBackground(new Color(255, 255, 140));
		btnInThongKe.setBounds(60, 445, 291, 33);
		pnLeft.add(btnInThongKe);

		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(430, 97, 1036, 636);
		pnCenter.setBackground(new Color(101, 186, 118));
		contentPane.add(pnCenter);
		String[] cols = { "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vu", "Giá", "Số lượng bán ra" };
		modelTkDichVu = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblTkDichVu = new JTable(modelTkDichVu);
		JScrollPane scrtbl = new JScrollPane(tblTkDichVu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách dịch vụ"));
		scrtbl.setBounds(10, 25, 1016, 537);
		pnCenter.add(scrtbl);

		JLabel lblTongDichVuBan = new JLabel("Tổng số lượng dịch vụ đã bán: ");
		lblTongDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongDichVuBan.setBounds(749, 572, 196, 26);
		pnCenter.add(lblTongDichVuBan);

		JLabel lblKqDichVuBan = new JLabel("");
		lblKqDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBan.setBounds(942, 592, 70, 21);
		pnCenter.add(lblKqDichVuBan);

		JLabel lblDichVuBanChayNhat = new JLabel("Dịch vụ bán chạy nhất:");
		lblDichVuBanChayNhat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDichVuBanChayNhat.setBounds(10, 608, 150, 21);
		pnCenter.add(lblDichVuBanChayNhat);

		JLabel lblKqDichVuBanChay = new JLabel("");
		lblKqDichVuBanChay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqDichVuBanChay.setBounds(159, 608, 113, 21);
		pnCenter.add(lblKqDichVuBanChay);

		JLabel lblTongTienDichVu = new JLabel("Tổng tiền dịch vụ đã bán: ");
		lblTongTienDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienDichVu.setBounds(10, 572, 164, 26);
		pnCenter.add(lblTongTienDichVu);

		JLabel lblKqTienDichVuBan = new JLabel("0 VNĐ");
		lblKqTienDichVuBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqTienDichVuBan.setBounds(176, 575, 143, 21);
		pnCenter.add(lblKqTienDichVuBan);

		DocDuLieuDatabaseVaoTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<DichVu> listDV = dao_dv.getAllDichVu();
		for (DichVu dv : listDV) {
			modelTkDichVu.addRow(new Object[] { dv.getMaDichVu(), dv.getTenDichVu(),
					dv.getMaLoaiDichVu().getMaLoaiDichVu(), dv.getGiaDichVu(), dv.getSoLuong(), });
		}
	}
}
