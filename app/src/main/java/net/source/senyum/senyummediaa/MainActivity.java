package net.source.senyum.senyummediaa;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import net.source.senyum.senyummediaa.Fragment.FragmentBeranda;
import net.source.senyum.senyummediaa.Fragment.FragmentBuku;
import net.source.senyum.senyummediaa.Fragment.FragmentElektronik;
import net.source.senyum.senyummediaa.Fragment.FragmentKertas;
import net.source.senyum.senyummediaa.Fragment.FragmentPeralatanKantor;
import net.source.senyum.senyummediaa.Fragment.FragmentPeralatanRT;
import net.source.senyum.senyummediaa.Fragment.FragmentPerlengkapanKantor;
import net.source.senyum.senyummediaa.Fragment.FragmentStationery;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.nav_action);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Beranda");
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapterTab adapter = new ViewPagerAdapterTab(getSupportFragmentManager());
        adapter.addFrag(new FragmentBeranda(), "BERANDA");
        adapter.addFrag(new FragmentStationery(), "Stationery");
        adapter.addFrag(new FragmentPerlengkapanKantor(), "Perlengkapan Kantor");
        adapter.addFrag(new FragmentPeralatanKantor(), "Peralatan Kantor");
        adapter.addFrag(new FragmentKertas(), "Kertas");
        adapter.addFrag(new FragmentElektronik(), "Elektronik");
        adapter.addFrag(new FragmentBuku(), "Buku");
        adapter.addFrag(new FragmentPeralatanRT(), "Peralatan Rumah Tangga");
        viewPager.setAdapter(adapter);
    }

    static class ViewPagerAdapterTab extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapterTab(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }

        public void addFrag (Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
