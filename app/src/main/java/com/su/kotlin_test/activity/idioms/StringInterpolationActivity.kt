package com.su.kotlin_test.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.activity.baseSyntax.StringTemplatesActivity
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_string_interpolation.*

/**
 * Created by Mr.Su on 2018/3/20.
 * String 内插——界面
 */

class StringInterpolationActivity : BaseActivity(), View.OnClickListener {
    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#string-内插"

    override fun layoutResId(): Int = R.layout.activity_string_interpolation

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        val sumUpStr = "\n和Gradle的使用是一致的"
        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnToOtherActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, StringTemplatesActivity::class.java)
        startActivity(intent)
    }

}
