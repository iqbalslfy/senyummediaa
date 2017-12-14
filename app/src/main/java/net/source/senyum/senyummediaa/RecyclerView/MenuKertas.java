package net.source.senyum.senyummediaa.RecyclerView;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Data.DataKertas;
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */


class MenuKertasHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public MenuKertasHolder(View itemView) {
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

public class MenuKertas extends RecyclerView.Adapter<MenuKertasHolder>{
    private List<DataKertas> ListKertas = new ArrayList<>();

    public MenuKertas(List<DataKertas> listKertas) {
        ListKertas = listKertas;
    }

    @Override
    public MenuKertasHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new MenuKertasHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuKertasHolder holder, int position) {
        holder.imageView.setImageResource(ListKertas.get(position).getGambar());
        holder.textNamaToko.setText(ListKertas.get(position).getNama_toko());
        holder.textHarga.setText(ListKertas.get(position).getHarga());
        holder.textHargaSebPotongan.setText(ListKertas.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return ListKertas.size();
    }
}
