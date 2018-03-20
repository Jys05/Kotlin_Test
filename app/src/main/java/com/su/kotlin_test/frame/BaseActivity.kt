package com.su.kotlin_test.frame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.su.kotlin_test.R
import com.su.kotlin_test.utils.TvSpanUtil

/**
 * Created by Sujiayong on 2018/2/24.
 * 框架的基本Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId())

        if (this.intent.extras != null) {
            this.getIntentExtras(this.intent.extras)
        }

        //设置Kotlin网址
        setTvKotlinWeb()

        initData()

        initView()

        iniitListener()
    }

    private fun setTvKotlinWeb() {
        val url = setKotlinWeb()
        val tvKotlinWeb = findViewById<TextView>(R.id.tvKotlinWeb)
        if(tvKotlinWeb!=null){
            TvSpanUtil.setTvSpan(tvKotlinWeb, url, url)
        }
    }

    abstract fun setKotlinWeb():String

    abstract fun layoutResId(): Int

    abstract fun getIntentExtras(extrasBundle: Bundle)

    abstract fun initData()

    abstract fun initView()

    abstract fun iniitListener()
}