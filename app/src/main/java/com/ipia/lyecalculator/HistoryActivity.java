package com.ipia.lyecalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.accent));
        }

        LinearLayout displayInfo = findViewById(R.id.displayInfo);
        displayInfo.removeAllViews();



        SoapHistoryDatabase db = Room.databaseBuilder(getApplicationContext(),
                SoapHistoryDatabase.class, "soap_history_database").allowMainThreadQueries().build();

        List<SoapHistory> soapHistoryList = db.soapHistoryDao().getAllSoapHistories();

        for(SoapHistory list: soapHistoryList){
            TextView iterativeTextView = new TextView(this);
            System.out.println(list.id+" "+list.soapName+" "+list.infoBlock+"\n");
            iterativeTextView.setText("No. "+list.id+"\nSoap name: "+list.soapName+"\nOils added: "+list.infoBlock+"\n\n");
            displayInfo.addView(iterativeTextView);
        }


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}