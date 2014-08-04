package com.example.aomsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlternateOptionMenuAdapter extends BaseAdapter {

	private String[] mOptions;
	private int[] mOptionsIcon;
	private Context _context;
	
	public AlternateOptionMenuAdapter(Context ctx,String[] opt_list,int[] opt_icon_list) {
		this._context = ctx;
		this.mOptions = opt_list;
		this.mOptionsIcon = opt_icon_list;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mOptions.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rootView=null;
		LayoutInflater inflater = (LayoutInflater) _context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rootView = inflater.inflate(R.layout.option_menu, null);
		ImageView imgv = (ImageView)rootView.findViewById(R.id.option_icon);
		TextView tv  = (TextView)rootView.findViewById(R.id.option_text);
		tv.setText(mOptions[position]);
		if(position<mOptionsIcon.length)
			imgv.setImageDrawable(_context.getResources().getDrawable(mOptionsIcon[position]));
		return rootView;
	}

}
