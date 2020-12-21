package com.tolstobrov.salary.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SalaryRecord.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SalaryDao getSalaryDao();
}
