package com.wangruize.tagcloud;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TagLayout tagLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tagLayout = findViewById(R.id.tag_layout);

        // 动态添加标签
        findViewById(R.id.add_tag_button).setOnClickListener(v -> {
            TextView tag = new TextView(this);
            tag.setText("标签 " + (tagLayout.getChildCount() + 1));
            tag.setPadding(16, 8, 16, 8);
            tag.setBackgroundResource(R.drawable.tag_background); // 设置标签样式
            tagLayout.addView(tag);
        });

        // 动态删除最后一个标签
        findViewById(R.id.remove_tag_button).setOnClickListener(v -> {
            int count = tagLayout.getChildCount();
            if (count > 0) {
                tagLayout.removeViewAt(count - 1);
            }
        });
    }
}