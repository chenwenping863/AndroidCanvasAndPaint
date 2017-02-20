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
    //http://blog.csdn.net/yixinyouni1314/article/details/7774164

    public static Bitmap CreateCricleImage(Bitmap image, int min) {

        Paint paint = new Paint();
        paint.setAntiAlias(true);//抗锯齿
        paint.setFilterBitmap(true);//对位图进行滤波处理

        Bitmap target = Bitmap.createBitmap(min, min, image.getConfig());

        Canvas canvas = new Canvas(target);

        canvas.drawCircle(min / 2, min / 2, min / 2, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        //你不可能控制每个窗口的绘制的时候，您就需要用下面的方法来处理——对整个Canvas进行处理。 1）在您的构造函数中，创建一个Paint滤波器。
        //PaintFlagsDrawFilter
        //当你在画图的时候，如果是View则在onDraw当中，如果是ViewGroup则在dispatchDraw中调用如下函数。
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        canvas.drawBitmap(image, 0, 0, paint);
        return target;

    }
}
