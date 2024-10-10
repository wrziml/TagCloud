package com.wangruize.tagcloud;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private float dX, dY; // 记录手指与控件左上角的偏移量
    private float initialX, initialY; // 记录控件原始位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 获取可拖动的 View
        final ImageView draggableView = findViewById(R.id.draggable_view);

        // 设置触摸监听器
        draggableView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        // 记录按下时控件的初始位置
                        initialX = v.getX();
                        initialY = v.getY();

                        // 计算手指按下时，手指相对控件左上角的偏移量
                        dX = initialX - event.getRawX();
                        dY = initialY - event.getRawY();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        // 更新控件的位置
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY() + dY);
                        return true;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}
