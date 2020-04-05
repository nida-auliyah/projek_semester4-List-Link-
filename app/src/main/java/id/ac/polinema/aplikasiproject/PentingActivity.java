package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PentingActivity extends AppCompatActivity {

    public static final String MAIN_KEY = "MAIN";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penting);
    }
}
