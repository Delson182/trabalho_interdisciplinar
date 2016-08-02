package br.com.ifms.areq;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;


public class TelaSplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);

        Handler telaSplash = new Handler();
        telaSplash.postDelayed(TelaSplashActivity.this, 2000);

    }

    public void run(){
        if(verificaConexao()) {
            startActivity(new Intent(TelaSplashActivity.this, MainActivity.class));
            finish();
        } else {
            AlertDialog.Builder dlg = new AlertDialog.Builder(TelaSplashActivity.this);
            dlg.setMessage("Seu dispositivo está sem conexão com internet");
            dlg.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dlg.show();
        }
    }

    public boolean verificaConexao(){
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null && manager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
