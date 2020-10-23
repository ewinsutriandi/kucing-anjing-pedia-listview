package simple.example.kocheng;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import simple.example.kocheng.model.Anjing;

public class AnjingActivity extends AppCompatActivity {

    List<Anjing> anjings;
    int indeksTampil = 0;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoHewan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        anjings = DataProvider.getAllAnjings(this);
        inisialisasiView();
        tampilkanProfil();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> anjingPertama());
        btnTerakhir.setOnClickListener(view -> anjingTerakhir());
        btnSebelumnya.setOnClickListener(view -> anjingSebelumnya());
        btnBerikutnya.setOnClickListener(view -> anjingBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHewan = findViewById(R.id.gambarHewan);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Ras Anjing");
    }


    private void tampilkanProfil() {
        Anjing k = anjings.get(indeksTampil);
        Log.d("ANJING","Menampilkan anjing "+k.getJenis());
        txJenis.setText(k.getJenis());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoHewan.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void anjingPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi anjing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfil();
        }
    }

    private void anjingTerakhir() {
        int posAkhir = anjings.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi anjing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfil();
        }
    }

    private void anjingBerikutnya() {
        if (indeksTampil == anjings.size() - 1) {
            Toast.makeText(this,"Sudah di posisi anjing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfil();
        }
    }

    private void anjingSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi anjing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfil();
        }
    }
}