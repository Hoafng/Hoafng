package entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class CTHoaDonThuePhong {
	private HoaDonThuePhong maHoaDon;
	private DichVu maDichVu;
	private Phong maPhong;
	private LocalDateTime gioVaoPhong;
	private int soLuongDichVu;
	private LocalDateTime gioRaPhong;
	public HoaDonThuePhong getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(HoaDonThuePhong maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public DichVu getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(DichVu maDichVu) {
		this.maDichVu = maDichVu;
	}
	public Phong getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}
	public LocalDateTime getGioVaoPhong() {
		return gioVaoPhong;
	}
	public void setGioVaoPhong(LocalDateTime gioVaoPhong) {
		this.gioVaoPhong = gioVaoPhong;
	}
	public int getSoLuongDichVu() {
		return soLuongDichVu;
	}
	public void setSoLuongDichVu(int soLuongDichVu) {
		this.soLuongDichVu = soLuongDichVu;
	}
	public LocalDateTime getGioRaPhong() {
		return gioRaPhong;
	}
	public void setGioRaPhong(LocalDateTime gioRaPhong) {
		this.gioRaPhong = gioRaPhong;
	}
	public CTHoaDonThuePhong(HoaDonThuePhong maHoaDon, DichVu maDichVu, Phong maPhong, LocalDateTime gioVaoPhong,
			int soLuongDichVu, LocalDateTime gioRaPhong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDichVu = maDichVu;
		this.maPhong = maPhong;
		this.gioVaoPhong = gioVaoPhong;
		this.soLuongDichVu = soLuongDichVu;
		this.gioRaPhong = gioRaPhong;
	}
	public CTHoaDonThuePhong(HoaDonThuePhong maHoaDon, DichVu maDichVu, Phong maPhong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDichVu = maDichVu;
		this.maPhong = maPhong;
	}
	public CTHoaDonThuePhong() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu, maHoaDon, maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTHoaDonThuePhong other = (CTHoaDonThuePhong) obj;
		return Objects.equals(maDichVu, other.maDichVu) && Objects.equals(maHoaDon, other.maHoaDon)
				&& Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "CTHoaDonThuePhong [maHoaDon=" + maHoaDon + ", maDichVu=" + maDichVu + ", maPhong=" + maPhong
				+ ", gioVaoPhong=" + gioVaoPhong + ", soLuongDichVu=" + soLuongDichVu + ", gioRaPhong=" + gioRaPhong
				+ "]";
	}
	
}
