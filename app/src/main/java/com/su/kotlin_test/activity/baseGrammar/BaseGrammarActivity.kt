package com.su.kotlin_test.activity.baseGrammar

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.su.kotlin_test.R
import com.su.kotlin_test.frame.BaseActivity
import kotlinx.android.synthetic.main.activity_base_grammar.*

/**
 * Created by Sujiayong on 2018/2/24.
 */
class BaseGrammarActivity : BaseActivity(), View.OnClickListener {

    override fun setLayoutResId(): Int = R.layout.activity_base_grammar

    override fun getIntentExtras(extrasBundle: Bundle) {
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun iniitListener() {
        btnDefineFun.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()

        when (v?.id) {
        //基本语法——界面
            btnDefineFun.id -> intent.setClass(this, DefineFunActivity::class.java)

        }

        startActivity(intent)
    }
}