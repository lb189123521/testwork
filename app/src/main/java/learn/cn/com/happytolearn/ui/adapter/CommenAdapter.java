package learn.cn.com.happytolearn.ui.adapter;

import java.util.List;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommenAdapter<T> extends BaseAdapter {
	protected Context context;
	protected List<T> mdatas;
	protected LayoutInflater minflarter;
	protected int Layoutid;
	public CommenAdapter(Context context,List<T> datas,int Layoutid) {
		this.context=context;
		minflarter = LayoutInflater.from(context);
		this.mdatas = datas;
		this.Layoutid = Layoutid;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mdatas.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		return mdatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public  View getView(int position, View convertView, ViewGroup parent){
		
	ViewHolder holder= ViewHolder.get(context, convertView, parent, Layoutid, position);
		
	convert(holder,getItem(position));
		Log.i("LIBO", ""+getItem(position));

		return holder.getConvertView();
		
		}
	public abstract void convert(ViewHolder holder,T t );

}
