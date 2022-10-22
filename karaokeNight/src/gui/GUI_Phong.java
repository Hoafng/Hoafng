package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Dao_Phong;
import entity.Phong;

public class GUI_Phong extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTable table;
	private DefaultTableModel modelPhong;
	private JScrollPane cpPhong;
	private Dao_Phong phong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Phong frame = new GUI_Phong();
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
	public GUI_Phong() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480,780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("Quản lý phòng");
		lblNewLabel.setBounds(640, 33, 200, 60);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 103, 1480, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(330, 25, 300, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(0, 0, 61, 30);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(140, 0, 160, 30);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(330, 88, 300, 30);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Loại phòng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(0, 0, 130, 30);
		panel_1_1.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(140, 0, 160, 30);
		panel_1_1.add(comboBox);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(835, 25, 300, 30);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số lượng người");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(0, 0, 130, 30);
		panel_1_2.add(lblNewLabel_1_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(140, 0, 160, 30);
		panel_1_2.add(comboBox_1);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(835, 88, 300, 30);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá phòng");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(0, 0, 112, 30);
		panel_1_3.add(lblNewLabel_1_3);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(140, 0, 160, 30);
		panel_1_3.add(textField_3);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(541, 152, 90, 30);
		panel.add(btnNewButton);
		
		JButton btnX = new JButton("Xóa");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnX.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnX.setBounds(664, 152, 90, 30);
		panel.add(btnX);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSa.setBounds(784, 152, 90, 30);
		panel.add(btnSa);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setEnabled(false);
		btnHy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHy.setBounds(909, 152, 90, 30);
		panel.add(btnHy);
		
		String[] colHeader = { "Mã phòng", "Loại phòng", "Giá phòng", "Số lượng người" };
		modelPhong = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelPhong);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(0, 295, 1480, 462);
		cpPhong = new JScrollPane(table);
		cpPhong.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpPhong.setBounds(0, 310, 1480, 433);
		contentPane.add(cpPhong);
		table.setRowHeight(10);
		docDuLieuTuSQL();
	}
	private void docDuLieuTuSQL() {
		
		phong = new Dao_Phong();
		table.setRowHeight(25);
		for (Phong p : phong.getAllPhong()) {
			Object[] rowData = { p.getMaPhong(), p.getMaLoaiPhong().getTenLoaiPhong(), p.getGiaPhong(), p.getSoLuongNguoi() };
			modelPhong.addRow(rowData);
		}
	}
}
