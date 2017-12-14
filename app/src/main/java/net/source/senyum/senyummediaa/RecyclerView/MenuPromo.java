package net.source.senyum.senyummediaa.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.source.senyum.senyummediaa.Data.DataPromo;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class MenuPromoHolder extends RecyclerView.ViewHolder{

    public ImageView ImgPromo;

    public MenuPromoHolder(View itemView, ImageView imgPromo) {
        super(itemView);
        ImgPromo = imgPromo;
    }

    public MenuPromoHolder(View itemView) {
        super(itemView);
        ImgPromo = itemView.findViewById(R.id.img_item_promo);
    }
}

public class MenuPromo extends RecyclerView.Adapter<MenuPromoHolder>{
    private List<DataPromo> ListGambar = new ArrayList<>();

    public MenuPromo(List<DataPromo> listGambar) {
        ListGambar = listGambar;
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
    }

    @Override
    public int getItemCount() {
        return ListGambar.size();
    }
}
