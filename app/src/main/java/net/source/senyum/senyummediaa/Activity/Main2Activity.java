package net.source.senyum.senyummediaa.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import net.source.senyum.senyummediaa.Fragment.FragmentAkunSaya;
import net.source.senyum.senyummediaa.Fragment.FragmentBeranda;
import net.source.senyum.senyummediaa.Fragment.FragmentHome;
import net.source.senyum.senyummediaa.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content, new FragmentHome()).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
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
                    return true;
                case R.id.nav_kategori:
                    transaction.replace(R.id.content, new FragmentBeranda()).commit();
                    return true;
                case R.id.nav_akun:
                    transaction.replace(R.id.content, new FragmentAkunSaya()).commit();
                    return true;
            }
            return true;
        }

    };
}
