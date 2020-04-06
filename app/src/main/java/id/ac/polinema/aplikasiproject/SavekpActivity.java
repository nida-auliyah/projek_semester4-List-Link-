package id.ac.polinema.aplikasiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.ac.polinema.aplikasiproject.models.KurangPenting;

public class SavekpActivity extends AppCompatActivity {

    private EditText descriptionInput;
    private EditText linkInput;
    private EditText tanggalInput;
    private KurangPenting item;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savekp);

        descriptionInput = findViewById(R.id.input_descriptionkp);
        linkInput = findViewById(R.id.input_linkkp);
        tanggalInput = findViewById(R.id.input_tanggalkp);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            item = extras.getParcelable(KurangPentingActivity.KURANGPENTING_KEY);
            index = extras.getInt(KurangPentingActivity.INDEX_KEY, 0);
            descriptionInput.setText(item.getNama());
            linkInput.setText(item.getLink());
            tanggalInput.setText(item.getTanggal());
        }

    }

    public void handlesimpankp(View view) {
        String description = descriptionInput.getText().toString();
        String link = linkInput.getText().toString();
        String tanggal = tanggalInput.getText().toString();

        item.setNama(description);
        item.setLink(link);
        item.setTanggal(tanggal);

        Intent intent = new Intent();
        intent.putExtra(KurangPentingActivity.KURANGPENTING_KEY, item);
        intent.putExtra(KurangPentingActivity.INDEX_KEY, index);
        setResult(RESULT_OK, intent);
        finish();
    }
}
