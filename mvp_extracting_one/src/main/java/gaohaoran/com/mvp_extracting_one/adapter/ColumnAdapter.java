package gaohaoran.com.mvp_extracting_one.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.bean.ColumnBean;

public class ColumnAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<ColumnBean.DataBean>list;

    public void setList(ArrayList<ColumnBean.DataBean> list) {
        this.list = list;
    }

    public ColumnAdapter(Context context, ArrayList<ColumnBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_columnitem, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1 = (Holder) holder;
        ColumnBean.DataBean dataBean = list.get(position);
//        RoundedBitmapDrawable circularBitmapDrawable =
//                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        Glide.with(context).load(dataBean.getThumbnail()).into(holder1.iv_thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Holder extends RecyclerView.ViewHolder {

        private final ImageView iv_thumbnail;

        public Holder(View itemView) {
            super(itemView);
            iv_thumbnail = itemView.findViewById(R.id.iv_thumbnail);
        }
    }

}
