package com.example.myframeworkapp.game.game1;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;


import com.example.myframeworkapp.R;


import static com.example.myframeworkapp.game.game1.GameView.screenRatioX;
import static com.example.myframeworkapp.game.game1.GameView.screenRatioY;

public class Bullet {

    int x, y, width, height;
    Bitmap bullet;

    public Bullet(Resources res) {
        bullet = BitmapFactory.decodeResource(res, R.drawable.bullet);

        width = bullet.getWidth();
        height=bullet.getHeight();

        width/=4;
        height /=4;

        width *=(int) screenRatioX;
        height*=(int) screenRatioY;

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);
        }

    Rect getCollisionShape(){
        return new Rect(x,y, x+width, y+height);
    }
}
