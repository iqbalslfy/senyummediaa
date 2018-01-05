package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Activity.PencarianActivity;
import net.source.senyum.senyummediaa.Data.DataItemPopuler;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 05/01/2018.
 */

class MenuPencarianHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imageView;
    public TextView tvJudul;

    private ItemClickListener itemClickListener;

    public MenuPencarianHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imgP);
        tvJudul = itemView.findViewById(R.id.tvcontoh);

        itemView.setOnClickListener(this);
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

public class MenuPencarianPopuler extends RecyclerView.Adapter<MenuPencarianHolder> {
    private List<DataItemPopuler> itemPopulerList = new ArrayList<DataItemPopuler>();
    private Context context;

    public MenuPencarianPopuler(List<DataItemPopuler> itemPopulerList, Context context) {
        this.itemPopulerList = itemPopulerList;
        this.context = context;
    }

    @Override
    public MenuPencarianHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_design_pencarian_populer, parent, false);
        return new MenuPencarianHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuPencarianHolder holder, int position) {
        holder.imageView.setImageResource(itemPopulerList.get(position).getImageID());
        holder.tvJudul.setText(itemPopulerList.get(position).getTvJudul());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                context.startActivity(new Intent(context, PencarianActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemPopulerList.size();
    }
}
