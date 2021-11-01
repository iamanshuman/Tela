package news;

import android.example.tela.R;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem mhome, msports, mtechnology,mentertainment, mfinance;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    ViewPager viewPager;


    String api = "5d1f1893a3874f47870b387a042eef87";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        mhome = findViewById(R.id.home);
        msports = findViewById(R.id.sports);
        mtechnology = findViewById(R.id.technology);
        mentertainment = findViewById(R.id.entertainment);
        mfinance = findViewById(R.id.finance);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.fragmentcontainer);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),5);
        viewPager.setAdapter(pagerAdapter);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==
                        2||tab.getPosition()==3||tab.getPosition()==4)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.getTabAt(0).select();
    }
}