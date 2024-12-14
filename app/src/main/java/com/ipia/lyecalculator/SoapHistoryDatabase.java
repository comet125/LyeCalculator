package com.ipia.lyecalculator;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SoapHistory.class}, version = 1)
public abstract class SoapHistoryDatabase extends RoomDatabase {
    public abstract SoapHistoryDao soapHistoryDao();
}
