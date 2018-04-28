package com.example.liufan.xiangmu.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liufan.xiangmu.MainActivity;
import com.example.liufan.xiangmu.R;
import com.example.liufan.xiangmu.api.API;
import com.example.liufan.xiangmu.baes.BaesActivity;
import com.example.liufan.xiangmu.bean.Publishan;
import com.example.liufan.xiangmu.bean.RegisterBean;
import com.example.liufan.xiangmu.qita.modle.IModle;
import com.example.liufan.xiangmu.qita.presenter.IPresenter;
import com.example.liufan.xiangmu.qita.view.PuilshanrView;
import com.yongchun.library.view.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class PublishanarticleActivity extends BaesActivity implements View.OnClickListener, PuilshanrView {

    private TextView qx_te;
    private TextView fb_tb;
    private EditText cz_ed;
    private ImageView cz_tianjia;
    List<ImageView> imas = new ArrayList<>();
    private PopupWindow popupWindow;
    private boolean bo;
    private ArrayList<String> images;
    private String token1;
    private int uid1;
    private String token;
    private List<MultipartBody.Part> listParts;
    private String string;
    private boolean boo;
    private int uid;


    @Override
    public int getlayout() {
        return R.layout.activity_publishanarticle;
    }

    @Override
    public void getinit() {
        qx_te = findViewById(R.id.qx_te);
        qx_te.setOnClickListener(this);
        fb_tb = findViewById(R.id.fb_tb);
        fb_tb.setOnClickListener(this);
        cz_ed = findViewById(R.id.cz_ed);
        cz_tianjia = findViewById(R.id.cz_tianjia);
        cz_tianjia.setOnClickListener(this);
        ImageView tj_iv = findViewById(R.id.tj_iv);
        ImageView tj_iv1 = findViewById(R.id.tj_iv1);
        ImageView tj_iv2 = findViewById(R.id.tj_iv2);
        ImageView tj_iv3 = findViewById(R.id.tj_iv3);
        imas.add(tj_iv);
        imas.add(tj_iv1);
        imas.add(tj_iv2);
        imas.add(tj_iv3);
    }

    @Override
    public void getdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //取消的点击事件
            case R.id.qx_te:
                finish();
                break;
            //发表的点击事件
            case R.id.fb_tb:
                muPush();
                break;
            //添加图片的点击事件
            case R.id.cz_tianjia:
                SharedPreferences user = getSharedPreferences("USER", Context.MODE_PRIVATE);
                boolean bo = user.getBoolean("bo", boo);
                if (bo == true) {
                    uid = user.getInt("uid", uid1);
                    token = user.getString("token", token1);
                    View view = View.inflate(PublishanarticleActivity.this, R.layout.popupwindow, null);
                    popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
                    popupWindow.setOutsideTouchable(true);
                    //显示在底部  main为activity_main布局控件中 最大的LinearLayout 的id
                    popupWindow.showAtLocation(this.findViewById(R.id.main),
                            Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    Button bt = view.findViewById(R.id.bt);
                    Button bt1 = view.findViewById(R.id.bt1);
                    Button bt2 = view.findViewById(R.id.bt2);
                    bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent2.putExtra(MediaStore.EXTRA_OUTPUT,
                                    Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                            startActivityForResult(intent2, 2);// 采用ForResult打开
                            popupWindow.dismiss();
                        }
                    });
                    bt1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageSelectorActivity.start(PublishanarticleActivity.this, 5, ImageSelectorActivity.MODE_MULTIPLE, true, true, true);
                            Intent intent = new Intent(Intent.ACTION_PICK);
                            intent.setType("image/*");
                            startActivityForResult(intent, 1);
                            popupWindow.dismiss();
                        }
                    });
                    bt2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });
                } else {

                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == ImageSelectorActivity.REQUEST_IMAGE) {
            images = (ArrayList<String>) data.getSerializableExtra(ImageSelectorActivity.REQUEST_OUTPUT);
            //把图片展示在界面
            for (int i = 0; i < images.size(); i++) {
                Bitmap bitmap = BitmapFactory.decodeFile(images.get(i));
                imas.get(i).setImageBitmap(bitmap);
            }
//            startActivity(new Intent(this,SelectResultActivity.class).putExtra(SelectResultActivity.EXTRA_IMAGES,images));
        }
    }

    //发布的方法
    private void muPush() {
        string = cz_ed.getText().toString();
        //判断文本内容不能为空
        if (!"".equals(string) & null != string) {
            //判断文件是否为空
            if (images.size() <= 0) {
                Toast.makeText(this, "请选择上传文件", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "选择了图片文件", Toast.LENGTH_SHORT).show();
                listParts = new ArrayList<>();
                //通过file对象创建一个请求
                for (int i = 0; i < images.size(); i++) {
                    String path = images.get(i);
                    File file = new File(path);
                    RequestBody requestFile = RequestBody.create(MediaType.parse("application/otcet-stream"), file);
                    //通过请求体对象 构建MultipartBody.Part对象
                    //"file" 接口里面参数的名
                    MultipartBody.Part part = MultipartBody.Part.createFormData("jokeFiles", file.getName(), requestFile);
                    listParts.add(part);
                }
                IPresenter iPresenter = new IPresenter();
                iPresenter.Publishanarticle(new IModle(), API.Url, uid + "", string, token, listParts, this);
            }
        } else {
            //提示用户
            Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void PuilshanError(String ss) {

    }

    @Override
    public void PuilshanSuccess(Publishan publishan) {
        Toast.makeText(PublishanarticleActivity.this, "上传成功", Toast.LENGTH_LONG).show();
    }
}
