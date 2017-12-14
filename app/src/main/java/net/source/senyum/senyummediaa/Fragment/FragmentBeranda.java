package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import net.source.senyum.senyummediaa.Adapters.ViewPagerAdapter;
import net.source.senyum.senyummediaa.Data.MenuItems;
import net.source.senyum.senyummediaa.Data.MenuStationery;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuItemRecyclerToko;
import net.source.senyum.senyummediaa.RecyclerView.MenuPeralatanKantor;
import net.source.senyum.senyummediaa.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentBeranda extends Fragment {

    private RecyclerView recyclerView, recyclerViewToko, recyclerViewPeralatanKantor;
    private RecyclerViewAdapter viewAdapter;
    private MenuItemRecyclerToko viewAdapterToko;
    private MenuPeralatanKantor VAPeralatanKantor;
    private RecyclerView.LayoutManager layoutManager, layoutStationery, layoutperalatankantor;
    private List<MenuItems> itemsList = new ArrayList<>();
    private List<MenuStationery> Menu = new ArrayList<>();

    private ViewPager viewPager;
    private Timer timer;


    public FragmentBeranda() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda_tab, container,false);

        Stationery();

        recyclerView = view.findViewById(R.id.rc_menu);
        recyclerViewToko = view.findViewById(R.id.rc_menu_stationery);
        recyclerViewPeralatanKantor = view.findViewById(R.id.rc_menu_peralatan_kantor);

        recyclerView.setHasFixedSize(true);
        recyclerViewToko.setHasFixedSize(true);
        recyclerViewPeralatanKantor.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutStationery = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutperalatankantor = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewToko.setLayoutManager(layoutStationery);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewPeralatanKantor.setLayoutManager(layoutperalatankantor);

        viewAdapter = new RecyclerViewAdapter(itemsList);
        viewAdapterToko = new MenuItemRecyclerToko(Menu);
        VAPeralatanKantor = new MenuPeralatanKantor(Menu);

        recyclerView.setAdapter(viewAdapter);
        recyclerViewToko.setAdapter(viewAdapterToko);
        recyclerViewPeralatanKantor.setAdapter(VAPeralatanKantor);

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
        Menu.add(new MenuStationery(R.drawable.daebak, "Daebak Cafe", "100.000", "150.000"));
        Menu.add(new MenuStationery(R.drawable.kedai, "Kedai Cafe", "125.000","130.000"));
        Menu.add(new MenuStationery(R.drawable.pencake, "Pencake Cafe", "155.000","170.000"));
        Menu.add(new MenuStationery(R.drawable.pondok, "Pondok Cafe", "120.000","160.000"));
        Menu.add(new MenuStationery(R.drawable.layar, "Layar Cafe", "115.000","140.000"));
    }



}
