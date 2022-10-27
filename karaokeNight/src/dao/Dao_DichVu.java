package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;

public class Dao_DichVu {
	public List<DichVu> getAllDichVuTuMaHoaDon() {
		List<DichVu> dsDichVu = new ArrayList<DichVu>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select d.maDichVu, d.tenDichVu, d.giaDichVu, d.soLuong "
					+ "from DichVu d join CTHoaDonThuePhong c on d.maDichVu = c.maDichVu ";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsDichVu.add(new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuong")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDichVu;
	}

	private ArrayList<DichVu> dsdv;

	public ArrayList<DichVu> getAllDichVu() {

		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *" + "from DichVu as d join LoaiDichVu as l on d.MaLoaiDichVu = l.MaLoaiDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				double giaDichVu = rs.getDouble(3);
				int soLuong = rs.getInt(4);
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(5), rs.getString(7));

				DichVu dv = new DichVu(maDichVu, tenDichVu, giaDichVu, soLuong, loaiDichVu);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	}

	public ArrayList<DichVu> TimDichVu(String column, String key) {
		dsdv = new ArrayList<DichVu>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiDichVu  where " + column + " like " + "'%" + key + "%'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DichVu dv = new DichVu();
				dsdv.add(dv);
			}
			return dsdv;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}
