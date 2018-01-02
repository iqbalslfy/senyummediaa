package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import net.source.senyum.senyummediaa.Adapters.ViewPagerAdapter;
import net.source.senyum.senyummediaa.Data.DataBuku;
import net.source.senyum.senyummediaa.Data.DataElektronik;
import net.source.senyum.senyummediaa.Data.DataKertas;
import net.source.senyum.senyummediaa.Data.DataPeralatanKantor;
import net.source.senyum.senyummediaa.Data.DataPerlengkapanKantor;
import net.source.senyum.senyummediaa.Data.DataPromo;
import net.source.senyum.senyummediaa.Data.DataRT;
import net.source.senyum.senyummediaa.Data.MenuItems;
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuBukuRv;
import net.source.senyum.senyummediaa.RecyclerView.MenuElektronikRv;
import net.source.senyum.senyummediaa.RecyclerView.MenuRumahTanggaRv;
import net.source.senyum.senyummediaa.RecyclerView.MenuStationeryRv;
import net.source.senyum.senyummediaa.RecyclerView.MenuKertas;
import net.source.senyum.senyummediaa.RecyclerView.MenuPeralatanKantor;
import net.source.senyum.senyummediaa.RecyclerView.MenuPerlengkapanKantor;
import net.source.senyum.senyummediaa.RecyclerView.MenuPromo;
import net.source.senyum.senyummediaa.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentBeranda extends Fragment {

    GridLayoutManager gridLayoutStationery;

    RecyclerView recyclerView,
            rvStationery,
            rvPeralatanKantor,
            rvPerlKantor,
            rvKertas,
            rvPromo,
            rvElektronik,
            rvBuku,
            rvRumahTangga;

    RecyclerViewAdapter viewAdapter;

    MenuStationeryRv viewAdapterToko;
    MenuPeralatanKantor VAPeralatanKantor;
    MenuPerlengkapanKantor VAPerlengkapanKantor;
    MenuElektronikRv VAElektronik;
    MenuBukuRv VABuku;
    MenuRumahTanggaRv VART;
    MenuKertas VAKertas;
    MenuPromo VAmenuPromo;

    RecyclerView.LayoutManager layoutManager,
            layoutStationery,
            layoutperalatankantor,
            layoutperlengkapankantor,
            layoutKertas,
            layoutMenuPromo,
            layoutElektronik,
            layoutBuku,
            layoutRT;

    List<MenuItems> itemsList = new ArrayList<>();
    List<DataStationery> MenuStationery = new ArrayList<>();
    List<DataPeralatanKantor> MenuPeralatan = new ArrayList<>();
    List<DataPerlengkapanKantor> MenuPerlengkapan = new ArrayList<>();
    List<DataKertas> MenuKertas = new ArrayList<>();
    List<DataElektronik> MenuElektronik = new ArrayList<>();
    List<DataBuku> MenuBuku = new ArrayList<>();
    List<DataRT> MenuRT = new ArrayList<>();
    List<net.source.senyum.senyummediaa.Data.DataPromo> DataPromo = new ArrayList<>();

    private ViewPager viewPager;
    private Timer timer;


    public FragmentBeranda() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda_tab, container,false);

        Stationery();
        Promo();
        Perlengkapan();
        Peralatan();
        Elektronik();
        Buku();
        RT();
        Kertas();

        recyclerView = view.findViewById(R.id.rc_menu);
        rvStationery = view.findViewById(R.id.rc_menu_stationery);
        rvPeralatanKantor = view.findViewById(R.id.rc_menu_peralatan_kantor);
        rvPerlKantor = view.findViewById(R.id.rc_menu_perlengkapan);
        rvKertas = view.findViewById(R.id.rc_menu_kertas);
        rvPromo = view.findViewById(R.id.rc_manue_promo);
        rvElektronik = view.findViewById(R.id.rc_menu_elektronik);
        rvBuku = view.findViewById(R.id.rc_menu_buku);
        rvRumahTangga = view.findViewById(R.id.rc_menu_rt);

        recyclerView.setHasFixedSize(true);
        rvStationery.setHasFixedSize(true);
        rvPeralatanKantor.setHasFixedSize(true);
        rvPerlKantor.setHasFixedSize(true);
        rvKertas.setHasFixedSize(true);
        rvPromo.setHasFixedSize(true);
        rvElektronik.setHasFixedSize(true);
        rvBuku.setHasFixedSize(true);
        rvRumahTangga.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutStationery = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutperalatankantor = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutperlengkapankantor = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutKertas = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutMenuPromo = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutElektronik = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutBuku = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutRT = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);


//
//        gridLayoutStationery = new GridLayoutManager(getContext(), 2);

