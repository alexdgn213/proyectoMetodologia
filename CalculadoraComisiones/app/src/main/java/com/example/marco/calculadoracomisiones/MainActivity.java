package com.example.marco.calculadoracomisiones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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


    }

