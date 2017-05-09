package cn.new18.timeline;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 饶伟 on 2016/8/3  13:32.
 */
public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.itemViewHolder>{
    private Context mContext;
    private List<TimeLineBean> mData;

    public TimeLineAdapter(Context context, List<TimeLineBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_timeline, null);
        itemViewHolder itemViewHolder = new itemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final itemViewHolder holder, final int position) {

        if (position == 0) {
            holder.line_top.setVisibility(View.INVISIBLE);
        }
        if (position == mData.size() - 1) {
            holder.line_end.setVisibility(View.INVISIBLE);
        }
        holder.text_time.setText(mData.get(position).time);
        holder.text_desc.setText(mData.get(position).desc);

        //根据TextView高度动态改变左侧线条高度
        holder.text_desc.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onGlobalLayout() {
                holder.text_desc.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int height = holder.text_desc.getHeight();
                LinearLayout.LayoutParams endParams = (LinearLayout.LayoutParams) holder.line_end.getLayoutParams();
                endParams.height = height - 20;
                endParams.width = DisplayUtils.dip2px(mContext, 2);
                endParams.leftMargin = DisplayUtils.dip2px(mContext, 15);
                LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(endParams);
                holder.line_end.setLayoutParams(param);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class itemViewHolder extends RecyclerView.ViewHolder {
        View line_top;
        View line_end;
        TextView text_time;
        TextView text_desc;
        public itemViewHolder(View itemView) {
            super(itemView);
            line_top = itemView.findViewById(R.id.line_top);
            line_end = itemView.findViewById(R.id.line_end);
            text_time = (TextView) itemView.findViewById(R.id.text_time);
            text_desc = (TextView) itemView.findViewById(R.id.text_desc);
        }
    }

}
