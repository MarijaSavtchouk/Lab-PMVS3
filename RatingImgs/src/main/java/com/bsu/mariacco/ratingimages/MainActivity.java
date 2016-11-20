package com.bsu.mariacco.ratingimages;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.*;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private String [] imgs = {"http://pngimg.com/upload/dog_PNG2454.png", "http://pngimg.com/upload/dog_PNG2453.png", "http://pngimg.com/upload/dog_PNG2452.png", "http://pngimg.com/upload/dog_PNG2450.png"};
    private ImageView rateImg;
    private TextView linkView;
    private int currentImg = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rateImg = (ImageView)findViewById(R.id.puppy_view);
        linkView = (TextView)findViewById(R.id.textView_link);
        linkView.setText(imgs[currentImg]);
    }
    public void onClickGoToLink(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(imgs[currentImg]));
        startActivity(browserIntent);
    }
    public void onClickNextTrial(View view){
        //Toast.makeText(getApplicationContext(),"Пора покормить кота!", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            public void run() {
                currentImg++;
                if(currentImg==imgs.length){
                    currentImg = 0;
                }
                //Toast.makeText(getApplicationContext(), "покормить кота!", Toast.LENGTH_SHORT).show();
                InputStream in = null;
                try {
                    in = (new URL(imgs[currentImg])).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                final Bitmap mIcon = BitmapFactory.decodeStream(in);
                rateImg.post(new Runnable() {

                    public void run() {
                        //Toast.makeText(getApplicationContext(), кота!", Toast.LENGTH_SHORT).show();
                        linkView.setText(imgs[currentImg]);
                        rateImg.setImageBitmap(mIcon);
                    }
                });
            }
        }).start();
    }
}
