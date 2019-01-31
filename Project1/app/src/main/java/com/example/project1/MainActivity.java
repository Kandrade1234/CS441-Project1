package com.example.project1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      int tracker = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView text = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);
/*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is interesting", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        final String [] jokes = new String [6];
        jokes[0] = "What's the best thing about switzerland?";
        jokes[1] = "I don't know but the flag is a big plus.";
        jokes[2] = "Did you hear about the actor who fell through the floorboards?";
        jokes[3] = "He was just going through a stage.";
        jokes[4] = "Why don't scientists trust atoms?";
        jokes[5] = "Because they make up everything";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText(jokes[tracker]);
                tracker++;
                if(tracker > 5) tracker = 0;

            }
        });

        ImageView fab = (ImageView)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent i = new Intent(Intent.ACTION_VIEW);
                 i.addCategory(Intent.CATEGORY_BROWSABLE);
                 i.setData(Uri.parse("https://www.gmail.com"));
                 startActivity(i);
            }
        });


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
}
