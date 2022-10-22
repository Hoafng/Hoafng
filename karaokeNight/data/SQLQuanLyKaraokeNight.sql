﻿create database karaoke
go
use karaoke
go
create Table TaiKhoan
(
	tenTaiKhoan Varchar(50) not null primary key,
	matKhau Varchar(50)
)
create Table NhanVien
(    
	maNhanVien Varchar(10) not null primary key,
	tenNhanVien NVarchar(50),
    soDienThoai Varchar(20),
    ngaySinh Date,
    diaChi NvarChar(100),
    gioiTinh bit,
    cmnd Varchar(20),
    chucVu Nvarchar(30),
    email Varchar(50),
    tenTaiKhoan Varchar(50)
)
create Table KhachHang
(	maKhachHang Varchar(20) not null primary key,
 	soDienThoai Varchar(20),
	tenKhachHang NVarchar(50)
)
create Table LoaiDichVu
(
    maLoaiDichVu Varchar(20) not null primary key,
    tenLoaiDichVu Nvarchar(50)
)
create Table DichVu
(
    maDichVu Varchar(20) not null primary key,
    tenDichVu Nvarchar(50),
    giaDichVu float,
    soLuong int,
    maLoaiDichVu Varchar(20)
)
create Table LoaiPhong
(
    maLoaiPhong Varchar(20) not null primary key,
    tenLoaiPhong Nvarchar(50)
)
create Table Phong
(
    maPhong Varchar(30) not null primary key,
    tinhTrang Nvarchar(50),
    giaPhong float,
    soLuongNguoi int,
    maLoaiPhong Varchar(20)
)
create Table PhieuDatPhong
(
    maPhieuDatPhong Varchar(20) not null primary key,
    soGioDat int,
    ngayDatPhong dateTime,
    ngayNhanPhong dateTime,
    maPhong Varchar(30),
    maKhachHang Varchar(20)
)
create Table HoaDonThuePhong
(
    maHoaDon Varchar(20) not null primary key,
    ngayLap dateTime,
    vat float,
    maKhachHang Varchar(20),
    maNhanVien Varchar(10)
)
create Table CTHoaDonThuePhong
(
	maHoaDon Varchar(20),
    maDichVu Varchar(20),
    maPhong Varchar(30),
    gioVaoPhong dateTime,
    soLuongDichVu int,
    gioRaPhong dateTime,
	primary key(maHoaDon,maDichVu,maPhong)
)
--Ràng buộc
ALTER TABLE NhanVien ADD CONSTRAINT FK_TenTaiKhoan FOREIGN KEY(tenTaiKhoan) REFERENCES TaiKhoan(tenTaiKhoan)
ALTER TABLE DichVu ADD CONSTRAINT FK_MaLoaiDichVu FOREIGN KEY(maLoaiDichVu) REFERENCES LoaiDichVu(maLoaiDichVu)
ALTER TABLE Phong ADD CONSTRAINT FK_MaLoaiPhong FOREIGN KEY(maLoaiPhong) REFERENCES LoaiPhong(maLoaiPhong)
ALTER TABLE PhieuDatPhong ADD CONSTRAINT FK_MaPhong FOREIGN KEY(maPhong) REFERENCES Phong(maPhong)
ALTER TABLE PhieuDatPhong ADD CONSTRAINT FK_MaKhachHang FOREIGN KEY(maKhachHang) REFERENCES KhachHang(maKhachHang)
ALTER TABLE HoaDonThuePhong ADD CONSTRAINT FK_maKhachHangHoaDon FOREIGN KEY(maKhachHang) REFERENCES KhachHang(maKhachHang)
ALTER TABLE HoaDonThuePhong ADD CONSTRAINT FK_MaNhanVien FOREIGN KEY(maNhanVien) REFERENCES NhanVien(maNhanVien)
ALTER TABLE CTHoaDonThuePhong ADD CONSTRAINT FK_MaHoaDonCT FOREIGN KEY(maHoaDon) REFERENCES HoaDonThuePhong(maHoaDon)
ALTER TABLE CTHoaDonThuePhong ADD CONSTRAINT FK_MaDichVuCT FOREIGN KEY(maDichVu) REFERENCES DichVu(maDichVu)
ALTER TABLE CTHoaDonThuePhong ADD CONSTRAINT FK_MaPhongCT FOREIGN KEY(maPhong) REFERENCES Phong(maPhong)
ALTER TABLE CTHoaDonThuePhong ADD CONSTRAINT CHECK_gioVaoPhong CHECK(gioRaPhong>=gioVaoPhong)
ALTER TABLE HoaDonThuePhong ADD CONSTRAINT DF_vat default 10/100 for vat
ALTER TABLE PhieuDatPhong ADD CONSTRAINT CHECK_soGioDat CHECK(soGioDat>0)
ALTER TABLE PhieuDatPhong ADD CONSTRAINT CHECK_ngayNhanPhong CHECK(ngayNhanPhong>ngayDatPhong)
ALTER TABLE DichVu ADD CONSTRAINT CHECK_soLuong CHECK(soLuong>=0)
ALTER TABLE DichVu ADD CONSTRAINT CHECK_giaDichVu CHECK(giaDichVu>=0)
ALTER TABLE Phong ADD CONSTRAINT  CHECK_tinhTrang CHECK(tinhTrang like N'Đang sử dụng' or tinhTrang like N'Đã đặt' or tinhTrang like N'Đang chờ' or tinhTrang like N'Trống')
ALTER TABLE Phong ADD CONSTRAINT CHECK_giaPhong CHECK(giaPhong>=0)
ALTER TABLE Phong ADD CONSTRAINT CHECK_soLuongNguoi CHECK(soLuongNguoi>0)
ALTER TABLE NhanVien ADD CONSTRAINT CHECK_ngaySinh CHECK(getdate()>ngaySinh)
ALTER TABLE NhanVien ADD CONSTRAINT CHECK_chucVu CHECK(chucVu like N'Quản lý' or chucVu like N'Nhân viên')



