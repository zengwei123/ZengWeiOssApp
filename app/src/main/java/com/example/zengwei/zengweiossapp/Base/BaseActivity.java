package com.example.zengwei.zengweiossapp.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.zengwei.zengweiossapp.Util.ZengBind;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengwei on 2018/11/12.
 * ???
 */

public abstract class BaseActivity extends AppCompatActivity{
    public static List<BaseActivity> baseActivities;
    /**初始化控件方法**/
    public abstract void initViews();
    public abstract void initClass();

    /**添加activity**/
    public void  addActivity(BaseActivity baseActivity){
        if (baseActivities==null){
            baseActivities=new ArrayList<>();
        }
        baseActivities.add(baseActivity);
    }
    /**g关闭所有Activity**/
    public void finisAll(){
        for (BaseActivity baseActivity:baseActivities){
            if(baseActivity!=null){
                baseActivity.finish();
            }
        }
    }
    /**activityt跳转方法**/
    public void startActivity(Class<?> tClass, Bundle bundle){
        Intent intent = new Intent(this, tClass);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivity(intent);
    }
    /**activity跳转方法接受返回值**/
    public void openActivityForResult(Class<?> openClass, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, openClass);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }
    /**返回上一个页面**/
    public void setResultOk(int requestCode,Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) ;
        intent.putExtras(bundle);
        setResult(requestCode, intent);
        finish();
    }
    /**Toast方法**/
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void showSnackbar(String msg, String butStr, View view, boolean isbut, View.OnClickListener onClickListener){
        if(isbut){
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
        }else{
            Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).setAction(butStr,onClickListener).show();
        }
    }
    /**控件绑定**/
    public void injectViews(){
        Field[] fields=this.getClass().getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(ZengBind.class)) {
                ZengBind inject=field.getAnnotation(ZengBind.class);
                int id = inject.value();
                if (id>0){
                    field.setAccessible(true);
                    try {
                        field.set(this,this.findViewById(id));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
