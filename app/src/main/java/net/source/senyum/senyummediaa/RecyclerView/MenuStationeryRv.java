package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import net.source.senyum.senyummediaa.Activity.Pemesanan;
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.Fragment.FragmentBeranda;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 31/10/2017.
 */

class StationeryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;
    public RelativeLayout relativeLayout;
    private ItemClickListener itemClickListener;


    public StationeryViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img_toko);
        textNamaToko = itemView.findViewById(R.id.txtNamaToko);
        textHarga = itemView.findViewById(R.id.txtHarga);
        textHargaSebPotongan = itemView.findViewById(R.id.txtHargaSebPotongan);

        itemView.setOnClickListener(this);

        strikeThroughText(textHargaSebPotongan);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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

public class MenuStationeryRv extends RecyclerView.Adapter<StationeryViewHolder>{

    private List<DataStationery> tokoList = new ArrayList<>();
    private Context context;

    public MenuStationeryRv(List<DataStationery> tokoList, Context context) {
        this.tokoList = tokoList;
        this.context = context;
    }

    @Override
    public StationeryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new StationeryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final StationeryViewHolder holder, final int position) {
        holder.imageView.setImageResource(tokoList.get(position).getGambar());
        holder.textNamaToko.setText(tokoList.get(position).getNama_toko());
        holder.textHarga.setText(tokoList.get(position).getHarga());
        holder.textHargaSebPotongan.setText(tokoList.get(position).getHargasebpotongan());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if (isLongClick){

                }else {
                    Toast.makeText(context, tokoList.get(pos).getNama_toko(), Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, Pemesanan.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tokoList.size();
    }


}
