package com.su.kotlin_test.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.activity.baseSyntax.StringTemplatesActivity
import com.su.kotlin_test.activity.baseSyntax.WhenExpressionActivity
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_common_to_other_ac.*

/**
 * Created by Mr.Su on 2018/3/20.
 * 类型判断——界面
 */

class InstanceChecksActivity : BaseActivity(), View.OnClickListener {
    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#类型判断"

    override fun layoutResId(): Int = R.layout.activity_common_to_other_ac

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        btnToOtherActivity.text = "跳转至‘使用 when 表达式’界面"

        val sumUpStr = "\n类型判断关键是 is \n" +
                "用法可见‘when 表达式’界面"
        tvSumUp.append(sumUpStr)
    }

    override fun iniitListener() {
        btnToOtherActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, WhenExpressionActivity::class.java)
        startActivity(intent)
    }

}