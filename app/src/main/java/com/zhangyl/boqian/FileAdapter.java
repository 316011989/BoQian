package com.zhangyl.boqian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;

public class FileAdapter extends BaseAdapter {
    private Context context;
    private File[] allFiles;

    FileAdapter(Context context) {
        this.context = context;
    }

    public void setData(File[] allFiles) {
        this.allFiles = allFiles;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return allFiles != null ? allFiles.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_filelist, null);
        TextView filename = convertView.findViewById(R.id.item_filename);
        TextView filesize = convertView.findViewById(R.id.item_filesize);
        File file = allFiles[position];
        filename.setText(file.getName());
        if (file.isDirectory())
            filesize.setVisibility(View.INVISIBLE);
        else
            filesize.setText(file.length() + "B");

        return convertView;
    }
}
