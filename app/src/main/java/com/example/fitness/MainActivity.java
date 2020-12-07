package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView titlepage,subtitlepage;
    ImageView imgpage;
    TextView btnexercise;
    View bgprogress, bgprogresstop;
    Animation animimgpage, bttone,bttwo, btthree,ltr;
    Intent i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titlepage = findViewById(R.id.titlepage);
        subtitlepage=findViewById(R.id.subtitlepage);
        btnexercise = findViewById(R.id.btnexercise);
        imgpage = findViewById(R.id.imgpage);
        bgprogress = findViewById(R.id.bgprogress);
        bgprogresstop = findViewById(R.id.bgprogresstop);


        //animasyon ata
        animimgpage= AnimationUtils.loadAnimation(this,R.anim.animimgpage);
        bttone = AnimationUtils.loadAnimation(this,R.anim.bttone);
        bttwo=AnimationUtils.loadAnimation(this,R.anim.bttwo);
        btthree=AnimationUtils.loadAnimation(this,R.anim.btthree);
        ltr=AnimationUtils.loadAnimation(this,R.anim.ltr);



        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
        bgprogresstop.startAnimation(ltr);


        //fontları import ediyoruz
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(),"fonts/Vidaloka.ttf");


        //textView'a font atadık
        titlepage.setTypeface(Vidaloka);
        subtitlepage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);


    }

    public void start(View v){
        i1 = new Intent (MainActivity.this,WorkoutAct.class);
        i1.addFlags(i1.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i1);
    }
}
