package abmprogrammieren.com.docathome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void volver(View view) {
        finish();
    }
}
