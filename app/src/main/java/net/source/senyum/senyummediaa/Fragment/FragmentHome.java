package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import net.source.senyum.senyummediaa.Adapters.ViewPagerAdapter;
import net.source.senyum.senyummediaa.Data.DataBrand;
import net.source.senyum.senyummediaa.Data.DataFlashSale;
import net.source.senyum.senyummediaa.Data.DataItemPopuler;
import net.source.senyum.senyummediaa.Data.DataKategori;
import net.source.senyum.senyummediaa.Data.DataPopulerProduk;
import net.source.senyum.senyummediaa.Data.DataRekomendasi;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuBrand;
import net.source.senyum.senyummediaa.RecyclerView.MenuFlashSale;
import net.source.senyum.senyummediaa.RecyclerView.MenuKategori;
import net.source.senyum.senyummediaa.RecyclerView.MenuPencarianPopuler;
import net.source.senyum.senyummediaa.RecyclerView.MenuPopulerProduk;
import net.source.senyum.senyummediaa.RecyclerView.MenuRekomendasi;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FragmentHome extends Fragment {

    private Toolbar mToolbar;
    private ViewPager viewpagerSlider;
    private Timer timer;
    LinearLayout SliderDots;
    private int dotcounts;
    private ImageView[] dots;

    RecyclerView rvPencarianPopuler,
            rvFlashSale,
            rvBrand,
            rvPopuler,
            rvKategori,
            rvRekomendasi;

    MenuPencarianPopuler menuPencarianPopuler;
    MenuFlashSale menuFlashSale;
    MenuBrand menuBrand;
    MenuPopulerProduk populerProduk;
    MenuKategori menuKategori;
    MenuRekomendasi menuRekomendasi;

    RecyclerView.LayoutManager layoutManagerPencarianPopuler, layoutManagerFlashSale, layoutManagerPopulerProduk;

    GridLayoutManager gridlayoutBRAND, gridlayoutKategori, gridlayoutRekomendasi;

    List<DataItemPopuler> itemPopulers = new ArrayList<>();
    List<DataFlashSale> itemFlashSale = new ArrayList<>();
    List<DataBrand> itemBrand = new ArrayList<>();
    List<DataPopulerProduk> itemPopulerProduk = new ArrayList<>();
    List<DataKategori> itemKategori = new ArrayList<>();
    List<DataRekomendasi> itemRekomendasi = new ArrayList<>();

    public FragmentHome() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_home, container, false );
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initData();
        flashSale();
        brand();
        populerProduks();
        kategori();
        rekomendasi();

        rvPencarianPopuler = view.findViewById(R.id.rv_pencarian_populer);
        rvPencarianPopuler.setHasFixedSize(true);

        rvFlashSale = view.findViewById(R.id.rv_flash_sale);
        rvFlashSale.setHasFixedSize(true);

        rvBrand = view.findViewById(R.id.rv_brand);
        rvBrand.setHasFixedSize(true);

        rvPopuler = view.findViewById(R.id.rv_populer);
        rvPopuler.setHasFixedSize(true);

        rvKategori = view.findViewById(R.id.rv_kategori);
        rvKategori.setHasFixedSize(true);

        rvRekomendasi = view.findViewById(R.id.rv_rekomendasi);
        rvRekomendasi.setHasFixedSize(true);

        layoutManagerFlashSale = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerPopulerProduk = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerPencarianPopuler = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        gridlayoutBRAND = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        gridlayoutKategori = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        gridlayoutRekomendasi = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

        rvPencarianPopuler.setLayoutManager(layoutManagerPencarianPopuler);
        menuPencarianPopuler = new MenuPencarianPopuler(itemPopulers, getContext());
        rvPencarianPopuler.setAdapter(menuPencarianPopuler);

        rvFlashSale.setLayoutManager(layoutManagerFlashSale);
        menuFlashSale = new MenuFlashSale(itemFlashSale, getContext());
        rvFlashSale.setAdapter(menuFlashSale);

        rvBrand.setLayoutManager(gridlayoutBRAND);
        menuBrand = new MenuBrand(itemBrand, getContext());
        rvBrand.setAdapter(menuBrand);

        rvPopuler.setLayoutManager(layoutManagerPopulerProduk);
        populerProduk = new MenuPopulerProduk(itemPopulerProduk, getContext());
        rvPopuler.setAdapter(populerProduk);

        rvKategori.setLayoutManager(gridlayoutKategori);
        menuKategori = new MenuKategori(itemKategori, getContext());
        rvKategori.setAdapter(menuKategori);


        rvRekomendasi.setLayoutManager(gridlayoutRekomendasi);
        menuRekomendasi = new MenuRekomendasi(itemRekomendasi, getContext());
        rvRekomendasi.setAdapter(menuRekomendasi);

        mToolbar = view.findViewById(R.id.nav_action);
        viewpagerSlider = view.findViewById(R.id.viewPagerHome);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewpagerSlider.setAdapter(viewPagerAdapter);

        SliderDots = view.findViewById(R.id.Dots);
        dotcounts = viewPagerAdapter.getCount();
        dots = new ImageView[dotcounts];

        for (int i = 0; i < dotcounts; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_enable));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);
            SliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_disable));

        viewpagerSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotcounts; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_disable));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.indicator_enable));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTasks(), 1000, 2000);


        return view;
    }

    private void rekomendasi() {
        itemRekomendasi.add(new DataRekomendasi(R.drawable.pulpen, "Pulpen", "50,000"));
        itemRekomendasi.add(new DataRekomendasi(R.drawable.kalkulator, "Kalkulator", "40,000"));
        itemRekomendasi.add(new DataRekomendasi(R.drawable.penggaris, "Penggaris", "15,000"));
        itemRekomendasi.add(new DataRekomendasi(R.drawable.pulpen, "Pulpen", "50,000"));
        itemRekomendasi.add(new DataRekomendasi(R.drawable.kalkulator, "Kalkulator", "40,000"));
        itemRekomendasi.add(new DataRekomendasi(R.drawable.penggaris, "Penggaris", "15,000"));
    }

    private void kategori() {
        itemKategori.add(new DataKategori(R.drawable.blueprint, "Stationery"));
        itemKategori.add(new DataKategori(R.drawable.daebak, "Perlengkapan \n Kantor"));
        itemKategori.add(new DataKategori(R.drawable.deli, "Peralatan \n Kantor"));
        itemKategori.add(new DataKategori(R.drawable.etona, "Kertas"));
        itemKategori.add(new DataKategori(R.drawable.imco, "Elektronik"));
        itemKategori.add(new DataKategori(R.drawable.zebra, "Buku"));
        itemKategori.add(new DataKategori(R.drawable.snowman, "Perlengkapan \n Rumah Tangga"));
    }

    private void populerProduks() {
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.blueprint, "Judul", "1,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.daebak, "Judul", "2,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.deli, "Judul", "3,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.etona, "Judul", "4,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.zebra, "Judul", "5,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.imtec, "Judul", "6,500,000"));
        itemPopulerProduk.add(new DataPopulerProduk(R.drawable.layar, "Judul", "7,500,000"));
    }

    private void brand() {
        itemBrand.add(new DataBrand(R.drawable.naci));
        itemBrand.add(new DataBrand(R.drawable.imtec));
        itemBrand.add(new DataBrand(R.drawable.sidu));
        itemBrand.add(new DataBrand(R.drawable.etona));
        itemBrand.add(new DataBrand(R.drawable.parker));
        itemBrand.add(new DataBrand(R.drawable.zebra));
        itemBrand.add(new DataBrand(R.drawable.kangaro));
        itemBrand.add(new DataBrand(R.drawable.imco));
    }

    private void flashSale() {
        itemFlashSale.add(new DataFlashSale(R.drawable.snowman, "1,000,000"));
        itemFlashSale.add(new DataFlashSale(R.drawable.blueprint, "2,000,000"));
        itemFlashSale.add(new DataFlashSale(R.drawable.daebak, "3,000,000"));
        itemFlashSale.add(new DataFlashSale(R.drawable.deli, "4,000,000"));
        itemFlashSale.add(new DataFlashSale(R.drawable.e_print, "5,000,000"));

    }

    private void initData() {
        itemPopulers.add(new DataItemPopuler(R.drawable.blueprint, "Contoh"));
        itemPopulers.add(new DataItemPopuler(R.drawable.etona, "Contoh"));
        itemPopulers.add(new DataItemPopuler(R.drawable.sidu, "Contoh"));
        itemPopulers.add(new DataItemPopuler(R.drawable.imtec, "Contoh"));
        itemPopulers.add(new DataItemPopuler(R.drawable.naci, "Contoh"));
    }

    public class TimerTasks extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewpagerSlider.getCurrentItem() == 0) {
                        viewpagerSlider.setCurrentItem(1);
                    } else if (viewpagerSlider.getCurrentItem() == 1) {
                        viewpagerSlider.setCurrentItem(2);
                    } else {
                        viewpagerSlider.setCurrentItem(0);
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

}
