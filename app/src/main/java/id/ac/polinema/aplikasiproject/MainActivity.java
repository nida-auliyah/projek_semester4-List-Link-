package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlecontinue(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivity(intent);
    }
}
