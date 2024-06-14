package com.sarmadtechempire.contactbook.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sarmadtechempire.contactbook.R;

public class SplashActivity extends AppCompatActivity {
    View red_Circle;

    RelativeLayout splashLayout;

    ImageView splashImage;
    CardView cardView;
    TextView splashText;
    private static final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        red_Circle = findViewById(R.id.red_Circle);
        splashLayout = findViewById(R.id.splashLayout);
        cardView = findViewById(R.id.cardView);
        splashImage = findViewById(R.id.splashImage);
        cardView = findViewById(R.id.cardView);
        splashText = findViewById(R.id.splashText);

        Animation bounce = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.bounce);
        red_Circle.startAnimation(bounce);

        new Handler().postDelayed(() -> {
            red_Circle.clearAnimation();
            Animation spread = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.spread);
            spread.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    splashLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    cardView.setVisibility(View.VISIBLE);

                    splashImage.setVisibility(View.VISIBLE);

                    splashText.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(() ->{
                    Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                    },1000);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            red_Circle.startAnimation(spread);
        }, SPLASH_DISPLAY_LENGTH - 1000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.splashLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
