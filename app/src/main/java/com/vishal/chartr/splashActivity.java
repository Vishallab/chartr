package com.vishal.chartr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView splashImage = findViewById(R.id.splash_image);




        // Load splash image with Glide, resize to 50% of original size, and center inside the ImageView
        Glide.with(this)
                .load(R.drawable.auto_chartrxrapido) // Replace your_splash_image with your image resource
                .apply(new RequestOptions().override(600).centerInside())
                .into(splashImage);

        // Handler to delay the transition to MainActivity for 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity after 4 seconds
                Intent intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                // Finish splash activity so that the user cannot go back to it
                finish();
            }
        }, 3000); // 3000 milliseconds delay
    }
}
