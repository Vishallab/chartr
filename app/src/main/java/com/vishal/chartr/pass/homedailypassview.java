package com.vishal.chartr.pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.vishal.chartr.R;
public class homedailypassview extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homedailypassview);

        //  1 ##################################################################################
        //only one thing to click to go to the details
        RelativeLayout rl_passes = findViewById(R.id.rl_passes);
        rl_passes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(homedailypassview.this,MyPassActivity.class);
                startActivity(intent);
            }
        });

    }
}