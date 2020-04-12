package id.ac.polinema.aplikasiproject.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Penting implements Parcelable {
    private String nama;
    private String link;
    private String tanggal;

    public Penting() {
    }

    public Penting(String nama, String link, String tanggal) {
        this.nama = nama;
        this.link = link;
        this.tanggal = tanggal;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(link);
        dest.writeString(tanggal);
    }

    protected Penting(Parcel in) {
        nama = in.readString();
        link = in.readString();
        tanggal = in.readString();
    }
    //implement dari parcerable
    public static final Creator<Penting> CREATOR = new Creator<Penting>() {
        @Override
        public Penting createFromParcel(Parcel source) {
            return new Penting(source);
        }

        @Override
        public Penting[] newArray(int size) {
            return new Penting[size];
        }
    };

}
