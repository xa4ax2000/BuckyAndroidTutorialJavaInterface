package com.example.andrewhyun.buckyandroidtutorialjavainterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);  -- will not use xml file

        //Layout
        RelativeLayout rl = new RelativeLayout(this); //create RelativeLayout
        rl.setBackgroundColor(Color.GREEN);           //make layout background green (using graphics.Color)

        //Red Button
        Button redBtn = new Button(this);      //create Button
        redBtn.setText("LOGIN");               //set Button text to 'LOGIN'
        redBtn.setBackgroundColor(Color.RED);  //set Button color to Red (using graphics.Color)

        //Username Input
        EditText username = new EditText(this);


        //Set ID for ALL widgets
        redBtn.setId(1);
        username.setId(2);

        //Details of position, height, and width for Red Button
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, //width
            RelativeLayout.LayoutParams.WRAP_CONTENT  //height
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL); //position center of width
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);   //position center of height

        //Details of position, height, and idth for Username
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, //width
            RelativeLayout.LayoutParams.WRAP_CONTENT // height
        );
        usernameDetails.addRule(RelativeLayout.ABOVE, redBtn.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);

        //Add widget to layout (Button is now a child of layout)
        rl.addView(redBtn, buttonDetails);     //add to view the Button using the LayoutParams defined

        //Set this activation content/display to the view
        setContentView(rl);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
