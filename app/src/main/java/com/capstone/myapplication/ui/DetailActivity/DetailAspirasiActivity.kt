package com.capstone.myapplication.ui.DetailActivity

import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.capstone.myapplication.data.dataSturcture
import com.capstone.myapplication.databinding.ActivityDetailAspirasiBinding
import com.google.android.material.appbar.AppBarLayout

class DetailAspirasiActivity : AppCompatActivity(), AppBarLayout.OnOffsetChangedListener {

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var binding: ActivityDetailAspirasiBinding
    private val percentageToShowImage = 20
    private var mMaxScrollSize = 0
    private var mIsImageHidden = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAspirasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.appbar.addOnOffsetChangedListener(this)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailAspirasiViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dataId = extras.getString(EXTRA_FILM)
            val dataCategory = extras.getString(EXTRA_CATEGORY)

            if (dataId != null && dataCategory != null) {
                viewModel.setFilm(dataId, dataCategory)
                val film = viewModel.getFilmDetail()
                dataDetail(film)
            }
        }


    }

    private fun dataDetail(data: dataSturcture) {
        binding.tvDetailOverview.text = StringBuilder("${data.status} ")
        binding.judulCollapsing.title = data.title
        binding.tvDetailOverview.text = data.detail

        Glide.with(this)
            .load(data.photo)
            .into(binding.ivPhotoDetail)

        binding.ivPhotoDetail.tag = data.photo

        setColorByPalette(data.photo.toInt())
    }

    private fun setColorByPalette(poster: Int) {
        val bitmap = BitmapFactory.decodeResource(resources, poster)

        Palette.from(bitmap).generate { palette ->
            val defValue = Color.parseColor("#FF03DAC5")
            binding.cardDetail.setCardBackgroundColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            binding.judulCollapsing.setContentScrimColor(
                palette?.getDarkMutedColor(defValue) ?: defValue
            )
            window.statusBarColor = palette?.getDarkMutedColor(defValue) ?: defValue
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0) mMaxScrollSize = appBarLayout!!.totalScrollRange

        val currentScrollPercentage: Int = (Math.abs(verticalOffset) * 100 / mMaxScrollSize)

        if (currentScrollPercentage >= percentageToShowImage) {
            if (!mIsImageHidden) {
                mIsImageHidden = true
            }
        }

        if (currentScrollPercentage < percentageToShowImage) {
            if (mIsImageHidden) {
                mIsImageHidden = false
            }
        }
    }
    
}