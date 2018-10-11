package com.example.marco.example;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Web2Activity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2);

        mWebsiteEditText = (EditText) findViewById(R.id.website_edittext);
        mLocationEditText = (EditText) findViewById(R.id.location_edittext);
    }

    public void openWebsite(View view) {    // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null)
        {        startActivity(intent);    }
        else {        Log.d("ImplicitIntents", "Can't handle this intent!");    } }

    public void openLocation(View view) {    // Get the string indicating a location. Input is not validated; it i spassed to the location handler intact.
        String loc = mLocationEditText.getText().toString();


        // Parse the location and create the intent.
           Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
           Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null)
        {        startActivity(intent);    }
        else {        Log.d("ImplicitIntents", "Can't handle this intent!");    }
    }



}
