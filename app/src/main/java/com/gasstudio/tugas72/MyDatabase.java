package com.gasstudio.tugas72;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_Barang";
    private static final String tb_Barang = "tb_Barang";
    private static final String tb_Barang_id = "id";
    private static final String tb_Barang_barang = "barang";
    private static final String tb_Barang_jenis = "jenis";
    private static final String CREATE_TABLE_Barang = "CREATE TABLE " + tb_Barang +"("
            + tb_Barang_id + " INTEGER PRIMARY KEY ,"
            + tb_Barang_barang + " TEXT ,"
            + tb_Barang_jenis+ " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Barang);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateBarang(Barang data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Barang_id, data.get_id());
        values.put(tb_Barang_barang, data.get_barang());
        values.put(tb_Barang_jenis, data.get_jenis());
        db.insert(tb_Barang, null, values);
        db.close();
    }
    public List<Barang> ReadBarang() {
        List<Barang> listbrg = new ArrayList<Barang>();
        String selectQuery = "SELECT * FROM " + tb_Barang;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Barang data = new Barang();
                data.set_id(cursor.getString(0));
                data.set_barang(cursor.getString(1));
                data.set_jenis(cursor.getString(2));
                listbrg.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listbrg;
    }
    public int UpdateBarang (Barang data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_Barang_barang, data.get_barang());
        values.put(tb_Barang_jenis, data.get_jenis());
        return db.update(tb_Barang, values, tb_Barang_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteBarang(Barang data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_Barang,tb_Barang_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
