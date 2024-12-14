package com.ipia.lyecalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Locale;


public class ResultsActivity extends AppCompatActivity {

    private double arganAmount;
    private double avocadoAmount;
    private double neemAmount;
    private double castorAmount;
    private double coconutAmount;
    private double coffeebtrAmount;
    private double lavanderAmount;
    private double beeswaxAmount;
    private double oliveAmount;
    private double palmAmount;
    private double sheaAmount;
    private double sheaLiquidAmount;
    private double sunflowerAmount;
    private double almondAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.accent));
        }

        LinearLayout displayInfo = findViewById(R.id.displayInfo);
        TextView firstRecall = findViewById(R.id.firstRecall);
        TextView secondRecall = findViewById(R.id.secondRecall);
        TextView finalMessage = findViewById(R.id.finalMessage);
        Button convertUnitButton = findViewById(R.id.convertUnitButton);
        Button newCalcButton = findViewById(R.id.newCalcButton);

        newCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ResultsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        arganAmount = getIntent().getDoubleExtra("arganAmount", 0.0);
        avocadoAmount = getIntent().getDoubleExtra("avocadoAmount", 0.0);
        neemAmount = getIntent().getDoubleExtra("neemAmount", 0.0);
        castorAmount = getIntent().getDoubleExtra("castorAmount", 0.0);
        coconutAmount = getIntent().getDoubleExtra("coconutAmount", 0.0);
        coffeebtrAmount = getIntent().getDoubleExtra("coffeebtrAmount", 0.0);
        lavanderAmount = getIntent().getDoubleExtra("lavanderAmount", 0.0);
        beeswaxAmount = getIntent().getDoubleExtra("beeswaxAmount", 0.0);
        oliveAmount = getIntent().getDoubleExtra("oliveAmount", 0.0);
        palmAmount = getIntent().getDoubleExtra("palmAmount", 0.0);
        sheaAmount = getIntent().getDoubleExtra("sheaAmount", 0.0);
        sheaLiquidAmount = getIntent().getDoubleExtra("sheaLiquidAmount", 0.0);
        sunflowerAmount = getIntent().getDoubleExtra("sunflowerAmount", 0.0);
        almondAmount = getIntent().getDoubleExtra("almondAmount", 0.0);

        String received1 = getIntent().getStringExtra("received1");
        String received2 = getIntent().getStringExtra("received2");
        String received3 = getIntent().getStringExtra("received3");

        boolean isSolid = received1.equals("Solid");
        final boolean[] isMetric = {received2.equals("Grams")};
        int sftPercentage = Integer.parseInt(received3.replace("%", ""));



        String combinedText = received1 + "\n" + received2 + "\n" + received3;
        firstRecall.setText(combinedText);

        String finalMessageCombined ="A "+received1+" soap, measured in "+received2+" with superfat of "+received3;
        finalMessage.setText(finalMessageCombined);

        String existingText="";
        String newText ="";

        checkerBlock(displayInfo, isSolid, sftPercentage, isMetric[0], existingText, newText, secondRecall, 1, false);


        final boolean[] isFirstButtonPress = {true};

        convertUnitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double unitRatio=1;

                if (isFirstButtonPress[0]) {
                    if (isMetric[0]) {
                        displayInfo.removeAllViews();
                        isTotalAmountDisplayed = false;
                        isOilTitleDisplayed = false;
                        isLyeTitleDisplayed = false;
                        isFinalTitleDisplayed = false;
                        isMetric[0] = false;
                        unitRatio = 0.03527;
                        System.out.println("Divide");

                        String newCombinedText = received1 + "\n" + "Ounces" + "\n" + received3;
                        firstRecall.setText(newCombinedText);

                        String finalMessageCombined ="A "+received1+" soap, measured in Ounces with superfat of "+received3;
                        finalMessage.setText(finalMessageCombined);
                        
                    } else {
                        displayInfo.removeAllViews();
                        isTotalAmountDisplayed = false;
                        isOilTitleDisplayed = false;
                        isLyeTitleDisplayed = false;
                        isFinalTitleDisplayed = false;
                        isMetric[0] = true;
                        unitRatio = 28.35;
                        System.out.println("Multiply");

                        String newCombinedText = received1 + "\n" + "Grams" + "\n" + received3;
                        firstRecall.setText(newCombinedText);

                        String finalMessageCombined ="A "+received1+" soap, measured in Grams with superfat of "+received3;
                        finalMessage.setText(finalMessageCombined);
                    }
                    isFirstButtonPress[0] = false;
                } else {
                    if (isMetric[0]) {
                        displayInfo.removeAllViews();
                        isTotalAmountDisplayed = false;
                        isOilTitleDisplayed = false;
                        isLyeTitleDisplayed = false;
                        isFinalTitleDisplayed = false;
                        isMetric[0] = false;
                        unitRatio = 1;
                        System.out.println("Divide");

                        String newCombinedText = received1 + "\n" + "Ounces" + "\n" + received3;
                        firstRecall.setText(newCombinedText);

                        String finalMessageCombined ="A "+received1+" soap, measured in Ounces with superfat of "+received3;
                        finalMessage.setText(finalMessageCombined);

                        isFirstButtonPress[0] = true;

                    } else {
                        displayInfo.removeAllViews();
                        isTotalAmountDisplayed = false;
                        isOilTitleDisplayed = false;
                        isLyeTitleDisplayed = false;
                        isFinalTitleDisplayed = false;
                        isMetric[0] = true;
                        unitRatio = 1;
                        System.out.println("Multiply");

                        String newCombinedText = received1 + "\n" + "Grams" + "\n" + received3;
                        firstRecall.setText(newCombinedText);

                        String finalMessageCombined ="A "+received1+" soap, measured in Grams with superfat of "+received3;
                        finalMessage.setText(finalMessageCombined);

                        isFirstButtonPress[0] = true;
                    }
                }

                checkerBlock(displayInfo, isSolid, sftPercentage, isMetric[0], existingText, newText, secondRecall, unitRatio, true);
            }
        });

    }

    private boolean noEntry=true;

    //havarija
    public void checkerBlock(LinearLayout displayInfo, boolean isSolid, int sftPercentage, boolean isMetric, String existingText, String newText, TextView secondRecall, double unitRatio, boolean noRepeat) {


        if (arganAmount > 0) {
            displayOilRatio(displayInfo, "Argan Oil", arganAmount, 0.135, 0.19, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat) {
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Argan Oil";
                secondRecall.setText(newText);
            }
        }
        if (avocadoAmount > 0) {
            displayOilRatio(displayInfo, "Avocado Oil", avocadoAmount, 0.137, 0.192, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat) {
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Avocado Oil";
                secondRecall.setText(newText);
            }
        }
        if (neemAmount > 0) {
            displayOilRatio(displayInfo, "Neem Oil", neemAmount, 0.14, 0.197, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Neem Oil";
                secondRecall.setText(newText);
            }
        }
        if (castorAmount > 0){
            displayOilRatio(displayInfo, "Castor Oil", castorAmount, 0.129, 0.181, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Castor Oil";
                secondRecall.setText(newText);
            }
        }
        if (coconutAmount > 0){
            displayOilRatio(displayInfo, "Coconut Oil", coconutAmount, 0.190, 0.258, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Coconut Oil";
                secondRecall.setText(newText);
            }
        }
        if (coffeebtrAmount > 0){
            displayOilRatio(displayInfo, "Coffee Butter", coffeebtrAmount, 0.183, 0.250, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Coffee Butter";
                secondRecall.setText(newText);
            }
        }
        if (lavanderAmount > 0){
            displayOilRatio(displayInfo, "Lavander Butter", lavanderAmount, 0.132, 0.186, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Lavander Butter";
                secondRecall.setText(newText);
            }
        }
        if (beeswaxAmount > 0){
            displayOilRatio(displayInfo, "Yellow Beeswax", beeswaxAmount, 0.066, 0.093, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Yellow Beeswax";
                secondRecall.setText(newText);
            }
        }
        if (oliveAmount > 0){
            displayOilRatio(displayInfo, "Olive Oil", oliveAmount, 0.137, 0.192, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Olive Oil";
                secondRecall.setText(newText);
            }
        }
        if (palmAmount > 0){
            displayOilRatio(displayInfo, "Palm Oil", palmAmount, 0.141, 0.198, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Palm Oil";
                secondRecall.setText(newText);
            }
        }
        if (sheaAmount > 0){
            displayOilRatio(displayInfo, "Shea Butter", sheaAmount, 0.128, 0.18, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Shea Butter";
                secondRecall.setText(newText);
            }
        }
        if (sheaLiquidAmount > 0){
            displayOilRatio(displayInfo, "Shea Oil", sheaLiquidAmount, 0.13, 0.183, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Shea Oil";
                secondRecall.setText(newText);
            }
        }
        if (sunflowerAmount > 0){
            displayOilRatio(displayInfo, "Sunflower Oil", sunflowerAmount, 0.136, 0.192, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Sunflower Oil";
                secondRecall.setText(newText);
            }
        }
        if (almondAmount > 0){
            displayOilRatio(displayInfo, "Almond Oil", almondAmount, 0.135, 0.19, isSolid, sftPercentage, isMetric, unitRatio);
            noEntry=false;

            if (!noRepeat){
                existingText = secondRecall.getText().toString();
                newText = existingText+"\n"+"Almond Oil";
                secondRecall.setText(newText);
            }
        }

        if (noEntry) {
            TextView finalMessage = findViewById(R.id.finalMessage);
            finalMessage.setText("No oils selected");
            secondRecall.setText("None chosen");
        }
    }

    private boolean isTotalAmountDisplayed = false;
    private boolean isOilTitleDisplayed = false;
    private boolean isLyeTitleDisplayed = false;
    private boolean isFinalTitleDisplayed = false;

    private void displayOilRatio(LinearLayout layout, String oilName, double oilAmount, double solidRatio, double liquidRatio, boolean isSolid, int sftPercentage, boolean isMetric, double unitRatio) {
        TextView textView = new TextView(this);
        double totalAmount = 0.0;
        double lyeAmount;
        double sftdAmount;
        double totalLyeAmount = 0.0;
        double totalSftdAmount = 0.0;
        double totalTotalAmount = 0.0;
        String unitSymbol = "g";

        totalAmount += getIntent().getDoubleExtra("arganAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("avocadoAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("neemAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("castorAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("coconutAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("coffeebtrAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("lavanderAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("beeswaxAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("oliveAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("palmAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("sheaAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("sheaLiquidAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("sunflowerAmount", 0.0);
        totalAmount += getIntent().getDoubleExtra("almondAmount", 0.0);


        double ratio = oilAmount / totalAmount;

        if (isSolid) {
            lyeAmount = oilAmount * solidRatio;
            sftdAmount = lyeAmount - (lyeAmount * (sftPercentage / 100.0));
            totalLyeAmount += lyeAmount;
            totalSftdAmount += sftdAmount;

        } else {
            lyeAmount = oilAmount * liquidRatio;
            sftdAmount = lyeAmount - (lyeAmount * (sftPercentage / 100.0));
            totalLyeAmount += lyeAmount;
            totalSftdAmount += sftdAmount;
        }

        if (!isMetric) {
            unitSymbol="oz";
        }


        if (!isFinalTitleDisplayed) {
            TextView titleTextView = new TextView(this);
            TextView lyeResultTextView = new TextView(this);
            TextView oilResultTextView = new TextView(this);
            TextView totalResultTextView = new TextView(this);

            titleTextView.setText("Result");
            titleTextView.setTextSize(18);
            titleTextView.setTypeface(null, Typeface.BOLD);

            totalTotalAmount = totalLyeAmount + totalSftdAmount;

            totalResultTextView.setText(String.format("Total Amount: %.2f %s", (totalTotalAmount+totalAmount)*unitRatio, unitSymbol));
            totalResultTextView.setTypeface(null, Typeface.BOLD);

            lyeResultTextView.setText(String.format("Lye & Liquid: %.2f %s", totalTotalAmount*unitRatio, unitSymbol));

            oilResultTextView.setText(String.format("Oil & Fats: %.2f %s", totalAmount*unitRatio, unitSymbol));

            layout.addView(titleTextView);
            layout.addView(totalResultTextView);
            layout.addView(lyeResultTextView);
            layout.addView(oilResultTextView);

            isFinalTitleDisplayed = true;
        }

        if (!isLyeTitleDisplayed) {

            TextView titleTextView = new TextView(this);
            TextView lyeTextView = new TextView(this);
            TextView sftdTextView = new TextView(this);
            TextView totalTextView = new TextView(this);

            titleTextView.setText("\nLye & Liquid");
            titleTextView.setTextSize(18);
            titleTextView.setTypeface(null, Typeface.BOLD);

            // totalTotalAmount = totalLyeAmount + totalSftdAmount;
            totalTextView.setText(String.format("Total Amount: %.2f %s", totalTotalAmount*unitRatio, unitSymbol));
            totalTextView.setTypeface(null, Typeface.BOLD);

            lyeTextView.setText(String.format("Lye amount: %.2f %s", totalLyeAmount*unitRatio, unitSymbol));

            sftdTextView.setText(String.format("Grams of liquid: %.2f %s", totalSftdAmount*unitRatio, unitSymbol)); //ili superfatted amount?

            layout.addView(titleTextView);
            layout.addView(totalTextView);
            layout.addView(lyeTextView);
            layout.addView(sftdTextView);

            isLyeTitleDisplayed = true;
        }

        if (!isOilTitleDisplayed) {
            TextView titleTextView = new TextView(this);
            titleTextView.setText("\nOils & Fats");
            titleTextView.setTextSize(18);
            titleTextView.setTypeface(null, Typeface.BOLD);
            layout.addView(titleTextView);
            isOilTitleDisplayed = true;
        }


        if (!isTotalAmountDisplayed) {
            TextView totalTextView = new TextView(this);
            totalTextView.setText(String.format(Locale.getDefault(), "Total Amount: %.0f %s - 100%%", totalAmount*unitRatio, unitSymbol));
            layout.addView(totalTextView);
            totalTextView.setTypeface(null, Typeface.BOLD);
            isTotalAmountDisplayed = true;
        }

        textView.setText(String.format(Locale.getDefault(), "%s - %.0f %s - %.0f%%", oilName, oilAmount*unitRatio, unitSymbol, ratio * 100));
        layout.addView(textView);

        if (!isFinalTitleDisplayed) {
            TextView titleTextView = new TextView(this);
            TextView lyeResultTextView = new TextView(this);
            TextView oilResultTextView = new TextView(this);
            TextView totalResultTextView = new TextView(this);

            titleTextView.setText("Result");
            titleTextView.setTextSize(18);
            titleTextView.setTypeface(null, Typeface.BOLD);

            totalResultTextView.setText(String.format("Total amount: %.2f %s", (totalTotalAmount+totalAmount)*unitRatio, unitSymbol));
            totalResultTextView.setTypeface(null, Typeface.BOLD);

            lyeResultTextView.setText(String.format("Lye amount: %.2f g %s", totalTotalAmount*unitRatio, unitSymbol));

            oilResultTextView.setText(String.format("Grams of liquid: %.2f %s", totalAmount*unitRatio, unitSymbol));

            layout.addView(titleTextView);
            layout.addView(totalResultTextView);
            layout.addView(lyeResultTextView);
            layout.addView(oilResultTextView);

            isFinalTitleDisplayed = true;
        }
    }

}