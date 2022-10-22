package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieuDatPhong;
	private int soGioDat;
	private LocalDateTime ngayDatPhong;
	private LocalDateTime ngayNhanPhong;
	private Phong maPhong;
	private KhachHang soDienThoai;
	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}
	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public int getSoGioDat() {
		return soGioDat;
	}
	public void setSoGioDat(int soGioDat) {
		this.soGioDat = soGioDat;
	}
	public LocalDateTime getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(LocalDateTime ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	public LocalDateTime getNgayNhanPhong() {
		return ngayNhanPhong;
	}
	public void setNgayNhanPhong(LocalDateTime ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}
	public Phong getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}
	public KhachHang getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(KhachHang soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public PhieuDatPhong(String maPhieuDatPhong, int soGioDat, LocalDateTime ngayDatPhong, LocalDateTime ngayNhanPhong,
			Phong maPhong, KhachHang soDienThoai) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.soGioDat = soGioDat;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.maPhong = maPhong;
		this.soDienThoai = soDienThoai;
	}
	public PhieuDatPhong(String maPhieuDatPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public PhieuDatPhong() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieuDatPhong, other.maPhieuDatPhong);
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", soGioDat=" + soGioDat + ", ngayDatPhong="
				+ ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", maPhong=" + maPhong + ", soDienThoai="
				+ soDienThoai + "]";
	}
	
}
