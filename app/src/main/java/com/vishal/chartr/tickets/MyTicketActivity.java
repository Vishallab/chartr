package com.vishal.chartr.tickets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.vishal.chartr.R;
import com.vishal.chartr.pass.MyPassActivity;
import com.vishal.chartr.pass.PassShowqrActivity;

public class MyTicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//##################################################################################33
        // Prevent screenshots or screen recordings
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_my_ticket);

//   1   ##################################################################################
        //on cick on cross btn to going back
        ImageView ivClose = findViewById(R.id.iv_close);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This will close the current activity and go back to the previous one
            }
        });
//   1   ##################################################################################
        // on click on QR to move to the move to QR layout
        RelativeLayout rvShowQR = findViewById(R.id.rv_showQR);
        rvShowQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ShowQRActivity
                Intent intent = new Intent(MyTicketActivity.this, TicketShowqrActivity.class);
                startActivity(intent);
            }
        });


    }
}