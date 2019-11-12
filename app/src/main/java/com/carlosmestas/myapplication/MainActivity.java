package com.carlosmestas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Intent intent;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.button_start);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation myAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.milkshake);
                v.startAnimation(myAnim);

                intent = new Intent(getApplicationContext() , Questionnaire.class);
                startActivity(intent);
                Animatoo.animateSplit(MainActivity.this);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        String txt = "\n";
        txt += getResources().getString(R.string.msj_dialog01);
        txt += "\n";
        txt += "Carlos Mestas";
        txt += "\n\n";
        txt += getResources().getString(R.string.msj_dialog02a);
        txt += "\n";
        txt += "Carlos Mestas";
        txt += "\n\n";
        txt += getResources().getString(R.string.msj_dialog03);

        TextView msg = new TextView(this);
        TextView msg2 = new TextView(this);

        msg.setText(txt);
        msg.setGravity(Gravity.CENTER_HORIZONTAL);

        builder.setTitle(getResources().getString(R.string.msj_dialog00));

        builder.setPositiveButton("OK",null);

        builder.setView(msg);
/*
                builder.setMessage(R.string.dialog_message)
                        .setTitle(R.string.dialog_title);
*/
        final AlertDialog dialog = builder.create();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

    }
}
