package net.source.senyum.senyummediaa.RecyclerView;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.source.senyum.senyummediaa.Data.DataRT;
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 14/12/2017.
 */

class RumahTanggaViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko,textHarga,textHargaSebPotongan;

    public RumahTanggaViewHolder(View itemView) {
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

public class MenuRumahTanggaRv extends RecyclerView.Adapter<RumahTanggaViewHolder> {
    private List<DataRT> ListRumahTangga = new ArrayList<>();

    public MenuRumahTanggaRv(List<DataRT> listRumahTangga) {
        ListRumahTangga = listRumahTangga;
    }

    @Override
    public RumahTanggaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new RumahTanggaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RumahTanggaViewHolder holder, int position) {
        holder.imageView.setImageResource(ListRumahTangga.get(position).getGambar());
        holder.textNamaToko.setText(ListRumahTangga.get(position).getNama_toko());
        holder.textHarga.setText(ListRumahTangga.get(position).getHarga());
        holder.textHargaSebPotongan.setText(ListRumahTangga.get(position).getHargasebpotongan());
    }

    @Override
    public int getItemCount() {
        return ListRumahTangga.size();
    }
}
