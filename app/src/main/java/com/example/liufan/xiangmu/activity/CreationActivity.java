package com.example.liufan.xiangmu.activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liufan.xiangmu.MainActivity;
import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.baes.BaesActivity;

/**+
 * 这是创作的Activity
 */

public class CreationActivity extends BaesActivity implements View.OnClickListener{


    private TextView qx_te;
    private ImageView wenb_iv;
    private ImageView ship_iv;

    @Override
    public int getlayout() {
        return R.layout.activity_creation;
    }

    @Override
    public void getinit() {
        ship_iv = findViewById(R.id.ship_iv);
        ship_iv.setOnClickListener(this);
        wenb_iv = findViewById(R.id.wenb_iv);
        wenb_iv.setOnClickListener(this);
        qx_te = findViewById(R.id.qx_te);
        qx_te.setOnClickListener(this);
    }

    @Override
    public void getdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //跳转到视频的点击事件
            case R.id.ship_iv:
                break;
            //跳转到段子的点击事件
            case R.id.wenb_iv:
                break;
                //回退到上一个页面
            case R.id.qx_te:
                Intent intent = new Intent (CreationActivity.this, MainActivity.class);
                startActivity (intent);
                break;

        }
    }
}
