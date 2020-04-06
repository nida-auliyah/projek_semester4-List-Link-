package id.ac.polinema.aplikasiproject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.ac.polinema.aplikasiproject.KurangPentingActivity;
import id.ac.polinema.aplikasiproject.R;
import id.ac.polinema.aplikasiproject.models.KurangPenting;

public class KurangPentingAdapter extends RecyclerView.Adapter<KurangPentingAdapter.ViewHolder> {

    public interface onItemKurangPentingListener {
        void onKurangPentingClicked(int index, KurangPenting item);
    }
    private List<KurangPenting> items;
    private KurangPentingAdapter.onItemKurangPentingListener Listener;

    public KurangPentingAdapter(List<KurangPenting> items, KurangPentingAdapter.onItemKurangPentingListener listener) {
        this.items = items;
        this.Listener = listener;
    }

    @NonNull
    @Override
    public KurangPentingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KurangPentingAdapter.ViewHolder holder, int position) {
        KurangPenting item = items.get(position);
        holder.bind(position, item);
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descriptionText;
        TextView linkText;
        TextView tanggalText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descriptionText = itemView.findViewById(R.id.text_description);
            linkText = itemView.findViewById(R.id.text_Link);
            tanggalText = itemView.findViewById(R.id.text_tanggal);
        }
        public void bind(final int index, final KurangPenting item) {
            descriptionText.setText(item.getNama());
            linkText.setText(item.getLink());
            tanggalText.setText(item.getTanggal());
            // TODO: Tambahkan interaksi click di sini
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Listener.onKurangPentingClicked(index, item);
                }
            });
        }
    }

}