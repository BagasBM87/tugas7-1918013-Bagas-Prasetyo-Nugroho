package com.gasstudio.tugas72;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Barang> Barang;
    public CustomListAdapter(Activity activity, List<Barang>
            Barang) {
        this.activity = activity;
        this.Barang = Barang;
    }
    @Override
    public int getCount() {
        return Barang.size();
    }
    @Override
    public Object getItem(int location) {
        return Barang.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView barang = (TextView)
                convertView.findViewById(R.id.text_barang);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Barang m = Barang.get(position);
        barang.setText("Barang : "+ m.get_barang());
        jenis.setText("Jenis : "+ m.get_jenis());
        return convertView;
    }
}