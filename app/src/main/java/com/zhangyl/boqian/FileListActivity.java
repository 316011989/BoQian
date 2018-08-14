package com.zhangyl.boqian;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;

public class FileListActivity extends Activity {
    ListView filelist_lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filelist);
        filelist_lv = findViewById(R.id.filelist_lv);
        getSDFile();
    }

    /**
     *
     */
    private void getSDFile() {
        File sdFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (sdFile.exists()) {
            Toast.makeText(this, sdFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            if (sdFile.isDirectory()) {
                File[] allFiles = sdFile.listFiles();

            }
        }
    }
}
