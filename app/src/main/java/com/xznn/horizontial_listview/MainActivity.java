package com.xznn.horizontial_listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

// 给 Android 开发者的 RxJava 详解 -
// http://gank.io/post/560e15be2dca930e00da1083#toc_1

public class MainActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.listviewdemo);
//
////        HorizontialListView listview = (HorizontialListView) findViewById(R.id.listview);
//        ListView listview = (ListView) findViewById(R.id.listview);
//        listview.setAdapter(mAdapter);
//
//    }
//
    private static String[] dataObjects = new String[]{ "Text #1",
            "Text #2",
            "Text #3",
            "Text #4",
            "Text #5",
    };

    private BaseAdapter mAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return dataObjects.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewitem, null);
            TextView title = (TextView) retval.findViewById(R.id.title);
            title.setText(dataObjects[position]);

            return retval;
        }

    };


//    private ListView lv;
//    private List<String> items=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewdemo);
        GridView gridView=(GridView) findViewById(R.id.listview);
        gridView.setAdapter(mAdapter);

        //-----------
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int allWidth = (int) (210 * 5 * density);
        int itemWidth = (int) (200 * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                allWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gridView.setLayoutParams(params);
        gridView.setColumnWidth(itemWidth);
        gridView.setHorizontalSpacing(10);
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(5);
        //-----------
    }
//
//    class MyAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return items.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//        LayoutInflater inflater=LayoutInflater.from(FirstListView.this);
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view=null;
//            if (convertView==null) {
//                view=inflater.inflate(R.layout.listformat, null);
//            }else {
//                view=convertView;
//            }
//            TextView tv1=(TextView)view.findViewById(R.id.textView1);
//            TextView tv2=(TextView)view.findViewById(R.id.textView2);
//            TextView tv3=(TextView)view.findViewById(R.id.textView3);
//            tv1.setText(items.get(position));
//            tv2.setText(items.get(position));
//            tv3.setText(items.get(position));
//            return view;
//        }
//
//    }
}
