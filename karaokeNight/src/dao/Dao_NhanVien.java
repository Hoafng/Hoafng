package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class Dao_NhanVien {
	public NhanVien getNhanVien(String tenTaiKhoan) {
		NhanVien nv = null;
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where tenTaiKhoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTaiKhoan);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("tenTaiKhoan"));
				nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("soDienThoai"),
						rs.getDate("ngaySinh"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"), rs.getString("cmnd"),
						rs.getString("chucVu"), rs.getString("email"), tk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public void suaThongTinNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update NhanVien set soDienThoai =?,ngaySinh =?,diaChi = ?,cmnd =?,email =? where maNhanVien = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getSoDienThoai());
			stmt.setDate(2, (Date) nv.getNgaySinh());
			stmt.setString(3, nv.getDiaChi());
			stmt.setString(4, nv.getCmnd());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getMaNhanVien());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
