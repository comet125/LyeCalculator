package com.ipia.lyecalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class HomeScreen extends AppCompatActivity {

        private void showNameInputDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the name of your soap");
            builder.setMessage("If you do not wish to save this soap, leave it empty");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String name = input.getText().toString();
                    startNextActivity(name);
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }


        private void startNextActivity(String name) {

            StringBuilder amountsBuilder = new StringBuilder();

            Intent receivedActivity=getIntent();
            String received1=receivedActivity.getStringExtra("pushed1");
            String received2=receivedActivity.getStringExtra("pushed2");
            String received3=receivedActivity.getStringExtra("pushed3");

            EditText arganEditText = findViewById(R.id.arganDecimal);
            EditText avocadoEditText = findViewById(R.id.avocadoDecimal);
            EditText neemEditText = findViewById(R.id.neemDecimal);
            EditText castorEditText = findViewById(R.id.castorDecimal);
            EditText coconutEditText = findViewById(R.id.coconutDecimal);
            EditText coffeebtrEditText = findViewById(R.id.coffeebtrDecimal);
            EditText lavanderEditText = findViewById(R.id.lavanderDecimal);
            EditText beeswaxEditText = findViewById(R.id.beeswaxDecimal);
            EditText oliveEditText = findViewById(R.id.oliveDecimal);
            EditText palmEditText = findViewById(R.id.palmDecimal);
            EditText sheaEditText = findViewById(R.id.sheaDecimal);
            EditText sheaLiquidEditText = findViewById(R.id.sheaLiquidDecimal);
            EditText sunflowerEditText = findViewById(R.id.sunflowerDecimal);
            EditText almondEditText = findViewById(R.id.almondDecimal);

            double arganAmount = 0.0;
            double avocadoAmount = 0.0;
            double neemAmount = 0.0;
            double castorAmount = 0.0;
            double coconutAmount = 0.0;
            double coffeebtrAmount = 0.0;
            double lavanderAmount = 0.0;
            double beeswaxAmount = 0.0;
            double oliveAmount = 0.0;
            double palmAmount = 0.0;
            double sheaAmount = 0.0;
            double sheaLiquidAmount = 0.0;
            double sunflowerAmount = 0.0;
            double almondAmount = 0.0;

            String arganText = arganEditText.getText().toString();
            if (!arganText.isEmpty()) {
                arganAmount = Double.parseDouble(arganText);
                amountsBuilder.append("Argan: ").append(arganAmount).append(", ");
            }

            String avocadoText = avocadoEditText.getText().toString();
            if (!avocadoText.isEmpty()) {
                avocadoAmount = Double.parseDouble(avocadoText);
                amountsBuilder.append("Avocado: ").append(avocadoAmount).append(", ");
            }

            String neemText = neemEditText.getText().toString();
            if (!neemText.isEmpty()) {
                neemAmount = Double.parseDouble(neemText);
                amountsBuilder.append("Neem: ").append(neemAmount).append(", ");
            }

            String castorText = castorEditText.getText().toString();
            if (!castorText.isEmpty()) {
                castorAmount = Double.parseDouble(castorText);
                amountsBuilder.append("Castor: ").append(castorAmount).append(", ");
            }

            String coconutText = coconutEditText.getText().toString();
            if (!coconutText.isEmpty()) {
                coconutAmount = Double.parseDouble(coconutText);
                amountsBuilder.append("Coconut: ").append(coconutAmount).append(", ");
            }

            String coffeebtrText = coffeebtrEditText.getText().toString();
            if (!coffeebtrText.isEmpty()) {
                coffeebtrAmount = Double.parseDouble(coffeebtrText);
                amountsBuilder.append("Coffee Butter: ").append(coffeebtrAmount).append(", ");
            }

            String lavanderText = lavanderEditText.getText().toString();
            if (!lavanderText.isEmpty()) {
                lavanderAmount = Double.parseDouble(lavanderText);
                amountsBuilder.append("Lavender: ").append(lavanderAmount).append(", ");
            }

            String beeswaxText = beeswaxEditText.getText().toString();
            if (!beeswaxText.isEmpty()) {
                beeswaxAmount = Double.parseDouble(beeswaxText);
                amountsBuilder.append("Yellow Beeswax: ").append(beeswaxAmount).append(", ");
            }

            String oliveText = oliveEditText.getText().toString();
            if (!oliveText.isEmpty()) {
                oliveAmount = Double.parseDouble(oliveText);
                amountsBuilder.append("Olive: ").append(oliveAmount).append(", ");
            }

            String palmText = palmEditText.getText().toString();
            if (!palmText.isEmpty()) {
                palmAmount = Double.parseDouble(palmText);
                amountsBuilder.append("Palm: ").append(palmAmount).append(", ");
            }

            String sheaText = sheaEditText.getText().toString();
            if (!sheaText.isEmpty()) {
                sheaAmount = Double.parseDouble(sheaText);
                amountsBuilder.append("Shea Butter: ").append(sheaAmount).append(", ");
            }

            String sheaLiquidText = sheaLiquidEditText.getText().toString();
            if (!sheaLiquidText.isEmpty()) {
                sheaLiquidAmount = Double.parseDouble(sheaLiquidText);
                amountsBuilder.append("Shea Oil: ").append(sheaLiquidAmount).append(", ");
            }

            String sunflowerText = sunflowerEditText.getText().toString();
            if (!sunflowerText.isEmpty()) {
                sunflowerAmount = Double.parseDouble(sunflowerText);
                amountsBuilder.append("Sunflower: ").append(sunflowerAmount).append(", ");
            }

            String almondText = almondEditText.getText().toString();
            if (!almondText.isEmpty()) {
                almondAmount = Double.parseDouble(almondText);
                amountsBuilder.append("Almond: ").append(almondAmount).append(", ");
            }

            if (amountsBuilder.length() > 0) {
                amountsBuilder.setLength(amountsBuilder.length() - 2);
            }


            String combinedAmounts = amountsBuilder.toString();
            //+ name

            System.out.println(name+combinedAmounts+" ");

            //BAZA----------------------------------------------------

            SoapHistoryDatabase db = Room.databaseBuilder(getApplicationContext(),
                    SoapHistoryDatabase.class, "soap_history_database").allowMainThreadQueries().build();

            if (!name.isEmpty() && !combinedAmounts.isEmpty()) {
                SoapHistory soap = new SoapHistory(name, combinedAmounts);
                db.soapHistoryDao().insertAll(soap);
            }

            //--------------------------------------------------------

            // System.out.println(almondAmount);

            Intent intent = new Intent(HomeScreen.this, ResultsActivity.class);

            intent.putExtra("arganAmount", arganAmount);
            intent.putExtra("avocadoAmount", avocadoAmount);
            intent.putExtra("neemAmount", neemAmount);
            intent.putExtra("castorAmount", castorAmount);
            intent.putExtra("coconutAmount", coconutAmount);
            intent.putExtra("coffeebtrAmount", coffeebtrAmount);
            intent.putExtra("lavanderAmount", lavanderAmount);
            intent.putExtra("beeswaxAmount", beeswaxAmount);
            intent.putExtra("oliveAmount", oliveAmount);
            intent.putExtra("palmAmount", palmAmount);
            intent.putExtra("sheaAmount", sheaAmount);
            intent.putExtra("sheaLiquidAmount", sheaLiquidAmount);
            intent.putExtra("sunflowerAmount", sunflowerAmount);
            intent.putExtra("almondAmount", almondAmount);


            intent.putExtra("received1", received1);
            intent.putExtra("received2", received2);
            intent.putExtra("received3", received3);


            startActivity(intent);
            finish();
        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.accent));
        }

        Intent receivedActivity=getIntent();
        String received1=receivedActivity.getStringExtra("pushed1");
        String received2=receivedActivity.getStringExtra("pushed2");
        String received3=receivedActivity.getStringExtra("pushed3");


        TextView infoDisplay = findViewById(R.id.infoDisplay);
        String combinedText = received1 + "\n" + received2 + "\n" + received3;
        infoDisplay.setText(combinedText);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button historyButton = findViewById(R.id.historyButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNameInputDialog();

            }
        });

        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(HomeScreen.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
    }
}