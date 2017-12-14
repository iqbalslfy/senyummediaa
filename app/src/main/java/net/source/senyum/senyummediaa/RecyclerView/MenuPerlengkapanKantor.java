package net.source.senyum.senyummediaa.RecyclerView;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Data.DataPerlengkapanKantor;
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class MenuPerlKanHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public MenuPerlKanHolder(View itemView) {
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

public class MenuPerlengkapanKantor extends RecyclerView.Adapter<MenuPerlKanHolder> {

    private List<DataPerlengkapanKantor> PerlengkapanKantor = new ArrayList<>();

    public MenuPerlengkapanKantor(List<DataPerlengkapanKantor> perlengkapanKantor) {
        PerlengkapanKantor = perlengkapanKantor;
    }

    @Override
    public MenuPerlKanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new MenuPerlKanHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuPerlKanHolder holder, int position) {
        holder.imageView.setImageResource(PerlengkapanKantor.get(position).getGambar());
        holder.textNamaToko.setText(PerlengkapanKantor.get(position).getNama_toko());
        holder.textHarga.setText(PerlengkapanKantor.get(position).getHarga());
        holder.textHargaSebPotongan.setText(PerlengkapanKantor.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return PerlengkapanKantor.size();
    }
}
