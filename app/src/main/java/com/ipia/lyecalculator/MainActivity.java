package com.ipia.lyecalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.accent));
        }

        //PRVI
        Spinner spinner1=findViewById(R.id.spinner5);
        ArrayList<String> niz1=new ArrayList<>();
        niz1.add("Solid");
        niz1.add("Liquid");
        ArrayAdapter<String> nizAdapter1=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, niz1);
        nizAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(nizAdapter1);

        //DRUGI
        Spinner spinner2=findViewById(R.id.spinner6);
        ArrayList<String> niz2=new ArrayList<>();
        niz2.add("Grams");
        niz2.add("Ounces");
        ArrayAdapter<String> nizAdapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, niz2);
        nizAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(nizAdapter2);


        //TRECI
        Spinner spinner3=findViewById(R.id.spinner7);
        ArrayList<String> niz3=new ArrayList<>();
        niz3.add("2%");
        niz3.add("3%");
        niz3.add("4%");
        niz3.add("5%");
        niz3.add("6%");
        niz3.add("7%");
        niz3.add("8%");
        niz3.add("9%");
        niz3.add("10%");
        ArrayAdapter<String> nizAdapter3=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, niz3);
        nizAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(nizAdapter3);


        Button taster=findViewById(R.id.taster);
        taster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pushInfo1=spinner1.getSelectedItem().toString();
                String pushInfo2=spinner2.getSelectedItem().toString();
                String pushInfo3=spinner3.getSelectedItem().toString();
                System.out.println(pushInfo1+pushInfo2+pushInfo3);
                Intent switchActivity=new Intent(MainActivity.this, HomeScreen.class);
                switchActivity.putExtra("pushed1",pushInfo1);
                switchActivity.putExtra("pushed2",pushInfo2);
                switchActivity.putExtra("pushed3",pushInfo3);

                startActivity(switchActivity);
            }
        });
    }
}