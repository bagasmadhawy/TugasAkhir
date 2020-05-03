package com.example.tugasakhir.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TimDAO {

    @Insert
    long insertTim(TimModel timModel);

    @Delete
    int deleteTim(TimModel timModel);

    @Query("Select * from tim_db")
    List<TimModel> getTim();
}
