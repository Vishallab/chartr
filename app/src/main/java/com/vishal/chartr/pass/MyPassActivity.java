package com.vishal.chartr.pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vishal.chartr.R;

public class MyPassActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//###########################################################################################
        // Prevent screenshots or screen recordings
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_my_pass);

//   1  ###########################################################################################

        //going back on click cross
        ImageView ivClose = findViewById(R.id.iv_close);
        ivClose.setOnClickListener(v -> finish()); // This will close the current activity and go back to the previous one

//   2  ###########################################################################################
        //to move to the QR

        RelativeLayout rvShowQR = findViewById(R.id.rv_showQR);
        rvShowQR.setOnClickListener(v -> {
            // Navigate to ShowQRActivity
            Intent intent = new Intent(MyPassActivity.this, PassShowqrActivity.class);
            startActivity(intent);
        });


    }
}
