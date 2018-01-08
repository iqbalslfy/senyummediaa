package net.source.senyum.senyummediaa;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import net.source.senyum.senyummediaa.Activity.BasketActivity;
import net.source.senyum.senyummediaa.Fragment.FragmentAkunSaya;
import net.source.senyum.senyummediaa.Fragment.FragmentBeranda;
import net.source.senyum.senyummediaa.Fragment.FragmentBuku;
import net.source.senyum.senyummediaa.Fragment.FragmentElektronik;
import net.source.senyum.senyummediaa.Fragment.FragmentHome;
import net.source.senyum.senyummediaa.Fragment.FragmentKategori;
import net.source.senyum.senyummediaa.Fragment.FragmentKertas;
import net.source.senyum.senyummediaa.Fragment.FragmentPeralatanKantor;
import net.source.senyum.senyummediaa.Fragment.FragmentPeralatanRT;
import net.source.senyum.senyummediaa.Fragment.FragmentPerlengkapanKantor;
import net.source.senyum.senyummediaa.Fragment.FragmentStationery;
import net.source.senyum.senyummediaa.Fragment.FragmentTroli;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, new FragmentHome()).commit();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_home:
                    transaction.replace(R.id.content, new FragmentHome()).commit();
                    break;
                case R.id.nav_kategori:
                    transaction.replace(R.id.content, new FragmentKategori()).commit();
                    break;
                case R.id.nav_akun:
                    transaction.replace(R.id.content, new FragmentAkunSaya()).commit();
                    break;
            }
            return true;
        }

    };

//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item_design_pencarian_populer) {
//        int id = item_design_pencarian_populer.getItemId();
//
//        if (id == R.id.basket) {
//            startActivity(new Intent(getApplicationContext(), BasketActivity.class));
//        }
//
//        return super.onOptionsItemSelected(item_design_pencarian_populer);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_basket, menu);
//
//        return true;
//    }


}
