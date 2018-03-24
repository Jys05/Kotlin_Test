package com.su.kotlin.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.activity.baseSyntax.StringTemplatesActivity
import com.su.kotlin.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_common_to_other_ac.*

/**
 * Created by Mr.Su on 2018/3/20.
 * String 内插——界面
 */

class StringInterpolationActivity : BaseActivity(), View.OnClickListener {
    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#string-内插"

    override fun layoutResId(): Int = R.layout.activity_common_to_other_ac

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        btnToOtherActivity.text = "跳转至‘使用字符串模板界面’"

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
