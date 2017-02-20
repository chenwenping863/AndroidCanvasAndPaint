package com.test.chenwenping.androidcanvasandpaint;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * Created by chenwenping on 17/2/20.
 */

public class CanvasBitmap {

    public static Bitmap CreateCricleImage(Bitmap image, int min) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);

        Bitmap target = Bitmap.createBitmap(min, min, image.getConfig());

        Canvas canvas = new Canvas(target);

        canvas.drawCircle(min / 2, min / 2, min / 2, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        canvas.drawBitmap(image, 0, 0, paint);
        return target;

    }
}
