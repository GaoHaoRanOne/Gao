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

import java.util.ArrayList;
import java.util.List;

import gaohaoran.com.mvp_extracting_one.R;
import gaohaoran.com.mvp_extracting_one.bean.WechatBean;

public class WechatAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<WechatBean.NewslistBean>list;


    public void setList(ArrayList<WechatBean.NewslistBean> list) {
        this.list = list;
    }

    public WechatAdapter(Context context, ArrayList<WechatBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_wechatitem, parent, false);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Holder holder1 = (Holder) holder;
        final WechatBean.NewslistBean newslistBean = list.get(position);
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder1.iv_picUrl);
        holder1.tv_title.setText(newslistBean.getTitle());
        holder1.tv_description.setText(newslistBean.getDescription());
        holder1.tv_ctime.setText(newslistBean.getCtime());

        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click!=null){
                    click.Click(position,newslistBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(WechatBean wechatBean) {
        List<WechatBean.NewslistBean> newslist = wechatBean.getNewslist();
        list.clear();
        list.addAll(newslist);
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {

        private final ImageView iv_picUrl;
        private final TextView tv_title;
        private final TextView tv_description;
        private final TextView tv_ctime;

        public Holder(View itemView) {
            super(itemView);
            iv_picUrl = itemView.findViewById(R.id.iv_picUrl);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_ctime = itemView.findViewById(R.id.tv_ctime);
        }
    }
    private OnItemClickListener click;
    public interface OnItemClickListener{
            void Click(int position,WechatBean.NewslistBean newslistBean);
        }
        public void setOnClick(OnItemClickListener onClick){
            this.click = onClick;
        }

}
