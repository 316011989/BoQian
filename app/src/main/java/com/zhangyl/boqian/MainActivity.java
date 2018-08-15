package com.zhangyl.boqian;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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
        verifyStoragePermissions();
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

    /**
     *
     */
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};


    public void verifyStoragePermissions() {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(this,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
