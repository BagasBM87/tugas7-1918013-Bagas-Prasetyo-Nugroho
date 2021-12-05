package com.gasstudio.tugas72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Ebarang, Ejenis;
    private String Sbarang, Sjenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Ebarang = (EditText) findViewById(R.id.create_barang);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sbarang = String.valueOf(Ebarang.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Sbarang.equals("")){
                    Ebarang.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi barang", Toast.LENGTH_SHORT).show();
                }
                else if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis", Toast.LENGTH_SHORT).show();
                }
                else {
                    Ebarang.setText("");
                    Ejenis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateBarang(new Barang(null, Sbarang, Sjenis));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
