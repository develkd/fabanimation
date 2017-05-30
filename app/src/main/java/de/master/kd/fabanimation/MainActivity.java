package de.master.kd.fabanimation;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_plus, fab_twitter, fab_fb;
    private Animation fabOpen, fabClose, fabRClockwise, fabRanticlockwise;
    private boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab_plus  = (FloatingActionButton)findViewById(R.id.fab_plus);
        fab_twitter  = (FloatingActionButton)findViewById(R.id.fab_twitter);
        fab_fb  = (FloatingActionButton)findViewById(R.id.fab_fb);
        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_fb.startAnimation(fabClose);
                    fab_twitter.startAnimation(fabClose);
                    fab_plus.startAnimation(fabRanticlockwise);

                    fab_fb.setClickable(false);
                    fab_twitter.setClickable(false);
                    isOpen = false;

                }else{

                    fab_fb.startAnimation(fabOpen);
                    fab_twitter.startAnimation(fabOpen);
                    fab_plus.startAnimation(fabRClockwise);

                    fab_fb.setClickable(true);
                    fab_twitter.setClickable(true);
                    isOpen = true;

                }
            }
        });

    }
}
