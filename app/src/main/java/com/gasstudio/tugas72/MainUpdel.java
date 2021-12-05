package com.gasstudio.tugas72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Sbarang, Sjenis;
    private EditText Ebarang, Ejenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Sbarang = i.getStringExtra("Ibarang");
        Sjenis = i.getStringExtra("Ijenis");
        Ebarang = (EditText) findViewById(R.id.updel_barang);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Ebarang.setText(Sbarang);
        Ejenis.setText(Sjenis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sbarang = String.valueOf(Ebarang.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Sbarang.equals("")){
                    Ebarang.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateBarang(new Barang(Sid, Sbarang, Sjenis));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteBarang(new Barang(Sid, Sbarang, Sjenis));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}