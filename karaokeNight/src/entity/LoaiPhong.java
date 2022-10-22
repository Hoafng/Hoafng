package entity;

import java.util.Objects;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public LoaiPhong() {
		super();
	}
	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}
	@Override
	public String toString() {
		return "maLoaiPhong [maLoaiPhong=" + maLoaiPhong + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}
	
}
