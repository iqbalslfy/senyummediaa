package net.source.senyum.senyummediaa.RecyclerView;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 31/10/2017.
 */

class StationeryViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public StationeryViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.img_toko);
        textNamaToko = (TextView)itemView.findViewById(R.id.txtNamaToko);
        textHarga = itemView.findViewById(R.id.txtHarga);
        textHargaSebPotongan = itemView.findViewById(R.id.txtHargaSebPotongan);

        strikeThroughText(textHargaSebPotongan);
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}

public class MenuStationeryRv extends RecyclerView.Adapter<StationeryViewHolder>{
    private List<DataStationery> tokoList = new ArrayList<>();

    public MenuStationeryRv(List<DataStationery> tokoList) {
        this.tokoList = tokoList;
    }

    @Override
    public StationeryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new StationeryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StationeryViewHolder holder, int position) {
        holder.imageView.setImageResource(tokoList.get(position).getGambar());
        holder.textNamaToko.setText(tokoList.get(position).getNama_toko());
        holder.textHarga.setText(tokoList.get(position).getHarga());
        holder.textHargaSebPotongan.setText(tokoList.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return tokoList.size();
    }


}
