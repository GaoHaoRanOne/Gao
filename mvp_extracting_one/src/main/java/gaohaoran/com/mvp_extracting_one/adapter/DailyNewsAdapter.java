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
import gaohaoran.com.mvp_extracting_one.bean.DailyNewsBean;

public class DailyNewsAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<DailyNewsBean.TopStoriesBean>bannerlist;
    private ArrayList<DailyNewsBean.StoriesBean>itemlist;
    public  String mData = "今日新闻";
    public void setItemlist(ArrayList<DailyNewsBean.StoriesBean> itemlist) {
        this.itemlist = itemlist;
    }

    public void setBannerlist(ArrayList<DailyNewsBean.TopStoriesBean> bannerlist) {
        this.bannerlist = bannerlist;
    }

    public DailyNewsAdapter(Context context, ArrayList<DailyNewsBean.TopStoriesBean> bannerlist, ArrayList<DailyNewsBean.StoriesBean> itemlist) {
        this.context = context;
        this.bannerlist = bannerlist;
        this.itemlist = itemlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == 0){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dailynews_banner, parent, false);
            viewHolder = new Holderbanner(inflate);
        }else if (viewType == 1){
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dailynews_item, parent, false);
            viewHolder = new HolderItem(inflate);
        }
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Holderbanner){
            Holderbanner holderbanner = (Holderbanner) holder;
            holderbanner.banner.setImages(bannerlist);
            holderbanner.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DailyNewsBean.TopStoriesBean topStoriesBean = (DailyNewsBean.TopStoriesBean) path;
                    Glide.with(context).load(topStoriesBean.getImage()).into(imageView);
                }
            });
            holderbanner.banner.start();
        }else if (holder instanceof HolderItem){
            HolderItem holderItem = (HolderItem) holder;
            DailyNewsBean.StoriesBean storiesBean = itemlist.get(position);
            Glide.with(context).load(storiesBean.getImages().get(0)).into(holderItem.iv_images);
            holderItem.tv_title.setText(storiesBean.getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        /*if (bannerlist!=null&&bannerlist.size()>0){
            return itemlist.size()+1+1;
        }else{
            return itemlist.size()+1;
        }*/
        return itemlist.size();
    }
    class Holderbanner extends RecyclerView.ViewHolder {

        private final Banner banner;

        public Holderbanner(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
    class HolderItem extends RecyclerView.ViewHolder {

        private final ImageView iv_images;
        private final TextView tv_title;

        public HolderItem(View itemView) {
            super(itemView);
            iv_images = itemView.findViewById(R.id.iv_images);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
