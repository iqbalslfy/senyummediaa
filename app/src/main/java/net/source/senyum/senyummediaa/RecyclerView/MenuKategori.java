package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.source.senyum.senyummediaa.Data.DataKategori;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.Kategori.BukuActivity;
import net.source.senyum.senyummediaa.Kategori.ElektronikActivity;
import net.source.senyum.senyummediaa.Kategori.KertasActivity;
import net.source.senyum.senyummediaa.Kategori.PeralatanKantorActivity;
import net.source.senyum.senyummediaa.Kategori.PeralatanRumahTangga;
import net.source.senyum.senyummediaa.Kategori.PerlengkapanKantorActivity;
import net.source.senyum.senyummediaa.Kategori.StationeryActivity;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 06/01/2018.
 */

class KategoriHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imgKategori;
    public TextView txtJudul;
    private ItemClickListener itemClickListener;

    public KategoriHolder(View itemView) {
        super(itemView);

        imgKategori = itemView.findViewById(R.id.img_itemKategori);
        txtJudul = itemView.findViewById(R.id.txtJudulKategori);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}

public class MenuKategori extends RecyclerView.Adapter<KategoriHolder> {
    private List<DataKategori> listKategori = new ArrayList<>();
    private Context context;

    public MenuKategori(List<DataKategori> listKategori, Context context) {
        this.listKategori = listKategori;
        this.context = context;
    }


    @Override
    public KategoriHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_kategori, parent, false);
        return new KategoriHolder(view);
    }

    @Override
    public void onBindViewHolder(KategoriHolder holder, int position) {
        holder.imgKategori.setImageResource(listKategori.get(position).getImgKategori());
        holder.txtJudul.setText(listKategori.get(position).getTxtJudul());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (pos == 0) {
                    context.startActivity(new Intent(context, StationeryActivity.class));
                }

                if (pos == 1) {
                    context.startActivity(new Intent(context, PerlengkapanKantorActivity.class));
                }

                if (pos == 2) {
                    context.startActivity(new Intent(context, PeralatanKantorActivity.class));
                }

                if (pos == 3) {
                    context.startActivity(new Intent(context, KertasActivity.class));
                }

                if (pos == 4) {
                    context.startActivity(new Intent(context, ElektronikActivity.class));
                }

                if (pos == 5) {
                    context.startActivity(new Intent(context, BukuActivity.class));
                }

                if (pos == 6) {
                    context.startActivity(new Intent(context, PeralatanRumahTangga.class));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listKategori.size();
    }
}
