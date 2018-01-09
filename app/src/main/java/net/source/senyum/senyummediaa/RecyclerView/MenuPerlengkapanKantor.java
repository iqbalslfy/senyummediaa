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
import net.source.senyum.senyummediaa.Data.DataMenuProduct;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

class MenuPerlKanHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imageView;
    public TextView txtJudul, txtHarga;
    private ItemClickListener itemClickListener;

    public MenuPerlKanHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.img_toko);
        txtJudul = itemView.findViewById(R.id.txtJudulProduct);
        txtHarga = itemView.findViewById(R.id.txtHargaProduct);
        itemView.setOnClickListener(this);

    }

    private void strikeThroughText(TextView price) {
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
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

public class MenuPerlengkapanKantor extends RecyclerView.Adapter<MenuPerlKanHolder> {

    private List<DataMenuProduct> itemProduct = new ArrayList<>();
    private Context context;

    public MenuPerlengkapanKantor(List<DataMenuProduct> itemProduct, Context context) {
        this.itemProduct = itemProduct;
        this.context = context;
    }

    @Override
    public MenuPerlKanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu_product, parent, false);
        return new MenuPerlKanHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuPerlKanHolder holder, int position) {
        holder.imageView.setImageResource(itemProduct.get(position).getGambar());
        holder.txtJudul.setText(itemProduct.get(position).getJudul());
        holder.txtHarga.setText(itemProduct.get(position).getHarga());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                context.startActivity(new Intent(context, Pemesanan.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemProduct.size();
    }
}
