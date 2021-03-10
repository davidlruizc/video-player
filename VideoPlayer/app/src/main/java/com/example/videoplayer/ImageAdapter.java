package com.example.videoplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return thumbImages.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 300));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(20, 20, 20, 20);
        imageView.setImageResource(thumbImages[position]);

        return imageView;
    }


    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4,
            R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8,
            R.drawable.img9, R.drawable.img10,
    };

    public String[] artistNames = {
            "AC/DC", "El Binomio de Oro",
            "Slipknot", "Scorpions",
            "Metallica", "The Beatles",
            "Coldplay", "Arctic Monkeys",
            "Aerosmith", "Rammstein",
    };

    public String[] videoPath = {
            "video1", "video2",
            "video3", "video4",
            "video5", "video6",
            "video7", "video8",
            "video9", "video10",
    };
}
