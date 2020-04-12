package id.ac.polinema.aplikasiproject.models;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private List<Penting> pentings;
    private List<KurangPenting> kp;
    private List<Favourite> f;

    public Activity() {
        this.pentings = new ArrayList<>();
        this.kp = new ArrayList<>();
        this.f = new ArrayList<>();
    }


    public List<Penting> getPentings() {
        return pentings;
    }

    public void addPenting(Penting penting) {
        this.pentings.add(penting);
    }

    public void removePenting(int index) {
        Penting penting = pentings.get(index);
        this.pentings.remove(penting);
    }

    public void updatePenting(int index, Penting penting) {
        this.pentings.set(index, penting);
    }

    public List<KurangPenting> getKurangpenting() {
        return kp;
    }

    public void addKurangpenting(KurangPenting kurangpenting) {
        this.kp.add(kurangpenting);
    }

    public void removeKurangPenting(int index) {
        KurangPenting k = kp.get(index);
        this.kp.remove(k);
    }

    public void updateKurangpenting(int index, KurangPenting p) {
        this.kp.set(index, p);
    }

    public List<Favourite> getFavourite() {
        return f;
    }

    public void addFavourite(Favourite favourite) {
        this.f.add(favourite);
    }

    public void removeFavourite(int index) {
        Favourite fav = f.get(index);
        this.f.remove(fav);
    }

    public void updateFavourite(int index, Favourite f) {
        this.f.set(index, f);
    }
}
