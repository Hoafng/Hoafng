package entity;

import java.util.Objects;

public class KhachHang {
	private String soDienThoai;
	private String tenKhachHang;
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
	public KhachHang(String soDienThoai, String tenKhachHang) {
		super();
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
	}
	public KhachHang(String soDienThoai) {
		super();
		this.soDienThoai = soDienThoai;
	}
	public KhachHang() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(soDienThoai);
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
		return Objects.equals(soDienThoai, other.soDienThoai);
	}
	@Override
	public String toString() {
		return "KhachHang [soDienThoai=" + soDienThoai + ", tenKhachHang=" + tenKhachHang + "]";
	}
	
}
