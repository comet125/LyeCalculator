package com.ipia.lyecalculator;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SoapHistory {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "soap_name")
    public String soapName;

    @ColumnInfo(name ="info_block")
    public String infoBlock;

    public SoapHistory(String soapName, String infoBlock){
        this.soapName = soapName;
        this.infoBlock = infoBlock;
    }

}
