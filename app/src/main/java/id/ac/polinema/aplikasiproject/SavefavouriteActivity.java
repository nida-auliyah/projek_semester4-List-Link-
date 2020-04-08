package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.aplikasiproject.models.Favourite;

public class SavefavouriteActivity extends AppCompatActivity {

    private EditText descriptionInput;
    private EditText linkInput;
    private EditText tanggalInput;
    private Favourite item;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savefavourite);

        descriptionInput = findViewById(R.id.input_descriptionf);
        linkInput = findViewById(R.id.input_linkf);
        tanggalInput = findViewById(R.id.input_tanggalf);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            item = extras.getParcelable(FavouriteActivity.FAVOURITE_KEY);
            index = extras.getInt(FavouriteActivity.INDEX_KEY, 0);
            descriptionInput.setText(item.getNama());
            linkInput.setText(item.getLink());
            tanggalInput.setText(item.getTanggal());
        }

    }

    public void handlesimpanf(View view) {
        String description = descriptionInput.getText().toString();
        String link = linkInput.getText().toString();
        String tanggal = tanggalInput.getText().toString();
        if (description.equals("")||link.equals("")){
            Toast.makeText(getApplicationContext(), "Data Harus diisi!",Toast.LENGTH_SHORT).show();
        }else {
            item.setNama(description);
            item.setLink(link);
            item.setTanggal(tanggal);

            Intent intent = new Intent();
            intent.putExtra(FavouriteActivity.FAVOURITE_KEY, item);
            intent.putExtra(FavouriteActivity.INDEX_KEY, index);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    public void handleuji(View view) {
        String linkuji = linkInput.getText().toString();
        if (!linkuji.startsWith("https")||!linkuji.startsWith("http")){
            linkuji = "http://" + linkuji;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(linkuji));
        startActivity(intent);
    }
}
