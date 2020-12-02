package com.machina.b_safe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

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
        tab_layouts.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
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

}