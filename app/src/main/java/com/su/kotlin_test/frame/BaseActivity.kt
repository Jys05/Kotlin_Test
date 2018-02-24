package com.su.kotlin_test.frame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Sujiayong on 2018/2/24.
 * 框架的基本Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutResId())

        if (this.intent.extras != null) {
            this.getIntentExtras(this.intent.extras)
        }

        initData()

        initView()

        iniitListener()
    }

    abstract fun setLayoutResId(): Int

    abstract fun getIntentExtras(extrasBundle: Bundle)

    abstract fun initData()

    abstract fun initView()

    abstract fun iniitListener()
}