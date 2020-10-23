package simple.example.kocheng;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import simple.example.kocheng.model.Kucing;

public class KucingActivity extends AppCompatActivity {

    List<Kucing> kucings;
    int indeksTampil = 0;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJenis,txAsal,txDeskripsi,txJudul;
    ImageView ivFotoKucing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ras);
        kucings = DataProvider.getAllKucings(this);
        inisialisasiView();
        tampilkanProfilKucing();
    }

    private void inisialisasiView() {
        btnPertama = findViewById(R.id.btnPertama);
        btnSebelumnya = findViewById(R.id.btnSebelumnya);
        btnBerikutnya = findViewById(R.id.btnBerikutnya);
        btnTerakhir = findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> kucingPertama());
        btnTerakhir.setOnClickListener(view -> kucingTerakhir());
        btnSebelumnya.setOnClickListener(view -> kucingSebelumnya());
        btnBerikutnya.setOnClickListener(view -> kucingBerikutnya());

        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoKucing = findViewById(R.id.gambarHewan);

        txJudul = findViewById(R.id.txJudul);
        txJudul.setText("Ras Kucing");
    }


    private void tampilkanProfilKucing() {
        Kucing k = kucings.get(indeksTampil);
        Log.d("KUCING","Menampilkan kucing "+k.getJenis());
        txJenis.setText(k.getJenis());
        txAsal.setText(k.getAsal());
        txDeskripsi.setText(k.getDeskripsi());
        ivFotoKucing.setImageDrawable(this.getDrawable(k.getDrawableRes()));
    }

    private void kucingPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi kucing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanProfilKucing();
        }
    }

    private void kucingTerakhir() {
        int posAkhir = kucings.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi kucing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanProfilKucing();
        }
    }

    private void kucingBerikutnya() {
        if (indeksTampil == kucings.size() - 1) {
            Toast.makeText(this,"Sudah di posisi kucing terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanProfilKucing();
        }
    }

    private void kucingSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi kucing pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanProfilKucing();
        }
    }
}