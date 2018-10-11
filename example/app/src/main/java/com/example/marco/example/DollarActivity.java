package com.example.marco.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DollarActivity extends AppCompatActivity {
    float monto = 0 ;
    float dolar =0;
    float total =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dollar);
        EditText editTextDolares = (EditText) findViewById(R.id.editText8);
        EditText editTextDolar = (EditText) findViewById(R.id.editText9);
        editTextDolar.addTextChangedListener(filterTextWatcher);
        editTextDolares.addTextChangedListener(filterTextWatcher);
        TextView textViewTotal = (TextView)findViewById(R.id.textView4);
     //  button = (Button)findViewById(R.id.button2);
    }
    private TextWatcher filterTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editTextDolares = (EditText) findViewById(R.id.editText8);
            EditText editTextDolar = (EditText) findViewById(R.id.editText9);
            TextView textViewTotal = (TextView)findViewById(R.id.textView4);

            if(editTextDolares.getText().toString().trim().length()>0)
                monto =  Float.parseFloat((editTextDolares.getText().toString()));
            else
                monto = 0;
            if(editTextDolar.getText().toString().trim().length()>0)
                dolar = Float.parseFloat(editTextDolar.getText().toString());
            else
                dolar = 0;
            total = dolar * monto;
            String mytext=Float.toString(total);
            textViewTotal.setText(mytext);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void calcularDolar(View view) {
        EditText editTextDolares = (EditText) findViewById(R.id.editText8);
        TextView textViewTotal = (TextView)findViewById(R.id.textView4);

        if(editTextDolares.getText().toString().trim().length()>0)
            monto =  Float.parseFloat((editTextDolares.getText().toString()));
        else
            monto = 0;
        EditText editTextDolar = (EditText) findViewById(R.id.editText9);
        if(editTextDolar.getText().toString().trim().length()>0)
            dolar = Float.parseFloat(editTextDolar.getText().toString());
        else
            dolar = 0;
        total = dolar * monto;
        TextView textView =(TextView)findViewById(R.id.textView4);
        String mytext=Float.toString(total);
        textView.setText(mytext);
    }
}
