package com.su.kotlin.activity.idioms

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.activity.baseSyntax.UseRangesActivity
import com.su.kotlin.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_common_to_other_ac.*

/**
 * Created by Mr.Su on 2018/3/20.
 * 使用去区间——界面
 */

class RangActivity : BaseActivity(), View.OnClickListener {
    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/idioms.html#使用区间"

    override fun layoutResId(): Int = R.layout.activity_common_to_other_ac

    override fun getIntentExtras(extrasBundle: Bundle) {

    }

    override fun initData() {

    }

    override fun initView() {
        btnToOtherActivity.text = "跳转至基本语法的‘使用区间界面’"
    }

    override fun iniitListener() {
        btnToOtherActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, UseRangesActivity::class.java)
        startActivity(intent)
    }

}