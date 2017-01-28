package com.example.andrewhyun.buckyandroidtutorialjavainterface;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.graphics.Color;
import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int countID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);  -- will not use xml file

        //Layout
        final RelativeLayout rl = new RelativeLayout(this); //create RelativeLayout
        rl.setBackgroundColor(Color.GREEN);           //make layout background green (using graphics.Color)

        //Red Button
        final Button redBtn = new Button(this);      //create Button
        redBtn.setText(R.string.redBtnText);               //set Button text to 'LOGIN'
        redBtn.setBackgroundColor(Color.RED);  //set Button color to Red (using graphics.Color)

        //Username Input
        final EditText username = new EditText(this);
        username.setBackgroundColor(Color.WHITE);
        username.setHint("Enter Username");

        //Message Input
        final EditText message = new EditText(this);
        message.setBackgroundColor(Color.WHITE);
        message.setHint("Enter Message");

        //Text View
        final TextView txt = new TextView(this);
        txt.setBackgroundColor(Color.WHITE);
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setGravity(Gravity.CENTER_HORIZONTAL);


        //Set ID for ALL widgets
        redBtn.setId(++countID);    //1
        username.setId(++countID);  //2
        message.setId(++countID);   //3
        txt.setId(++countID);       //4

        //Details of position, height, and width for Red Button
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, //width
            RelativeLayout.LayoutParams.WRAP_CONTENT  //height
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL); //position center of width
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);   //position center of height

        //Details of position, height, and width for Username
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, //width
            RelativeLayout.LayoutParams.WRAP_CONTENT            //height
        );
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.addRule(RelativeLayout.ABOVE, message.getId());
        usernameDetails.setMargins(0,0,0,50);

        //Details of position, height, and width for Message
        RelativeLayout.LayoutParams messageDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, //width
            RelativeLayout.LayoutParams.WRAP_CONTENT // height
        );
        messageDetails.addRule(RelativeLayout.ABOVE, redBtn.getId());
        messageDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        messageDetails.setMargins(0, 0, 0, 50);

        //Details of position, height, and width for txt
        final RelativeLayout.LayoutParams txtDetails = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        txtDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        txtDetails.addRule(RelativeLayout.CENTER_VERTICAL);
        txtDetails.setMargins(0, 0, 0, 50);

        //Converting DIP to Pixels
        Resources res = getResources();
        int pixel = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200, res.getDisplayMetrics());

        //Set width of Username, Message, and Txt
        username.setWidth(pixel);
        message.setWidth(pixel);
        txt.setWidth(pixel);

        //Add widget to layout
        rl.addView(redBtn, buttonDetails);     //add to view the Button using the LayoutParams defined (Button is now a child of layout)
        rl.addView(username, usernameDetails);
        rl.addView(message, messageDetails); //add to view the message using the LayoutParams defined
        //r1.addView(txt, txtDetails);      -- This will be added LATER as a event from a listener
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


        //Event Handling
        redBtn.setOnClickListener(
            new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(username.getText().toString().equals("")){
                        txt.setText(R.string.IfUserEmpty);
                    }
                    else{
                        txt.setText(getResources().getString(R.string.IfUserIsNotEmpty, username.getText().toString()));
                    }
                    if (message.getText().toString().equals("")) {
                        txt.setText(getResources().getString(R.string.IfPassEmpty, txt.getText().toString()));
                    }
                    else{
                        txt.setText(getResources().getString(R.string.IfPassIsNotEmpty, txt.getText(), message.getText().toString()));
                    }
                    rl.addView(txt, txtDetails);
                    rl.removeView(username);
                    rl.removeView(message);
                    rl.removeView(redBtn);
                }
            }
        );
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
