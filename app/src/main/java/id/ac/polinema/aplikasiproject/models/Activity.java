package id.ac.polinema.aplikasiproject.models;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private List<Main> mains;
    private List<KurangPenting> kp;
    private List<Favourite> f;

    public Activity() {
        this.mains = new ArrayList<>();
        this.kp = new ArrayList<>();
        this.f = new ArrayList<>();
    }


    public List<Main> getMains() {
        return mains;
    }

    public void addMain(Main main) {
        this.mains.add(main);
    }

    public void removeMain(int index) {
        Main main = mains.get(index);
        this.mains.remove(main);
    }

    public void updateMain(int index, Main main) {
        this.mains.set(index, main);
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
