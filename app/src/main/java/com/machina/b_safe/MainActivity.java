package com.machina.b_safe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    Button btn_logout;

    SharedPreferences sharedpreferences;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_logout = (Button) findViewById(R.id.button_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                logout();
            }
        });

        androidx.appcompat.widget.Toolbar toolbars = findViewById(R.id.main_menu_toolbar);
        setSupportActionBar(toolbars);


        TabLayout tab_layouts = findViewById(R.id.main_menu_tab_layout);
        tab_layouts.addTab(tab_layouts.newTab().setText("Berita"));
        tab_layouts.addTab(tab_layouts.newTab().setText("Tips Evakuasi"));
        tab_layouts.setTabGravity(TabLayout.GRAVITY_FILL);

        //Tambahkan fungsi agar dapat memunculkan halaman fragment yang telah dibuat kemudian dapat di swipe
        final ViewPager pagers = findViewById(R.id.main_menu_pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tab_layouts.getTabCount());
        pagers.setAdapter(adapter);
        pagers.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layouts));

        tab_layouts.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private void logout() {
        sharedpreferences = getSharedPreferences(
                LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(LoginActivity.session_status, false);
        editor.putString(LoginActivity.TAG_ID, null);
        editor.putString(LoginActivity.TAG_EMAIL, null);
        editor.putString(LoginActivity.TAG_NAME, null);
        editor.putString(LoginActivity.TAG_PHONE, null);
        editor.commit();

        intent = new Intent(MainActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}