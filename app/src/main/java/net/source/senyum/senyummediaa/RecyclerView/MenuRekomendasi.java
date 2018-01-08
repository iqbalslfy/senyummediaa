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
import net.source.senyum.senyummediaa.Data.DataRekomendasi;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 08/01/2018.
 */

class RekomendasiHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView ImgRekomendasi;
    public TextView txtJudul, txtHarga;
    private ItemClickListener itemClickListener;


    public RekomendasiHolder(View itemView) {
        super(itemView);

        ImgRekomendasi = itemView.findViewById(R.id.ImgRekomendasi);
        txtJudul = itemView.findViewById(R.id.txtJudulRekomendasi);
        txtHarga = itemView.findViewById(R.id.txtHargaRekomendasi);

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

public class MenuRekomendasi extends RecyclerView.Adapter<RekomendasiHolder>{
    private  List<DataRekomendasi> rekomendasiList = new ArrayList<>();
    private Context context;

    public MenuRekomendasi(List<DataRekomendasi> rekomendasiList, Context context) {
        this.rekomendasiList = rekomendasiList;
        this.context = context;
    }

    @Override
    public RekomendasiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rekomendasi, parent, false);

        return new RekomendasiHolder(view);
    }

    @Override
    public void onBindViewHolder(RekomendasiHolder holder, int position) {
       holder.ImgRekomendasi.setImageResource(rekomendasiList.get(position).getImgRekomenasi());
       holder.txtJudul.setText(rekomendasiList.get(position).getTxtJudul());
       holder.txtHarga.setText(rekomendasiList.get(position).getTxtHarga());
       holder.setItemClickListener(new ItemClickListener() {
           @Override
           public void onClick(View view, int pos, boolean isLongClick) {
               context.startActivity(new Intent(context, Pemesanan.class));
           }
       });
    }

    @Override
    public int getItemCount() {
        return rekomendasiList.size();
    }
}
