package com.carlosmestas.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Questionnaire extends AppCompatActivity {

    EditText editTextName, editTextLastName;
    Spinner spinnerDay, spinnerMonth, spinnerYear;
    Button buttonCalculate;
    String name, lastName, stringDay, stringMonth, stringYear;
    int day, month, year;
    Toast toast;
    Intent intent;

    String[] itemsDay = new String[]{"1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31"};
    String[] itemsMonth = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
    String[] itemsYear = new String[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        Calendar cal = Calendar.getInstance();

        final int d3 = cal.get(Calendar.YEAR);
//      final int d2 = cal.get(Calendar.MONTH);
//      final int d1 = cal.get(Calendar.DAY_OF_MONTH);

//      java.util.Date date = new Date();

        editTextLastName = findViewById(R.id.editTextLastName);
        editTextName = findViewById(R.id.editTextName);
        buttonCalculate = findViewById(R.id.buttonCalculate);

        for(int i = 0 ; i < itemsYear.length ; i++){
            itemsYear[i] = ""+ (d3 - i);
        }

        spinnerDay = findViewById(R.id.spinnerDay);
        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerYear = findViewById(R.id.spinnerYear);


        ArrayAdapter<String> adapterDay = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsDay);
        spinnerDay.setAdapter(adapterDay);

        ArrayAdapter<String> adapterMonth = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsMonth);
        spinnerMonth.setAdapter(adapterMonth);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,itemsYear);
        spinnerYear.setAdapter(adapterYear);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), Answers.class);

                lastName = editTextLastName.getText().toString();
                name = editTextName.getText().toString();

                stringDay = spinnerDay.getSelectedItem().toString();
                stringMonth = spinnerMonth.getSelectedItem().toString();
                stringYear = spinnerYear.getSelectedItem().toString();

                day = Integer.parseInt(stringDay);
                month = Integer.parseInt(stringMonth);
                year = Integer.parseInt(stringYear);


                if(lastName.equals("") || name.equals("")){
                    toast = Toast.makeText(getApplicationContext(), "" + getResources().getString(R.string.fill_all), Toast.LENGTH_SHORT);
                    toast.show();
                }

                else if(month == 2 && ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) && day > 29){
                    toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_1), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(month == 2 && !((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))){
                    toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_2), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if((month == 4 || month == 6 || month == 9 || month == 11 )&& day == 31){
                    toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.error_3), Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    toast = Toast.makeText(getApplicationContext(), lastName + " - " + name + " - " + stringDay + "/"
                            + stringMonth + "/" + stringYear, Toast.LENGTH_SHORT);
                    toast.show();
                    intent.putExtra("lastName", lastName);
                    intent.putExtra("name", name);
                    intent.putExtra("day", day);
                    intent.putExtra("month", month);
                    intent.putExtra("year", year);
                    startActivity(intent);
                }






            }
        });




    }

}
