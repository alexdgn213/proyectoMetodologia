package abmprogrammieren.com.docathome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void ingresar(View view) {
        Intent intent;
        intent = new Intent(this,ActividadPrincipal.class);
        startActivity(intent);

    }

    public void doctor(View view){
        Intent intent;
        intent = new Intent(this,LoginDoctor.class);
        startActivity(intent);
        finish();

    }
}
