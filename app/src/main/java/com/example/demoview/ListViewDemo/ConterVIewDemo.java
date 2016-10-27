package com.example.demoview.ListViewDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demoview.ListViewDemo.adapter.MyAdapter;
import com.example.demoview.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by：赖上罗小贱 on 2016/10/26
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class ConterVIewDemo extends AppCompatActivity{
    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conterview_activity);

        lv = (ListView) findViewById(R.id.listView1);
        /*定义一个以HashMap为内容的动态数组*/
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();/*在数组中存放数据*/
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.ic_launcher);//加入图片
            map.put("ItemTitle", "第" + i + "行");
            map.put("ItemText", "这是第" + i + "行");
            listItem.add(map);
        }
        MyAdapter adapter = new MyAdapter(this, listItem);
        lv.setAdapter(adapter);//为ListView绑定适配器

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                System.out.println("你点击了第" + arg2 + "行");//设置系统输出点击的行
            }
        });

    }
}
