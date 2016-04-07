package com.example.xie.stock.uitls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xie.stock.R;
import com.example.xie.stock.entity.Stocklist;
import com.example.xie.stock.view.MyHScrollView;

import java.util.ArrayList;
import java.util.List;


public class StockAdapter extends BaseAdapter {
    private Context context;
    private List<Stocklist> list;
    private int row_layout;
    private RelativeLayout rl;

    public StockAdapter(Context context, List<Stocklist> list,RelativeLayout rl, int row_layout) {
        this.context = context;
        this.list = list;
        this.row_layout = row_layout;
        this.rl=rl;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int location) {
        return list.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        ViewHolder viewholder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(row_layout, null);
            viewholder = new ViewHolder();
            MyHScrollView scrollView1 = (MyHScrollView) convertView
                    .findViewById(R.id.horizontalScrollView1);
            viewholder.scrollView = scrollView1;
            viewholder.tv = (TextView) convertView
                    .findViewById(R.id.textView);
            viewholder.tv1 = (TextView) convertView
                    .findViewById(R.id.textView1);
            viewholder.tv2 = (TextView) convertView
                    .findViewById(R.id.textView2);
            viewholder.tv3 = (TextView) convertView
                    .findViewById(R.id.textView3);
            viewholder.tv4 = (TextView) convertView
                    .findViewById(R.id.textView4);
            viewholder.tv5 = (TextView) convertView
                    .findViewById(R.id.textView5);
            viewholder.tv6 = (TextView) convertView
                    .findViewById(R.id.textView6);
            viewholder.tv7 = (TextView) convertView
                    .findViewById(R.id.textView7);
            viewholder.tv8 = (TextView) convertView
                    .findViewById(R.id.textView8);
            viewholder.tv9 = (TextView) convertView
                    .findViewById(R.id.textView9);
            viewholder.tv10 = (TextView) convertView
                    .findViewById(R.id.textView10);

            MyHScrollView headSrcrollView =
                    (MyHScrollView) rl.findViewById(R.id.horizontalScrollView1);
            headSrcrollView.AddOnScrollChangedListener(new OnScrollChangedListenerImp(scrollView1));
            convertView.setTag(viewholder);

        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        viewholder.tv.setText(list.get(position).getCode());
        viewholder.tv.setVisibility(View.VISIBLE);
        viewholder.tv1.setText(list.get(position).getName());
        viewholder.tv2.setText(list.get(position).getPrice() + "");
        viewholder.tv3.setText(list.get(position).getRate() + "%");
        viewholder.tv4.setText(list.get(position).getRise() + "");
        viewholder.tv5.setText(list.get(position).getPreClose() + "");
        viewholder.tv6.setText(list.get(position).getVol() + "");
        viewholder.tv7.setText(list.get(position).getAmount() + "");
        viewholder.tv8.setText(list.get(position).getOpen() + "");
        viewholder.tv9.setText(list.get(position).getHigh() + "");
        viewholder.tv10.setText(list.get(position).getLow() + "");
        return convertView;
    }

    class OnScrollChangedListenerImp implements MyHScrollView.OnScrollChangedListener {
        MyHScrollView mScrollViewArg;

        public OnScrollChangedListenerImp(MyHScrollView scrollViewar) {
            mScrollViewArg = scrollViewar;
        }

        @Override
        public void onScrollChanged(int l, int t, int oldl, int oldt) {
            mScrollViewArg.smoothScrollTo(l, t);
        }
    };

    private class ViewHolder {
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        TextView tv6;
        TextView tv7;
        TextView tv8;
        TextView tv9;
        TextView tv10;
        HorizontalScrollView scrollView;
    }
}
