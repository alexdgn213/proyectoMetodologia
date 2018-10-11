package com.example.marco.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class AMCActivity extends AppCompatActivity {
    float metraje1;
    float metraje2;
    float metraje3;
    float metraje4;
    float precio1;
    float precio2;
    float precio3;
    float precio4;
    float r1;
    float r2;
    float r3;
    float r4;
    float metro;
    float metrajeinm;
    float totalinmueble;

    int contador = 0;
    int contador1 =0;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0 ;

    boolean primero = false;
    boolean segundo = false;
    boolean tercero = false;
    boolean cuarto = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amc);
        EditText editTextMetraje1 = (EditText)findViewById(R.id.editText12);
        EditText editTextPrecio1 = (EditText)findViewById(R.id.editText13);
        EditText editTextMetraje2 = (EditText)findViewById(R.id.editText16);
        EditText editTextPrecio2 = (EditText)findViewById(R.id.editText17);
        EditText editTextMetraje3 = (EditText)findViewById(R.id.editText20);
        EditText editTextPrecio3 = (EditText)findViewById(R.id.editText21);
        EditText editTextMetraje4 = (EditText)findViewById(R.id.editText24);
        EditText editTextPrecio4 = (EditText)findViewById(R.id.editText25);
        EditText editTextMetrajeInm = (EditText)findViewById(R.id.editText28);

        editTextMetraje1.addTextChangedListener(filterTextWatcher);
        editTextPrecio1.addTextChangedListener(filterTextWatcher);
        editTextMetraje2.addTextChangedListener(filterTextWatcher);
        editTextPrecio2.addTextChangedListener(filterTextWatcher);
        editTextMetraje3.addTextChangedListener(filterTextWatcher);
        editTextPrecio3.addTextChangedListener(filterTextWatcher);
        editTextMetraje4.addTextChangedListener(filterTextWatcher);
        editTextPrecio4.addTextChangedListener(filterTextWatcher);
        editTextMetrajeInm.addTextChangedListener(filterTextWatcher);
    }

    private TextWatcher filterTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editTextMetraje1 = (EditText)findViewById(R.id.editText12);
            EditText editTextPrecio1 = (EditText)findViewById(R.id.editText13);
            EditText editTextMetraje2 = (EditText)findViewById(R.id.editText16);
            EditText editTextPrecio2 = (EditText)findViewById(R.id.editText17);
            EditText editTextMetraje3 = (EditText)findViewById(R.id.editText20);
            EditText editTextPrecio3 = (EditText)findViewById(R.id.editText21);
            EditText editTextMetraje4 = (EditText)findViewById(R.id.editText24);
            EditText editTextPrecio4 = (EditText)findViewById(R.id.editText25);
            TextView textViewMetraje = (TextView)findViewById(R.id.textView20);
            TextView textViewTotal = (TextView)findViewById(R.id.textView16);
            EditText editTextMetrajeInm = (EditText)findViewById(R.id.editText28);

            if(editTextMetrajeInm.getText().toString().trim().length()>0)
                metrajeinm =  Float.parseFloat((editTextMetrajeInm.getText().toString()));
            else {
                metrajeinm=0;

            }

            if(editTextMetraje1.getText().toString().trim().length()>0)
                metraje1 =  Float.parseFloat((editTextMetraje1.getText().toString()));
            else {
                metraje1 = 0;
                contador1 = 0;

            }
            if(editTextPrecio1.getText().toString().trim().length()>0)
                precio1 = Float.parseFloat(editTextPrecio1.getText().toString());
            else {
                precio1 = 0;
                contador1 = 0;
            }
            if(editTextMetraje2.getText().toString().trim().length()>0)
                metraje2 =  Float.parseFloat((editTextMetraje2.getText().toString()));
            else {
                metraje2 = 0;
                contador2 = 0;

            }
            if(editTextPrecio2.getText().toString().trim().length()>0)
                precio2 = Float.parseFloat(editTextPrecio2.getText().toString());
            else{
                precio2=0;
            contador2 = 0;

        }
            if(editTextMetraje3.getText().toString().trim().length()>0)
                metraje3 =  Float.parseFloat((editTextMetraje3.getText().toString()));
            else{
                metraje3 = 0;
            contador3 = 0;

        }
            if(editTextPrecio3.getText().toString().trim().length()>0)
                precio3 = Float.parseFloat(editTextPrecio3.getText().toString());
            else{
                precio3=0;
            contador3 = 0;

        }
            if(editTextMetraje4.getText().toString().trim().length()>0)
                metraje4 =  Float.parseFloat((editTextMetraje4.getText().toString()));
            else{
                metraje4 = 0;
            contador4 = 0;

        }
            if(editTextPrecio4.getText().toString().trim().length()>0)
                precio4 = Float.parseFloat(editTextPrecio4.getText().toString());
            else{
                precio4=0;
            contador4 = 0;

        }

            if((precio1 * metraje1)!= 0 ){
                contador1=1;
                primero = true;

            }
            else{
                primero = false;
                contador1 = 0;
            }
            if((precio2 * metraje2)!= 0 ){
                contador2=1;
                segundo = true;
            }
            else{
                segundo = false;
            }
            if((precio3 * metraje3)!= 0 ){
                contador3=1;
                tercero = true;
            }
            else{
                tercero = false;
            }
            if((precio4 * metraje4)!= 0 ){
                contador4=1;
                cuarto = true;
            }
            else{
                cuarto = false;
            }
            if(primero == true)r1 = precio1 / metraje1;
            else r1=0;
            if(segundo == true)r2 = precio2 / metraje2;
            else r2 = 0;
            if(tercero == true)r3 = precio3 / metraje3;
            else r3 = 0;
            if(cuarto == true)r4 = precio4 / metraje4;
            else r4 = 0;


            contador = contador1+contador2+contador3+contador4;
            metro = (r1+ r2 + r3 + r4)/contador;
            totalinmueble = metro * metrajeinm;

            String mytext=Float.toString(metro);
            textViewMetraje.setText(mytext);
            String mytext2=Float.toString(totalinmueble);
            textViewTotal.setText(mytext2);

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
