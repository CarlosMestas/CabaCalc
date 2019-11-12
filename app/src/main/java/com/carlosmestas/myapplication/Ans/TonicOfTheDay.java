package com.carlosmestas.myapplication.Ans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.R;

import java.util.Calendar;

public class TonicOfTheDay extends AppCompatActivity {

    int number;
    TextView tvTitle, tvMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonic_of_the_day);

        Intent intent = getIntent();
        number = intent.getIntExtra("tonicOfTheDay",0);

        tvTitle = findViewById(R.id.textViewTD);
        tvMsj = findViewById(R.id.textViewTDMsj);

        tvTitle.setText(tvTitle.getText().toString() + ": " + number);

        Calendar cal = Calendar.getInstance();

        int d3 = cal.get(Calendar.YEAR);
        int d2 = cal.get(Calendar.MONTH);
        d2++;
        if(d2 == 13)
            d2 = 1;

        int d1 = cal.get(Calendar.DAY_OF_MONTH);

        String zero1 = "", zero2 = "";

        if(d1 < 10){
            zero1 = "0";
        }

        if(d2 < 10){
            zero2 = "0";
        }

        if(number == 1){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300301));
        }

        else if(number == 2){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300302));
        }

        else if(number == 3){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300303));
        }


        else if(number == 4){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300304));
        }


        else if(number == 5){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300305));
        }


        else if(number == 6){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300306));
        }


        else if(number == 7){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300307));
        }


        else if(number == 8){
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300308));
        }

        else{
            tvMsj.setText(getResources().getString(R.string.msj_03001)  + " " + zero1 + d1 + "/" + zero2 +d2 + "/" + d3 + " " +
                    getResources().getString(R.string.msj_03002) + " " + number +  getResources().getString(R.string.msj_0300309));
        }




    }

    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(TonicOfTheDay.this);
    }
}
