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

class MenuBukuViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public MenuBukuViewHolder(View itemView) {
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

public class MenuBukuRv extends RecyclerView.Adapter<MenuBukuViewHolder>{
    private List<MenuStationery> ListBuku = new ArrayList<>();

    public MenuBukuRv(List<MenuStationery> listBuku) {
        ListBuku = listBuku;
    }

    @Override
    public MenuBukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new MenuBukuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuBukuViewHolder holder, int position) {
        holder.imageView.setImageResource(ListBuku.get(position).getGambar());
        holder.textNamaToko.setText(ListBuku.get(position).getNama_toko());
        holder.textHarga.setText(ListBuku.get(position).getHarga());
        holder.textHargaSebPotongan.setText(ListBuku.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return ListBuku.size();
    }
}
