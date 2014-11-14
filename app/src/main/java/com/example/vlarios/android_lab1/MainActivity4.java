package com.example.vlarios.android_lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.graphics.Color;



public class MainActivity4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        chgTextColor(message, 1);
    }

    private void chgTextColor(String message, int colorSel){
        final String msg = message;
        final Handler handler = new Handler();
        final int sel = colorSel;


        new Thread(new Runnable() {
            @Override
            public void run() {

                int timeToBlink = 1000;    //in milissegunds
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int selAux=sel;
                        TextView txt = (TextView) findViewById(R.id.textView);
                        txt.setTextSize(40);
                        if(selAux == 1) {
                            txt.setTextColor(Color.RED);
                            txt.setText(msg);
                        }
                        else if (selAux == 2) {
                            txt.setTextColor(Color.GREEN);
                            txt.setText(msg);
                        }
                        else if (selAux == 3) {
                            txt.setTextColor(Color.BLUE);
                            txt.setText(msg);
                        }
                        if (selAux==3) {
                            selAux=1;
                        }
                        else {
                            selAux++;
                        }
                        chgTextColor(msg,selAux);
                    }
                });
            }
        }).start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
