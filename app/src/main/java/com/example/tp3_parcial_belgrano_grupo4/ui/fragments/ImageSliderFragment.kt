package com.example.tp3_parcial_belgrano_grupo4.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.models.SlideModel
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.ImageSlider
import com.example.tp3_parcial_belgrano_grupo4.R

class ImageSliderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.image_slider_fragment, container, false)

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)

        val slideModels: ArrayList<SlideModel> = ArrayList()
        slideModels.add(SlideModel(R.drawable.example_slider_img1, ScaleTypes.CENTER_INSIDE))
        slideModels.add(SlideModel(R.drawable.example_slider_img2, ScaleTypes.CENTER_INSIDE))
        slideModels.add(SlideModel(R.drawable.example_slider_img3, ScaleTypes.CENTER_INSIDE))

        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP)



        return view
    }
}
