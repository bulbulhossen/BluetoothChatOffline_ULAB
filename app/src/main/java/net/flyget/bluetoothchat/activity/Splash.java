package net.flyget.bluetoothchat.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.flyget.bluetoothchat.R;


public class Splash extends Activity {


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread() {

            public void run() {

                try {

                    sleep(2000);
                    finish();
                    Intent cv = new Intent(Splash.this, MainActivity.class/*otherclass*/);
                    startActivity(cv);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}