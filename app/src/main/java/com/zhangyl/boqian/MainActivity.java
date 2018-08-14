package com.zhangyl.boqian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    MyQueue myQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_touserlist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //代码异常
                startActivity(new Intent(MainActivity.this, UserListActivity.class));
            }
        });
        findViewById(R.id.tv_queuetest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //堆栈队列测试
                testQueue();
            }
        });
        findViewById(R.id.tv_filelist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //文件管理,播放mp4，查看jpg，Caches folder
                startActivity(new Intent(MainActivity.this, FileListActivity.class));
            }
        });
    }

    /**
     * 堆栈队列测试
     */
    private void testQueue() {
        if (myQueue == null || myQueue.isEmpty()) {
            myQueue = new MyQueue();
            myQueue.push(1);
            myQueue.push(2);
            myQueue.push(3);
        }
        Toast.makeText(this, myQueue.pop() + "", Toast.LENGTH_SHORT).show();
    }
}
