package hu.paulolajos.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import hu.paulolajos.ui.R

@BindingAdapter("loadImage")
fun loadImage(thumbImg : ImageView, url : String){
    Glide.with(thumbImg)
        .load(url)
        .circleCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .fallback(R.drawable.ic_launcher_foreground)
        .into(thumbImg)
}