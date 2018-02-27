package com.su.kotlin_test.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.activity.baseGrammar.BaseSyntaxActivity
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Sujiayong on 2018/2/24.
 *
 * 关于findViewById：可以直接使用Layout中的id属性的值
 *
 * 下面引掉的是：控件定义了一个对象（其实是多余的）
 */
class MainActivity : BaseActivity(), View.OnClickListener {

//    var mBtnBaseGrammar: Button? = null

    override fun setLayoutResId(): Int =R.layout.activity_main

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
//        mBtnBaseGrammar = btnBaseGrammar
    }

    override fun iniitListener() {
//        mBtnBaseGrammar?.setOnClickListener(this)
        btnBaseGrammar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when (v?.id) {
        //基本语法——界面
            btnBaseGrammar.id -> intent.setClass(this, BaseSyntaxActivity::class.java)

        }

        startActivity(intent)
    }

}
