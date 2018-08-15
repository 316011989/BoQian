package com.zhangyl.boqian;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class FileListActivity extends Activity {
    ListView filelist_lv;
    FileAdapter adapter;
    File[] allFiles;
    private String currentPath;
    private String parentPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filelist);
        filelist_lv = findViewById(R.id.filelist_lv);
        parentPath = Environment.getExternalStorageDirectory().getParent();
        currentPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        //listview顶部返回上一级
        TextView heaser = new TextView(this);
        heaser.setText("..");
        heaser.setPadding(50, 50, 50, 50);
        filelist_lv.addHeaderView(heaser);
        //调用打开文件夹,初始打开sd卡目录
        openDic();
        setClick();
    }

    /**
     * 打开文件夹
     */
    private void openDic() {
        File sdFile = new File(currentPath);
        if (sdFile.exists()) {
            if (sdFile.isDirectory()) {
                allFiles = sdFile.listFiles();
                if (adapter == null)
                    adapter = new FileAdapter(this);
                adapter.setData(allFiles);
                filelist_lv.setAdapter(adapter);
            }
        }
    }

    /**
     * item点击事件
     */
    private void setClick() {
        filelist_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //返回上一級
                if (position == 0) {
                    if (parentPath.equals(Environment.getExternalStorageDirectory().getParent()))
                        Toast.makeText(FileListActivity.this, "已到sd卡根目录", Toast.LENGTH_SHORT).show();
                    else {
                        currentPath = parentPath;
                        parentPath = new File(parentPath).getParent();
                        Toast.makeText(FileListActivity.this, "返回上一級", Toast.LENGTH_SHORT).show();
                        //切换列表
                        openDic();
                    }
                }
                //打开文件夹
                else if (allFiles[position - 1].isDirectory()) {
                    parentPath = currentPath;
                    currentPath = allFiles[position - 1].getAbsolutePath();
                    //切换列表
                    openDic();
                }
                //打开文件
                else {
                    openFile(allFiles[position - 1].getAbsolutePath());
                }
            }
        });
    }

    /**
     *
     */
    private void openFile(String filePath) {
        FileUtil.openFiles(this, filePath);
//        FileUtil.show(this, filePath);
    }
}
