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
import net.source.senyum.senyummediaa.Data.DataStationery;
import net.source.senyum.senyummediaa.R;
import net.source.senyum.senyummediaa.RecyclerView.MenuBrand;
import net.source.senyum.senyummediaa.RecyclerView.MenuStationeryRv;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class FragmentPerlengkapanKantor extends Fragment {
    GridLayoutManager gridLayoutStationery,
            gridBrand;

    RecyclerView rvBrands,
            rvStationery;

    MenuBrand menuBrandAdapter;
    MenuStationeryRv menuStationeryRv;

    List<DataBrand> brandList = new ArrayList<>();
    List<DataStationery> stationeryList = new ArrayList<>();
    private ViewPager viewpagerSlider;
    private Timer timer;
    LinearLayout SliderDots;
    private int dotcounts;
    private ImageView[] dots;

    public FragmentPerlengkapanKantor() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perlengkapan_kantor, container, false);

        brand();
        perlengkapan();

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

    }

    private void brand() {

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
