package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void handleFab(View view) {
        Intent intent = new Intent(this, CategoryAddActivity.class);
        startActivity(intent);
    }
}
