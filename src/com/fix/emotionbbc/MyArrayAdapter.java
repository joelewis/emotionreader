package com.fix.emotionbbc;


import java.util.ArrayList;

import com.fix.emotionbbc.R;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

public class MyArrayAdapter extends ArrayAdapter {

	private int[] colors = new int[] { Color.WHITE, 0x30aaaaaa };
	private int[] dotColors = new int[7];
    private ArrayList<String> itemstitle;
    private ArrayList<String> itemsdescription;
    private ArrayList<Uri> itemslink;
  
    
public MyArrayAdapter(Context context, ArrayList<String> content1, ArrayList<String> content2) {
    super(context, R.layout.two_line_list_view, R.id.text1, content1);
    itemstitle = content1;
    itemsdescription = content2;
}

public MyArrayAdapter(Context context, ArrayList<String> content1, ArrayList<String> content2, ArrayList<Uri> content3) {
    super(context, R.layout.two_line_list_view, R.id.text1, content1);
    itemstitle = content1;
    itemsdescription = content2;
    itemslink = content3;
}
 
public Uri getlink(int position) {
	Uri url = itemslink.get(position);
	return url;
}




@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = super.getView(position, convertView, parent);

    TwoLineListItem tlli = (TwoLineListItem)v;
    TextView tv1 = (TextView) v.findViewById(R.id.text1);
    TextView tv2 = (TextView) v.findViewById(R.id.text2);
    tv1.setText(itemstitle.get(position));
    tv1.setText(itemsdescription.get(position));
    int colorPos = position % colors.length;
    tlli.setBackgroundColor(colors[colorPos]);
    return tlli;
}


}