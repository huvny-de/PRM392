package huyvn.com.lab9;

public class CongViec {
    private int id;
    private String congviec;

    public CongViec(int id, String congviec) {
        this.id = id;
        this.congviec = congviec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }
}