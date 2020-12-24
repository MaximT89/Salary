package com.tolstobrov.salary.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tolstobrov.salary.entity.SalaryRecord;

@Database(entities = {SalaryRecord.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SalaryDao getSalaryDao();
}
