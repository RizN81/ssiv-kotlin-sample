package com.davemorrissey.labs.subscaleview.sample.imagedisplay

import android.app.Fragment
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder
import com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder
import com.davemorrissey.labs.subscaleview.sample.R.layout

import kotlinx.android.synthetic.main.imagedisplay_large_fragment.next
import kotlinx.android.synthetic.main.imagedisplay_large_fragment.imageView

class ImageDisplayLargeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layout.imagedisplay_large_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next.setOnClickListener { (parentFragment as ImageDisplayFragment).next() }
        imageView.setBitmapDecoderFactory(CompatDecoderFactory(SkiaImageDecoder::class.java, Bitmap.Config.ARGB_8888))
        imageView.setRegionDecoderFactory(CompatDecoderFactory(SkiaPooledImageRegionDecoder::class.java, Bitmap.Config.ARGB_8888))
        imageView.setImage(ImageSource.asset("card.png"))
    }
}