--Insert Dữ liệu
Insert into TaiKhoan
Values('tester01','tester01'),
	  ('nhanvien01' , 'nhanvien01'),
	  ('nhanvien02' , 'nhanvien02'),
	  ('nhanvien03' , 'nhanvien03'),
	  ('nhanvien04' , 'nhanvien04'),
	  ('nhanvien05' , 'nhanvien05'),
	  ('nhanvien06' , 'nhanvien06'),
	  ('nhanvien07' , 'nhanvien07'),
	  ('nhanvien08' , 'nhanvien08'),
	  ('nhanvien09' , 'nhanvien09'),
	  ('nhanvien10' , 'nhanvien10'),
	  ('quanly01' , 'quanly01'),
	  ('quanly02' , 'quanly02'),
	  ('quanly03' , 'quanly03')


Insert into NhanVien
Values('NV01' , N'Nguyễn A Đại' , '0909111111' , '2001-01-01' , N'Quận 1, Thành Phố Hồ Chí Minh' , 1 , '385111111' , N'Nhân viên' , 'nguyenadai@gmail.com' , 'nhanvien01'),
	  ('NV02' , N'Nguyễn A Nhị' , '0909222222' , '2002-02-02' , N'Quận 2, Thành Phố Hồ Chí Minh' , 0 , '3852222222' , N'Nhân viên' , 'nguyenanhi@gmail.com' , 'nhanvien02'),
	  ('NV03' , N'Nguyễn A Tam' , '0909333333' , '2003-03-03' , N'Quận 3, Thành Phố Hồ Chí Minh' , 0 , '3853333333' , N'Nhân viên' , 'nguyenatam@gmail.com' , 'nhanvien03'),
	  ('NV04' , N'Nguyễn A Tứ' , '09094444444' , '2004-04-04' , N'Quận 4, Thành Phố Hồ Chí Minh' , 1 , '385444444' , N'Nhân viên' , 'nguyenatu@gmail.com' , 'nhanvien04'),
	  ('NV05' , N'Nguyễn A Ngũ' , '0909555555' , '2005-05-05' , N'Quận 5, Thành Phố Hồ Chí Minh' , 1 , '385555555' , N'Nhân viên' , 'nguyenangu@gmail.com' , 'nhanvien05'),
	  ('NV06' , N'Nguyễn A Lục' , '0909666666' , '2006-06-06' , N'Quận 6, Thành Phố Hồ Chí Minh' , 1 , '385666666' , N'Nhân viên' , 'nguyenaluc@gmail.com' , 'nhanvien06'),
	  ('NV07' , N'Nguyễn A Thất' , '0909777777' , '2007-07-07' , N'Quận 7, Thành Phố Hồ Chí Minh' , 1 , '385777777' , N'Nhân viên' , 'nguyenathat@gmail.com' , 'nhanvien07'),
	  ('NV08' , N'Nguyễn A Bát' , '0909888888' , '2008-08-08' , N'Quận 8, Thành Phố Hồ Chí Minh' , 0 , '385888888' , N'Nhân viên' , 'nguyenabat@gmail.com' , 'nhanvien08'),
	  ('NV09' , N'Nguyễn A Cửu' , '0909999999' , '2009-09-09' , N'Quận 9, Thành Phố Hồ Chí Minh' , 0 , '385999999' , N'Nhân viên' , 'nguyenacuu@gmail.com' , 'nhanvien09'),
	  ('NV10' , N'Nguyễn A Thập' , '0909101010' , '2010-10-10' , N'Quận 10, Thành Phố Hồ Chí Minh' , 1 , '385101010' , N'Nhân viên' , 'nguyenathap@gmail.com' , 'nhanvien10'),
	  ('NV11' , N'Nguyễn Thập Nhất' , '0909010101' , '2001-11-11' , N'Quận 11, Thành Phố Hồ Chí Minh' , 1 , '385010101' , N'Quản lý' , 'nguyenthapnhat@gmail.com' , 'tester01'),
	  ('NV12' , N'Nguyễn A Ngưu' , '0909121212' , '1998-12-12' , N'Quận 1, Thành Phố Hồ Chí Minh' , 1 , '385121212' , N'Quản lý' , 'nguyenanguu@gmail.com' , 'quanly01'),
	  ('NV13' , N'Nguyễn A Mã' , '0909131313' , '1998-12-13' , N'Quận 1, Thành Phố Hồ Chí Minh' , 1 , '385131313' , N'Quản lý' , 'nguyenama@gmail.com' , 'quanly02'),
	  ('NV14' , N'Nguyễn Thập Tứ' , '0909141414' , '2000-12-14' , N'Quận 1, Thành Phố Hồ Chí Minh' , 0 , '385121212' , N'Quản lý' , 'nguyenthaptu@gmail.com' , 'quanly03')


