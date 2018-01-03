package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import net.source.senyum.senyummediaa.Activity.BrandActivity;
import net.source.senyum.senyummediaa.Data.DataBrand;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 30/10/2017.
 */

class MenuBrandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
    public ImageView brandview;
    private ItemClickListener itemClickListener;

    public MenuBrandViewHolder(View itemView) {
        super(itemView);
       brandview = itemView.findViewById(R.id.img_brand);
       itemView.setOnClickListener(this);
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

public class MenuBrand extends RecyclerView.Adapter<MenuBrandViewHolder>{

    private List<DataBrand> brandList = new ArrayList<>();
    Context context;

    public MenuBrand(List<DataBrand> brandList, Context context) {
        this.brandList = brandList;
        this.context = context;
    }

    @Override
    public MenuBrandViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_brand, parent, false);

        return new MenuBrandViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MenuBrandViewHolder holder, int position) {
       holder.brandview.setImageResource(brandList.get(position).getImageID());

       holder.setItemClickListener(new ItemClickListener() {
           @Override
           public void onClick(View view, int pos, boolean isLongClick) {
            context.startActivity(new Intent(context, BrandActivity.class));
           }
       });
    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }
}

