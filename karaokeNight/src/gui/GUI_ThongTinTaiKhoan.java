package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

public class GUI_ThongTinTaiKhoan extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtSoDienThoai;
	private JTextField txtTenNhanVien;
	private JTextField txtcmnd;
	private JTextField txtChucVu;
	private JTextField txtDiaChi;
	private Dao_NhanVien dao_NhanVien ;
	private Dao_TaiKhoan dao_TaiKhoan = new Dao_TaiKhoan();

	/**
	 * Launch the application.
	 */
	private TaiKhoan tk = dao_TaiKhoan.tk;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private ButtonGroup bgGioiTinh;
	private JDateChooser dateChooser;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongTinTaiKhoan frame = new GUI_ThongTinTaiKhoan();
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
	public GUI_ThongTinTaiKhoan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblThongTinTaiKhoan = new JLabel("Thông tin tài khoản");
		lblThongTinTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThongTinTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTinTaiKhoan.setBounds(590, 51, 300, 80);
		contentPane.add(lblThongTinTaiKhoan);
		
		JPanel panel = new JPanel();
		panel.setBounds(300, 188, 300, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//Menu
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
		
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setBounds(0, 0, 90, 30);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblMaNhanVien);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(100, 0, 200, 30);
		panel.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(300, 288, 300, 30);
		contentPane.add(panel_1);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(0, 0, 90, 30);
		panel_1.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(100, 0, 200, 30);
		panel_1.add(txtSoDienThoai);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(880, 188, 300, 30);
		contentPane.add(panel_2);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenNhanVien.setBounds(0, 0, 90, 30);
		panel_2.add(lblTenNhanVien);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(100, 0, 200, 30);
		panel_2.add(txtTenNhanVien);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(880, 288, 300, 30);
		contentPane.add(panel_1_1);
		
		JLabel lblcmnd = new JLabel("CMND");
		lblcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblcmnd.setBounds(0, 0, 90, 30);
		panel_1_1.add(lblcmnd);
		
		txtcmnd = new JTextField();
		txtcmnd.setEditable(false);
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(100, 0, 200, 30);
		panel_1_1.add(txtcmnd);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(300, 388, 300, 30);
		contentPane.add(panel_1_2);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioiTinh.setBounds(0, 0, 90, 30);
		panel_1_2.add(lblGioiTinh);
		
		rdNam = new JRadioButton("Nam");
		rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdNam.setBounds(100, 0, 100, 30);
		panel_1_2.add(rdNam);
		rdNam.setEnabled(false);
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdNu.setBounds(200, 0, 100, 30);
		panel_1_2.add(rdNu);
		rdNu.setEnabled(false);
		
		bgGioiTinh = new ButtonGroup();
		bgGioiTinh.add(rdNam);
		bgGioiTinh.add(rdNu);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(880, 388, 300, 30);
		contentPane.add(panel_1_1_1);
		
		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChucVu.setBounds(0, 0, 90, 30);
		panel_1_1_1.add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(100, 0, 200, 30);
		panel_1_1_1.add(txtChucVu);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(300, 588, 480, 30);
		contentPane.add(panel_1_3);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiaChi.setBounds(0, 0, 90, 30);
		panel_1_3.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(100, 0, 380, 30);
		panel_1_3.add(txtDiaChi);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSoDienThoai.isEditable()==false)
				{
					moKhoaTextField();
					btnSua.setEnabled(true);
				}
				else {
					suaThongTin();
					khoaTextField();
				}
				
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSua.setBounds(880, 650, 100, 30);
		contentPane.add(btnSua);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(1017, 650, 100, 30);
		contentPane.add(btnHuy);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThoat.setBounds(1161, 650, 100, 30);
		contentPane.add(btnThoat);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(300, 488, 300, 30);
		contentPane.add(panel_1_1_2);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgaySinh.setBounds(0, 0, 90, 30);
		panel_1_1_2.add(lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(100, 0, 170, 30);
		panel_1_1_2.add(txtNgaySinh);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/YYYY");
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(100, 0, 200, 30);
		panel_1_1_2.add(dateChooser);
		dateChooser.setLayout(null);
		
		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(null);
		pnEmail.setBounds(880, 488, 300, 30);
		contentPane.add(pnEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(0, 0, 90, 30);
		pnEmail.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(100, 0, 200, 30);
		pnEmail.add(txtEmail);
		
		docDuLieuTuSQL();
	}
	protected void suaThongTin() {
		String maNV = txtMaNhanVien.getText().toString();
		String tenNV = txtTenNhanVien.getText().toString();
		String sDT = txtSoDienThoai.getText().toString();
		String dC = txtDiaChi.getText().toString();
		String eM = txtEmail.getText().toString();
		String cmnd = txtcmnd.getText().toString();
		String cv = txtChucVu.getText().toString();
		Date ns = Date.valueOf(txtNgaySinh.getText());
		Boolean gt =rdNam.isSelected()?true:false;
		NhanVien nv = new NhanVien(maNV, tenNV, sDT, ns, dC, gt , cmnd, cv, eM, tk);
		if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?", "Cảnh báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			dao_NhanVien.suaThongTinNhanVien(nv);
		}
	}

	protected void moKhoaTextField() {
		txtSoDienThoai.setEditable(true);
		txtNgaySinh.setEditable(true);
		txtDiaChi.setEditable(true);
		txtEmail.setEditable(true);
		txtcmnd.setEditable(true);
		dateChooser.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			        	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");																																																																																																																																																												
			            if ("date".equals(e.getPropertyName())) {
			            	String a = sf.format(e.getNewValue());		   
			            	txtNgaySinh.setText(a + "");
			            }
			        }
			    });
	}
	protected void khoaTextField()
	{
		txtSoDienThoai.setEditable(false);
		txtNgaySinh.setEditable(false);
		txtDiaChi.setEditable(false);
		txtEmail.setEditable(false);
		txtcmnd.setEditable(false);
		dateChooser.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			        	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");																																																																																																																																																												
			            if ("date".equals(e.getPropertyName())) {
			            	String a = sf.format(e.getNewValue());		   
			            	txtNgaySinh.setText(a + "");
			            }
			        }
			    });
		dateChooser.getDateEditor().removePropertyChangeListener(dateChooser);
	}

	private void docDuLieuTuSQL() {
		dao_NhanVien = new Dao_NhanVien();
		NhanVien nv = dao_NhanVien.getNhanVien(tk.getTenTaiKhoan());
		txtMaNhanVien.setText(nv.getMaNhanVien());
		txtTenNhanVien.setText(nv.getTenNhanVien());
		txtSoDienThoai.setText(nv.getSoDienThoai());	
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String ns = sf.format(nv.getNgaySinh());
		txtNgaySinh.setText(ns);
		txtDiaChi.setText(nv.getDiaChi());
		txtcmnd.setText(nv.getCmnd());
		txtEmail.setText(nv.getEmail());
		txtChucVu.setText(nv.getChucVu());
		if(nv.isGioiTinh())
			rdNam.setSelected(true);
		else rdNu.setSelected(true);
	}
}
