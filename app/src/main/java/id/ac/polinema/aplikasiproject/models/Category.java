package id.ac.polinema.aplikasiproject.models;

public class Category {
    private String logo;
    private String nama;

    public Category(String logo, String nama) {
        this.logo = logo;
        this.nama = nama;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
