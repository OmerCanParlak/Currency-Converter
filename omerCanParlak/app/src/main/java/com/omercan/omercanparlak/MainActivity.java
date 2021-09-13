package com.omercan.omercanparlak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Spinner spinner;
    Spinner spinner2;
double from;
double to;
    String[] currncy = {"EUR", "USD", "GBP", "CAD", "CHF", "TRY"};
    double[] array = {1,1.18,0.86,1.49,1.08,9.85};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);


        ArrayAdapter<String> adepter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, currncy);
        spinner.setAdapter(adepter);
        spinner2.setAdapter(adepter);


    }

    public void convert(View view) {
        double among = Double.parseDouble(editText.getText().toString());
        double price = among * convert();
        textView.setText(String.valueOf(price));




    }

    public double convert() {

        String selected= spinner.getSelectedItem().toString();
        String selected2 = spinner2.getSelectedItem().toString();
        for( int i = 0; i<=5;i++){
            if(selected == currncy[i]){
                from = array[i];
            }
            if(selected2 == currncy[i]){
                to= array[i];
            }
        }





        double unit = to / from;
        return unit;


    }}
