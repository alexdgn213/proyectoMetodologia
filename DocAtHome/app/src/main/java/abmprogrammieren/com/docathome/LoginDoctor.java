package abmprogrammieren.com.docathome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doctor);
    }
    public void ingresar(View view) {
        Intent intent;
        intent = new Intent(this,ActividadPrincipal.class);
        startActivity(intent);

    }
    public void paciente(View view){
        Intent intent;
        intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();

    }
}
