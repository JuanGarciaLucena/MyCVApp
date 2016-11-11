package emebesoft.com.mycvapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.orm.SugarContext;

import java.util.List;

import fragments.ExperienceFragment;
import fragments.PersonalFragment;
import fragments.PresentationFragment;
import fragments.ProjectsFragment;
import fragments.TechFragment;
import objects.ExperienceObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initDB();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_presentation) {
            fragment = new PresentationFragment();
        } else if (id == R.id.nav_experience) {
            fragment = new ExperienceFragment();
        } else if (id == R.id.nav_tech) {
            fragment = new TechFragment();
        } else if (id == R.id.nav_projects) {
            fragment = new ProjectsFragment();
        } else if (id == R.id.nav_personal) {
            fragment = new PersonalFragment();
        }

        fragmentManager.beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void initDB(){


        SugarContext.init(MainActivity.this);

        List<ExperienceObject> experienceObjectList = ExperienceObject.findWithQuery(ExperienceObject.class, "Select * from experience_object");
        if(experienceObjectList.isEmpty()){

            ExperienceObject experienceObject1 = new ExperienceObject(0, "1eEurope", "Septiembre 2015", "Agosto 2016", "Android developer", getResources().getString(R.string.experience_detail_oneeurope));
            ExperienceObject experienceObject2 = new ExperienceObject(1, "Realcom", "Junio 2015", "Junio 2015", "Android developer", getResources().getString(R.string.experience_detail_realcom));
            ExperienceObject experienceObject3 = new ExperienceObject(2, "Elitech Lab", "Febrero 2014", "Marzo 2015", "Android developer", getResources().getString(R.string.experience_detail_elitechlab));
            ExperienceObject experienceObject4 = new ExperienceObject(3, "Cobre las Cruces", "Julio 2013", "Enero 2014", "SCADA Admin", getResources().getString(R.string.experience_detail_clc));
            ExperienceObject experienceObject5 = new ExperienceObject(4, "Viavansi", "Enero 2012", "Enero 2013", "Android developer", getResources().getString(R.string.experience_detail_viavansi));

            experienceObject1.save();
            experienceObject2.save();
            experienceObject3.save();
            experienceObject4.save();
            experienceObject5.save();
            SugarContext.terminate();
        }
    }
}
