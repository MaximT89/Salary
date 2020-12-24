package com.tolstobrov.salary.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.tolstobrov.salary.entity.SalaryRecord;

import java.util.List;

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
