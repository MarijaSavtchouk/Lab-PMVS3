package com.bsu.mariacco.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import
        android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button; import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
    private Button startFrameAnim;
    private Button startTransformAnim;
    private Button alphaAnim;
    private Button slideAnim;
    private Button combineAnim;
    private Button cancelAnim;
    private ImageView animationView;;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startFrameAnim = (Button) findViewById(R.id.frameAnimationStart);
        startTransformAnim= (Button) findViewById(R.id.transformAnimationStart);
        cancelAnim = (Button) findViewById(R.id.cancelAnimation);
        alphaAnim = (Button)findViewById(R.id.alphaAnimation);
        slideAnim = (Button)findViewById(R.id.slideAnim);
        combineAnim = (Button)findViewById(R.id.combineAnim);
        animationView =
                (ImageView) findViewById(R.id.animationView);
        startFrameAnim.setOnClickListener(this);
        startTransformAnim.setOnClickListener(this);
        alphaAnim.setOnClickListener(this);
        slideAnim.setOnClickListener(this);
        cancelAnim.setOnClickListener(this);
        combineAnim.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (startFrameAnim.equals(v)) {

            animationView.setBackgroundResource(R.drawable.frame_anim);
            AnimationDrawable animation =
                (AnimationDrawable) animationView.getBackground();
            animation.start();
        } else if (startTransformAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.ic_launcher);
            Animation transformAnimation =
                AnimationUtils.loadAnimation(this, R.anim.transform_anim);
            animationView.startAnimation(transformAnimation);
        }
        else if(alphaAnim.equals(v)){
            animationView.setBackgroundResource(R.drawable.ic_launcher);
            Animation alphaAnimation =
                    AnimationUtils.loadAnimation(this, R.anim.alpha);
            animationView.startAnimation(alphaAnimation);
        }
        else if (slideAnim.equals(v)){
            animationView.setBackgroundResource(R.drawable.ic_launcher);

            Animation animation = AnimationUtils.loadAnimation(this,
                        R.anim.slide);
            animationView.startAnimation(animation);
        }
        else if(combineAnim.equals(v)){
            animationView.setBackgroundResource(R.drawable.ic_launcher);

            Animation animation;
                animation = AnimationUtils.loadAnimation(this,
                        R.anim.combine);
            animationView.startAnimation(animation);
        }
        else if (cancelAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.ic_launcher);
        }
    }
}