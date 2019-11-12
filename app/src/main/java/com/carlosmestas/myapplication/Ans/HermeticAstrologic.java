package com.carlosmestas.myapplication.Ans;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.Answers;
import com.carlosmestas.myapplication.R;

public class HermeticAstrologic extends AppCompatActivity {

    int number;
    TextView tvTitle, tvMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hermetic_astrologic);

        /*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        */

        Intent intent = getIntent();
        number = intent.getIntExtra("hermeticAstrologic",0);

        tvTitle = findViewById(R.id.textViewHA);
        tvMsj = findViewById(R.id.textViewHAMsj);

        if(number == 1){
            tvTitle.setText(getResources().getString(R.string.msj_0401));
            tvMsj.setText(getResources().getString(R.string.msj_040101));
        }
        else if(number == 2){
            tvTitle.setText(getResources().getString(R.string.msj_0402));
            tvMsj.setText(getResources().getString(R.string.msj_040202));
        }
        else if(number == 3){

            tvTitle.setText(getResources().getString(R.string.msj_0403));
            tvMsj.setText(getResources().getString(R.string.msj_040303));
        }
        else if(number == 4){

            tvTitle.setText(getResources().getString(R.string.msj_0404));
            tvMsj.setText(getResources().getString(R.string.msj_040404));
        }
        else if(number == 5){

            tvTitle.setText(getResources().getString(R.string.msj_0405));
            tvMsj.setText(getResources().getString(R.string.msj_040505));
        }
        else if(number == 6){
            tvTitle.setText(getResources().getString(R.string.msj_0406));
            tvMsj.setText(getResources().getString(R.string.msj_040606));
        }
        else{
            tvTitle.setText(getResources().getString(R.string.msj_0407a));
            tvMsj.setText(getResources().getString(R.string.msj_040707));
        }




    }

    /*
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    */
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(HermeticAstrologic.this);
    }
}
