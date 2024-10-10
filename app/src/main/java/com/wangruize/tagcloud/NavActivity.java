package com.wangruize.tagcloud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        // 获取按钮
        Button goToMainButton = findViewById(R.id.go_to_main_button);
        Button goToSecondButton = findViewById(R.id.go_to_second_button);

        // 设置按钮点击事件
        goToMainButton.setOnClickListener(v -> {
            // 跳转到 MainActivity
            Intent intent = new Intent(NavActivity.this, MainActivity.class);
            startActivity(intent);
        });

        goToSecondButton.setOnClickListener(v -> {
            // 跳转到 SecondActivity
            Intent intent = new Intent(NavActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}
