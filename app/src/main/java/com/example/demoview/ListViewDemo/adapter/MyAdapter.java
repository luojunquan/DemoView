package com.example.demoview.ListViewDemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoview.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by：赖上罗小贱 on 2016/10/26
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private LayoutInflater inflater;
    ArrayList<HashMap<String,Object>> listItem;
    public MyAdapter(Context context,ArrayList<HashMap<String, Object>> listItem) {
        this.inflater = LayoutInflater.from(context);
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_conterview_activity,null);
            holder.img = (ImageView) convertView.findViewById(R.id.ItemImage);
            holder.title = (TextView)convertView.findViewById(R.id.ItemTitle);
            holder.text = (TextView)convertView.findViewById(R.id.ItemText);
            holder.btn = (Button) convertView.findViewById(R.id.ItemBottom);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setImageResource((Integer) listItem.get(position).get("ItemImage"));
        holder.title.setText((String) listItem.get(position).get("ItemTitle"));
        holder.text.setText((String) listItem.get(position).get("ItemText"));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("你点击了选项"+position);//bottom会覆盖item的焦点，所以要在xml里面配置android:focusable="false"
//                Toast.makeText(RecyclewAdapter.this, "click " + position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    static class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView text;
        public Button btn;
    }
}
