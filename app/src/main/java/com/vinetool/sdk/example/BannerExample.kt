package com.vinetool.sdk.example

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.vinetool.sdk.BannerLayout
import com.vinetool.sdk.tool.Const
import kotlinx.android.synthetic.main.activity_banner.*
import kotlinx.android.synthetic.main.content_banner.*

class BannerExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        banner1.setBannerEventListener(object: BannerLayout.BannerEventListener{
            override fun onAdLoaded() {
                Log.d(Const.D_BUG,"BannerExample AdLoaded")
            }

            override fun onAdShown() {
                Log.d(Const.D_BUG,"BannerExample Shown")
            }

            override fun onAdError(errorCode: Int) {
                Log.d(Const.D_BUG, "BannerExample Error $errorCode")
            }

            override fun onAdClicked() {
                Log.d(Const.TAG,"BannerExample Clicked")
            }

        })

        banner1.createAd()

        show.setOnClickListener {
            banner1.showAd()
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }




}
