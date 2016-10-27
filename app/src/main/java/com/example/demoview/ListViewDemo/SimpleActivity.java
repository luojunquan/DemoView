package com.example.demoview.ListViewDemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.demoview.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ListView 的SimpleAdapter的Demo
 * Created by：赖上罗小贱 on 2016/10/26
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class SimpleActivity extends AppCompatActivity{
    //定义数组以填充数据
    private String[] name=new String[]{
            "威龙注塑机","霸龙注塑机","恐龙注塑机"    };
    private String[] address =new String[]{
            "广东","北京","黑龙江"    };
    private int[] lowerest_wholesale =new int[]{
            11,22,33    };
    private int[] price =new int[]{
            11,22,33    };
    private int[] picture =new int[]{
            R.drawable.one,
            R.drawable.two,
            R.drawable.three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//定义一个HashMap构成的列表以键值对的方式存放数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
//循环填充数据
        for(int i=0;i<name.length;i++)        {
            HashMap<String,Object> map = new HashMap<String,Object>();
            map.put("name", name[i]);
            map.put("address", address[i]);
            map.put("lowerest_wholesale", lowerest_wholesale[i]);
            map.put("price", price[i]);
            map.put("picture", picture[i]);
            listItem.add(map);
        }

//构造SimpleAdapter对象，设置适配器
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,
                listItem,//需要绑定的数据
                R.layout.item_simple_activity,//每一行的布局
                new String[] {"name","address", "lowerest_wholesale","price","picture"},
//数组中的数据源的键对应到定义布局的View中
                new int[] {R.id.name,R.id.address,R.id.lowerest_wholesale,R.id.price,R.id.picture});
        ListView list= (ListView) findViewById(R.id.list_item);
//为ListView绑定适配器
        list.setAdapter(mSimpleAdapter);
    }
}
