package com.tolstobrov.salary.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "salary")
public class SalaryRecord {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "sizeSalary")
    public long sizeSalary;

    @ColumnInfo(name = "reason")
    public String reason;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getSizeSalary() {
        return sizeSalary;
    }

    public void setSizeSalary(long sizeSalary) {
        this.sizeSalary = sizeSalary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
