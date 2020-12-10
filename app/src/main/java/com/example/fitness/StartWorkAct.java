package com.example.fitness;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage,fitonetitle,fitonedesc,
            btnexercise,timerValue;
    View divpage,bgprogress;
    ImageView imgtimer;
    LinearLayout fitone;

    private static final long START_TIME_IN_MILLIS = 800000;
    private CountDownTimer countDownTimer;
    private boolean aTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Animation btthree,bttfour,ttbone,ttbtwo, alphagogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        //animasyonları tanımlıyoruz
        btthree = AnimationUtils.loadAnimation(this,R.anim.btthree);
        bttfour = AnimationUtils.loadAnimation(this,R.anim.bttfour);
        ttbone = AnimationUtils.loadAnimation(this,R.anim.ttbone);
        ttbtwo = AnimationUtils.loadAnimation(this,R.anim.ttbtwo);
        alphagogo = AnimationUtils.loadAnimation(this,R.anim.alphagogo);



        //fontları import ediyoruz
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(),"fonts/Vidaloka.ttf");

        timerValue = findViewById(R.id.timerValue);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        //fit itemleri
        fitonetitle=findViewById(R.id.fitonetitle);
        fitonedesc=findViewById(R.id.fitonedesc);
        bgprogress=findViewById(R.id.bgprogress);
        divpage=findViewById(R.id.divpage);
        fitone=findViewById(R.id.fitone);
        imgtimer = findViewById(R.id.imgtimer);



        intropage.setTypeface(Vidaloka);
        subintropage.setTypeface(MLight);
        btnexercise.setTypeface(MMedium);

        //fit itemler'a font ata
        fitonedesc.setTypeface(MLight);
        fitonetitle.setTypeface(MMedium);

        btnexercise.startAnimation(bttfour);
        bgprogress.startAnimation(btthree);
        fitone.startAnimation(ttbone);
        intropage.startAnimation(ttbtwo);
        subintropage.startAnimation(ttbtwo);
        divpage.startAnimation(ttbtwo);
        imgtimer.startAnimation(alphagogo);
        timerValue.startAnimation(alphagogo);

        startTimer();

    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
            Toast.makeText(getApplicationContext(),"Congratulations!",Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000)/60;
        int seconds = (int) (mTimeLeftInMillis/1000)%60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timerValue.setText(timeLeft);
    }

}
