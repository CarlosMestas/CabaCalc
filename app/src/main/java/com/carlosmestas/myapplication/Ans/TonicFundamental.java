package com.carlosmestas.myapplication.Ans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.carlosmestas.myapplication.R;

public class TonicFundamental extends AppCompatActivity {

    int number;
    TextView tvTitle, tvMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonic_fundamental);

        Intent intent = getIntent();
        number = intent.getIntExtra("tonicFundamental",0);

        tvTitle = findViewById(R.id.textViewTF);
        tvMsj = findViewById(R.id.textViewTFMsj);

        tvTitle.setText(tvTitle.getText().toString() + ": " + number);

        if(number == 1){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0201));
        }
        else if(number == 2){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0202));
        }
        else if(number == 3){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0203));
        }
        else if(number == 4){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0204));
        }
        else if(number == 5){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0205));
        }
        else if(number == 6){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0206));
        }
        else if(number == 7){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0207));
        }
        else if(number == 8){
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0208));
        }
        else{
            tvMsj.setText(getResources().getString(R.string.msj_02) + "\n\n" + getResources().getString(R.string.msj_0209));
        }

    }
}
