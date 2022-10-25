package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.TaiKhoan;

public class UI_DangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JLabel lblMatKhau;
	private JTextField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnQuenMatKhau;
	private UI_TrangChu trangChu = new UI_TrangChu();
	private TaiKhoan tk = trangChu.taiKhoan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_DangNhap frame = new UI_DangNhap();
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
	public UI_DangNhap() {
		setResizable(false);
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTieuDe = new JLabel("Hệ Thống Quản Lý Karaoke Night");
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTieuDe.setBounds(70, 23, 461, 41);
		contentPane.add(lblTieuDe);
		
		JLabel lblTaiKhoan = new JLabel("Tài Khoản");
		lblTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(67, 100, 94, 30);
		contentPane.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTaiKhoan.setBounds(171, 100, 299, 30);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		lblMatKhau = new JLabel("Mật Khẩu");
		lblMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMatKhau.setBounds(70, 168, 94, 30);
		contentPane.add(lblMatKhau);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(171, 168, 299, 30);
		contentPane.add(txtMatKhau);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDangNhap.setBounds(121, 230, 134, 41);
		contentPane.add(btnDangNhap);
		
		btnQuenMatKhau = new JButton("Quên Mật Khẩu");
		btnQuenMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnQuenMatKhau.setBounds(331, 230, 184, 41);
		contentPane.add(btnQuenMatKhau);
	}
}
