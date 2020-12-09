package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage,fitonetitle,fitonedesc,
            btnexercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        //fontları import ediyoruz
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(),"fonts/Vidaloka.ttf");


        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        //fit itemleri
        fitonetitle=findViewById(R.id.fitonetitle);
        fitonedesc=findViewById(R.id.fitonedesc);



        intropage.setTypeface(Vidaloka);
        subintropage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        //fit itemler'a font ata
        fitonedesc.setTypeface(MLight);
        fitonetitle.setTypeface(MMedium);





    }
}
