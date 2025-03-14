package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private int id;
    private String fullname;
    private String position;
    private String department;
    private String email;
    private String phone;
    private LocalDate hireDate;
    private BigDecimal basicSalary;
    private BigDecimal bonus;
    private String status;

    // Constructor đầy đủ tham số
    public Employee(int id, String fullname, String position, String department, String email, String phone,
                    LocalDate hireDate, BigDecimal basicSalary, BigDecimal bonus, String status) {
        this.id = id;
        this.fullname = fullname;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.status = status;
    }

    // Constructor không có id (dùng khi thêm nhân viên mới)
    public Employee(String fullname, String position, String department, String email, String phone,
                    LocalDate hireDate, BigDecimal basicSalary, BigDecimal bonus, String status) {
        this.fullname = fullname;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.status = status;
    }

    // Constructor không tham số
    public Employee() {}

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public BigDecimal getBasicSalary() { return basicSalary; }
    public void setBasicSalary(BigDecimal basicSalary) { this.basicSalary = basicSalary; }

    public BigDecimal getBonus() { return bonus; }
    public void setBonus(BigDecimal bonus) { this.bonus = bonus; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Override toString() để debug dễ dàng
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", hireDate=" + hireDate +
                ", basicSalary=" + basicSalary +
                ", bonus=" + bonus +
                ", status='" + status + '\'' +
                '}';
    }

//Constructor hỗ trợ kiểu double cho basicSalary và bonus
public Employee(int id, String fullname, String position, String department, String email, String phone,
             LocalDate hireDate, double basicSalary, double bonus, String status) {
 this.id = id;
 this.fullname = fullname;
 this.position = position;
 this.department = department;
 this.email = email;
 this.phone = phone;
 this.hireDate = hireDate;
 this.basicSalary = BigDecimal.valueOf(basicSalary);
 this.bonus = BigDecimal.valueOf(bonus);
 this.status = status;
}
}
