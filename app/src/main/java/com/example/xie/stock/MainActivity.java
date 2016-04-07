package com.example.xie.stock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.xie.stock.entity.Klist;
import com.example.xie.stock.entity.Stocklist;
import com.example.xie.stock.uitls.DataTools;
import com.example.xie.stock.uitls.StockAdapter;
import com.example.xie.stock.uitls.StockDataPath;

import java.util.ArrayList;

public class MainActivity extends Activity implements ListView.OnItemClickListener {
    private RelativeLayout rl;
    private ListView listView;
   private ArrayList<Stocklist> datas  = new ArrayList<>();
    private ArrayList<Stocklist> tmp;
    private StockAdapter adapter;

    private TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHeadView();
        handerGetData();
        //inputStream = getInputStreamByUrl("http://192.168.1.83:8086/klinedata.xml");
        // datas = ParserByPull.getGuPiaoBeansByInputStream(inputStream);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
        listView.setOnItemClickListener(this);
        adapter = new StockAdapter(MainActivity.this, datas,rl, R.layout.item);
        listView.setAdapter(adapter);
    }

    public void handerGetData() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            Stocklist klist = new Stocklist();
            klist.setOpen(2);
            klist.setLow(1);
            klist.setHigh(6);
            klist.setAmount(10);
            klist.setCode("86");
            klist.setPreClose(11);
            klist.setPrice(11);
            datas.add(klist);
        }

//        adapter.notifyDataSetChanged();
        /*final Handler mHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                datas.clear();
                datas.addAll(tmp);
                adapter.notifyDataSetChanged();
            }
        };
        new Thread() {
            @Override
            public void run() {
                try {
                    tmp = DataTools.getDatas(StockDataPath.STOCK_PATH);
                    mHandler.sendEmptyMessage(1);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();*/
    }


    class ListViewAndHeadViewTouchLinstener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            HorizontalScrollView headSrcrollView = (HorizontalScrollView) rl
                    .findViewById(R.id.horizontalScrollView1);
            headSrcrollView.onTouchEvent(arg1);
            return false;
        }
    }
    private void initHeadView() {
        listView=(ListView)findViewById(R.id.listView1);
        rl = (RelativeLayout) findViewById(R.id.rl);
        tv = (TextView) (rl.findViewById(R.id.textView));
        tv1 = (TextView) (rl.findViewById(R.id.textView1));
        tv2 = (TextView) (rl.findViewById(R.id.textView2));
        tv3 = (TextView) (rl.findViewById(R.id.textView3));
        tv4 = (TextView) (rl.findViewById(R.id.textView4));
        tv5 = (TextView) (rl.findViewById(R.id.textView5));
        tv6 = (TextView) (rl.findViewById(R.id.textView6));
        tv7 = (TextView) (rl.findViewById(R.id.textView7));
        tv8 = (TextView) (rl.findViewById(R.id.textView8));
        tv9 = (TextView) (rl.findViewById(R.id.textView9));
        tv10 = (TextView) (rl.findViewById(R.id.textView10));
        tv.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv1.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv2.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv3.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv4.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv5.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv6.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv7.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv8.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv9.setTextColor(getResources().getColor(R.color.white_ffffff));
        tv10.setTextColor(getResources().getColor(R.color.white_ffffff));
        rl.setFocusable(true);
        rl.setClickable(true);
        rl.setBackgroundColor(getResources().getColor(R.color.black_000000));
        rl.setOnTouchListener(new ListViewAndHeadViewTouchLinstener());
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}