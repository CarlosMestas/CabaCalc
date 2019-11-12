package com.carlosmestas.myapplication;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.carlosmestas.myapplication.Ans.TonicOfTheDay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Questionnaire extends AppCompatActivity {

    EditText editTextName, editTextDate;
    Calendar myCalendar = Calendar.getInstance();

    Button buttonCalculate;
    String name;
    int day, month, year;
    Toast toast;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        Calendar cal = Calendar.getInstance();

        final int d3 = cal.get(Calendar.YEAR);
        final int d2 = cal.get(Calendar.MONTH) + 1;
        final int d1 = cal.get(Calendar.DAY_OF_MONTH);

        editTextName = findViewById(R.id.editTextName);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        editTextDate = findViewById(R.id.editTextDate);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Questionnaire.this, date,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH))
                        .show();            }
        });

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent = new Intent(getApplicationContext(), Answers.class);

                name = editTextName.getText().toString();

                day = myCalendar.get(Calendar.DAY_OF_MONTH);
                month = myCalendar.get(Calendar.MONTH) + 1;
                year = myCalendar.get(Calendar.YEAR);

                if(name.equals("")){
                    toast = Toast.makeText(getApplicationContext(), "" + getResources().getString(R.string.fill_all)
                            /*+"***"+d1+"-"+d2+"-"+d3*/, Toast.LENGTH_SHORT);
                    toast.show();
                }

                else{
                    if(year < d3){
                        intent.putExtra("name", name);
                        intent.putExtra("day", day);
                        intent.putExtra("month", month);
                        intent.putExtra("year", year);
                        startActivity(intent);
                        Animatoo.animateZoom(Questionnaire.this);
                    }
                    else if(year == d3){
                        if(month < d2){
                            intent.putExtra("name", name);
                            intent.putExtra("day", day);
                            intent.putExtra("month", month);
                            intent.putExtra("year", year);
                            startActivity(intent);
                            Animatoo.animateZoom(Questionnaire.this);
                        }
                        else if(month == d2){
                            if(day < d1){

                                intent.putExtra("name", name);
                                intent.putExtra("day", day);
                                intent.putExtra("month", month);
                                intent.putExtra("year", year);
                                startActivity(intent);
                                Animatoo.animateZoom(Questionnaire.this);

                            }
                            else if(day == d1){

                                intent.putExtra("name", name);
                                intent.putExtra("day", day);
                                intent.putExtra("month", month);
                                intent.putExtra("year", year);
                                startActivity(intent);
                                Animatoo.animateZoom(Questionnaire.this);

                            }
                            else{
                                toast = Toast.makeText(getApplicationContext(),getResources().getString(R.string.wrong_date), Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                        else{
                            toast = Toast.makeText(getApplicationContext(),getResources().getString(R.string.wrong_date), Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                    else{
                        toast = Toast.makeText(getApplicationContext(),getResources().getString(R.string.wrong_date), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }






            }
        });
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };

    private void actualizarInput() {
        String formatoDeFecha = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        editTextDate.setText(sdf.format(myCalendar.getTime()));
    }

    public void onBackPressed(){
        super.onBackPressed();
        Animatoo.animateFade(Questionnaire.this);
    }
}
