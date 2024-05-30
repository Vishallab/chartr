package com.vishal.chartr.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vishal.chartr.R;
import com.vishal.chartr.pass.AllPassesActivity;
import com.vishal.chartr.tickets.AllTicketesActivity;

public class MyProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

// 1 ################################################################################################

        // Find the RelativeLayout with id rl_info opening edit profile
        RelativeLayout rlInfo = findViewById(R.id.rl_info);

        // Set OnClickListener for rl_info
        rlInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open EditProfileActivity
                Intent intent = new Intent(MyProfileActivity.this, EditProfile.class);
                startActivity(intent);
            }
        });

// 2 ################################################################################################

        // Example: Finding a RelativeLayout and setting an OnClickListener to open the all tickets
        RelativeLayout rl_tickets = findViewById(R.id.rl_tickets);
        rl_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show custom dialog
                final Dialog dialog = new Dialog(MyProfileActivity.this);
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(MyProfileActivity.this, AllTicketesActivity.class));
                    }
                }, 1000); // 4 seconds delay
            }

        });
// 3 ################################################################################################

        // Example: Finding a RelativeLayout and setting an OnClickListener to open the all passes

        RelativeLayout rl_passes = findViewById(R.id.rl_passes);

        rl_passes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Show custom dialog
                final Dialog dialog = new Dialog(MyProfileActivity.this);
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(MyProfileActivity.this, AllPassesActivity.class));
                    }
                }, 3000); // 4 seconds delay
            }

        });

// 3 ################################################################################################
        // shear the app with others witch the playstore link and the massage

        RelativeLayout rl_refer_friend = findViewById(R.id.rl_refer_friend);
        rl_refer_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appLink = "https://play.google.com/store/apps/details?id=in.chartr.transit";
                String message = "Book contact-less bus tickets, get directions from one place to another by buses, metro or both, see which bus is coming at bus stop in realtime. Download chartr app by visiting: " + appLink;

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this amazing app!");
                shareIntent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(Intent.createChooser(shareIntent, "Share via"));

            }
        });

// 4 ################################################################################################
// rate us pr click krne se play store pr app le jane k liye
        RelativeLayout rl_rate_us = findViewById(R.id.rl_rate_us);
        rl_rate_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=in.chartr.transit"));
                startActivity(intent);
            }
        });

// 5 ################################################################################################
//opeing the contact us layput
        RelativeLayout rl_about_us = findViewById(R.id.rl_about_us);
        rl_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfileActivity.this, profilesContactUs.class);
                startActivity(intent);

            }
        });

// 6 ################################################################################################

        //linked open krnek liye
        ImageView iv_linkedin = findViewById(R.id.iv_linkedin);
        iv_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/vishalmishra01/"));
                startActivity(intent);
            }
        });

        //instagram  open krnek liye
        ImageView iv_instagram = findViewById(R.id.iv_instagram);
        iv_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/ig_viishal/"));
                startActivity(intent);
            }
        });

        //instagram  open krnek liye
        ImageView iv_github = findViewById(R.id.iv_github);
        iv_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Vishallab"));
                startActivity(intent);
            }
        });


    }
}