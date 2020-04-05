package id.ac.polinema.aplikasiproject.models;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private List<Main> mains;

    public Activity() {
        this.mains = new ArrayList<>();
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
}