//
        rvStationery.setLayoutManager(layoutStationery);
        recyclerView.setLayoutManager(layoutManager);
        rvPeralatanKantor.setLayoutManager(layoutperalatankantor);
        rvPerlKantor.setLayoutManager(layoutperlengkapankantor);
        rvKertas.setLayoutManager(layoutKertas);
        rvPromo.setLayoutManager(layoutMenuPromo);
        rvElektronik.setLayoutManager(layoutElektronik);
        rvBuku.setLayoutManager(layoutBuku);
        rvRumahTangga.setLayoutManager(layoutRT);

        viewAdapter = new RecyclerViewAdapter(itemsList);
        viewAdapterToko = new MenuStationeryRv(MenuStationery, getContext());

        VAPeralatanKantor = new MenuPeralatanKantor(MenuPeralatan, getContext());
        VAPerlengkapanKantor = new MenuPerlengkapanKantor(MenuPerlengkapan, getContext());
        VAKertas = new MenuKertas(MenuKertas, getContext());
        VAmenuPromo = new MenuPromo(DataPromo, getContext());
        VAElektronik = new MenuElektronikRv(MenuElektronik, getContext());
        VABuku = new MenuBukuRv(MenuBuku, getContext());
        VART = new MenuRumahTanggaRv(MenuRT, getContext());

        recyclerView.setAdapter(viewAdapter);
        rvStationery.setAdapter(viewAdapterToko);
        rvPeralatanKantor.setAdapter(VAPeralatanKantor);
        rvPerlKantor.setAdapter(VAPerlengkapanKantor);
        rvKertas.setAdapter(VAKertas);
        rvPromo.setAdapter(VAmenuPromo);
        rvElektronik.setAdapter(VAElektronik);
        rvBuku.setAdapter(VABuku);
        rvRumahTangga.setAdapter(VART);

        viewPager = view.findViewById(R.id.viewPagerHome);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager.setAdapter(viewPagerAdapter);


        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTasks(), 1000, 2000);
        return view;
    }

    public class TimerTasks extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }


    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
        timer.purge();
    }

    private void runDataMenu() {

        itemsList.add(new MenuItems("ANEKA AYAM"));
        itemsList.add(new MenuItems("ANEKA BEBEK"));
        itemsList.add(new MenuItems("PILIHAN EDITOR"));
        itemsList.add(new MenuItems("ANEKA NASI"));
        itemsList.add(new MenuItems("BAKMI"));
        itemsList.add(new MenuItems("BAKSO"));
        itemsList.add(new MenuItems("BURGER"));
        itemsList.add(new MenuItems("SANDWICH"));
        itemsList.add(new MenuItems("CHINESE"));

    }

    private void Stationery(){
        MenuStationery.add(new DataStationery(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuStationery.add(new DataStationery(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuStationery.add(new DataStationery(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuStationery.add(new DataStationery(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuStationery.add(new DataStationery(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Perlengkapan(){
        MenuPerlengkapan.add(new DataPerlengkapanKantor(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuPerlengkapan.add(new DataPerlengkapanKantor(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuPerlengkapan.add(new DataPerlengkapanKantor(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuPerlengkapan.add(new DataPerlengkapanKantor(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuPerlengkapan.add(new DataPerlengkapanKantor(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Peralatan(){
        MenuPeralatan.add(new DataPeralatanKantor(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuPeralatan.add(new DataPeralatanKantor(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuPeralatan.add(new DataPeralatanKantor(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuPeralatan.add(new DataPeralatanKantor(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuPeralatan.add(new DataPeralatanKantor(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Kertas(){
        MenuKertas.add(new DataKertas(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuKertas.add(new DataKertas(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuKertas.add(new DataKertas(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuKertas.add(new DataKertas(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuKertas.add(new DataKertas(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Elektronik(){
        MenuElektronik.add(new DataElektronik(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuElektronik.add(new DataElektronik(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuElektronik.add(new DataElektronik(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuElektronik.add(new DataElektronik(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuElektronik.add(new DataElektronik(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Buku(){
        MenuBuku.add(new DataBuku(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuBuku.add(new DataBuku(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuBuku.add(new DataBuku(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuBuku.add(new DataBuku(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuBuku.add(new DataBuku(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void RT(){
        MenuRT.add(new DataRT(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        MenuRT.add(new DataRT(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        MenuRT.add(new DataRT(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        MenuRT.add(new DataRT(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        MenuRT.add(new DataRT(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }

    private void Promo(){
        DataPromo.add(new DataPromo(R.drawable.slider1));
        DataPromo.add(new DataPromo(R.drawable.slider2));
        DataPromo.add(new DataPromo(R.drawable.slider3));
        DataPromo.add(new DataPromo(R.drawable.slider4));
        DataPromo.add(new DataPromo(R.drawable.slider5));
        DataPromo.add(new DataPromo(R.drawable.slider7));
    }



}
