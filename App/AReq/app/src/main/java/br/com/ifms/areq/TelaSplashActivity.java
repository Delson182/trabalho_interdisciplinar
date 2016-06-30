package br.com.ifms.areq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;


public class TelaSplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        Handler telaSplash = new Handler();
        telaSplash.postDelayed(TelaSplashActivity.this, 3000);
    }

    public void run(){
        startActivity(new Intent(TelaSplashActivity.this, MainActivity.class));
        finish();
    }
}
