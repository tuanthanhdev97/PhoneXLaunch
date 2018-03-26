package skyfree.com.phonexlaunche;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by dinhtuanthanh on 26/03/2018.
 */

public class WallpaperAdapter extends PagerAdapter {
    ArrayList<Integer> imageList;
    Context context;
    LayoutInflater layoutInflater;

    public WallpaperAdapter(ArrayList<Integer> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;
        View view = layoutInflater.inflate(R.layout.wallpaper_layout, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(context).load(imageList.get(position)).into(imageView);

        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}