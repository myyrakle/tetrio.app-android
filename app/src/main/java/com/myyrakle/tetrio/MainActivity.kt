package com.myyrakle.tetrio

import android.app.Instrumentation
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings.LOAD_DEFAULT
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var webView: WebView? = null
    private var leftButton: Button? = null
    private var rightButton: Button? = null
    private var xButton: Button? = null
    private var zButton: Button? = null
    private var hardButton: Button? = null
    private var softButton: Button? = null
    private var holdButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

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

        this.setLeftButton()
        this.setRightButton()
        this.setZButton()
        this.setXButton()
        this.setHardButton()
        this.setSoftButton()
        this.setHoldButton()
    }

    private fun setLeftButton() {
        this.leftButton = findViewById((R.id.left))
        leftButton?.setOnClickListener(View.OnClickListener {
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
    }

    private fun setRightButton() {
        this.rightButton = findViewById((R.id.right))
        rightButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT)
            }).start()
        })
        rightButton?.setOnLongClickListener ( View.OnLongClickListener{
            Thread(Runnable{
                for (i in 1..10) {
                    Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_RIGHT)
                }
            }).start();
            true
        })
    }

    private fun setXButton() {
        this.xButton = findViewById((R.id.x))
        xButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_UP)
            }).start()
        })
    }

    private fun setZButton() {
        this.zButton = findViewById((R.id.z))
        zButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_CTRL_LEFT)
            }).start()
        })
    }

    private fun setHardButton() {
        this.hardButton = findViewById((R.id.hard))
        hardButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_SPACE)
            }).start()
        })
    }

    private fun setSoftButton() {
        this.softButton = findViewById((R.id.soft))
        softButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN)
            }).start()
        })
        softButton?.setOnLongClickListener ( View.OnLongClickListener{
            Thread(Runnable{
                for (i in 1..30) {
                    Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_DPAD_DOWN)
                }
            }).start();
            true
        })
    }

    private fun setHoldButton() {
        this.holdButton = findViewById((R.id.hold))
        holdButton?.setOnClickListener(View.OnClickListener {
            Thread(Runnable{
                Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_SHIFT_LEFT)
            }).start()
        })
    }
}