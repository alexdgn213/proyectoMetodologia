package abmprogrammieren.com.docathome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class ActividadPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    LinearLayout pantallaHistorial;
    LinearLayout pantallaRecipes;
    LinearLayout pantallaConsultas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    */
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        pantallaHistorial = findViewById(R.id.pantallaHistorial);
        pantallaRecipes = findViewById(R.id.pantallaRecipes);
        pantallaConsultas = findViewById(R.id.pantallaMedicos);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        pantallaHistorial.setVisibility(View.VISIBLE);
        pantallaRecipes.setVisibility(View.GONE);
        pantallaConsultas.setVisibility(View.GONE);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad_principal, menu);
        return true;
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

        if (id == R.id.nav_cerrar_sesion) {
            // Handle the camera action
            Intent intent = new Intent(this,Login.class);
            startActivity(intent);
        } else if (id == R.id.nav_perfil) {
            // Handle the camera action
            Intent intent = new Intent(this,Perfil.class);
            startActivity(intent);
        }  else if (id == R.id.nav_historial) {
            pantallaHistorial.setVisibility(View.VISIBLE);
            pantallaRecipes.setVisibility(View.GONE);
            pantallaConsultas.setVisibility(View.GONE);
        }  else if (id == R.id.nav_recipes) {
            pantallaHistorial.setVisibility(View.GONE);
            pantallaRecipes.setVisibility(View.VISIBLE);
            pantallaConsultas.setVisibility(View.GONE);
        }  else if (id == R.id.nav_consulta) {
            pantallaHistorial.setVisibility(View.GONE);
            pantallaRecipes.setVisibility(View.GONE);
            pantallaConsultas.setVisibility(View.VISIBLE);
        }/*else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void iniciarLlamada(View view){
        Intent intent = new Intent(this,PantallaStreaming.class);
        startActivity(intent);

    }
}
