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

import java.util.List;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.bean.V2exBean;

public class V2exAdapter extends RecyclerView.Adapter{
    List<V2exBean> list;
    Context context;

    public V2exAdapter(List<V2exBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_v2ex, viewGroup,false);
        ViewHolder vh = new ViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        Glide.with(context).load("https:"+list.get(i).getName()).into(vh.mIvTopicFace);
        vh.mTvTopicComment.setText(list.get(i).getCommet());
        vh.mTvTopicName.setText(list.get(i).getImg());
        vh.mTvTopicNode.setText(list.get(i).getTab2());
        vh.mTvTopicTips.setText(list.get(i).getCodelike());
        vh.mTvTopicTitle.setText(list.get(i).getTitle());
//        vh.m.setText(list.get(i).getCommet());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView mIvTopicFace;
        TextView mTvTopicName;
        TextView mTvTopicTips;
        TextView mTvTopicComment;
        TextView mTvTopicNode;
        TextView mTvTopicTitle;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mIvTopicFace = (ImageView) view.findViewById(R.id.iv_topic_face);
            this.mTvTopicName = (TextView) view.findViewById(R.id.tv_topic_name);
            this.mTvTopicTips = (TextView) view.findViewById(R.id.tv_topic_tips);
            this.mTvTopicComment = (TextView) view.findViewById(R.id.tv_topic_comment);
            this.mTvTopicNode = (TextView) view.findViewById(R.id.tv_topic_node);
            this.mTvTopicTitle = (TextView) view.findViewById(R.id.tv_topic_title);
        }
    }
}
