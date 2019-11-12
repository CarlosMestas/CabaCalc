package com.carlosmestas.myapplication.Ans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.R;

public class KabbalahOfTheYear extends AppCompatActivity {

    int number;
    TextView tvTitle, tvMsj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabbalah_of_the_year);

        Intent intent = getIntent();
        number = intent.getIntExtra("year", 0);

        tvTitle = findViewById(R.id.textViewKY);
        tvMsj = findViewById(R.id.textViewKYMsj);

        String text = "";

        text += getResources().getString(R.string.msj_0501);

        int tmp = number;
        int tmp2, temp3;
        text +="\n";
        for (int i = 0; i < 4; i++) {
            text += "\n";
            text += getResources().getString(R.string.year);
            text += ": ";
            tmp += sumAllNumbers(tmp);
            text += tmp;
            text += ", ";
            text += getResources().getString(R.string.msj_0502);
            text += ": ";

            tmp2 = sumAllNumbers(tmp);
            while(tmp2 > 9){
                tmp2 = sumAllNumbers(tmp2);
            }
            text += tmp2;

        }

        tvMsj.setText(text);
    }

    static int sumAllNumbers(int num){
        int ans = 0;
        while(num > 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }
    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(KabbalahOfTheYear.this);
    }
}
