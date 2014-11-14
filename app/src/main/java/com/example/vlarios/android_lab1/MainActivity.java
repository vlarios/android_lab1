package com.example.vlarios.android_lab1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.android_lab1.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void select1(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        EditText editText = (EditText) findViewById(R.id.nombre);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public void select2(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        EditText editText = (EditText) findViewById(R.id.apellido);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void select3(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        EditText editText = (EditText) findViewById(R.id.edad);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void select4(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

}
