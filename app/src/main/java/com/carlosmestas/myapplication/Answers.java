package com.carlosmestas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.Ans.HermeticAstrologic;
import com.carlosmestas.myapplication.Ans.InteriorUrgency;
import com.carlosmestas.myapplication.Ans.KabbalahOfTheYear;
import com.carlosmestas.myapplication.Ans.TonicFundamental;
import com.carlosmestas.myapplication.Ans.TonicOfTheDay;

import java.util.Calendar;
import java.util.Date;

public class Answers extends AppCompatActivity {

    Intent intent;
    String name;
    int day, month, year;
    int interiorUrgency = 0;
    int fundamentalTonic = 0;
    int tonicDay = 0;
    TextView textViewCompleteName;
    TextView textViewDateBirth;
    Button buttonInteriorUrgency, buttonFundamentalTonic, buttonTonicDay, buttonHermeticAstrologic, buttonKabbalahOfTheYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        intent = getIntent();

        name = intent.getStringExtra("name");
        day = intent.getIntExtra("day",0);
        month = intent.getIntExtra("month",0);
        year = intent.getIntExtra("year",0);

        interiorUrgency += sumAllNumbers(day);
        interiorUrgency += sumAllNumbers(month);
        interiorUrgency += sumAllNumbers(year);

        while(interiorUrgency > 9){
            interiorUrgency = sumAllNumbers(interiorUrgency);
        }

        fundamentalTonic = sumAllCharacters(name);

        while(fundamentalTonic > 9){
            fundamentalTonic = sumAllNumbers(fundamentalTonic);
        }

        fundamentalTonic += interiorUrgency;

        while(fundamentalTonic > 9){
            fundamentalTonic = sumAllNumbers(fundamentalTonic);
        }

        final java.util.Date date = new Date();

        Calendar cal = Calendar.getInstance();

        final int d0 = cal.get(Calendar.DAY_OF_WEEK);
        int d3 = cal.get(Calendar.YEAR);
        int d2 = cal.get(Calendar.MONTH);
        d2++;
        if(d2 == 13)
            d2 = 1;

        int d1 = cal.get(Calendar.DAY_OF_MONTH);

        int tmp1, tmp2, tmp3;

        tmp1 = sumAllNumbers(d1);

        while(tmp1 > 9){
            tmp1 = sumAllNumbers(tmp1);
        }

        tmp2 = sumAllNumbers(d2);

        while(tmp2 > 9){
            tmp2 = sumAllNumbers(tmp2);
        }

        tmp3 = sumAllNumbers(d3);

        while(tmp3 > 9){
            tmp3 = sumAllNumbers(tmp3);
        }


        tonicDay += (tmp1);
        tonicDay += (tmp2);
        tonicDay += (tmp3);

        while(tonicDay > 9){
            tonicDay = sumAllNumbers(tonicDay);
        }

        tonicDay += fundamentalTonic;

        while(tonicDay > 9){
            tonicDay = sumAllNumbers(tonicDay);
        }

        Toast.makeText(getApplicationContext(), "" + interiorUrgency + " - " +fundamentalTonic, Toast.LENGTH_LONG).show();

        String zero1 = "", zero2 = "";

        if(day < 10){
            zero1 = "0";
        }

        if(month < 10){
            zero2 = "0";
        }

        textViewCompleteName = findViewById(R.id.textViewName);
        textViewDateBirth = findViewById(R.id.textViewDate);

        textViewCompleteName.setText(name);
        textViewDateBirth.setText(getResources().getString(R.string.birth_day) + ": " + zero1 +day + "/" +  zero2 + month + "/" + year);

        buttonInteriorUrgency = findViewById(R.id.button);
        buttonFundamentalTonic = findViewById(R.id.button2);
        buttonTonicDay = findViewById(R.id.button3);
        buttonHermeticAstrologic = findViewById(R.id.button4);
        buttonKabbalahOfTheYear = findViewById(R.id.button5);

        buttonInteriorUrgency.setText(buttonInteriorUrgency.getText().toString() + ": " + interiorUrgency);
        buttonFundamentalTonic.setText(buttonFundamentalTonic.getText().toString() + ": "+ fundamentalTonic);
        buttonTonicDay.setText(buttonTonicDay.getText().toString() + ": " + tonicDay);

        buttonInteriorUrgency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getApplicationContext(), InteriorUrgency.class);
                intent2.putExtra("interiorUrgency", interiorUrgency);
                startActivity(intent2);
                Animatoo.animateFade(Answers.this);
            }
        });

        buttonFundamentalTonic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getApplicationContext(), TonicFundamental.class);
                intent2.putExtra("tonicFundamental", fundamentalTonic);
                startActivity(intent2);
                Animatoo.animateFade(Answers.this);
            }
        });

        buttonTonicDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getApplicationContext(), TonicOfTheDay.class);
                intent2.putExtra("tonicOfTheDay", tonicDay);
                startActivity(intent2);
                Animatoo.animateFade(Answers.this);
            }
        });

        buttonHermeticAstrologic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getApplicationContext(), HermeticAstrologic.class);
                intent2.putExtra("hermeticAstrologic", d0);
                startActivity(intent2);
                Animatoo.animateFade(Answers.this);
            }
        });

        buttonKabbalahOfTheYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2;
                intent2 = new Intent(getApplicationContext(), KabbalahOfTheYear.class);
                intent2.putExtra("year", year);
                startActivity(intent2);
                Animatoo.animateFade(Answers.this);
            }
        });
    }

    static int sumAllNumbers(int num){
        int ans = 0;
        while(num > 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }

    static int sumAllCharacters(String name){
        int ans = 0;
        for(int i = 0 ; i < name.length() ; i++){
            if(name.charAt(i) != ' ')
                ans++;
        }

        return ans;
    }

    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(Answers.this);
    }
}
