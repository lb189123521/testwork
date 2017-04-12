package learn.cn.com.happytolearn.ui.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import learn.cn.com.happytolearn.R;

public class HomeGridAdapter extends BaseAdapter{

    Context context;
   // List<Map<String, String>> data;
    List<String> data;
    ViewHolder holder;
    public HomeGridAdapter(Context context, List<String> list) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(view==null){
            holder=new ViewHolder();
            view=LayoutInflater.from(context).inflate(R.layout.adapter_home, null);
           // holder.order_bt=(TextView) view.findViewById(R.id.order_bt);

            view.setTag(holder);
        }else{
            holder=(ViewHolder) view.getTag();
        }

      //  holder.order_bt.setText(data.get(position).get("name"));

        return view;

    }



    public static class ViewHolder{
        TextView order_bt;

    }

}
