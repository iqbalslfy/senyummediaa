package net.source.senyum.senyummediaa.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Activity.Pemesanan;
import net.source.senyum.senyummediaa.Data.DataPopulerProduk;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 06/01/2018.
 */

class PopulerProdukHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView imgPromo;
    public TextView txtJudul, txtHarga;
    private ItemClickListener itemClickListener;

    public PopulerProdukHolder(View itemView) {
        super(itemView);

        imgPromo = itemView.findViewById(R.id.imgPopulerProduk);
        txtJudul = itemView.findViewById(R.id.txtJudulPopuler);
        txtHarga = itemView.findViewById(R.id.txtHargaPopuler);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
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

public class MenuPopulerProduk extends RecyclerView.Adapter<PopulerProdukHolder>{
    private List<DataPopulerProduk> produkList = new ArrayList<>();
    private Context context;

    public MenuPopulerProduk(List<DataPopulerProduk> produkList, Context context) {
        this.produkList = produkList;
        this.context = context;
    }

    @Override
    public PopulerProdukHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_populer_produk, parent, false);

        return new PopulerProdukHolder(view);
    }

    @Override
    public void onBindViewHolder(PopulerProdukHolder holder, int position) {
    holder.imgPromo.setImageResource(produkList.get(position).getImgProduk());
    holder.txtJudul.setText(produkList.get(position).getTxtJudul());
    holder.txtHarga.setText(produkList.get(position).getTxtHarga());
    holder.setItemClickListener(new ItemClickListener() {
        @Override
        public void onClick(View view, int pos, boolean isLongClick) {
            context.startActivity(new Intent(context, Pemesanan.class));
        }
    });
    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }
}
