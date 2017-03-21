package emebesoft.com.mycvapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import fragments.ExperienceFragment;
import fragments.PresentationFragment;
import fragments.ProjectsFragment;
import fragments.TechFragment;
import fragments.TestFieldFragment;
import libraryView.LibraryFragment;
import objects.ExperienceObject;
import objects.ProjectObject;
import objects.TechObject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.emailFloatingButton) FloatingActionButton emailFloatingButton;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.sectionsNavigatorView) NavigationView sectionsNavigatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        toolbar.setTitle(getResources().getString(R.string.presentation_letter_title));
        setSupportActionBar(toolbar);

        emailFloatingButton.setOnClickListener(view -> {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + getResources().getString(R.string.contact_email)));
                intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.contact_subject));
                startActivity(intent);
            }
        );


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        sectionsNavigatorView.setNavigationItemSelectedListener(this);
        sectionsNavigatorView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(sectionsNavigatorView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_presentation) {
            toolbar.setTitle(getResources().getString(R.string.presentation_letter_title));
            fragment = new PresentationFragment();
        } else if (id == R.id.nav_experience) {
            toolbar.setTitle(getResources().getString(R.string.experience));
            fragment = new ExperienceFragment();
        } else if (id == R.id.nav_tech) {
            toolbar.setTitle(getResources().getString(R.string.tech));
            fragment = new TechFragment();
        } else if (id == R.id.nav_library){
            toolbar.setTitle(getResources().getString(R.string.library));
            fragment = new LibraryFragment();
        } else if (id == R.id.nav_projects) {
            toolbar.setTitle(getResources().getString(R.string.projects));
            fragment = new ProjectsFragment();
        } else if (id == R.id.nav_test_field) {
            toolbar.setTitle(getResources().getString(R.string.test_field));
            fragment = new TestFieldFragment();
        }

        fragmentManager.beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
