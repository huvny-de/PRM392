package huyvn.lab42;

import java.io.Serializable;

public class Student implements Serializable {

    private String hoten, email;
    private int namsinh;

    public Student(String hoten, String email, int namsinh) {
        this.hoten = hoten;
        this.email = email;
        this.namsinh = namsinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }
}