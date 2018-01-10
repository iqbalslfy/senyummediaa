package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.source.senyum.senyummediaa.Data.DataMenuProfile;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuProfile;

import java.util.ArrayList;
import java.util.List;


public class FragmentAkunSaya extends Fragment {
    RecyclerView recyclerView;
    List<DataMenuProfile> itemProfilList = new ArrayList<>();
    MenuProfile menuProfile;
    GridLayoutManager layoutManager;

    public FragmentAkunSaya() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_akun_saya, container, false);

        menuku();

        recyclerView = view.findViewById(R.id.rv_profile);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        menuProfile = new MenuProfile(itemProfilList, getContext());
        recyclerView.setAdapter(menuProfile);

        return view;
    }

    private void menuku() {
        itemProfilList.add(new DataMenuProfile(R.color.aice_blue, "Belanjaanku","Lihat Riwayat Belanja"));
        itemProfilList.add(new DataMenuProfile(R.color.colorPrimary, "Favoritku","Lihat Riwayat Favoritku"));
        itemProfilList.add(new DataMenuProfile(R.color.colorPrimaryDark, "Terakhir Dilihat","Produk yang pernah dilihat"));
        itemProfilList.add(new DataMenuProfile(R.color.cardview_dark_background, "Akun Saya","Lihat Riwayat Akun Saya"));
        itemProfilList.add(new DataMenuProfile(R.color.transparant_gray, "Bantuan","Lihat Bantuan"));

    }
}
