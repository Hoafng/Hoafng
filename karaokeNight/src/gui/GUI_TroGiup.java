package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;

public class GUI_TroGiup extends JFrame {

	private JPanel contentPane;
	private JTextField textField_HoVaTen;
	private JTextField textField_Email;
	private JTextField textField_TieuDe;
	private JTextField textField_SoDienThoai;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_TroGiup(TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
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

		JLabel lblTitleTroGiup = new JLabel("Hỗ Trợ");
		lblTitleTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitleTroGiup.setBounds(304, 10, 188, 54);
		contentPane.add(lblTitleTroGiup);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 60, 302, 450);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(101, 186, 118));

		JLabel lblThongTinLienHe = new JLabel("Thông tin liên hệ");
		lblThongTinLienHe.setBounds(22, 10, 196, 29);
		lblThongTinLienHe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelLeft.add(lblThongTinLienHe);

		JLabel lblKaraokenightgmailcom = new JLabel("KaraokeNight@gmail.com");
		lblKaraokenightgmailcom.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\mail.png"));
		lblKaraokenightgmailcom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKaraokenightgmailcom.setBounds(10, 211, 282, 77);
		panelLeft.add(lblKaraokenightgmailcom);

		JLabel lbl_iconDiaChi = new JLabel("");
		lbl_iconDiaChi.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\location.png"));
		lbl_iconDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconDiaChi.setBounds(0, 82, 64, 90);
		panelLeft.add(lbl_iconDiaChi);

		JLabel lblKaraokenightgmailcom_1 = new JLabel("0909686868");
		lblKaraokenightgmailcom_1
				.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\phone.png"));
		lblKaraokenightgmailcom_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKaraokenightgmailcom_1.setBounds(10, 296, 282, 77);
		panelLeft.add(lblKaraokenightgmailcom_1);

		JTextArea textArea_DiaChi = new JTextArea("28 Khổng Tử, Bình Thọ, Thủ Đức, Thành Phố Hồ Chí Minh");
		textArea_DiaChi.setLineWrap(true);
		textArea_DiaChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea_DiaChi.setEditable(false);
		textArea_DiaChi.setBounds(62, 66, 208, 106);
		panelLeft.add(textArea_DiaChi);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(304, 60, 456, 450);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		panelRight.setBackground(new Color(101, 186, 118));

		JLabel lblGuiLoiNhan = new JLabel("Gửi Lời Nhắn");
		lblGuiLoiNhan.setBounds(138, 10, 185, 29);
		lblGuiLoiNhan.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panelRight.add(lblGuiLoiNhan);

		JLabel lblHoVaTen = new JLabel("Họ và tên");
		lblHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHoVaTen.setBounds(10, 49, 196, 29);
		panelRight.add(lblHoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_HoVaTen.setBounds(10, 82, 196, 40);
		panelRight.add(textField_HoVaTen);
		textField_HoVaTen.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(239, 49, 196, 29);
		panelRight.add(lblEmail);

		textField_Email = new JTextField();
		textField_Email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Email.setColumns(10);
		textField_Email.setBounds(239, 82, 196, 40);
		panelRight.add(textField_Email);

		JLabel lblTitle = new JLabel("Tiêu đề");
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTitle.setBounds(10, 142, 196, 29);
		panelRight.add(lblTitle);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(239, 142, 196, 29);
		panelRight.add(lblSoDienThoai);

		JLabel lblLoiNhan = new JLabel("Lời nhắn của bạn");
		lblLoiNhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoiNhan.setBounds(10, 220, 196, 29);
		panelRight.add(lblLoiNhan);

		textField_TieuDe = new JTextField();
		textField_TieuDe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TieuDe.setColumns(10);
		textField_TieuDe.setBounds(10, 169, 196, 41);
		panelRight.add(textField_TieuDe);

		textField_SoDienThoai = new JTextField();
		textField_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoDienThoai.setColumns(10);
		textField_SoDienThoai.setBounds(239, 169, 196, 41);
		panelRight.add(textField_SoDienThoai);

		JButton btnGuiTinNhan = new JButton("Gửi tin nhắn");
		btnGuiTinNhan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnGuiTinNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuiTinNhan.setBounds(10, 377, 142, 29);

		panelRight.add(btnGuiTinNhan);

		JTextArea textArea_LoiNhan = new JTextArea("");
		textArea_LoiNhan.setLineWrap(true);
		textArea_LoiNhan.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea_LoiNhan.setBounds(10, 250, 425, 106);
		panelRight.add(textArea_LoiNhan);
	}
}
