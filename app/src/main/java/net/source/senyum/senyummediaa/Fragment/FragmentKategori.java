package net.source.senyum.senyummediaa.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import net.source.senyum.senyummediaa.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentKategori extends Fragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public FragmentKategori() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kategori, container, false);

        toolbar = view.findViewById(R.id.nav_action);
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewpager);


        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterTab adapter = new ViewPagerAdapterTab(getFragmentManager());

        adapter.addFrag(new FragmentStationery(), "Stationery");
        adapter.addFrag(new FragmentPerlengkapanKantor(), "Perlengkapan Kantor");
        adapter.addFrag(new FragmentPeralatanKantor(), "Peralatan Kantor");
        adapter.addFrag(new FragmentKertas(), "Kertas");
        adapter.addFrag(new FragmentElektronik(), "Elektronik");
        adapter.addFrag(new FragmentBuku(), "Buku");
        adapter.addFrag(new FragmentPeralatanRT(), "Peralatan Rumah Tangga");

        viewPager.setAdapter(adapter);

    }

    class ViewPagerAdapterTab extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapterTab(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