Insert into KhachHang
Values('KH001', '0909090909' , N'Diệp Chung Minh'),
	  ('KH002', '0908080808' , N'Phong Vân' ),
	  ('KH003', '0907070707' , N'Tô Bình '),
	  ('KH004', '0906060606' , N'Dương Gian'),
	  ('KH005', '0905050505' , N'Lâm Uyên'),
	  ('KH006', '0904040404' , N'Tô Lê'),
	  ('KH007', '0903030303' , N'Vương Trường Sinh'),
	  ('KH008', '0902020202' , N'Uông Như Yên'),
	  ('KH009', '0901010101' , N'Vương Thanh Sơn'),
	  ('KH010', '0900000000' , N'Chu Tiểu Yêu'),
	  ('KH011', '0912345678' , N'Chu Bá Thông'),
	  ('KH012', '0911111111' , N'Lý Long Cơ'),
	  ('KH013', '0922222222' , N'Duynaldinho'),
	  ('KH014', '0933333333' , N'Duybrahimovic'),
	  ('KH015', '0944444444' , N'Cristiano Lionel Messinaldo'),
	  ('KH016', '0955555555' , N'Uchiha Sasuke'),
	  ('KH017', '0966666666' , N'Uchiha Itachi'),
	  ('KH018', '0977777777' , N'Uchiha Obito'),
	  ('KH019', '0988888888' , N'Uchiha Shishui'),
	  ('KH020', '0999999999' , N'Uchiha Madara'),
	  ('KH021', '0911234567' , N'Tobirama Senju'),
	  ('KH022', '0922345678' , N'Uzumaki Naruto'),
	  ('KH023', '0933456789' , N'Namikaze Minato')



