package com.example.amarp.firstgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {

    private Bitmap image;
    private int x,y;
    private int xVelocity = 10, yVelocity = 5;
    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    public CharacterSprite(Bitmap image) {
        this.image = image;
        x = 100;
        y = 100;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image,x,y,null);
    }

    public void update(){


        x = x + xVelocity;
        y = y + yVelocity;

        if ((x > screenWidth-image.getWidth()) || (x < 0)){
            xVelocity = xVelocity * -1;
        }
        if ((y > screenHeight - image.getHeight()) || (y < 0)){
            yVelocity = yVelocity * -1;
        }

    }

    public void currentPosUpdate(int currentX, int currentY){

        x = currentX;
        y = currentY;
        update();
    }
}
