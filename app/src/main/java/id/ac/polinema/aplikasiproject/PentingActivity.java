package id.ac.polinema.aplikasiproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import id.ac.polinema.aplikasiproject.adapter.PentingAdapter;
import id.ac.polinema.aplikasiproject.models.Activity;
import id.ac.polinema.aplikasiproject.models.Penting;

public class PentingActivity extends AppCompatActivity implements PentingAdapter.onItemMainListener {

    public static final String MAIN_KEY = "MAIN";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private RecyclerView mainsView;
    private PentingAdapter adapter;
    private Activity account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penting);

        mainsView = findViewById(R.id.rv_penting);

        FloatingActionButton fab = findViewById(R.id.fab_penting);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Tambahkan event click fab di sini

                Intent intent = new Intent(PentingActivity.this, SavepentingActivity.class);
                intent.putExtra(MAIN_KEY, new Penting());
                startActivityForResult(intent, INSERT_REQUEST);

            }
        });

        account = Application.getAccount();
        adapter = new PentingAdapter(account.getPentings(), this);
        mainsView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainsView.setLayoutManager(layoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                account.removePenting(index);
                adapter.notifyDataSetChanged();

            }
        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(mainsView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Penting penting = data.getParcelableExtra(MAIN_KEY);
            if (requestCode == INSERT_REQUEST) {
                account.addPenting(penting);
            }else if (requestCode == UPDATE_REQUEST) {
                int index = data.getIntExtra(INDEX_KEY, 0);
                account.updatePenting(index, penting);
            }
            adapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onMainClicked(int index, Penting item) {

        Intent intent = new Intent(this, SavepentingActivity.class);
        intent.putExtra(MAIN_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
