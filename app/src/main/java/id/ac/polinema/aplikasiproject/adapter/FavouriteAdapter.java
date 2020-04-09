package id.ac.polinema.aplikasiproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import id.ac.polinema.aplikasiproject.R;
import id.ac.polinema.aplikasiproject.models.Favourite;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    public interface onItemFavouriteListener {
        void onFavouriteClicked(int index, Favourite item);
    }
    private List<Favourite> items;
    private FavouriteAdapter.onItemFavouriteListener Listener;

    public FavouriteAdapter(List<Favourite> items, FavouriteAdapter.onItemFavouriteListener listener) {
        this.items = items;
        this.Listener = listener;
    }

    @NonNull
    @Override
    public FavouriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_daftarlink, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FavouriteAdapter.ViewHolder holder, int position) {
        final Favourite item = items.get(position);
        holder.bind(position, item);
        holder.web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                String url = item.getLink();

                if (!url.startsWith("https")||!url.startsWith("http")){
                    url = "http://" + url;
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descriptionText;
        TextView tanggalText;
        FloatingActionButton web;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionText = itemView.findViewById(R.id.text_description);
            tanggalText = itemView.findViewById(R.id.text_tanggal);
            web = itemView.findViewById(R.id.fb_web);
        }
        public void bind(final int index, final Favourite item) {
            descriptionText.setText(item.getNama());
            tanggalText.setText(item.getTanggal());
            // TODO: Tambahkan interaksi click di sini
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Listener.onFavouriteClicked(index, item);
                }
            });
        }
    }

}
