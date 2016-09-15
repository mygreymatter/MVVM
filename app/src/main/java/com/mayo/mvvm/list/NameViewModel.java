package com.mayo.mvvm.list;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mayo.mvvm.R;

/**
 * Created by Mahayogi Lakshmipathi on 15/9/16.
 *
 * @author <a href="mailto:mygreymatter@gmail.com">Mahayogi Lakshmipathi</a>
 * @version 1.0
 */
public class NameViewModel extends BaseObservable{

    public ObservableField<String> name;
    public ObservableField<String> pictureProfile;

    public NameViewModel(NameModel nameModel){
        name = new ObservableField<>(nameModel.name);
        pictureProfile = new ObservableField<>(nameModel.imageUrl);
    }

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView,String url){
        Log.i("mayo",url);
        Glide.with(imageView.getContext())
                .load(url)
                .skipMemoryCache(true)
                .placeholder(R.mipmap.ic_launcher)
                .override(200,200)
                .into(imageView);
    }
}
