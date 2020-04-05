package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.aplikasiproject.adapter.CategoryAdapter;
import id.ac.polinema.aplikasiproject.models.Category;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        RecyclerView teamsView = findViewById(R.id.rv_teams);

        List<Category> teams = new ArrayList<>();
        teams.add(new Category("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Liverpool_FC.svg/360px-Liverpool_FC.svg.png", "Link Penting"));
        teams.add(new Category("https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/Manchester_City_FC_badge.svg/360px-Manchester_City_FC_badge.svg.png", "Link Kurang Penting"));
        teams.add(new Category("https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/Manchester_City_FC_badge.svg/360px-Manchester_City_FC_badge.svg.png", "Link Favorite"));

        CategoryAdapter adapter = new CategoryAdapter(this, teams);
        teamsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        teamsView.setLayoutManager(layoutManager);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
