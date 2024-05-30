package com.vishal.chartr.tickets;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.vishal.chartr.R;

public class AllTicketesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_ticketes);

        //  1  ################################################################################

        // Find the ImageButton with id ib_back
        ImageButton ibBack = findViewById(R.id.ib_back);
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the current activity and go back to the previous one
                finish();
            }
        });

        //  1  ################################################################################
        //opening the ticket detail o the click on the layout

        LinearLayout ll_ticket1 = findViewById(R.id.ll_ticket1);
        ll_ticket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Show custom dialog
                final Dialog dialog = new Dialog(AllTicketesActivity.this);
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(AllTicketesActivity.this, MyTicketActivity.class));
                    }
                }, 1000); // 4 seconds delay



            }
        });
    }
}