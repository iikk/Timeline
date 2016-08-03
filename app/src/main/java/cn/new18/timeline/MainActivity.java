package cn.new18.timeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<TimeLineBean> data = new ArrayList<>();
    private List<String> time = new ArrayList<>();
    private List<String> desc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        TimeLineAdapter timeLineAdapter = new TimeLineAdapter(this, data);
        mRecyclerView.setAdapter(timeLineAdapter);
    }

    private void initData() {
        time.add("09:09");
        time.add("10:10");
        time.add("11:11");
        time.add("12:12");
        time.add("13:13");
        time.add("14:14");
        time.add("15:15");
        time.add("16:16");
        time.add("17:17");

        desc.add("大家镇静一下，我要开始导航了。");
        desc.add("坦率地讲，这种天气你就不应该开车出来。");
        desc.add("我们现在到了科技与人文的十字路口。");
        desc.add("(叹气声)（略作停顿）这么小的路口一般导航都是不报的，情怀！");
        desc.add("前方一百米红绿灯，看到了吗？虽然没有摄像头，但你也别闯红灯，是吧，做个体面人。闯红灯多不体面。我们是坚强的理想主义者，闯灯就不骄傲了。");
        desc.add("前方右转高速入口，左转大坑，请左转，因为我爱这个千疮百孔的世界！");
        desc.add("我们现在已经在开车了是吧，要克制，做司机跟企业家都要克制！");
        desc.add("体验了本次导航，是不是觉得这个世界更美好了一些啊？");
        desc.add("我可能是东半球最准的导航！");

        for (int i = 0; i < time.size(); i++) {
            data.add(new TimeLineBean(time.get(i), desc.get(i)));
        }
    }
}
