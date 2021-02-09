package com.example.myframeworkapp.game.game1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.myframeworkapp.R;

public class Background {

    int x=0,y=0;
    Bitmap background;

    public Background(int screenx, int screeny, Resources res) {
       background= BitmapFactory.decodeResource(res, R.drawable.background);
       background= Bitmap.createScaledBitmap(background, screenx, screeny,false);
    }
}