Insert into LoaiDichVu 
Values('DV001' , N'Thức uống'),
	  ('DV002' , N'Thức ăn'),
	  ('DV003' , N'Dich vụ kèm')


Insert into DichVu
Values('DVBiaTiger' , N'Bia Tiger' , '22000' , '240' , 'DV001'),
	  ('DVBiaHeineken' , N'Bia Heineken' , '28000' , '240' , 'DV001'),
	  ('DVBiaSaigon' , N'Bia Saigon' , '18000' , '240' , 'DV001'),
	  ('DVBiaSaigonCoffee' , N'Bia Saigon Coffee' , '20000' , '240' , 'DV001'),
	  ('DVBiaSaigonSpecial' , N'Bia Saigon Special' , '22000' , '240' , 'DV001'),
	  ('DVBiaTigerBac' , N'Bia Tiger Bac' , '25000' , '240' , 'DV001'),
	  ('DVBiaSututrang' , N'Bia Sư tử trắng' , '28000' , '240' , 'DV001'),
	  ('DVBiaViet' , N'Bia Việt' , '22000' , '240' , 'DV001'),
	  ('DVBiaHanoi' , N'Bia Hanoi' , '20000' , '240' , 'DV001'),
	  ('DVBiaHuda' , N'Bia Huda' , '30000' , '240' , 'DV001'),
	  ('DVBiaSapporo' , N'Bia Sapporo' , '28000' , '240' , 'DV001'),
	  ('DVBiaLeffe' , N'Bia Leffe' , '30000' , '240' , 'DV001'),
	  ('DVBiaBudweiser' , N'Bia Budweiser' , '30000' , '240' , 'DV001'),
	  ('DVBiaNhatAsahi' , N'Bia Nhật Asahi' , '30000' , '240' , 'DV001'),
	  ('DVBiaLacViet' , N'Bia Lạc Việt' , '18000' , '240' , 'DV001'),
	  ('DVBia333' , N'Bia 333' , '18000' , '240' , 'DV001'),
	  ('DVBiaLarue' , N'Bia Larue' , '18000' , '240' , 'DV001'),
	  ('DVStrongbowdauden' , N'Strongbow dâu đen ' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowdau' , N'Strongbow dâu' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowtao' , N'Strongbow táo' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowdao' , N'Strongbow đào' , '30000' , '120' , 'DV001'),
	  ('DVStrongbownho' , N'Strongbow nho' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowduahau' , N'Strongbow dưa hấu' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowxoai' , N'Strongbow xoài' , '30000' , '120' , 'DV001'),
	  ('DVStrongbowmit' , N'Strongbow mít' , '30000' , '120' , 'DV001'),
	  ('DVRuouVangdo' , N'Rượu Vang đỏ' , '180000' , '40' , 'DV001'),
	  ('DVRuouVangSanta' , N'Rượu Vang Santa Helena' , '350000' , '40' , 'DV001'),
	  ('DVRuouNho' , N'Rượu nho' , '120000' , '40' , 'DV001'),
	  ('DVRuouSoju' , N'Rượu Soju' , '120000' , '40' , 'DV001'),
	  ('DVRuouGao' , N'Rượu Gạo' , '120000' , '40' , 'DV001'),
	  ('DVVodka' , N'Vodka' , '300000' , '40' , 'DV001'),
	  ('DVRuouDe' , N'Rượu Đế' , '120000' , '40' , 'DV001'),
	  ('DVStingdau' , N'Sting dâu' , '18000' , '60' , 'DV001'),
	  ('DVSpritechanh' , N'Sprite chanh' , '18000' , '60' , 'DV001'),
	  ('DVPepsi' , N'Pepsi' , '20000' , '60' , 'DV001'),
	  ('DVCocacola' , N'Cocacola' , '20000' , '60' , 'DV001'),
	  ('DV7up' , N'7up' , '18000' , '60' , 'DV001'),
	  ('DVMirinda' , N'Mirinda' , '18000' , '60' , 'DV001'),
	  ('DVFanta' , N'Fanta' , '18000' , '60' , 'DV001'),
	  ('DVBohuc' , N'Bò húc' , '22000' , '60' , 'DV001'),
	  ('DV0Do' , N'Trà xanh 0 độ' , '18000' , '60' , 'DV001'),
	  ('DVC2' , N'C2' , '18000' , '60' , 'DV001'),
	  ('DVTraThaoMoc' , N'Trà thảo mộc Dr.Thanh' , '18000' , '60' , 'DV001'),
	  ('DVCamEp' , N'Nước ép cam' , '30000' , '60' , 'DV001'),
	  ('DVNuocsuoi' , N'Nước suối' , '15000' , '60' , 'DV001'),
	  ('DVNuocsuoigas' , N'Nước suối có gas' , '18000' , '60' , 'DV001'),
	  ('DVKhanlanh' , N'Khăn lạnh' , '10000' , '300' , 'DV003'),
	  ('DVDauphong' , N'Đậu phộng' , '22000' , '300' , 'DV003'),
	  ('DVDiaTraiCayLon' , N'Đĩa trái cây lớn' , '180000' , '40' , 'DV002'),
	  ('DVDiaTraiCayVua' , N'Đĩa trái cây vừa' , '120000' , '40' , 'DV002'),
	  ('DVDiaTraiCayNho' , N'Đĩa trái cây nhỏ' , '60000' , '40' , 'DV002'),
	  ('DVDiaSaladLon' , N'Đĩa Salad kem trộn lớn' , '180000' , '40' , 'DV002'),
	  ('DVDiaSaladVua' , N'Đĩa Salad kem trộn vừa' , '120000' , '40' , 'DV002'),
	  ('DVDiaSaladNho' , N'Đĩa Salad kem trộn nhỏ' , '60000' , '40' , 'DV002'),
	  ('DVGaMuoiCoNuong' , N'Gà muối cỏ nướng' , '220000' , '200' , 'DV002'),
	  ('DVGaNauChao' , N'Gà nấu cháo' , '250000' , '200' , 'DV002'),
	  ('DVGaHapXa' , N'Gà hấp xã' , '250000' , '200' , 'DV002'),
	  ('DVGaNuongGiayBac' , N'Gà nướng giấy bạc' , '220000' , '200' , 'DV002'),
	  ('DVGaAnMay' , N'Gà ăn mày' , '350000' , '200' , 'DV002'),
	  ('DVGaNuongBongDem' , N'Gà nướng bóng đêm' , '220000' , '200' , 'DV002'),
	  ('DVMiXaoHaiSan' , N'Mì xào hải sản' , '120000' , '100' , 'DV002'),
	  ('DVMiXaoLong' , N'Mì xào lòng' , '120000' , '100' , 'DV002'),
	  ('DVMiXaoBo' , N'Mì xào bò' , '180000' , '100' , 'DV002'),
	  ('DVComChien' , N'Cơm chiên dương châu' , '120000' , '100' , 'DV002'),
	  ('DVComChienHaiSan' , N'Cơm chiên hải sản' , '180000' , '100' , 'DV002'),
	  ('DVCuaGachNgamTuong' , N'Cua gạch Cà Mau ngâm tương' , '300000' , '200' , 'DV002'),
	  ('DVCuaThitSotTrung' , N'Cua thịt Cà Mau sốt trứng muối' , '250000' , '200' , 'DV002'),
	  ('DVCuaGachChayToi' , N'Cua gạch Cà Mau cháy tỏi' , '300000' , '200' , 'DV002'),
	  ('DVCuaThitChayToi' , N'Cua thịt Cà Mau cháy tỏi' , '250000' , '200' , 'DV002'),
	  ('DVCuaGachGangMe' , N'Cua gạch Cà Mau gang me' , '300000' , '200' , 'DV002'),
	  ('DVCuaThitGangMe' , N'Cua thịt Cà Mau gang me' , '250000' , '200' , 'DV002'),
	  ('DVCuaGachHap' , N'Cua gạch Cà Mau hấp' , '300000' , '200' , 'DV002'),
	  ('DVCuaThitHap' , N'Cua thịt Cà Mau hấp' , '250000' , '200' , 'DV002'),
	  ('DVCaDieuHongHap' , N'Cá điêu hồng hấp' , '150000' , '100' , 'DV002'),
	  ('DVCaDieuHongChien' , N'Cá điêu hồng chiên xù' , '150000' , '100' , 'DV002'),
	  ('DVLauCaDieuHong' , N'Lẩu cá điêu hồng' , '200000' , '100' , 'DV002'),
	  ('DVLauCaDuoi' , N'Lẩu cá đuối' , '300000' , '100' , 'DV002'),
	  ('DVCaDuoiHap' , N'Cá đuối hấp' , '250000' , '100' , 'DV002'),
	  ('DVKhoCaDuoi' , N'Khô cá đuối nướng' , '300000' , '150' , 'DV002'),
	  ('DVKhoMuc' , N'Khô mực nướng' , '300000' , '150' , 'DV002'),
	  ('DVKhoTomTit' , N'Khô tôm tít nướng' , '250000' , '150' , 'DV002'),
	  ('DVBoGacBep' , N'Thịt Bò gác bếp' , '300000' , '150' , 'DV002'),
	  ('DVThitHeoLuoc' , N'Thịt heo luộc' , '200000' , '150' , 'DV002'),
	  ('DVThitHeoQuay' , N'Thịt heo quay' , '250000' , '150' , 'DV002'),
	  ('DVThitHeoNuong' , N'Thịt heo nướng' , '250000' , '150' , 'DV002'),
	  ('DVBanhHoi' , N'1kg Bánh hỏi' , '100000' , '150' , 'DV002'),
	  ('DVRauMuongXao' , N'Rồng xanh vác cảnh' , '80000' , '150' , 'DV002'),
	  ('DVHatDieu' , N'Hậu duệ mặt trời' , '60000' , '150' , 'DV003')
	  

Insert into LoaiPhong
Values('PT' , N'Phòng thường'),
	  ('PVip' , N'Phòng Vip')


Insert into Phong
Values('P001001' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P001002' , N'Đang sử dụng' , '120000' , '10' , 'PT'),
	  ('PVip001003' , N'Trống' , '120000' , '6' , 'PVip'),
	  ('P001004' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P001005' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P001006' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P001007' , N'Trống' , '60000' , '6' , 'PT'),
	  ('PVip001008' , N'Đã đặt' , '360000' , '15' , 'PT'),

	  ('P002001' , N'Đang sử dụng' , '120000' , '10' , 'PT'),
	  ('P002002' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P002003' , N'Trống' , '60000' , '6' , 'PT'),
	  ('PVip002004' , N'Trống' , '120000' , '6' , 'PVip'),
	  ('P002005' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P002006' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P002007' , N'Đã đặt' , '180000' , '15' , 'PT'),
	  ('PVip002008' , N'Trống' , '120000' , '6' , 'PVip'),

	  ('P003001' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip003002' , N'Đang sử dụng' , '120000' , '6' , 'PVip'),
	  ('P003003' , N'Đang chờ' , '60000' , '6' , 'PT'),
	  ('P003004' , N'Trống' , '120000' , '10' , 'PT'),
	  ('P003005' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P003006' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P003007' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip003008' , N'Trống' , '240000' , '10' , 'PVip'),

	  ('P004001' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P004002' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P004003' , N'Đã đặt' , '60000' , '6' , 'PT'),
	  ('PVip004004' , N'Trống' , '240000' , '10' , 'PVip'),
	  ('P004005' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P004006' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P004007' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip004008' , N'Trống' , '480000' , '20' , 'PVip'),

	  ('P005001' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P005002' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P005003' , N'Đã đặt' , '60000' , '6' , 'PT'),
	  ('P005004' , N'Trống' , '120000' , '10' , 'PT'),
	  ('PVip005005' , N'Đang chờ' , '240000' , '10' , 'PVip'),
	  ('P005006' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P005007' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip005008' , N'Trống' , '480000' , '20' , 'PVip'),

	  ('P006001' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P006002' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P006003' , N'Đã đặt' , '60000' , '6' , 'PT'),
	  ('P006004' , N'Trống' , '120000' , '10' , 'PT'),
	  ('P006005' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('PVip006006' , N'Trống' , '360000' , '15' , 'PVip'),
	  ('P006007' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip006008' , N'Trống' , '480000' , '20' , 'PVip'),

	  ('PVip007001' , N'Đang chờ' , '240000' , '10' , 'PVip'),
	  ('P007002' , N'Trống' , '60000' , '6' , 'PT'),
	  ('P007003' , N'Đã đặt' , '60000' , '6' , 'PT'),
	  ('P007004' , N'Trống' , '120000' , '10' , 'PT'),
	  ('P007005' , N'Đang chờ' , '120000' , '10' , 'PT'),
	  ('P007006' , N'Trống' , '180000' , '15' , 'PT'),
	  ('P007007' , N'Đã đặt' , '120000' , '10' , 'PT'),
	  ('PVip007008' , N'Trống' , '480000' , '20' , 'PVip'),

	  ('PVip008006' , N'Trống' , '720000' , '40' , 'PVip'),
	  ('PVip008008' , N'Trống' , '1200000' , '60' , 'PVip')


Insert into PhieuDatPhong
Values('MPDP01' , 5 , '2022-10-17' , '2022-10-18' , 'PVip001008' , 'KH001'),
	  ('MPDP02' , 2 , '2022-10-17' , '2022-10-18' , 'P002007' , 'KH002'),
	  ('MPDP03' , 5 , '2022-10-17' , '2022-10-18' , 'P003001' , 'KH003'),
	  ('MPDP04' , 2 , '2022-10-17' , '2022-10-18' , 'P003007' , 'KH004'),
	  ('MPDP05' , 3 , '2022-10-17' , '2022-10-18' , 'P004003' , 'KH005'),
	  ('MPDP06' , 4 , '2022-10-17' , '2022-10-18' , 'P004007' , 'KH006'),
	  ('MPDP07' , 5 , '2022-10-17' , '2022-10-18' , 'P005003' , 'KH007'),
	  ('MPDP08' , 5 , '2022-10-17' , '2022-10-18' , 'P005007' , 'KH008'),
	  ('MPDP09' , 5 , '2022-10-17' , '2022-10-18' , 'P006003' , 'KH009'),
	  ('MPDP10' , 5 , '2022-10-17' , '2022-10-18' , 'P006007' , 'KH010'),
	  ('MPDP11' , 5 , '2022-10-17' , '2022-10-18' , 'PVip001008' , 'KH011'),
	  ('MPDP12' , 5 , '2022-10-17' , '2022-10-18' , 'PVip004008' , 'KH012'),
	  ('MPDP13' , 12 , '2022-10-17' , '2022-10-18' , 'PVip008008' , 'KH013')


Insert into HoaDonThuePhong
Values('NV01101020220001' , '2022-10-10' , 0.1 , 'KH001' , 'NV01'),
	  ('NV01101020220002' , '2022-10-10' , 0.1 , 'KH002' , 'NV01'),
	  ('NV01101020220003' , '2022-10-10' , 0.1 , 'KH003' , 'NV01'),
	  ('NV01101020220004' , '2022-10-10' , 0.1 , 'KH004' , 'NV01'),
	  ('NV01101020220005' , '2022-10-10' , 0.1 , 'KH005' , 'NV01'),
	  ('NV01101020220006' , '2022-10-10' , 0.1 , 'KH006' , 'NV02'),
	  ('NV01101020220007' , '2022-10-10' , 0.1 , 'KH007' , 'NV02'),
	  ('NV01101020220008' , '2022-10-10' , 0.1 , 'KH008' , 'NV02'),
	  ('NV01111020220001' , '2022-10-11' , 0.1 , 'KH009' , 'NV03'),
	  ('NV01111020220002' , '2022-10-11' , 0.1 , 'KH010' , 'NV03'),
	  ('NV01111020220003' , '2022-10-11' , 0.1 , 'KH012' , 'NV04'),
	  ('NV01111020220004' , '2022-10-11' , 0.1 , 'KH013' , 'NV04'),
	  ('NV01121020220001' , '2022-10-12' , 0.1 , 'KH014' , 'NV05'),
	  ('NV01121020220002' , '2022-10-12' , 0.1 , 'KH015' , 'NV05'),
	  ('NV01121020220003' , '2022-10-12' , 0.1 , 'KH016' , 'NV05'),
	  ('NV01121020220004' , '2022-10-12' , 0.1 , 'KH017' , 'NV06'),
	  ('NV01131020220001' , '2022-10-13' , 0.1 , 'KH018' , 'NV01'),
	  ('NV01131020220002' , '2022-10-13' , 0.1 , 'KH020' , 'NV01'),
	  ('NV01131020220003' , '2022-10-13' , 0.1 , 'KH021' , 'NV01'),
	  ('NV01131020220004' , '2022-10-13' , 0.1 , 'KH022' , 'NV02'),
	  ('NV01131020220005' , '2022-10-13' , 0.1 , 'KH023' , 'NV02'),
	  ('NV01141020220001' , '2022-10-14' , 0.1 , 'KH007' , 'NV04'),
	  ('NV01141020220002' , '2022-10-14' , 0.1 , 'KH002' , 'NV04'),
	  ('NV01141020220003' , '2022-10-14' , 0.1 , 'KH001' , 'NV05'),
	  ('NV01141020220004' , '2022-10-14' , 0.1 , 'KH009' , 'NV06'),
	  ('NV01141020220005' , '2022-10-14' , 0.1 , 'KH005' , 'NV06'),
	  ('NV01141020220006' , '2022-10-14' , 0.1 , 'KH006' , 'NV06')

Insert into CTHoaDonThuePhong
Values('NV01101020220001','DVBia333' ,'P001001' ,'2022-10-10 10:10:10.110','10','2022-10-10 11:10:10.110'),
		('NV01101020220001','DVBiaTiger' ,'P001001' ,'2022-10-10 11:10:10.110','10','2022-10-10 11:12:10.110'),
		('NV01101020220001','DVKhanlanh' ,'P001001' ,'2022-10-10 11:10:10.110','10','2022-10-10 11:12:10.110')

