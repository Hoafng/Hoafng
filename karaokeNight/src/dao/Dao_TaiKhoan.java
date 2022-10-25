package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.ConnectDB;
import entity.Phong;
import entity.TaiKhoan;

public class Dao_TaiKhoan {
	public TaiKhoan tk;
	public TaiKhoan getTaiKhoan(String tenTaiKhoan,String matKhau) {
		tenTaiKhoan ="nhanvien01";
		matKhau ="nhanvien01";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * From Phong where tenTaiKhoan = ? and matKhau = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTaiKhoan);
			statement.setString(2, matKhau);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				tk.setTenTaiKhoan(tenTaiKhoan);
				tk.setMatKhau(matKhau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	public void updateTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update TaiKhoan set matKhau =? where tenTaiKhoan = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tk.getMatKhau());
			stmt.setString(2, tk.getTenTaiKhoan());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
