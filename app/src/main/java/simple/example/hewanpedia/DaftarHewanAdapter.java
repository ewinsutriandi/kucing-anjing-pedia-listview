package simple.example.hewanpedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import simple.example.hewanpedia.model.Hewan;

public class DaftarHewanAdapter extends ArrayAdapter<Hewan> {

    Context context;

    public DaftarHewanAdapter(Context context, List<Hewan> hewans) {
        super(context, R.layout.row_daftar_hewan, hewans);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hewan hewan = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_hewan, parent, false);
            viewHolder.textJenis =  convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_hewan);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(hewan.getRas());
        viewHolder.textAsal.setText(hewan.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(hewan.getDrawableRes()));
        return convertView;
    }

}
