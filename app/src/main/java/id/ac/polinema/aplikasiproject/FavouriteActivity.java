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

import id.ac.polinema.aplikasiproject.adapter.FavouriteAdapter;
import id.ac.polinema.aplikasiproject.models.Activity;
import id.ac.polinema.aplikasiproject.models.Favourite;

public class FavouriteActivity extends AppCompatActivity implements FavouriteAdapter.onItemFavouriteListener{

    public static final String FAVOURITE_KEY = "FAVOURITE";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private RecyclerView View;
    private FavouriteAdapter adapter;
    private Activity account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        View = findViewById(R.id.rv_penting);

        FloatingActionButton fab = findViewById(R.id.fb_favourite);

        fab.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Tambahkan event click fab di sini

                Intent intent = new Intent(FavouriteActivity.this, SavefavouriteActivity.class);
                intent.putExtra(FAVOURITE_KEY, new Favourite());
                startActivityForResult(intent, INSERT_REQUEST);

            }
        });


        account = Application.getAccount();
        adapter = new FavouriteAdapter(account.getFavourite(), this);
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
                account.removeFavourite(index);
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
            Favourite f = data.getParcelableExtra(FAVOURITE_KEY);
            if (requestCode == INSERT_REQUEST) {
                account.addFavourite(f);
            }else if (requestCode == UPDATE_REQUEST) {
                int index = data.getIntExtra(INDEX_KEY, 0);
                account.updateFavourite(index, f);
            }
            adapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onFavouriteClicked(int index, Favourite item) {
        Intent intent = new Intent(this, SavefavouriteActivity.class);
        intent.putExtra(FAVOURITE_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }
}
