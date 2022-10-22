package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class Dao_Phong {
	public List<Phong> getAllPhong() {
		List<Phong> dsPhong = new ArrayList<Phong>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"),rs.getString("tenLoaiPhong"));
				dsPhong.add(
						new Phong(rs.getString("maPhong"),rs.getString("tinhTrang"),rs.getDouble("giaPhong"), rs.getInt("soLuongNguoi"),loaiPhong));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

}
