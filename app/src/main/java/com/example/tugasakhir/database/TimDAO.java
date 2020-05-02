package com.example.tugasakhir.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface TimDAO {

    @Insert
    long insertTim(TimModel timModel);

    @Delete
    int deleteTim(TimModel timModel);
}
