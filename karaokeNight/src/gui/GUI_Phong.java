package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
import entity.LoaiPhong;
import entity.Phong;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI_Phong extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private JTable table;
	private DefaultTableModel modelPhong;
	private JScrollPane cpPhong;
	private Dao_Phong dao_phong = new Dao_Phong();
	private JComboBox cbSoLuongNguoi;
	private JComboBox cbLoaiPhong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnHuy;
	private JLabel lblThongBaoGiaPhong;
	private JLabel lblThongBaoMaPhong;

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
	@SuppressWarnings("unchecked")
	public GUI_Phong() {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 108));
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
		panel.setBackground(new Color(101, 186, 118));
		panel.setBounds(0, 103, 1480, 207);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel lblMaPhong = new JPanel();
		lblMaPhong.setBounds(330, 25, 300, 30);
		panel.add(lblMaPhong);
		lblMaPhong.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setBounds(0, 0, 61, 30);
		lblMaPhong.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		txtMaPhong = new JTextField();
		txtMaPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (dao_phong.getPhongTheoMaPhong(txtMaPhong.getText()) == null) {
					lblThongBaoMaPhong.setText("Ví dụ mẫu :P001002");
				}else lblThongBaoMaPhong.setText("");
			}
		});
		txtMaPhong.setEditable(false);
		txtMaPhong.setBounds(140, 0, 160, 30);
		lblMaPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(330, 88, 300, 30);
		panel.add(panel_1_1);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(0, 0, 130, 30);
		panel_1_1.add(lblLoaiPhong);

		cbLoaiPhong = new JComboBox<String>();
		cbLoaiPhong.setEnabled(false);
		cbLoaiPhong.setModel(new DefaultComboBoxModel<>(new String[] { "Phòng thường", "Phòng vip" }));
		cbLoaiPhong.setBounds(140, 0, 160, 30);
		cbLoaiPhong.setSelectedIndex(0);
		panel_1_1.add(cbLoaiPhong);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(835, 25, 300, 30);
		panel.add(panel_1_2);

		JLabel lblSoLuongNguoi = new JLabel("Số lượng người");
		lblSoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoLuongNguoi.setBounds(0, 0, 130, 30);
		panel_1_2.add(lblSoLuongNguoi);

		cbSoLuongNguoi = new JComboBox<>();
		cbSoLuongNguoi.setEnabled(false);
		cbSoLuongNguoi.setModel(new DefaultComboBoxModel<>(new String[] { "6", "10", "15", "20", "40", "60" }));
		cbSoLuongNguoi.setBounds(140, 0, 160, 30);
		panel_1_2.add(cbSoLuongNguoi);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(835, 88, 300, 30);
		panel.add(panel_1_3);

		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaPhong.setBounds(0, 0, 112, 30);
		panel_1_3.add(lblGiaPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(140, 0, 160, 30);
		panel_1_3.add(txtGiaPhong);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaPhong.isEditable() == false) {
					txtMaPhong.setText("");
					txtGiaPhong.setText("");
					cbLoaiPhong.setSelectedIndex(0);
					cbSoLuongNguoi.setSelectedIndex(0);
					moKhoaTextField();
					btnHuy.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				} else {
					themPhong();
					khoaTextField();
				}
			}
		});
		btnThem.setBackground(new Color(255, 255, 108));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnThem.setBounds(541, 152, 90, 30);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(255, 255, 108));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXoa.setBounds(664, 152, 90, 30);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 255, 108));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSua.setBounds(784, 152, 90, 30);
		panel.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaTextField();
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(true);
				btnHuy.setEnabled(false);
			}
		});
		btnHuy.setBackground(new Color(255, 255, 108));
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(909, 152, 90, 30);
		panel.add(btnHuy);

		lblThongBaoMaPhong = new JLabel("");
		lblThongBaoMaPhong.setForeground(new Color(255, 0, 0));
		lblThongBaoMaPhong.setBounds(330, 60, 300, 13);
		panel.add(lblThongBaoMaPhong);

		lblThongBaoGiaPhong = new JLabel("");
		lblThongBaoGiaPhong.setForeground(Color.RED);
		lblThongBaoGiaPhong.setBounds(835, 125, 300, 13);
		panel.add(lblThongBaoGiaPhong);

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
		table.addMouseListener(this);
		docDuLieuTuSQL();
	}

	protected void themPhong() {
		String maPhong = txtMaPhong.getText();
		String maLoaiPhong = cbLoaiPhong.getSelectedItem().toString();
		int soLuongNguoi = Integer.parseInt(cbSoLuongNguoi.getSelectedItem().toString());
		double giaPhong = Double.parseDouble(txtGiaPhong.getText());
		LoaiPhong lp = new LoaiPhong(maLoaiPhong);
		Phong p = new Phong(maPhong, "Trống", giaPhong, soLuongNguoi, lp);
		if (this.dao_phong.insertPhong(p) == false)
			JOptionPane.showMessageDialog(this, "Trùng mã phòng");
		else {
			this.dao_phong.insertPhong(p);
			Object[] rowData = { p.getMaPhong(), p.getMaLoaiPhong().getTenLoaiPhong(), p.getGiaPhong(),
					p.getSoLuongNguoi() };
			modelPhong.addRow(rowData);
		}
	}


	protected void khoaTextField() {
		txtMaPhong.setEditable(false);
		txtGiaPhong.setEditable(false);
		cbLoaiPhong.setEnabled(false);
		cbSoLuongNguoi.setEnabled(false);
		table.addMouseListener(this);
	}

	protected void moKhoaTextField() {
		txtMaPhong.setEditable(true);
		txtGiaPhong.setEditable(true);
		cbLoaiPhong.setEnabled(true);
		cbSoLuongNguoi.setEnabled(true);
		table.removeMouseListener(this);
	}

	private void docDuLieuTuSQL() {

		dao_phong = new Dao_Phong();
		table.setRowHeight(25);
		for (Phong p : dao_phong.getAllPhong()) {
			Object[] rowData = { p.getMaPhong(), p.getMaLoaiPhong().getTenLoaiPhong(), p.getGiaPhong(),
					p.getSoLuongNguoi() };
			modelPhong.addRow(rowData);
		}
	}

	private boolean kiemTraDuLieu() {
		String maPhong = txtMaPhong.getText();
		int giaPhong = 0;
		if (!(txtGiaPhong.getText().equals("")))
			giaPhong = Integer.parseInt(txtGiaPhong.getText());
		if (!(maPhong.length() > 0 && maPhong.matches("(P)(Vip)?\\d{6}"))) {
			JOptionPane.showMessageDialog(null, "Error: Mã phòng theo mẫu: P và 3 số.Ví dụ: P001001");
			txtMaPhong.requestFocus();
			return false;
		}
		if (giaPhong < 0 || txtGiaPhong.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Error: Nhập giá phòng");
			txtGiaPhong.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaPhong.setText(modelPhong.getValueAt(row, 0).toString());
		cbLoaiPhong.setSelectedItem(modelPhong.getValueAt(row, 1).toString());
		txtGiaPhong.setText(modelPhong.getValueAt(row, 2).toString());
		cbSoLuongNguoi.setSelectedItem(modelPhong.getValueAt(row, 3).toString());
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
