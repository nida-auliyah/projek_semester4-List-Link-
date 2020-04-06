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

import id.ac.polinema.aplikasiproject.adapter.KurangPentingAdapter;
import id.ac.polinema.aplikasiproject.models.Activity;
import id.ac.polinema.aplikasiproject.models.KurangPenting;

public class KurangPentingActivity extends AppCompatActivity implements KurangPentingAdapter.onItemKurangPentingListener{

    public static final String KURANGPENTING_KEY = "KURANGPENTING";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private RecyclerView View;
    private KurangPentingAdapter adapter;
    private Activity account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kurang_penting);

        View = findViewById(R.id.rv_penting);

        FloatingActionButton fab = findViewById(R.id.fb_kurangpenting);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Tambahkan event click fab di sini

                Intent intent = new Intent(KurangPentingActivity.this, SavekpActivity.class);
                intent.putExtra(KURANGPENTING_KEY, new KurangPenting());
                startActivityForResult(intent, INSERT_REQUEST);

            }
        });


        account = Application.getAccount();
        adapter = new KurangPentingAdapter(account.getKurangpenting(), this);
        View.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        View.setLayoutManager(layoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                account.removeKurangPenting(index);
                adapter.notifyDataSetChanged();

            }
        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mItemTouchHelper.attachToRecyclerView(View);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            KurangPenting kp = data.getParcelableExtra(KURANGPENTING_KEY);
            if (requestCode == INSERT_REQUEST) {
                account.addKurangpenting(kp);
            }else if (requestCode == UPDATE_REQUEST) {
                int index = data.getIntExtra(INDEX_KEY, 0);
                account.updateKurangpenting(index, kp);
            }
            adapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onKurangPentingClicked(int index, KurangPenting item) {
        Intent intent = new Intent(this, SavekpActivity.class);
        intent.putExtra(KURANGPENTING_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }
}
