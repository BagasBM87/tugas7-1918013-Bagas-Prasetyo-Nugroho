package com.gasstudio.tugas72;

public class Barang {
    private String _id, _barang, _jenis;
    public Barang (String id, String barang, String jenis) {
        this._id = id;
        this._barang = barang;
        this._jenis = jenis;
    }
    public Barang() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_barang() {
        return _barang;
    }
    public void set_barang(String _barang) {
        this._barang = _barang;
    }
    public String get_jenis() { return _jenis; }
    public void set_jenis(String _jenis) {this._jenis = _jenis;
    }
}