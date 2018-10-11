package com.example.marco.example;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button button;

    float monto = 0 ;
    float reserva =0;
    float oficina = 0;
    float gerente = 0;
    float asesor = 0;
    float totalasesor= 0;
    float productividad =0;
    float sinergia = 0;

    int referidos = 0;
    int puntas=0;
    int pregcompartidos=0;
    int venta = 0;
    int interna = 0;
    Switch switchButton;
    EditText editTextReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // FOR NAVIGATION VIEW ITEM TEXT COLOR
        int[][] state = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] color = new int[] {
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };

        ColorStateList csl = new ColorStateList(state, color);


// FOR NAVIGATION VIEW ITEM ICON COLOR
        int[][] states = new int[][] {
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_pressed}  // pressed

        };

        int[] colors = new int[] {
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };

        ColorStateList csl2 = new ColorStateList(states, colors);

        navigationView.setItemTextColor(csl2);
        navigationView.setItemIconTintList(csl2);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtainNumbers(view);
            }
        });
        editTextReserva = (EditText) findViewById(R.id.editText2);


        switchButton = (Switch) findViewById(R.id.switch2);
        switchButton.setChecked(false);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    editTextReserva.setVisibility(View.INVISIBLE);
                } else {
                    editTextReserva.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void obtainNumbers(View view) {
        EditText editTextMonto = (EditText) findViewById(R.id.editText);
        if(editTextMonto.getText().toString().trim().length()>0)
            monto =  Float.parseFloat((editTextMonto.getText().toString()));
        else
            monto = 0;

        EditText editTextReserva = (EditText) findViewById(R.id.editText2);
        if(editTextReserva.getText().toString().trim().length()>0)
            reserva =  Float.parseFloat((editTextReserva.getText().toString()));
        else
            reserva = 0;
        EditText editTextAsesor = (EditText) findViewById(R.id.editText3);
        if(editTextAsesor.getText().toString().trim().length()>0)
            asesor =  Float.parseFloat((editTextAsesor.getText().toString()));
        else
            asesor = 0;

        EditText editTextPuntas = (EditText) findViewById(R.id.editText4);
        if(editTextPuntas.getText().toString().trim().length()>0)
            puntas =  Integer.parseInt((editTextPuntas.getText().toString()));
        else
            puntas = 0;

        EditText editTextReferidos = (EditText) findViewById(R.id.editText5);
        if(editTextReferidos.getText().toString().trim().length() > 0)
            referidos =  Integer.parseInt((editTextReferidos.getText().toString()));
        else
            referidos=0;

        EditText editTextSinergia = (EditText) findViewById(R.id.editText7);
        if(editTextSinergia.getText().toString().trim().length() > 0)
            sinergia =  Float.parseFloat((editTextSinergia.getText().toString()));
        else
            sinergia = 0;

        EditText editTextProductividad = (EditText) findViewById(R.id.editText6);
        if(editTextProductividad.getText().toString().trim().length() > 0)
            productividad =  Float.parseFloat((editTextProductividad.getText().toString()));
        else
            productividad = 0;

        // initiate a Switch
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
// check current state of a Switch (true or false).
        Boolean switchState = simpleSwitch.isChecked();
        if(switchState == true)interna=1;
        if(switchState == false)interna=0;

        //Switch de alquiler
        Switch alquilerSwitch = (Switch) findViewById(R.id.switch2);
        Boolean alquilerSwitchState = alquilerSwitch.isChecked();
        if( alquilerSwitchState == true){
            venta = 1;
            reserva=100;
            editTextReserva.setVisibility(View.INVISIBLE);
        }
        if(alquilerSwitchState == false){
            venta = 0;
            if(editTextReserva.getText().toString().trim().length()>0){
                reserva =  Float.parseFloat((editTextReserva.getText().toString()));
                editTextReserva.setVisibility(View.VISIBLE);
            }
            else{

                reserva = 0;
                editTextReserva.setVisibility(View.VISIBLE);}
        }
//Calculos
        monto = monto * reserva / 100;
        if(interna == 1)
            monto = monto / 2;
        oficina = monto *10 / 100;
        monto = monto - oficina;
        monto = monto - monto * (referidos*10)/100; //Quito el % de referidos
        gerente = monto *10/100;
        monto = monto - gerente;

        if(puntas == 1)
            asesor=asesor/2;
        if(pregcompartidos >= 1)
            asesor = asesor /2;
        if(pregcompartidos ==2)
            asesor = asesor / 2;
        if(pregcompartidos ==2 && puntas == 2)
            asesor = asesor *2;
        totalasesor = monto *(asesor + productividad + sinergia) / 100;


        TextView textView =(TextView)findViewById(R.id.textView);
        String mytext=Float.toString(totalasesor);
        textView.setText(mytext);

        TextView textView1=(TextView)findViewById(R.id.textView2);
        String mytext2 = Float.toString(oficina);
        textView1.setText(mytext2);

        TextView textView2=(TextView)findViewById(R.id.textView3);
        String mytext3 = Float.toString(gerente);
        textView2.setText(mytext3);
    }

    public void launchWebActivity(){
        Intent intent = new Intent (this, Web2Activity.class);
        startActivity(intent);
    }

    public void launchDollarActivity(){
        Intent intent = new Intent (this, DollarActivity.class);
        startActivity(intent);
    }

    public void launchAMCActivity(){
        Intent intent = new Intent (this,AMCActivity.class);
        startActivity(intent);
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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_amc) {
            launchAMCActivity();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_dollar) {
            launchDollarActivity();

        } else if (id == R.id.nav_web) {
        launchWebActivity();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
