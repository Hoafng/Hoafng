package gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GUI_TroGiup extends JFrame {

	private JPanel contentPane;
	private JTextField textField_HoVaTen;
	private JTextField textField_Email;
	private JTextField textField_TieuDe;
	private JTextField textField_SoDienThoai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TroGiup frame = new GUI_TroGiup();
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
	public GUI_TroGiup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitleTroGiup = new JLabel("Hỗ Trợ");
		lblTitleTroGiup.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitleTroGiup.setBounds(338, 0, 188, 54);
		contentPane.add(lblTitleTroGiup);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 60, 302, 450);
		panelLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
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
		lblKaraokenightgmailcom_1.setIcon(new ImageIcon("D:\\Nam3\\HK5\\PTUD\\Karaoke\\Karaoke_Night\\icon\\phone.png"));
		lblKaraokenightgmailcom_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblKaraokenightgmailcom_1.setBounds(10, 296, 282, 77);
		panelLeft.add(lblKaraokenightgmailcom_1);
		
		JTextArea textArea_DiaChi = new JTextArea("28 Khổng Tử, Bình Thọ, Thủ Đức, Thành Phố Hồ Chí Minh");
		textArea_DiaChi.setLineWrap(true);
		textArea_DiaChi.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textArea_DiaChi.setEnabled(false);
		textArea_DiaChi.setBounds(62, 66, 208, 106);
		panelLeft.add(textArea_DiaChi);
		
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(304, 60, 456, 450);
		panelRight.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panelRight);
		panelRight.setLayout(null);
		
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
