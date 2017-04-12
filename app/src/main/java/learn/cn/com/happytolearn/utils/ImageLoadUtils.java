package learn.cn.com.happytolearn.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 图片加载，可以随时替换加载工具
 * <p/>
 * Created by LOVE on 2016/04/18.
 */
public class ImageLoadUtils {
    public static void loadImage(Context context, ImageView imageView, String url) {
        Glide
                .with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.override(600, 600)
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, String url ,int resouceId) {
        Glide
                .with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //.override(600, 600)
                .error(resouceId)
                .into(imageView);
    }
}
