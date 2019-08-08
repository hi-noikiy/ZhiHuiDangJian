package com.lfc.zhihuidangjianapp.widget.sidebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.lfc.zhihuidangjianapp.R;


public class SideBar extends View {

    private Paint paint = new Paint();

    private boolean showBackground;

    private int textColor = Color.parseColor("#000000");

    private float textSize = 12;

    public static String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};

    private OnChooseLetterChangedListener onChooseLetterChangedListener;

    public SideBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public SideBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SideBar);
        textColor = a.getColor(R.styleable.SideBar_textColor, 0x000000);
        textSize = a.getDimension(R.styleable.SideBar_textSize, 12);
    }

    public SideBar(Context context) {
        this(context, null);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBackground) {
            // 字母条背后颜色
            canvas.drawColor(Color.parseColor("#BFBFBF"));
        }
        int height = getHeight();
        int width = getWidth();
        // 平均每个字母占的高度
        int singleHeight = height / letters.length;
        for (int i = 0; i < letters.length; i++) {
            // 字母的颜色
            paint.setColor(textColor);
            paint.setAntiAlias(true);
            paint.setTextSize(textSize);
            float x = width / 2 - paint.measureText(letters[i]) / 2;
            float y = singleHeight * i + singleHeight;
            canvas.drawText(letters[i], x, y, paint);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float y = event.getY();
        int c = (int) (y / getHeight() * letters.length);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBackground = true;
                if (c > -1 && c < letters.length && onChooseLetterChangedListener != null) {
                    onChooseLetterChangedListener.onChooseLetter(letters[c]);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                if (c > -1 && c < letters.length && onChooseLetterChangedListener != null) {
                    onChooseLetterChangedListener.onChooseLetter(letters[c]);
                }
                break;
            case MotionEvent.ACTION_UP:
                showBackground = false;
                if (onChooseLetterChangedListener != null) {
                    onChooseLetterChangedListener.onNoChooseLetter();
                }
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnTouchingLetterChangedListener(OnChooseLetterChangedListener onChooseLetterChangedListener) {
        this.onChooseLetterChangedListener = onChooseLetterChangedListener;
    }

    public interface OnChooseLetterChangedListener {

        void onChooseLetter(String s);

        void onNoChooseLetter();

    }

}
