package com.example.finalproject.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.finalproject.R;


public class AnswerBubble {
    private Point position;
    private Bitmap image;

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
//    private class RandomPoint {
//        public int x, y;
//        public RandomPoint(int max_x, int max_y){
//            Random r max_x
//        }
//    }
    public AnswerBubble(Bitmap bitmap) {
        image = Bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*0.3), (int)(bitmap.getHeight()*0.3), true);
        position = new Point(5,100);
    }

    public void draw(Context context, Canvas canvas) {
        canvas.drawBitmap(image, position.x, position.y, null);
//        final Animation bounce = AnimationUtils.loadAnimation(context, R.anim.bounce);
    }

    public void update() {
        int viscosity = image.getDensity();
        if (viscosity!= 0) {
            image.setDensity(viscosity - 1);
        } else {

        }

    }

    public static Bitmap scale(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }
}
