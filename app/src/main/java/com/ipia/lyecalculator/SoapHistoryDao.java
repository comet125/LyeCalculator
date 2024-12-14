package com.ipia.lyecalculator;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SoapHistoryDao {

    @Insert
    void insertAll(SoapHistory... soapHistories);

    @Query("SELECT * FROM soaphistory")
    List<SoapHistory> getAllSoapHistories();
}
