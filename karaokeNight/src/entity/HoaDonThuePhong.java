package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class HoaDonThuePhong {
	private String maHoaDon;
	private LocalDateTime ngayLap;
	private double vat;
	private KhachHang soDienThoai;
	private NhanVien maNhanVien;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	public KhachHang getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(KhachHang soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public HoaDonThuePhong(String maHoaDon, LocalDateTime ngayLap, double vat, KhachHang soDienThoai,
			NhanVien maNhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.vat = vat;
		this.soDienThoai = soDienThoai;
		this.maNhanVien = maNhanVien;
	}
	public HoaDonThuePhong(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public HoaDonThuePhong() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonThuePhong other = (HoaDonThuePhong) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDonThuePhong [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", vat=" + vat + ", soDienThoai="
				+ soDienThoai + ", maNhanVien=" + maNhanVien + "]";
	}
	
}
