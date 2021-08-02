package com.example.mine_d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Mined extends View {


    private static Context context;
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint;
    private Paint mypaint;
    private Paint paint;
    private Paint decor;
    private boolean[][] cellChecked;
    private boolean num[][];
    int x1 = new Random().nextInt(8);
    int x2 = new Random().nextInt(8);
    int x3 = new Random().nextInt(8);
    int x4 = new Random().nextInt(8);
    int x5 = new Random().nextInt(8);
    int x6 = new Random().nextInt(8);
    int x7 = new Random().nextInt(8);
    int x8 = new Random().nextInt(8);

    int y1 = new Random().nextInt(8);
    int c, d, e, f, h, k, l, g;
    int count = 0;
    int cx = 0;
    public int cp = 0;
    int am = 0;
    int timec = 0;

    public Mined(Context context, Context context1) {
        super(context);

        blackPaint = new Paint();
        mypaint = new Paint();
        paint = new Paint();
        decor = new Paint();
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.context = context1;
        if(x1<3)
        {
            y1 = 3 + new Random().nextInt(5);
        }
        else
        {
            y1 = new Random().nextInt(3);
        }
    }

    public Mined(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }

        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;

        cellChecked = new boolean[numColumns][numRows];

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        blackPaint.setColor(Color.WHITE);
        if (numColumns == 0 || numRows == 0) {
            return;
        }
        int count = 0;
        int width = getWidth();
        int height = getHeight();


        am = 0;
        if (x1 != y1) {


        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (cellChecked[i][j]) {

                    am++;

                    if ((i == x1 && j == 0) || (i==y1 && j==0)|| (i == x2 && j == 1) || (i == x3 && j == 2) || (i == x4 && j == 3) || (i == x5 && j == 4) || (i == x6 && j == 5) || (i == x7 && j == 6) || (i == x8 && j == 7))
                    {

                        if (cp == 0) {

                            mypaint.setColor(Color.GREEN);
                            canvas.drawRect(i * cellWidth, j * cellWidth,
                                    (i + 1) * cellWidth, (j + 1) * cellWidth,
                                    mypaint);
                            if (j == 0)
                            {
                                if (x1 < 7)
                                {
                                    x1 = x1 + 1;
                                }
                                else
                                    {
                                    x1 = x1 - 1;
                                }

                                if(y1<7)
                                {
                                    y1 = y1+1;
                                }
                                else
                                {
                                    y1 = y1 -1;
                                }


                                if ((i + 1 == x1 || i - 1 == x1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i!=y1 - 1 && i!=y1 + 1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i == x2 || i + 1 == x2 || i - 1 == x2) && (i != x1 - 1 && i != x1 + 1)&&(i!=y1 - 1 && i!=y1 + 1)) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if((i != x1 - 1 && i != x1 + 1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i+1 == y1 || i-1 ==y1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i + 1 == x1 || i - 1 == x1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i!=y1 - 1 && i!=y1 + 1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if((i + 1 == x1 || i - 1 == x1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i+1 == y1 || i-1 ==y1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if((i != x1 - 1 && i != x1 + 1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i+1 == y1 || i-1 ==y1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if((i + 1 == x1 || i - 1 == x1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i+1 == y1 || i-1 ==y1))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else
                                    {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }


                            } else if (j == 1) {
                                if (x2 < 7) {
                                    x2 = x2 + 1;
                                } else {
                                    x2 = x2 - 1;
                                }


                                if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if((i==x1||i+1==x1||i-1==x1))
                                else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x3||i+1==x3||i-1==x3)
                                else if ((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1)))
                                {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x2||i-1==x2)&&(i==x1||i+1==x1||i-1==x1))
                                else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x2||i-1==x2)&&(i==x3||i+1==x3||i-1==x3))
                                else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x3||i+1==x3||i-1==x3)&&(i==x1||i+1==x1||i-1==x1))
                                else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x2||i-1==x2)&&(i==x1||i+1==x1||i-1==x1)&&(i==x3||i+1==x3||i-1==x3))
                                else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("4", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
                                else
                                    {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            } else if (j == 2) {
                                if (x3 < 7) {
                                    x3 = x3 + 1;
                                } else {
                                    x3 = x3 - 1;
                                }


                                if ((i == x3 - 1 || i == x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if(i==x2||i+1==x2||i-1==x2)
                                else if ((i != x3 - 1 && i != x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x4||i+1==x4||i-1==x4)
                                else if ((i != x3 - 1 && i != x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x3||i-1==x3)&&(i==x2||i+1==x2||i-1==x2))
                                else if ((i == x3 - 1 || i == x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x3||i-1==x3)&&(i==x4||i+1==x4||i-1==x4))
                                else if ((i == x3 - 1 || i == x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x4||i+1==x4||i-1==x4)&&(i==x2||i+1==x2||i-1==x2))
                                else if ((i != x3 - 1 && i != x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x3||i-1==x3)&&(i==x2||i+1==x2||i-1==x2)&&(i==x4||i+1==x4||i-1==x4))
                                else if ((i == x3 - 1 || i == x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }


                            } else if (j == 3) {
                                if (x4 < 7) {
                                    x4 = x4 + 1;
                                } else {
                                    x4 = x4 - 1;
                                }


                                if ((i == x4 - 1 || i == x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if(i==x3||i+1==x3||i-1==x3)
                                else if ((i != x4 - 1 && i != x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x5||i+1==x5||i-1==x5)
                                else if ((i != x4 - 1 && i != x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x4||i-1==x4)&&(i==x3||i+1==x3||i-1==x3))
                                else if ((i == x4 - 1 || i == x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x4||i-1==x4)&&(i==x5||i+1==x5||i-1==x5))
                                else if ((i == x4 - 1 || i == x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x5||i+1==x5||i-1==x5)&&(i==x3||i+1==x3||i-1==x3))
                                else if ((i != x4 - 1 && i != x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x4||i-1==x4)&&(i==x3||i+1==x3||i-1==x3)&&(i==x5||i+1==x5||i-1==x5))
                                else if ((i == x4 - 1 || i == x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            } else if (j == 4) {
                                if (x5 < 7) {
                                    x5 = x5 + 1;
                                } else {
                                    x5 = x5 - 1;
                                }


                                if ((i == x5 - 1 || i == x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if(i==x4||i+1==x4||i-1==x4)
                                else if ((i != x5 - 1 && i != x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x6||i+1==x6||i-1==x6)
                                else if ((i != x5 - 1 && i != x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x5||i-1==x5)&&(i==x4||i+1==x4||i-1==x4))
                                else if ((i == x5 - 1 || i == x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x5||i-1==x5)&&(i==x6||i+1==x6||i-1==x6))
                                else if ((i == x5 - 1 || i == x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x6||i+1==x6||i-1==x6)&&(i==x4||i+1==x4||i-1==x4))
                                else if ((i != x5 - 1 && i != x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x5||i-1==x5)&&(i==x4||i+1==x4||i-1==x4)&&(i==x6||i+1==x6||i-1==x6))
                                else if ((i == x5 - 1 || i == x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            } else if (j == 5) {
                                if (x6 < 7) {
                                    x6 = x6 + 1;
                                } else {
                                    x6 = x6 - 1;
                                }

                                if ((i == x6 - 1 || i == x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if(i==x5||i+1==x5||i-1==x5)
                                else if ((i != x6 - 1 && i != x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x7||i+1==x7||i-1==x7)
                                else if ((i != x6 - 1 && i != x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x6||i-1==x6)&&(i==x5||i+1==x5||i-1==x5))
                                else if ((i == x6 - 1 || i == x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x6||i-1==x6)&&(i==x7||i+1==x7||i-1==x7))
                                else if ((i == x6 - 1 || i == x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x7||i+1==x7||i-1==x7)&&(i==x5||i+1==x5||i-1==x5))
                                else if ((i != x6 - 1 && i != x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x6||i-1==x6)&&(i==x5||i+1==x5||i-1==x5)&&(i==x7||i+1==x7||i-1==x7))
                                else if ((i == x6 - 1 || i == x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            } else if (j == 6) {
                                if (x7 < 7) {
                                    x7 = x7 + 1;
                                } else {
                                    x7 = x7 - 1;
                                }

                                if ((i == x7 - 1 || i == x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

//                    else if(i==x6||i+1==x6||i-1==x6)
                                else if ((i != x7 - 1 && i != x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if(i==x8||i+1==x8||i-1==x8)
                                else if ((i != x7 - 1 && i != x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x7||i-1==x7)&&(i==x6||i+1==x6||i-1==x6))
                                else if ((i == x7 - 1 || i == x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x7||i-1==x7)&&(i==x8||i+1==x8||i-1==x8))
                                else if ((i == x7 - 1 || i == x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i==x8||i+1==x8||i-1==x8)&&(i==x6||i+1==x6||i-1==x6))
                                else if ((i != x7 - 1 && i != x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                }
//                    else if((i+1==x7||i-1==x7)&&(i==x6||i+1==x6||i-1==x6)&&(i==x8||i+1==x8||i-1==x8))
                                else if ((i == x7 - 1 || i == x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            } else if (j == 7) {
                                if (x8 < 7) {
                                    x8 = x8 + 1;
                                } else {
                                    x8 = x8 - 1;
                                }

                                if ((i == x8 - 1 || i == x8 + 1) && (i != x7 && i != x7 - 1 && i != x7 + 1)) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else if ((i == x7 || i + 1 == x7 || i - 1 == x7) && (i != x8 - 1 && i != x8 + 1)) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else if ((i + 1 == x8 || i - 1 == x8) && (i == x7 || i + 1 == x7 || i - 1 == x7)) {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                                } else {
                                    cp++;
                                    paint.setColor(Color.BLACK);
                                    paint.setTextSize(100);
                                    canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                                }

                            }

                        }
                        else
                            {
                            Mined.vibrateDevice(context);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x1 * cellWidth, 0 * cellWidth,
                                    (x1 + 1) * cellWidth, (0+1)*cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(y1 * cellWidth, 0 * cellWidth,
                                    (y1 + 1) * cellWidth, (0 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x2 * cellWidth, 1 * cellWidth,
                                    (x2 + 1) * cellWidth, (1 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x3 * cellWidth, 2 * cellWidth,
                                    (x3 + 1) * cellWidth, (2 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x4 * cellWidth, 3 * cellWidth,
                                    (x4 + 1) * cellWidth, (3 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x5 * cellWidth, 4 * cellWidth,
                                    (x5 + 1) * cellWidth, (4 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x6 * cellWidth, 5 * cellWidth,
                                    (x6 + 1) * cellWidth, (5 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x7 * cellWidth, 6 * cellWidth,
                                    (x7 + 1) * cellWidth, (6 + 1) * cellWidth,
                                    blackPaint);
                            blackPaint.setColor(Color.RED);
                            canvas.drawRect(x8 * cellWidth, 7 * cellWidth,
                                    (x8 + 1) * cellWidth, (7 + 1) * cellWidth,
                                    blackPaint);
                            count++;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    String s3 = Integer.toString(am - 1);
                                    Intent i1 = new Intent(context, MainActivity6.class);
                                    String s = "GAME OVER! YOU STEPPED UPON MINE";
                                    i1.putExtra("msg", s);
                                    i1.putExtra("score", s3);
                                    i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity(i1);
                                }
                            }, 5000);
                        }

                    } else {

                        mypaint.setColor(Color.GREEN);
                        canvas.drawRect(i * cellWidth, j * cellWidth,
                                (i + 1) * cellWidth, (j + 1) * cellWidth,
                                mypaint);
                        if (j == 0) {

                            if ((i + 1 == x1 || i - 1 == x1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i!=y1 - 1 && i!=y1 + 1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i == x2 || i + 1 == x2 || i - 1 == x2) && (i != x1 - 1 && i != x1 + 1)&&(i!=y1 - 1 && i!=y1 + 1)) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if((i != x1 - 1 && i != x1 + 1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i+1 == y1 || i-1 ==y1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i + 1 == x1 || i - 1 == x1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i!=y1 - 1 && i!=y1 + 1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if((i + 1 == x1 || i - 1 == x1) && (i != x2 && i != x2 - 1 && i != x2 + 1) && (i+1 == y1 || i-1 ==y1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if((i != x1 - 1 && i != x1 + 1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i+1 == y1 || i-1 ==y1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if((i + 1 == x1 || i - 1 == x1) && (i == x2 || i + 1 == x2 || i - 1 == x2) && (i+1 == y1 || i-1 ==y1))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        }
//                paint.setColor(Color.BLACK);
//                paint.setTextSize(200);
//                canvas.drawText("S", i*cellWidth, (j+1)*cellHeight, paint);
                        else if (j == 1) {

                            if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if((i==x1||i+1==x1||i-1==x1))
                            else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x3||i+1==x3||i-1==x3)
                            else if ((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1)))
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x2||i-1==x2)&&(i==x1||i+1==x1||i-1==x1))
                            else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x2||i-1==x2)&&(i==x3||i+1==x3||i-1==x3))
                            else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x3||i+1==x3||i-1==x3)&&(i==x1||i+1==x1||i-1==x1))
                            else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i != x2 - 1 && i != x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x2||i-1==x2)&&(i==x1||i+1==x1||i-1==x1)&&(i==x3||i+1==x3||i-1==x3))
                            else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != y1 && i != (y1 - 1) && i != (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i == x2 - 1 || i == x2 + 1) && (i != x1 && i != (x1 - 1) && i != (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i != x2 - 1 && i != x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else if ((i == x2 - 1 || i == x2 + 1) && (i == x1 || i == (x1 - 1) || i == (x1 + 1)) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == y1 || i == (y1 - 1) || i == (y1 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("4", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                            else
                            {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 2) {
//                    if(i+1==x3||i-1==x3)
                            if ((i == x3 - 1 || i == x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if(i==x2||i+1==x2||i-1==x2)
                            else if ((i != x3 - 1 && i != x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x4||i+1==x4||i-1==x4)
                            else if ((i != x3 - 1 && i != x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x3||i-1==x3)&&(i==x2||i+1==x2||i-1==x2))
                            else if ((i == x3 - 1 || i == x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i != x4 && i != (x4 - 1) && i != (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x3||i-1==x3)&&(i==x4||i+1==x4||i-1==x4))
                            else if ((i == x3 - 1 || i == x3 + 1) && (i != x2 && i != (x2 - 1) && i != (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x4||i+1==x4||i-1==x4)&&(i==x2||i+1==x2||i-1==x2))
                            else if ((i != x3 - 1 && i != x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x3||i-1==x3)&&(i==x2||i+1==x2||i-1==x2)&&(i==x4||i+1==x4||i-1==x4))
                            else if ((i == x3 - 1 || i == x3 + 1) && (i == x2 || i == (x2 - 1) || i == (x2 + 1)) && (i == x4 || i == (x4 - 1) || i == (x4 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 3) {
//                    if(i+1==x4||i-1==x4)
                            if ((i == x4 - 1 || i == x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if(i==x3||i+1==x3||i-1==x3)
                            else if ((i != x4 - 1 && i != x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x5||i+1==x5||i-1==x5)
                            else if ((i != x4 - 1 && i != x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x4||i-1==x4)&&(i==x3||i+1==x3||i-1==x3))
                            else if ((i == x4 - 1 || i == x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i != x5 && i != (x5 - 1) && i != (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x4||i-1==x4)&&(i==x5||i+1==x5||i-1==x5))
                            else if ((i == x4 - 1 || i == x4 + 1) && (i != x3 && i != (x3 - 1) && i != (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x5||i+1==x5||i-1==x5)&&(i==x3||i+1==x3||i-1==x3))
                            else if ((i != x4 - 1 && i != x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x4||i-1==x4)&&(i==x3||i+1==x3||i-1==x3)&&(i==x5||i+1==x5||i-1==x5))
                            else if ((i == x4 - 1 || i == x4 + 1) && (i == x3 || i == (x3 - 1) || i == (x3 + 1)) && (i == x5 || i == (x5 - 1) || i == (x5 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 4) {
//                    if(i+1==x5||i-1==x5)
                            if ((i == x5 - 1 || i == x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if(i==x4||i+1==x4||i-1==x4)
                            else if ((i != x5 - 1 && i != x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x6||i+1==x6||i-1==x6)
                            else if ((i != x5 - 1 && i != x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x5||i-1==x5)&&(i==x4||i+1==x4||i-1==x4))
                            else if ((i == x5 - 1 || i == x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i != x6 && i != (x6 - 1) && i != (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x5||i-1==x5)&&(i==x6||i+1==x6||i-1==x6))
                            else if ((i == x5 - 1 || i == x5 + 1) && (i != x4 && i != (x4 - 1) && i != (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x6||i+1==x6||i-1==x6)&&(i==x4||i+1==x4||i-1==x4))
                            else if ((i != x5 - 1 && i != x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x5||i-1==x5)&&(i==x4||i+1==x4||i-1==x4)&&(i==x6||i+1==x6||i-1==x6))
                            else if ((i == x5 - 1 || i == x5 + 1) && (i == x4 || i == (x4 - 1) || i == (x4 + 1)) && (i == x6 || i == (x6 - 1) || i == (x6 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 5) {
//                    if(i+1==x6||i-1==x6)
                            if ((i == x6 - 1 || i == x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if(i==x5||i+1==x5||i-1==x5)
                            else if ((i != x6 - 1 && i != x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x7||i+1==x7||i-1==x7)
                            else if ((i != x6 - 1 && i != x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x6||i-1==x6)&&(i==x5||i+1==x5||i-1==x5))
                            else if ((i == x6 - 1 || i == x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i != x7 && i != (x7 - 1) && i != (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x6||i-1==x6)&&(i==x7||i+1==x7||i-1==x7))
                            else if ((i == x6 - 1 || i == x6 + 1) && (i != x5 && i != (x5 - 1) && i != (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x7||i+1==x7||i-1==x7)&&(i==x5||i+1==x5||i-1==x5))
                            else if ((i != x6 - 1 && i != x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x6||i-1==x6)&&(i==x5||i+1==x5||i-1==x5)&&(i==x7||i+1==x7||i-1==x7))
                            else if ((i == x6 - 1 || i == x6 + 1) && (i == x5 || i == (x5 - 1) || i == (x5 + 1)) && (i == x7 || i == (x7 - 1) || i == (x7 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 6) {
//                    if(i+1==x7||i-1==x7)
                            if ((i == x7 - 1 || i == x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }

//                    else if(i==x6||i+1==x6||i-1==x6)
                            else if ((i != x7 - 1 && i != x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if(i==x8||i+1==x8||i-1==x8)
                            else if ((i != x7 - 1 && i != x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x7||i-1==x7)&&(i==x6||i+1==x6||i-1==x6))
                            else if ((i == x7 - 1 || i == x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i != x8 && i != (x8 - 1) && i != (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x7||i-1==x7)&&(i==x8||i+1==x8||i-1==x8))
                            else if ((i == x7 - 1 || i == x7 + 1) && (i != x6 && i != (x6 - 1) && i != (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i==x8||i+1==x8||i-1==x8)&&(i==x6||i+1==x6||i-1==x6))
                            else if ((i != x7 - 1 && i != x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
//                    else if((i+1==x7||i-1==x7)&&(i==x6||i+1==x6||i-1==x6)&&(i==x8||i+1==x8||i-1==x8))
                            else if ((i == x7 - 1 || i == x7 + 1) && (i == x6 || i == (x6 - 1) || i == (x6 + 1)) && (i == x8 || i == (x8 - 1) || i == (x8 + 1))) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("3", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        } else if (j == 7) {
                            if ((i == x8 - 1 || i == x8 + 1) && (i != x7 && i != x7 - 1 && i != x7 + 1)) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else if ((i == x7 || i + 1 == x7 || i - 1 == x7) && (i != x8 - 1 && i != x8 + 1)) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("1", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else if ((i + 1 == x8 || i - 1 == x8) && (i == x7 || i + 1 == x7 || i - 1 == x7)) {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("2", i * cellWidth, (j + 1) * cellWidth, paint);
                            } else {
                                cp++;
                                paint.setColor(Color.BLACK);
                                paint.setTextSize(100);
                                canvas.drawText("0", i * cellWidth, (j + 1) * cellWidth, paint);
                            }
                        }

                    }

                }


            }
        }
    }

        paint.setColor(Color.BLACK);

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, width, paint);
        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellWidth, width, i * cellWidth, paint);
        }
        if(am==55 && count==0)

        {
//            T.cancel();
            Toast.makeText(context, "Wait for 5 seconds", Toast.LENGTH_SHORT).show();
            String s2 = Integer.toString(am);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i2 = new Intent(context, MainActivity7.class);
                    String s1 = "CONGRATULATIONS!! YOU WON";
                    i2.putExtra("msg", s1);
                    i2.putExtra("tame", s2);
                    i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i2);
                }
            }, 5000);

        }
        decor.setColor(Color.GRAY);
        canvas.drawRect(0,8*cellWidth,width,height,decor);
        decor.setColor(Color.BLACK);
        decor.setTextSize(95);
        canvas.drawText("MINESWEEPER",cellWidth/2,height-cellWidth,decor);
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int column = (int)(event.getX() / cellWidth);
            int row = (int)(event.getY() / cellWidth);

            cellChecked[column][row] = !cellChecked[column][row];
            invalidate();
        }

        return true;
    }

    public static void vibrateDevice(Context mContext)
    {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
        Toast.makeText(mContext, "Wait for 5 seconds", Toast.LENGTH_SHORT).show();
    }


}



