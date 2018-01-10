package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.source.senyum.senyummediaa.Adapters.ViewPagerAdapter;
import net.source.senyum.senyummediaa.Data.DataBrand;
import net.source.senyum.senyummediaa.Data.DataMenuProduct;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuBrand;
import net.source.senyum.senyummediaa.RecyclerView.MenuElektronikRv;
import net.source.senyum.senyummediaa.RecyclerView.MenuKertas;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class FragmentElektronik extends Fragment {
    GridLayoutManager gridLayoutElektronik,
            gridBrand;

    RecyclerView rvBrands,
            rvElektronik;

    MenuBrand menuBrandAdapter;
    MenuElektronikRv elektronikAdapter;

    List<DataBrand> brandList = new ArrayList<>();
    List<DataMenuProduct> itemProduct = new ArrayList<>();

    private ViewPager viewpagerSlider;

    private Timer timer;
    LinearLayout SliderDots;
    private int dotcounts;
    private ImageView[] dots;

    public FragmentElektronik() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elektronik, container, false);

        brand();
        perlengkapan();

        rvBrands = view.findViewById(R.id.rv_brand_elektronik);
        rvBrands.setHasFixedSize(true);

        rvElektronik = view.findViewById(R.id.rv_menu_elektronik);
        rvElektronik.setHasFixedSize(true);

        gridBrand = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);
        gridLayoutElektronik = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);

        rvElektronik.setLayoutManager(gridLayoutElektronik);
        elektronikAdapter = new MenuElektronikRv(itemProduct, getContext());
        rvElektronik.setAdapter(elektronikAdapter);

        rvBrands.setLayoutManager(gridBrand);
        menuBrandAdapter = new MenuBrand(brandList, getContext());
        rvBrands.setAdapter(menuBrandAdapter);

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

    private void perlengkapan() {
        itemProduct.add(new DataMenuProduct(R.drawable.pulpen, "Contoh", "1,000,000"));
        itemProduct.add(new DataMenuProduct(R.drawable.kalkulator, "Contoh", "1,200,000"));
        itemProduct.add(new DataMenuProduct(R.drawable.penggaris, "Contoh", "1,300,000"));
        itemProduct.add(new DataMenuProduct(R.drawable.pulpen, "Contoh", "1,500,000"));
        itemProduct.add(new DataMenuProduct(R.drawable.kalkulator, "Contoh", "1,120,000"));
        itemProduct.add(new DataMenuProduct(R.drawable.penggaris, "Contoh", "2,000,000"));
    }

    private void brand() {
        brandList.add(new DataBrand(R.drawable.blueprint));
        brandList.add(new DataBrand(R.drawable.deli));
        brandList.add(new DataBrand(R.drawable.etona));
        brandList.add(new DataBrand(R.drawable.e_print));
        brandList.add(new DataBrand(R.drawable.imco));
        brandList.add(new DataBrand(R.drawable.zebra));
        brandList.add(new DataBrand(R.drawable.sidu));
        brandList.add(new DataBrand(R.drawable.parker));
        brandList.add(new DataBrand(R.drawable.imtec));
        brandList.add(new DataBrand(R.drawable.naci));
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
