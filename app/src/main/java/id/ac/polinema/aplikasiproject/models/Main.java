package id.ac.polinema.aplikasiproject.models;

public class Main {
    private String nama;
    private String link;
    private String tanggal;

    public Main(String nama, String link, String tanggal) {
        this.nama = nama;
        this.link = link;
        this.tanggal = tanggal;
    }

    public Main() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
