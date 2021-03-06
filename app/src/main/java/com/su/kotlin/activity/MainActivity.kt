package com.su.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin.R
import com.su.kotlin.activity.baseSyntax.BaseSyntaxActivity
import com.su.kotlin.activity.idioms.IdiomsActivity
import com.su.kotlin.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Sujiayong on 2018/2/24.
 *
 * 关于findViewById：可以直接使用Layout中的id属性的值
 *
 * 下面引掉的是：控件定义了一个对象（其实是多余的）
 */
class MainActivity : BaseActivity(), View.OnClickListener {

    override fun setKotlinWeb(): String = "https://www.kotlincn.net/docs/reference/"

    override fun layoutResId(): Int =R.layout.activity_main

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun iniitListener() {
        btnBaseGrammar.setOnClickListener(this)
        btnIdioms.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when (v?.id) {

            btnBaseGrammar.id -> intent.setClass(this, BaseSyntaxActivity::class.java)

            btnIdioms.id -> intent.setClass(this, IdiomsActivity::class.java)

        }

        startActivity(intent)
    }

}
