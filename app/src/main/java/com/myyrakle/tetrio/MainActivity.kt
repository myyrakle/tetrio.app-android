package com.myyrakle.tetrio

import android.app.Instrumentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings.LOAD_DEFAULT
import android.webkit.WebSettings.LOAD_NO_CACHE
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null
    private var leftButton: Button? = null
    private var rightButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.webView = findViewById(R.id.webView)
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.builtInZoomControls = true
        webView?.settings?.domStorageEnabled = true
        webView?.settings?.javaScriptCanOpenWindowsAutomatically = true
        webView?.settings?.loadsImagesAutomatically = true
        webView?.settings?.allowFileAccess=true
        webView?.settings?.useWideViewPort = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.builtInZoomControls=true
        webView?.settings?.allowContentAccess = true
        webView?.settings?.useWideViewPort =true
        webView?.settings?.blockNetworkImage = false
        webView?.settings?.blockNetworkLoads = false
        webView?.settings?.databaseEnabled = true
        webView?.settings?.cacheMode = LOAD_DEFAULT
        webView?.settings?.safeBrowsingEnabled = true
        webView?.webViewClient = WebViewClient()
        webView?.loadUrl("https://tetr.io/")

        this.leftButton = findViewById((R.id.left))
        leftButton?.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "asdf", Toast.LENGTH_LONG)
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_LEFT)
            }).start()
        })
        leftButton?.setOnLongClickListener ( View.OnLongClickListener{
            Thread(Runnable{
                for (i in 1..10) {
                    Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_LEFT)
                }
            }).start();
            true
        })

        this.rightButton = findViewById((R.id.right))
        rightButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT)
            }).start()
        })
    }
}