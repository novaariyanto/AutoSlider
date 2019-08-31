package com.shaktisinh.autoslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SPECBEE on 8/4/2017.
 */

class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> color;
    private List<String> colorName;
    private List<String> image;

    public SliderAdapter(Context context, List<Integer> color, List<String> colorName,List<String> images) {
        this.context = context;
        this.color = color;
        this.colorName = colorName;
        this.image = images;
    }

    @Override
    public int getCount() {
        return color.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
        ImageView imageView = (ImageView)view.findViewById(R.id.idImages);

        textView.setText(colorName.get(position));
        linearLayout.setBackgroundColor(color.get(position));
        Picasso.get().load(image.get(position)).into(imageView);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
