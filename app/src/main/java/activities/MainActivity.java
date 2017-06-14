package activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.mohamedfawzy.bookstrade.R;

import other.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ViewPager viewPager;
    private DrawerLayout drawer;
    private TabLayout tabLayout;
    private FloatingActionButton fabShare, fabEdit, fabAdd;
    Toolbar toolbar;
    private String[] pageTitle = {"Home", "Find a Book", "Offer a Book", "Notifications", "Settings", "About Us", "Privacy Policy", "My Profile"};

    //private int [] pageIcons = {R.mipmap.icon_home, R.mipmap.icon_book, R.mipmap.icon_book};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
        handleFabEvents();
        setUpActionBar();
        setUpTabLayout();
        handleNavigationEvents();
        setUpViewPager();
        handleTabLayoutEvents_controlFabs();


    }

    private void initializeUI()
    {
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        fabShare = (FloatingActionButton) findViewById(R.id.fab_share);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabEdit = (FloatingActionButton) findViewById(R.id.fab_edit);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
    }


    private void handleFabEvents()
    {

        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

    }

    private void setUpActionBar()
    {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }
    private void setUpTabLayout()
    {
        for (int i = 0; i < 4; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(pageTitle[i]));
           // tabLayout.addTab(tabLayout.newTab().setIcon(icons[i]));
        }

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


    }
    private void handleTabLayoutEvents_controlFabs()
    {
        //change ViewPager page when tab selected
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                controlFabsVisibility(tab.getPosition());

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager()
    {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void handleNavigationEvents()
    {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void controlFabsVisibility(int tabPosition)
    {
        switch (tabPosition) {
            case 0:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 1:
                fabShare.show();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 2:
                fabShare.hide();
                fabAdd.show();
                fabEdit.hide();
                break;
            case 3:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 4:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 5:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 6:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case 7:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.show();
                break;
            default:
                fabShare.hide();
                fabAdd.hide();
                fabEdit.hide();
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            viewPager.setCurrentItem(0);
        }
        if (id == R.id.nav_profile) {
            //viewPager.setCurrentItem(7);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_findBook) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nav_offerBook) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_notifications) {
            viewPager.setCurrentItem(3);

//            Intent intent = new Intent(MainActivity.this, NotificationsActivity.class);
 //           startActivity(intent);

        } else if (id == R.id.nav_settings) {
           // viewPager.setCurrentItem(4);
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_about_us) {
            //viewPager.setCurrentItem(5);
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_privacy_policy) {
           // viewPager.setCurrentItem(6);
            Intent intent = new Intent(MainActivity.this, PrivacyActivity.class);
            startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        assert drawer != null;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}