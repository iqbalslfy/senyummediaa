package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import net.source.senyum.senyummediaa.Activity.Pemesanan;
import net.source.senyum.senyummediaa.Activity.PromoActivity;
import net.source.senyum.senyummediaa.Data.DataPromo;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class MenuPromoHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public ImageView ImgPromo;
    private ItemClickListener itemClickListener;

    public MenuPromoHolder(View itemView, ImageView imgPromo) {
        super(itemView);
        ImgPromo = imgPromo;

        itemView.setOnClickListener(this);
    }

    public MenuPromoHolder(View itemView) {
        super(itemView);
        ImgPromo = itemView.findViewById(R.id.img_item_promo);
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

public class MenuPromo extends RecyclerView.Adapter<MenuPromoHolder>{
    private List<DataPromo> ListGambar = new ArrayList<>();
    private Context context;

    public MenuPromo(List<DataPromo> listGambar, Context context) {
        ListGambar = listGambar;
        this.context = context;
    }

    @Override
    public MenuPromoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_promo, parent, false);
        return new MenuPromoHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuPromoHolder holder, int position) {
        holder.ImgPromo.setImageResource(ListGambar.get(position).getIDGambarPromo());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                context.startActivity(new Intent(context, PromoActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListGambar.size();
    }
}
