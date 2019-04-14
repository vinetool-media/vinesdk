package com.vinetool.sdk.example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vinetool.sdk.CatFishLayout
import com.vinetool.sdk.tool.Const
import kotlinx.android.synthetic.main.activity_cat_fish.*

class CatFishExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_fish)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val catFish = CatFishLayout(this,catfish)

        catFish.setAdTag("20-320x50")

        catFish.setCatFishEventListener(object: CatFishLayout.CatFishEventListener{
            override fun onAdLoaded() {
                Log.d(Const.D_BUG,"CatFishExample AdLoaded")
            }

            override fun onAdShown() {
                Log.d(Const.D_BUG,"CatFishExample Shown")
            }

            override fun onAdError(errorCode: Int) {
                Log.d(Const.D_BUG,"CatFishExample Error: "+errorCode)
            }

            override fun onAdClicked() {
                Log.d(Const.D_BUG,"CatFishExample Clicked")
            }

            override fun onAdClose() {
                Log.d(Const.D_BUG,"CatFishExample Closed")
            }

        })

        catFish.createAd()

        show.setOnClickListener{
            catFish.showAd()
        }
    }
}
