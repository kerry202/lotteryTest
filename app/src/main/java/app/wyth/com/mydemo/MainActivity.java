package app.wyth.com.mydemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author yangbo
 *  @qq	903023560
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Info> ButtonName = new ArrayList<>();
    private ArrayList<Info> bule2 = new ArrayList<>();
    private Info info;
    private MYAdapter myAdapter;
    private RecyclerView red;
    private RecyclerView bule;
    private My2Adapter mya2dapter;
    private int conut = 0;
    private int conut2 = 0;
    private TextView select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDate();


    }


    private void initDate() {

        for (int i = 0; i < 36; i++) {
            info = new Info();
            info.text = i + 1 + "";
            info.color = true;
            ButtonName.add(info);
        }
        for (int i = 0; i < 16; i++) {
            info = new Info();
            info.text = i + 1 + "";
            info.color = true;
            bule2.add(info);
        }


        myAdapter = new MYAdapter(ButtonName);
        mya2dapter = new My2Adapter(this, bule2);


        red.setAdapter(myAdapter);

        bule.setAdapter(mya2dapter);

        findViewById(R.id.ttt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> list = RandomUtils.creatRandom();
               ArrayList<String> list2 = RandomUtils.creatRandom2();

                for (int i1 = 0; i1 < ButtonName.size(); i1++) {

                    Info info = ButtonName.get(i1);
                    info.color = true;

                    for (int i = 0; i < list.size(); i++) {
                        String text = info.text;
                        String s = list.get(i);
                        if (text.equals(s)) {
                            info.color = false;

                        }
                    }

                }

                for (int i1 = 0; i1 < bule2.size(); i1++) {

                    Info info = bule2.get(i1);
                    info.color = true;
                    for (int i = 0; i < list2.size(); i++) {
                        String text = info.text;
                        String s = list2.get(i);
                        if (text.equals(s)) {
                            info.color = false;

                        }
                    }

                }


                myAdapter.setNewData(ButtonName);

                mya2dapter.setNewData(bule2);
                conut=6;
                conut2=1;

                int c = MathC.number(conut, conut2);
                select.setText("已经选好" + c + "注");

            }
        });
    }

    @NonNull
    private void initView() {
        red = (RecyclerView) findViewById(R.id.red);
        bule = (RecyclerView) findViewById(R.id.bule);
        select = (TextView) findViewById(R.id.select);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);
        StaggeredGridLayoutManager staggeredGridLayou = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);

        red.setLayoutManager(staggeredGridLayoutManager);

        bule.setLayoutManager(staggeredGridLayou);
    }


    class MYAdapter extends BaseQuickAdapter<Info, BaseViewHolder> {


        public MYAdapter(ArrayList<Info> buttonName) {
            super(R.layout.adapter_layout, buttonName);
        }

        @Override
        protected void convert(BaseViewHolder helper, final Info item) {
            final TextView textView = helper.getView(R.id.t);

            helper.setText(R.id.t, item.text);

            if (item.color) {
                textView.setBackgroundResource(R.drawable.textview_style);
            } else {
                textView.setBackgroundResource(R.drawable.textview3_style);
            }

            helper.setOnClickListener(R.id.t, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (item.color) {
                        textView.setBackgroundResource(R.drawable.textview3_style);
                        item.color = false;
                        ++conut;
                    } else {
                        textView.setBackgroundResource(R.drawable.textview_style);
                        item.color = true;
                        --conut;
                    }

                    int c = MathC.number(conut, conut2);
                    select.setText("已经选好" + c + "注");
                }
            });
        }
    }

    class My2Adapter extends BaseQuickAdapter<Info, BaseViewHolder> {


        public My2Adapter(MainActivity mainActivity, ArrayList<Info> data) {

            super(R.layout.adapter2_layout, data);
        }


        @Override
        protected void convert(BaseViewHolder helper, final Info item) {
            final TextView textView = helper.getView(R.id.tt);

            helper.setText(R.id.tt, item.text);

            if (item.color) {
                textView.setBackgroundResource(R.drawable.textview_style);
            } else {
                textView.setBackgroundResource(R.drawable.blue_style);
            }

            helper.setOnClickListener(R.id.tt, new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (item.color) {
                        textView.setBackgroundResource(R.drawable.blue_style);
                        item.color = false;
                        ++conut2;
                    } else {
                        textView.setBackgroundResource(R.drawable.textview_style);
                        item.color = true;
                        --conut2;

                    }

                    int c = MathC.number(conut, conut2);

                    select.setText("已经选好" + c + "注");


                }
            });
        }
    }
}
