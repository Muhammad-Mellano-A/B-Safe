package com.machina.b_safe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbars = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbars);


        TabLayout tab_layouts = findViewById(R.id.main_menu_tab_layout);
        tab_layouts.addTab(tab_layouts.newTab().setText("Berita"));
        tab_layouts.addTab(tab_layouts.newTab().setText("Tips Evakuasi"));
        tab_layouts.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager pagers = findViewById(R.id.main_menu_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tab_layouts.getTabCount());
        pagers.setAdapter(adapter);
        pagers.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layouts));
        tab_layouts.addOnTabSelectedListener(new BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pagers.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater main_inflater = getMenuInflater();
        main_inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}