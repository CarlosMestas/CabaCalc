package com.carlosmestas.myapplication.Ans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.R;

public class InteriorUrgency extends AppCompatActivity {

    int number;
    TextView tvTitle, tvMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior_urgency);

        Intent intent = getIntent();
        number = intent.getIntExtra("interiorUrgency",0);

        tvTitle = findViewById(R.id.textViewIU);
        tvMsj = findViewById(R.id.textViewIUMsj);

        tvTitle.setText(tvTitle.getText().toString() + ": "+number);
        if(number == 1){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01011)+"\n\n"
                    + getResources().getString(R.string.msj_01012));
        }
        else if(number == 2){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01021)+"\n\n"
                    + getResources().getString(R.string.msj_01022));
        }
        else if(number == 3){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01031)+"\n\n"
                    + getResources().getString(R.string.msj_01032));
        }
        else if(number == 4){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01041)+"\n\n"
                    + getResources().getString(R.string.msj_01042));
        }
        else if(number == 5){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01051)+"\n\n"
                    + getResources().getString(R.string.msj_01052));
        }
        else if(number == 6){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01061)+"\n\n"
                    + getResources().getString(R.string.msj_01062));
        }
        else if(number == 7){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01071)+"\n\n"
                    + getResources().getString(R.string.msj_01072));
        }
        else if(number == 8){
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01081)+"\n\n"
                    + getResources().getString(R.string.msj_01082));
        }
        else{
            tvMsj.setText(getResources().getString(R.string.msj_01) + "\n\n" + getResources().getString(R.string.msj_01091)+"\n\n"
                    + getResources().getString(R.string.msj_01092));
        }
    }

    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(InteriorUrgency.this);
    }
}
