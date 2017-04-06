package com.restore.save.orient.screen.demo.screen_orient_save_restore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*

When we change the screen orientation then the activity is Destroyed and recreated again in another orientation

For eg. In Portrait mode onCreate, onStart, onResume method called to bring activity and when changed to Landscape then
onPause, onSaveInstanceState, onStop, onDestroy will be called to destroy Portrait activity and once again onCreate,
onRestoreInstanceState, onStart, onResume method called to bring activity

When back method is called both onSaveInstanceState, onRestoreInstanceState method are not called application is simply destroyed

 */

public class MainActivity extends AppCompatActivity {
    int score;
    EditText et;
    String etString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = 0;
        et =(EditText) findViewById(R.id.editText);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        etString = et.getText().toString();
        outState.putString("edittext",etString);
        outState.putInt("score", score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        et.setText(savedInstanceState.getString("edittext"));
        score = savedInstanceState.getInt("score");
    }

    public void performAction(View v)
    {
        switch(v.getId())
        {
            case R.id.bInc:
                score += 1;
                break;
            case R.id.bShowCounter:
                Toast.makeText(MainActivity.this,"Your score is "+score, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
