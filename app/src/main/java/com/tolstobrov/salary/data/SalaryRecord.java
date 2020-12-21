package com.tolstobrov.salary.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SalaryRecord {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String date;
}
