package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Activity.FlashSaleActivity;
import net.source.senyum.senyummediaa.Data.DataFlashSale;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 06/01/2018.
 */

class FlashSaleHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public ImageView imgFlashSale;
    public TextView txtFlashSale;
    private ItemClickListener itemClickListener;


    public FlashSaleHolder(View itemView) {
        super(itemView);

        imgFlashSale = itemView.findViewById(R.id.img_flash_sale);
        txtFlashSale = itemView.findViewById(R.id.txtHargaFlash_sale);

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

public class MenuFlashSale extends RecyclerView.Adapter<FlashSaleHolder> {
    private List<DataFlashSale> flashSaleList = new ArrayList<>();
    private Context context;

    public MenuFlashSale(List<DataFlashSale> flashSaleList, Context context) {
        this.flashSaleList = flashSaleList;
        this.context = context;
    }

    @Override
    public FlashSaleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_design_flash_sale, parent, false);

        return new FlashSaleHolder(view);
    }

    @Override
    public void onBindViewHolder(FlashSaleHolder holder, int position) {
        holder.imgFlashSale.setImageResource(flashSaleList.get(position).getImgFlashSale());
        holder.txtFlashSale.setText(flashSaleList.get(position).getTxtHarga());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                context.startActivity(new Intent(context, FlashSaleActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return flashSaleList.size();
    }
}
