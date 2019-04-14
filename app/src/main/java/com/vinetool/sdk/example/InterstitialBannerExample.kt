package com.vinetool.sdk.example

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.vinetool.sdk.tool.Const
import com.vinetool.sdk.tool.Interstitial
import kotlinx.android.synthetic.main.activity_interstitial.*


class InterstitialBannerExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_interstitial)

        val bt = findViewById<Button>(R.id.showAd)

        setSupportActionBar(toolbar2)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val inters = Interstitial(this, Interstitial.BANNER)
        inters.setAdTag("20-320x480")
        inters.setInterstitialEventListener(object : Interstitial.InterstitialEventListener {
            override fun onAdLoaded() {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad loaded")
            }

            override fun onAdShown() {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad shown")
            }

            override fun onAdError(errorCode: Int) {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad error -> $errorCode")
            }

            override fun onAdClicked() {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad clicked")
            }

            override fun onAdClosed() {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad Closed")
            }

            override fun onAdLoadFailed() {
                Log.d(Const.D_BUG, "Event Listener : interstitial ad load failed")
            }

        })
        inters.createAd()

        bt.setOnClickListener {
            //Your code here
            inters.showAd()
        }


    }
}
