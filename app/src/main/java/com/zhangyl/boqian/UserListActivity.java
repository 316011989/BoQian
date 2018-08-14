package com.zhangyl.boqian;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class UserListActivity extends Activity {
    private static Drawable sBackground;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            ImageView iv = new ImageView(this);
            if (sBackground == null) {
                sBackground = getResources().getDrawable(R.drawable.ic_launcher_background);
            }
            iv.setImageDrawable(sBackground);
            setContentView(iv);
            String usersJson = getSharedPreferences("userlist",
                    Context.MODE_PRIVATE).getString("users", null);
            List<User> users = JSON.parseArray(usersJson, User.class);
            //沒有判空
        if ( users != null)
            Toast.makeText(this, "user count is " + users.size(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "users为空" , Toast.LENGTH_SHORT).show();
    }
}

