package com.example.liufan.xiangmu.util;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liufan on 2018/4/24.
 */

public class RetrofitUtil {
    private static RetrofitUtil RETROFIT_UTILS = null;

    private RetrofitUtil() {
    }

    public static RetrofitUtil getInData() {
        if (RETROFIT_UTILS == null){
            synchronized (RetrofitUtil.class){
                if (RETROFIT_UTILS == null){
                    RETROFIT_UTILS = new RetrofitUtil();
                }
            }
        }
        return RETROFIT_UTILS;
    }

    public <T> T getRetrofit(String path,Class<T> cla){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("TAG",message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new MyInter())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        T t = retrofit.create(cla);
        return t;
    }

    	//拦截器
    	class MyInter implements Interceptor {
    		private static final String TAG = "MyInter";
    		@Override
    		public Response intercept(Chain chain) throws IOException {
    			//获取原来的body
    			Request request = chain.request();
    			RequestBody body = request.body();
    			if (body instanceof FormBody) {
    				//遍历原来的所有参数，加到新的Body里面，最后将公共参数加到新的Body
    				FormBody.Builder newBuilder = new FormBody.Builder();
    				for (int i = 0; i < ((FormBody) body).size(); i++) {
    					String name = ((FormBody) body).name(i);
    					String value = ((FormBody) body).value(i);

    					//放入新的
    					newBuilder.add(name, value);
    				}
    				//在将公共参数添加进去
    				newBuilder.add("source", "android");
    				FormBody newBody = newBuilder.build();
    				//创建新的请求
    				Request newRequest = request.newBuilder().post(newBody).build();
    				Response response = chain.proceed(newRequest);
    				return response;
    			}

    			return null;
    		}
    	}

}
