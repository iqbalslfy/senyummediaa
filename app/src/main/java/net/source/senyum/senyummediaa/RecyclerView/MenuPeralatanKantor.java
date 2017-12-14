package net.source.senyum.senyummediaa.RecyclerView;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Data.MenuStationery;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class MenuPeralatanKantorbHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public MenuPeralatanKantorbHolder(View itemView) {
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
public class MenuPeralatanKantor extends RecyclerView.Adapter<MenuPeralatanKantorbHolder>{
    private List<MenuStationery> menuPeralatan = new ArrayList<>();

    public MenuPeralatanKantor(List<MenuStationery> menuPeralatan) {
        this.menuPeralatan = menuPeralatan;
    }

    @Override
    public MenuPeralatanKantorbHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);

        return new MenuPeralatanKantorbHolder(view);

    }

    @Override
    public void onBindViewHolder(MenuPeralatanKantorbHolder holder, int position) {
        holder.imageView.setImageResource(menuPeralatan.get(position).getGambar());
        holder.textNamaToko.setText(menuPeralatan.get(position).getNama_toko());
        holder.textHarga.setText(menuPeralatan.get(position).getHarga());
        holder.textHargaSebPotongan.setText(menuPeralatan.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return menuPeralatan.size();
    }
}
