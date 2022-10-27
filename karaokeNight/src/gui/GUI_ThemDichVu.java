package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import connectDB.ConnectDB;
import dao.Dao_DichVu;
import entity.DichVu;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ThemDichVu extends JFrame implements TableCellRenderer {

	private JPanel contentPane;
	private JTable tableLeft;
	private JTable tableRight;
	private JTextField textFieldMaDichVu;
	private JTextField textFieldTenDichVu;
	private JTextField textFieldMaPhong;
	private DefaultTableModel modelDichVu;
	private Phong p;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GUI_ThemDichVu(Phong phong,TaiKhoan taiKhoan) {

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p = phong;
		tk=taiKhoan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(101, 186, 118));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDichVu = new JLabel("Dịch Vụ");
		lblDichVu.setBounds(680, 23, 190, 35);
		lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblDichVu);

		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 91, 722, 652);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);

		JButton btnadd = new JButton("");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnadd.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\add.png"));
		btnadd.setBounds(617, 36, 53, 35);

		panelLeft.add(btnadd);

		panelLeft.setLayout(null);
		panelLeft.setBackground(new Color(101, 186, 118));

		JLabel lblTatCaDichVu = new JLabel("Tất cả dịch vụ");
		lblTatCaDichVu.setBounds(273, 6, 186, 35);
		lblTatCaDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelLeft.add(lblTatCaDichVu);

		JPanel panelRight = new JPanel();
		panelRight.setBounds(724, 91, 743, 652);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));

		JButton btnIconxoa = new JButton("");
		btnIconxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIconxoa.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\dauTru.png"));
		btnIconxoa.setBounds(617, 36, 53, 35);
		panelRight.add(btnIconxoa);

		panelRight.setLayout(null);
		panelRight.setBackground(new Color(101, 186, 118));
		tableRight = new JTable();
		tableRight.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableRight.setBounds(10, 92, 702, 343);
		tableRight.setToolTipText("");
		tableRight.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Hủy" }));

		panelLeft.add(tableRight);

		JScrollPane scrollPane1 = new JScrollPane(tableRight);

		JLabel lblMaDichVu = new JLabel("Mã dịch vụ");
		lblMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaDichVu.setBounds(10, 494, 89, 35);
		panelLeft.add(lblMaDichVu);

		textFieldMaDichVu = new JTextField();
		textFieldMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaDichVu.setColumns(10);
		textFieldMaDichVu.setBounds(100, 489, 158, 40);
		panelLeft.add(textFieldMaDichVu);

		JButton btnsearch = new JButton("");
		btnsearch.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\search.png"));
		btnsearch.setBounds(256, 489, 41, 40);
		panelLeft.add(btnsearch);

		JLabel lblTendichvu = new JLabel("Tên dịch vụ");
		lblTendichvu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTendichvu.setBounds(349, 494, 89, 35);
		panelLeft.add(lblTendichvu);

		textFieldTenDichVu = new JTextField();
		textFieldTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldTenDichVu.setColumns(10);
		textFieldTenDichVu.setBounds(439, 489, 158, 40);
		panelLeft.add(textFieldTenDichVu);

		JButton btnsearch1 = new JButton("");
		btnsearch1.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\search.png"));
		btnsearch1.setBounds(595, 489, 41, 40);
		panelLeft.add(btnsearch1);
		scrollPane1.setBounds(10, 92, 702, 343);
		panelRight.add(scrollPane1);

		contentPane.add(panelRight);

		JLabel lblDichVuDaThem = new JLabel("Dịch vụ đã thêm");
		lblDichVuDaThem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panelRight.add(lblDichVuDaThem);

		JLabel lblMPhng = new JLabel("Mã phòng");
		lblMPhng.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMPhng.setBounds(54, 486, 89, 35);
		panelRight.add(lblMPhng);

		textFieldMaPhong = new JTextField();
		textFieldMaPhong.setEditable(false);
		textFieldMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textFieldMaPhong.setColumns(10);
		textFieldMaPhong.setBounds(130, 486, 158, 40);
		panelRight.add(textFieldMaPhong);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(543, 579, 158, 40);
		panelRight.add(btnXacNhan);

		JLabel lblDichVuThem = new JLabel("Dịch vụ thêm");
		lblDichVuThem.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDichVuThem.setBounds(269, 10, 239, 35);
		panelRight.add(lblDichVuThem);

		String[] colHeader = { "Mã dịch vụ", "Tên dịch vụ", "Giá", "Số lượng", "Thêm" };
		modelDichVu = new DefaultTableModel(colHeader, 0);
		tableLeft = new JTable(modelDichVu);
		tableLeft.setFillsViewportHeight(true);
		tableLeft.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tableLeft.setBounds(10, 21, 683, 410);
		panelLeft.add(tableLeft);
		JScrollPane cpDichVuLeft = new JScrollPane(tableLeft);
		cpDichVuLeft.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cpDichVuLeft.setBounds(10, 92, 702, 343);
		panelLeft.add(cpDichVuLeft);
		tableLeft.setRowHeight(10);
		docDuLieuTuSQL();

	}

	private void docDuLieuTuSQL() {

		Dao_DichVu dichvuall = new Dao_DichVu();
		tableLeft.setRowHeight(25);
		for (DichVu d : dichvuall.getAllDichVu()) {
			Object[] rowData = { d.getMaDichVu(), d.getTenDichVu(), d.getGiaDichVu(), d.getSoLuong(), "Thêm" };
			modelDichVu.addRow(rowData);
			tableLeft.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
			;

		}
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

}

class ButtonRenderer extends JButton implements TableCellRenderer {

	public ButtonRenderer() {
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean Selected, boolean Focus, int row,
			int col) {

		setText((obj == null) ? "" : obj.toString());

		return this;
	}

}

class ButtonEditor extends DefaultCellEditor {

	protected JButton btn;
	private String lbl;
	private Boolean clicked;

	public ButtonEditor(JTextField txt) {
		super(txt);
		btn = new JButton();
		btn.setOpaque(true);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}

		});

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean Selected, int row, int col) {

		lbl = (obj == null) ? "" : obj.toString();
		btn.setText(lbl);
		clicked = true;
		return btn;
	}

	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			JOptionPane.showMessageDialog(btn, lbl + "Clicked");
		}
		clicked = false;
		return new String(lbl);

	}

	@Override
	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	protected void fireEditingStopped() {
		super.fireEditingStopped();
	}

}