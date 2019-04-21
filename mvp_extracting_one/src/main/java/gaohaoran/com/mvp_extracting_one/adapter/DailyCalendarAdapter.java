package gaohaoran.com.mvp_extracting_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.bean.DailyCalendarBean;
import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;

public class DailyCalendarAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<DailyCalendarBean.StoriesBean>list;

    public void setList(ArrayList<DailyCalendarBean.StoriesBean> list) {
        this.list = list;
    }

    public DailyCalendarAdapter(Context context, ArrayList<DailyCalendarBean.StoriesBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dailycalendaritem, parent, false);
        return new Holder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holderItem = (Holder) holder;
        DailyCalendarBean.StoriesBean storiesBean = list.get(position);
        Glide.with(context).load(storiesBean.getImages().get(0)).into(holderItem.iv_images);
        holderItem.tv_title.setText(storiesBean.getTitle());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder {

        private final ImageView iv_images;
        private final TextView tv_title;

        public Holder(View itemView) {
            super(itemView);
            iv_images = itemView.findViewById(R.id.iv_images);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
