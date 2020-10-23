package simple.example.kocheng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import simple.example.kocheng.model.Anjing;
import simple.example.kocheng.model.Kucing;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKucing,btnAnjing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_ras_kucing);
        btnAnjing = findViewById(R.id.btn_buka_ras_anjing);
        btnKucing.setOnClickListener(view -> bukaKucingActivity());
        btnAnjing.setOnClickListener(view -> bukaAnjingActivity());
    }


    private void bukaKucingActivity() {
        Log.d("MAIN","Buka activity kucing");
        Intent intent = new Intent(this, KucingActivity.class);
        startActivity(intent);
    }

    private void bukaAnjingActivity() {
        Log.d("MAIN","Buka activity anjing");
        Intent intent = new Intent(this, AnjingActivity.class);
        startActivity(intent);
    }

}