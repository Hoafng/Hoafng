package entity;

import java.util.Objects;

public class KhachHang {
	private String maKhachHang;
	private String soDienThoai;
	private String tenKhachHang;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	public KhachHang() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai + ", tenKhachHang="
				+ tenKhachHang + "]";
	}
	
}
