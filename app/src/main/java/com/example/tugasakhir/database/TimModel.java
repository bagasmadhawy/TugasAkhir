package com.example.tugasakhir.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tim_db")
public class TimModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "tahun")
    private String tahun;

    @ColumnInfo(name = "tim")
    private String tim;

    @ColumnInfo(name = "posisi")
    private String posisi;

    @ColumnInfo(name = "asalNeg")
    private String asalNeg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getAsalNeg() {
        return asalNeg;
    }

    public void setAsalNeg(String asalNeg) {
        this.asalNeg = asalNeg;
    }
}
