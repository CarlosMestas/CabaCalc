package com.carlosmestas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

/*
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
*/
public class SplashActivity extends AppCompatActivity {

    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 3000; // 3 segundos

    @Override
    public void onCreate(Bundle savedInstanceState) {


        //getActionBar().hide();

        super.onCreate(savedInstanceState);

        // Tenemos una plantilla llamada splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                Animatoo.animateDiagonal(SplashActivity.this);
                finish();
            };
        }, DURACION_SPLASH);
    }
}