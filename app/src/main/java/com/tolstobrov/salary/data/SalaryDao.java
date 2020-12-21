package com.tolstobrov.salary.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface SalaryDao {

    @Query("SELECT * FROM salary")
    List<SalaryRecord> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(SalaryRecord salaryRecord);

    @Update
    void update(SalaryRecord salaryRecord);

    @Delete
    void delete(SalaryRecord salaryRecord);
}
