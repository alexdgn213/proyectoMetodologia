package abmprogrammieren.com.docathome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PantallaStreaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_streaming);
    }
    public void finalizarLlamada(View view){
        finish();
    }
}
