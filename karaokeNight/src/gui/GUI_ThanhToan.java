package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Dao_DichVu;
import entity.DichVu;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ThanhToan extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldMaHoaDon;
	private JTextField textFieldNgayLap;
	private JTextField textFieldTenKhachHang;
	private JTextField textFieldSoDienThoai;
	private JTextField textFieldGiaPhong;
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldMaPhong;
	private JTextField textFieldLoaiPhong;
	private JTextField textFieldVAT;
	private JTable table;
	private JTextField textField_ThanhTien;
	private DefaultTableModel modelDichVu;
	private double thanhTien = 0;
	private Phong p;
	private TaiKhoan tk;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_ThanhToan(Phong phong,TaiKhoan taiKhoan) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		p=phong;
		tk=taiKhoan;
		
		JLabel lblThanhTon = new JLabel("Thanh Toán");
		lblThanhTon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThanhTon.setBounds(246, 10, 190, 46);
		contentPane.add(lblThanhTon);
		
		JLabel lblMaHoaDon = new JLabel("Mã hóa đơn");
		lblMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaHoaDon.setBounds(47, 84, 120, 40);
		contentPane.add(lblMaHoaDon);
		
		textFieldMaHoaDon = new JTextField();
		textFieldMaHoaDon.setEditable(false);
		textFieldMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaHoaDon.setColumns(10);
		textFieldMaHoaDon.setBounds(152, 84, 158, 40);
		contentPane.add(textFieldMaHoaDon);
		
		JLabel lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNgayLap.setBounds(361, 84, 120, 40);
		contentPane.add(lblNgayLap);
		
		textFieldNgayLap = new JTextField();
		textFieldNgayLap.setEditable(false);
		textFieldNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldNgayLap.setColumns(10);
		textFieldNgayLap.setBounds(457, 84, 158, 40);
		contentPane.add(textFieldNgayLap);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenKhachHang.setBounds(47, 159, 120, 40);
		contentPane.add(lblTenKhachHang);
		
		textFieldTenKhachHang = new JTextField();
		textFieldTenKhachHang.setEditable(false);
		textFieldTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldTenKhachHang.setColumns(10);
		textFieldTenKhachHang.setBounds(152, 159, 158, 40);
		contentPane.add(textFieldTenKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(361, 159, 120, 40);
		contentPane.add(lblSoDienThoai);
		
		textFieldSoDienThoai = new JTextField();
		textFieldSoDienThoai.setEditable(false);
		textFieldSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldSoDienThoai.setColumns(10);
		textFieldSoDienThoai.setBounds(457, 159, 158, 40);
		contentPane.add(textFieldSoDienThoai);
		
		JLabel lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(47, 304, 120, 40);
		contentPane.add(lblGiaPhong);
		
		textFieldGiaPhong = new JTextField();
		textFieldGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldGiaPhong.setEditable(false);
		textFieldGiaPhong.setColumns(10);
		textFieldGiaPhong.setBounds(152, 304, 158, 40);
		contentPane.add(textFieldGiaPhong);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaNhanVien.setBounds(47, 229, 120, 40);
		contentPane.add(lblMaNhanVien);
		
		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaNhanVien.setEditable(false);
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(152, 229, 158, 40);
		contentPane.add(textFieldMaNhanVien);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(361, 229, 120, 40);
		contentPane.add(lblMaPhong);
		
		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaPhong.setEditable(false);
		textFieldMaPhong.setColumns(10);
		textFieldMaPhong.setBounds(457, 229, 158, 40);
		contentPane.add(textFieldMaPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(361, 304, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		textFieldLoaiPhong = new JTextField();
		textFieldLoaiPhong.setEditable(false);
		textFieldLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldLoaiPhong.setColumns(10);
		textFieldLoaiPhong.setBounds(457, 304, 158, 40);
		contentPane.add(textFieldLoaiPhong);
		
		
		String[] hour = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		String[] minute = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20",
				"21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40",
				"41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60"};
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(47, 373, 120, 40);
		contentPane.add(lblGioVaoPhong);
		
		JComboBox comboBox_GioVaoPhong = new JComboBox(hour);
		comboBox_GioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioVaoPhong.setBounds(152, 373, 54, 40);
		contentPane.add(comboBox_GioVaoPhong);
		
		JLabel lblGio = new JLabel("giờ");
		lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio.setBounds(210, 373, 40, 40);
		contentPane.add(lblGio);
		
		JComboBox comboBox_PhutVaoPhong = new JComboBox(minute);
		comboBox_PhutVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutVaoPhong.setBounds(249, 373, 54, 40);
		contentPane.add(comboBox_PhutVaoPhong);
		
		JLabel lblPhut = new JLabel("phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut.setBounds(307, 373, 40, 40);
		contentPane.add(lblPhut);
		
		JLabel lblGioRaPhong = new JLabel("Giờ ra phòng");
		lblGioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioRaPhong.setBounds(356, 373, 120, 40);
		contentPane.add(lblGioRaPhong);
		
		JComboBox comboBox_GioRaPhong = new JComboBox(hour);
		comboBox_GioRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioRaPhong.setBounds(461, 373, 54, 40);
		contentPane.add(comboBox_GioRaPhong);
		
		JLabel lblGio_1 = new JLabel("giờ");
		lblGio_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio_1.setBounds(519, 373, 40, 40);
		contentPane.add(lblGio_1);
		
		JComboBox comboBox_PhutRaPhong = new JComboBox(minute);
		comboBox_PhutRaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutRaPhong.setBounds(558, 373, 54, 40);
		contentPane.add(comboBox_PhutRaPhong);
		
		JLabel lblPhut_1 = new JLabel("phút");
		lblPhut_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut_1.setBounds(616, 373, 40, 40);
		contentPane.add(lblPhut_1);
		
		JLabel lblSoGioHat = new JLabel("Số giờ hát");
		lblSoGioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoGioHat.setBounds(47, 436, 120, 40);
		contentPane.add(lblSoGioHat);
		
		JComboBox comboBox_GioHat = new JComboBox(hour);
		comboBox_GioHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_GioHat.setBounds(152, 436, 54, 40);
		contentPane.add(comboBox_GioHat);
		
		JLabel lblGio_2 = new JLabel("giờ");
		lblGio_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio_2.setBounds(210, 436, 40, 40);
		contentPane.add(lblGio_2);
		
		JComboBox comboBox_PhutHat = new JComboBox(minute);
		comboBox_PhutHat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_PhutHat.setBounds(249, 436, 54, 40);
		contentPane.add(comboBox_PhutHat);
		
		JLabel lblPhut_2 = new JLabel("phút");
		lblPhut_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut_2.setBounds(307, 436, 40, 40);
		contentPane.add(lblPhut_2);
		
		JLabel lblVAT = new JLabel("VAT");
		lblVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblVAT.setBounds(361, 436, 120, 40);
		contentPane.add(lblVAT);
		
		textFieldVAT = new JTextField();
		textFieldVAT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldVAT.setEditable(false);
		textFieldVAT.setColumns(10);
		textFieldVAT.setBounds(457, 436, 158, 40);
		contentPane.add(textFieldVAT);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 510, 581, 145);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThanhTien.setBounds(246, 680, 120, 40);
		contentPane.add(lblThanhTien);
		
		textField_ThanhTien = new JTextField();
		textField_ThanhTien.setEditable(false);
		textField_ThanhTien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_ThanhTien.setColumns(10);
		textField_ThanhTien.setBounds(317, 680, 158, 40);
		contentPane.add(textField_ThanhTien);
		
		JCheckBox chckbx_InHoaDon = new JCheckBox("In hóa đơn");
		chckbx_InHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		chckbx_InHoaDon.setBounds(314, 730, 93, 21);
		contentPane.add(chckbx_InHoaDon);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(199, 762, 123, 40);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(391, 762, 123, 40);
		contentPane.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			
			}
		});
		
		String[] colHeader = { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng" };
		modelDichVu = new DefaultTableModel(colHeader, 0);
		table = new JTable(modelDichVu);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(10, 10, 561, 169);
		panel.add(table);
		JScrollPane cpDichVu = new JScrollPane(table);
		cpDichVu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpDichVu.setBounds(10, 10, 561, 133);
		panel.add(cpDichVu);
		table.setRowHeight(10);

		docDuLieuTuSQL();
		
	}
	private void docDuLieuTuSQL() {
		
		Dao_DichVu dichvu = new Dao_DichVu();
		table.setRowHeight(25);
		for (DichVu d : dichvu.getAllDichVuTuMaHoaDon()) {
			Object[] rowData = { d.getMaDichVu(), d.getTenDichVu(), d.getGiaDichVu(), d.getSoLuong()};
			modelDichVu.addRow(rowData);
			thanhTien = d.getGiaDichVu() + thanhTien;
		}
		textField_ThanhTien.setText(thanhTien+"d");
	}
	
}
