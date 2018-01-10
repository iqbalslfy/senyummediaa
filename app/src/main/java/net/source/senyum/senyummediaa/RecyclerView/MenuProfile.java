package net.source.senyum.senyummediaa.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.source.senyum.senyummediaa.Data.DataMenuProfile;
import net.source.senyum.senyummediaa.FunctionClick.ItemClickListener;
import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 10/01/2018.
 */

class MenuProfileHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

    public ImageView imgMenuProfil;
    public TextView txtTitle,txtLihat;
    private ItemClickListener itemClickListener;

    public MenuProfileHolder(View itemView) {
        super(itemView);
        imgMenuProfil = itemView.findViewById(R.id.img_profile_menu);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtLihat = itemView.findViewById(R.id.txtlihat);

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

public class MenuProfile extends RecyclerView.Adapter<MenuProfileHolder>{
    private List<DataMenuProfile> profileList = new ArrayList<>();
    private Context context;

    public MenuProfile(List<DataMenuProfile> profileList, Context context) {
        this.profileList = profileList;
        this.context = context;
    }

    @Override
    public MenuProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_profile_menu, parent, false);
        return new MenuProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuProfileHolder holder, int position) {
        holder.imgMenuProfil.setImageResource(profileList.get(position).getImgMenu());
        holder.txtTitle.setText(profileList.get(position).getTxtTitile());
        holder.txtLihat.setText(profileList.get(position).getTxtLihat());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                Toast.makeText(context, "clicked: " + profileList.get(pos).getTxtTitile(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}
