package com.example.vikri.tugassapi.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vikri.tugassapi.Model.TeamsItem;
import com.example.vikri.tugassapi.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.Holder> {
    private List<TeamsItem> artikelList;
    private Context context;
    public ArtikelAdapter(Context context, List<TeamsItem> artikelList) {
        this.context = context;
        this.artikelList = artikelList;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sport, parent, false);
        return new Holder(view);
    }
    @Override
    public void onBindViewHolder(ArtikelAdapter.Holder holder, final int
            position) {
        holder.bind(position);
    }
    @Override
    public int getItemCount() {
        return artikelList.size();
    }
    class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout openSport;
        private ImageView imgSport;
        private TextView tvDeskripsi;
        private TextView tvTanggal;
        public Holder(View itemView) {
            super(itemView);
            imgSport= itemView.findViewById(R.id.img_artikel);
            tvDeskripsi= itemView.findViewById(R.id.tv_judul_artikel);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            openSport = itemView.findViewById(R.id.openEdukasi);
        }
        public void bind(final int position) {
            Picasso.get()
                    .load(artikelList.get(position).getStrTeamLogo())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imgSport);
            tvDeskripsi.setText(artikelList.get(position).getIdTeam());
            tvTanggal.setText(artikelList.get(position).getStrTeam());
            openSport.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "clicked : " +
                                    tvDeskripsi.getText().toString() + "\n Position : " + String.valueOf(position),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
