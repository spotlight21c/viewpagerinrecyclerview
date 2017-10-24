package com.trend21c.viewpagerinrecyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by kevin on 2017. 10. 24..
 */

public class ProductCardAdapter extends RecyclerView.Adapter<ProductCardAdapter.ViewHolder> {

    private ArrayList<Product> items;
    private FragmentManager fragmentManager;

    HashMap<Integer, Integer> mViewPagerState = new HashMap<>();

    public ProductCardAdapter(FragmentManager fragmentManager, ArrayList<Product> items) {
        this.items = items;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        BannerPagerAdapter bannerPagerAdapter = new BannerPagerAdapter(fragmentManager);
        viewHolder.vp.setAdapter(bannerPagerAdapter);
        viewHolder.vp.setId(i+1);

        if (mViewPagerState.containsKey(i)) {
            viewHolder.vp.setCurrentItem(mViewPagerState.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        mViewPagerState.put(holder.getAdapterPosition(), holder.vp.getCurrentItem());
        super.onViewRecycled(holder);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewPager vp;

        public ViewHolder(View itemView) {
            super(itemView);
            vp = (ViewPager) itemView.findViewById(R.id.vp);
        }
    }

    public class BannerPagerAdapter extends FragmentPagerAdapter {
        public BannerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return BlankFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

}
