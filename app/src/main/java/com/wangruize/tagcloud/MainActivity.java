package com.wangruize.tagcloud;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        EditText tagText = findViewById(R.id.tag_input);
        findViewById(R.id.add_tag_button).setOnClickListener(v -> addTag(tagText));

    }

    private void addTag(TextView tagText) {
        // 使用 LayoutInflater 加载自定义的标签布局
        View tagView = LayoutInflater.from(this).inflate(R.layout.tag_item, tagLayout, false);

        // 设置标签文本
        TextView tagTextView = tagView.findViewById(R.id.tag_text);
        String tag = tagText.getText().toString();
        if (!tag.isEmpty() && tag.length() < 10) {
            tagTextView.setText(tag);
        }else{
            if (tag.length() >= 10){
                Toast.makeText(this, "标签过长，请控制在10个字以内", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        // 设置删除按钮的点击事件
        ImageView deleteButton = tagView.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(v -> tagLayout.removeView(tagView));

        // 将标签添加到 TagLayout 中
        tagLayout.addView(tagView);
        tagText.setText("");
    }
}