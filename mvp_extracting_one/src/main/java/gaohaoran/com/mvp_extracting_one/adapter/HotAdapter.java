package gaohaoran.com.mvp_extracting_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.bean.HotBean;

public class HotAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<HotBean.RecentBean>list;

    public void setList(ArrayList<HotBean.RecentBean> list) {
        this.list = list;
    }

    public HotAdapter(Context context, ArrayList<HotBean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_hotitem, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1 = (Holder) holder;
        HotBean.RecentBean recentBean = list.get(position);
        Glide.with(context).load(recentBean.getThumbnail()).into(holder1.iv_thumbnail);
        holder1.tv_title.setText(recentBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder {

        private final ImageView iv_thumbnail;
        private final TextView tv_title;

        public Holder(View itemView) {
            super(itemView);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
