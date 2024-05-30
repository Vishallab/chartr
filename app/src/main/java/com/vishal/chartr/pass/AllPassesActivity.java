package com.vishal.chartr.pass;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vishal.chartr.R;

public class AllPassesActivity extends AppCompatActivity {
    private TextView bookingTimeTextView;
    private TextView passIDTextView;
    private SharedPreferences sharedPreferencesforpastpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_passes);
//  1 ##################################################################

        //Finding a RelativeLayout and setting an OnClickListener

        RelativeLayout pass1 = findViewById(R.id.pass1);
        pass1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                    // Show custom dialog
                final Dialog dialog = new Dialog(AllPassesActivity.this);
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(AllPassesActivity.this, MyPassActivity.class));
                    }
                }, 3000); // 3 seconds delay
            }
        });

//  1 ##################################################################

      //for back
        ImageButton ib_back = findViewById(R.id.ib_back);
        ib_back.setOnClickListener(v -> finish() );



    }
}
