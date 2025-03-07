package model;

public class nhanvien {
    private int id;
    private String hoTen;
    private String chucVu;
    private String phongBan;
    private double luong;

    public nhanvien(int id, String hoTen, String chucVu, String phongBan, double luong) {
        this.id = id;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.phongBan = phongBan;
        this.luong = luong;
    }

    public int getId() { return id; }
    public String getHoTen() { return hoTen; }
    public String getChucVu() { return chucVu; }
    public String getPhongBan() { return phongBan; }
    public double getLuong() { return luong; }

    public void setId(int id) { this.id = id; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }
    public void setPhongBan(String phongBan) { this.phongBan = phongBan; }
    public void setLuong(double luong) { this.luong = luong; }
}
