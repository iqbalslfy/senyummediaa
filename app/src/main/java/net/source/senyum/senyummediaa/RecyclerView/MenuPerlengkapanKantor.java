package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.source.senyum.senyummediaa.Activity.Pemesanan;
import net.source.senyum.senyummediaa.Data.DataPerlengkapanKantor;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class MenuPerlKanHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;
    private ItemClickListener itemClickListener;

    public MenuPerlKanHolder(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.img_toko);
        textNamaToko = (TextView)itemView.findViewById(R.id.txtNamaToko);
        textHarga = itemView.findViewById(R.id.txtHarga);
        textHargaSebPotongan = itemView.findViewById(R.id.txtHargaSebPotongan);

        itemView.setOnClickListener(this);

        strikeThroughText(textHargaSebPotongan);
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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

public class MenuPerlengkapanKantor extends RecyclerView.Adapter<MenuPerlKanHolder> {

    private List<DataPerlengkapanKantor> PerlengkapanKantor = new ArrayList<>();
    private Context context;

    public MenuPerlengkapanKantor(List<DataPerlengkapanKantor> perlengkapanKantor, Context context) {
        PerlengkapanKantor = perlengkapanKantor;
        this.context = context;
    }

    @Override
    public MenuPerlKanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_stationery, parent, false);
        return new MenuPerlKanHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuPerlKanHolder holder, int position) {
        holder.imageView.setImageResource(PerlengkapanKantor.get(position).getGambar());
        holder.textNamaToko.setText(PerlengkapanKantor.get(position).getNama_toko());
        holder.textHarga.setText(PerlengkapanKantor.get(position).getHarga());
        holder.textHargaSebPotongan.setText(PerlengkapanKantor.get(position).getHargasebpotongan());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                Toast.makeText(context, ""+ PerlengkapanKantor.get(pos).getNama_toko(),Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, Pemesanan.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return PerlengkapanKantor.size();
    }
}
