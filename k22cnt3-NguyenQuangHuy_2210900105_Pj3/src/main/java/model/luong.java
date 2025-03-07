package model;

public class luong {
    private int id;
    private String hoTen;
    private String chucVu;
    private double luongCoBan;
    private double thuong;
    private double tongLuong;

    public luong(int id, String hoTen, String chucVu, double luongCoBan, double thuong, double tongLuong) {
        this.id = id;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.thuong = thuong;
        this.tongLuong = tongLuong;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getChucVu() { return chucVu; }
    public void setChucVu(String chucVu) { this.chucVu = chucVu; }

    public double getLuongCoBan() { return luongCoBan; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    public double getThuong() { return thuong; }
    public void setThuong(double thuong) { this.thuong = thuong; }

    public double getTongLuong() { return tongLuong; }
    public void setTongLuong(double tongLuong) { this.tongLuong = tongLuong; }
}
